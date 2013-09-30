package org.opendaylight.ovsdb;

import org.junit.Test;
import org.opendaylight.ovsdb.internal.OvsRPCListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OvsdbTestListeningServer {
    private static final Logger logger = LoggerFactory
            .getLogger(OvsdbTestListeningServer.class);

    @Test
    public void addBridge() throws Throwable{

          int port = 6632;
          String listenerip = "172.16.58.1";
        OvsRPCListener ovslistener = new OvsRPCListener(listenerip, port);

    }
}
