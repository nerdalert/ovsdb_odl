package org.opendaylight.ovsdb.internal;

<<<<<<< HEAD
import com.fasterxml.jackson.core.JsonFactory;
=======
>>>>>>> 5fc89136202044b915348a2f20d7e56c6ce3a399
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.MappingJsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.buffer.ByteBuf;
<<<<<<< HEAD
import io.netty.buffer.ByteBufInputStream;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import io.netty.util.ResourceLeakDetector;
=======
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
>>>>>>> 5fc89136202044b915348a2f20d7e56c6ce3a399
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
<<<<<<< HEAD
=======
import java.util.Map;
>>>>>>> 5fc89136202044b915348a2f20d7e56c6ce3a399


public class JsonDecoder extends MessageToMessageDecoder<ByteBuf> {
    protected static final Logger logger = LoggerFactory.getLogger(JsonDecoder.class);
<<<<<<< HEAD
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
            out.add(root);
            //  ctx.fireChannelRead();
            //    }
        }
    }
}



=======
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

>>>>>>> 5fc89136202044b915348a2f20d7e56c6ce3a399
