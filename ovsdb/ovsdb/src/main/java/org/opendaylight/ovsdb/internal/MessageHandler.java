package org.opendaylight.ovsdb.internal;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.opendaylight.ovsdb.table.*;

import io.netty.channel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;

public class MessageHandler extends SimpleChannelInboundHandler<String> {
    protected static final Logger logger = LoggerFactory
            .getLogger(ConnectionService.class);

    private Map <Long, MessageHandlerFuture> responseFutures = new HashMap<Long, MessageHandlerFuture>();

    public Future<Object> getResponse(long id){
        MessageHandlerFuture responseFuture = new MessageHandlerFuture(Long.valueOf(id));
        responseFutures.put(Long.valueOf(id), responseFuture);
        return responseFuture;
    }

    @Override
    public void channelRead0(ChannelHandlerContext ctx, String msg){

        JsonNode jsonNode;
        ObjectMapper mapper = new ObjectMapper();

        try{
            jsonNode = mapper.readTree(msg);
        }catch(IOException e){
            e.printStackTrace();
            return;
        }

        if(jsonNode.has("method")){
            String method = jsonNode.get("method").toString();
            if(method.contains("echo")){
                EchoReply echoreply = new EchoReply();
                JsonNode echoReplyJnode = mapper.valueToTree(echoreply);
                //   String reply = "{\"result\":[], \"id\":\"echo\"}";
                ctx.writeAndFlush(echoReplyJnode.toString());
            }

        }
        else if(jsonNode.has("result")){
            Long requestId = jsonNode.get("id").asLong();
            JsonParser parser = mapper.treeAsTokens(jsonNode.get("result"));
            try{
                Object response = mapper.readValue(parser, MessageMapper.getMapper().pop(requestId));
                MessageHandlerFuture future = responseFutures.get(requestId);
                if (future != null) {
                    future.gotResponse(requestId, response);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else {
            try {
                JsonFactory factory = mapper.getJsonFactory();
                JsonParser jparse = null;
                //Map to Root Pojo Data.class
                jparse = factory.createJsonParser(msg);
                JsonNode actualObj = mapper.readTree(jparse);
                Data hostreply = mapper.treeToValue(actualObj, Data.class);

                // Raw MSG String Return Print
                System.out.println(msg);
                //Example Return ID
                System.out.println("Json Response for channel ID ==> " + hostreply.Id());
                //Example Return Error
                System.out.println("Bridge Table UUID is ==> " + hostreply.getError());
                //Example Return Result
                System.out.println("Open_vSwitch Table UUID is ==> " + hostreply.getResults().getOvsTable().keySet());

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception{
        ctx.flush();
    }
}