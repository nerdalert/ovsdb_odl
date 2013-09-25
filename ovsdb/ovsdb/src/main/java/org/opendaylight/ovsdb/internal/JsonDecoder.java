package org.opendaylight.ovsdb.internal;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.MappingJsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;


public class JsonDecoder extends MessageToMessageDecoder<ByteBuf> {
    protected static final Logger logger = LoggerFactory.getLogger(JsonDecoder.class);
    private static final ObjectMapper jsonMapper = new ObjectMapper();

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
        if (msg == null) {
            return;
        }
        byte[] buffer = new byte[msg.readableBytes()];
        msg.getBytes(0, buffer);
        // Binding to Map.Class until Truncated Replies are Resolved
        Map jsonreply = jsonMapper.readValue(buffer, Map.class);
        out.add(jsonreply);
    }
}

