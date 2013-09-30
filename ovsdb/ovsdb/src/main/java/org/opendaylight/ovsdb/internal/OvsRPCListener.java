package org.opendaylight.ovsdb.internal;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.util.CharsetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created with IntelliJ IDEA.
 * User: brent
 * Date: 9/29/13
 * Time: 4:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class OvsRPCListener {
    protected static final Logger logger = LoggerFactory.getLogger(OvsRPCListener.class);
    private int port;
    private  String listenerip;

    public OvsRPCListener() throws Exception {
        listenerip = null;
        try {
            listenerip = String.valueOf(InetAddress.getLocalHost());
        } catch (UnknownHostException e) {
            logger.debug("Invalid IP Address " + e.getStackTrace());
        }
        port = 6632;
        run();
    }

    public OvsRPCListener(int port) throws Exception {
        this.port = port;
        listenerip = null;
        run();
    }

    public OvsRPCListener(String listenerip, int port) throws Exception {
        this.port = port;
        this.listenerip = listenerip;
      run();
    }

    EventLoopGroup bossGroup = new NioEventLoopGroup();
    EventLoopGroup workerGroup = new NioEventLoopGroup();

    public void run() throws Exception {
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_REUSEADDR, true)
                    .childOption(ChannelOption.TCP_NODELAY, true)
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new LoggingHandler(LogLevel.INFO),
                                    new StringEncoder(CharsetUtil.UTF_8),
                                    new StringEncoder(CharsetUtil.UTF_8),
                                    new OvsRPCHandler());
                        }
                    });
            b.bind(port).sync().channel().closeFuture().sync();
        }
        finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
