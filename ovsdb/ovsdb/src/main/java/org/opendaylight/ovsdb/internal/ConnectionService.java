package org.opendaylight.ovsdb.internal;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;
import org.opendaylight.controller.sal.connection.ConnectionConstants;
import org.opendaylight.controller.sal.connection.IPluginInConnectionService;
import org.opendaylight.controller.sal.core.Node;
import org.opendaylight.controller.sal.utils.Status;
import org.opendaylight.controller.sal.utils.StatusCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;


/**
 * Represents the openflow plugin component in charge of programming the flows
 * the flow programming and relay them to functional modules above SAL.
 */
public class ConnectionService implements IPluginInConnectionService, IConnectionServiceInternal {
    protected static final Logger logger = LoggerFactory.getLogger(ConnectionService.class);

    private static final Integer defaultOvsdbPort = 6632;
    ConcurrentMap<String, Connection> ovsdbConnections;

    public void init() {
        ovsdbConnections = new ConcurrentHashMap<String, Connection>();
    }

    /**
     * Function called by the dependency manager when at least one dependency
     * become unsatisfied or when the component is shutting down because for
     * example bundle is being stopped.
     */
    void destroy() {
    }

    /**
     * Function called by dependency manager after "init ()" is called and after
     * the services provided by the class are registered in the service registry
     */
    void start() {
    }

    /**
     * Function called by the dependency manager before the services exported by
     * the component are unregistered, this will be followed by a "destroy ()"
     * calls
     */
    void stop() {
    }

    @Override
    public Status disconnect(Node node) {
        String identifier = (String) node.getID();
        Connection connection = ovsdbConnections.get(identifier);
        if (connection != null) {
            ovsdbConnections.remove(identifier);
            return connection.disconnect();
        } else {
            return new Status(StatusCode.NOTFOUND);
        }
    }


    @Override
    public Node connect(String identifier, Map<ConnectionConstants, String> params) {
        InetAddress address;
        Integer port;

        try {
            address = InetAddress.getByName(params.get(ConnectionConstants.ADDRESS));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        try {
            port = Integer.parseInt(params.get(ConnectionConstants.PORT));
            if (port == 0) port = defaultOvsdbPort;
        } catch (Exception e) {
            port = defaultOvsdbPort;
        }

        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(new NioEventLoopGroup());
            bootstrap.channel(NioSocketChannel.class);
            bootstrap.option(ChannelOption.SO_KEEPALIVE, true);
            bootstrap.option(ChannelOption.RCVBUF_ALLOCATOR, new AdaptiveRecvByteBufAllocator(65535, 65535, 65535));
            bootstrap.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                public void initChannel(SocketChannel channel) throws Exception {

//                  Add new Handlers here.
                    channel.pipeline().addLast(new JsonDecoder());
                    channel.pipeline().addLast(new StringEncoder(CharsetUtil.UTF_8));
                    channel.pipeline().addLast("messageHandler", new MessageHandler());
                }
            });
            logger.debug("1 Channel INIT " + "Identifier=>" + identifier + "Address=>" + address);
            ChannelFuture future = bootstrap.connect(address, port).sync();
            Channel channel = future.channel();

            //   Connection connection = new Connection(identifier, channel, new JsonRpcClient());
            logger.debug("2 Channel INIT Future" + "Identifier=>" + identifier + channel + address);
            Connection connection = new Connection(identifier, channel);

            ovsdbConnections.put(identifier, connection);

            return connection.getNode();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Connection getConnection(Node node) {
        String identifier = (String) node.getID();
        return ovsdbConnections.get(identifier);

    }

    @Override
    public void notifyClusterViewChanged() {
    }

    @Override
    public void notifyNodeDisconnectFromMaster(Node arg0) {
    }
}
