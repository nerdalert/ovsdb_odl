package org.opendaylight.ovsdb.internal;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.MappingJsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufInputStream;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import io.netty.util.ResourceLeakDetector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;


public class JsonDecoder extends MessageToMessageDecoder<ByteBuf> {
    protected static final Logger logger = LoggerFactory.getLogger(JsonDecoder.class);
    private final ObjectMapper mapper = new ObjectMapper();
    JsonFactory jf = new MappingJsonFactory();

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf buf, List<Object> out) throws Exception {



        ResourceLeakDetector.setEnabled(true);
        //Uncomment for String Out
        //  logger.debug("called " + buf.toString(CharsetUtil.UTF_8) + "<=EOL\n");

        byte[] bytes = null;
        buf.markReaderIndex();
        ByteBuf wrappedbuf = buf;
        if (bytes != null) {
            ByteBuf bufcopy = Unpooled.wrappedBuffer(bytes);
            wrappedbuf = Unpooled.wrappedBuffer(bufcopy, buf);
            bytes = null;
        } else {
            ByteBufInputStream bbistream = new ByteBufInputStream(wrappedbuf);
            JsonParser jp = jf.createParser(bbistream);
            JsonNode root = jp.readValueAsTree();
            bbistream.reset();

            //Data hostreply = mapper.treeToValue(root, Data.class);
            Map hostreply = mapper.treeToValue(root, Map.class);

            out.add(hostreply);

        }
    }
}


//        if (buf == null) {
//            return;
//        }
//        byte[] buffer = new byte[buf.readableBytes()];
//        buf.getBytes(0, buffer);
//        // Binding to Map.Class until Truncated Replies are Resolved
//        Map jsonreply = jsonMapper.readValue(buffer, Map.class);
//        logger.debug("JSONDecode ==> " + ctx.alloc().compositeDirectBuffer());
//        out.add(jsonreply);
//    }


