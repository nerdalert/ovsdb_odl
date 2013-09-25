package org.opendaylight.ovsdb.internal;

import org.opendaylight.controller.sal.connection.ConnectionConstants;
import org.opendaylight.controller.sal.core.Node;

import java.util.Map;

public interface IConnectionServiceInternal {
    public Connection getConnection(Node node);

    // public Node connect(String identifier, Map<ConnectionConstants, String> params);
    public Node connect(String identifier, Map<ConnectionConstants, String> params);
}
