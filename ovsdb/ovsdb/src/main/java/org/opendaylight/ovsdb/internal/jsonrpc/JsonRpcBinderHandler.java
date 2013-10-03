package org.opendaylight.ovsdb.internal.jsonrpc;

import com.fasterxml.jackson.databind.JsonNode;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class JsonRpcBinderHandler extends MessageToMessageDecoder<JsonNode> {

    protected static final Logger logger = LoggerFactory.getLogger(JsonRpcBinderHandler.class);
    ObjectMapper mapper = null;

    public JsonRpcBinderHandler(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    protected void decode(ChannelHandlerContext ctx, JsonNode msg, List<Object> out) throws Exception {
        logger.debug("got json {}", msg);
    }
}
