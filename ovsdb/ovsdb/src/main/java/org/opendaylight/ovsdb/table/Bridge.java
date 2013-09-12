package org.opendaylight.ovsdb.table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


//@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Bridge {
    public BridgeInfo bridgeInfo;

    public BridgeInfo getBridgeInfo() {
        return bridgeInfo;
    }

    public void setNew(BridgeInfo bridgeInfo) {
        this.bridgeInfo = bridgeInfo;
    }

    @Override
    public String toString() {
        return "Bridge{" +
                "[Bridge.class getName= " + bridgeInfo.getName().toString() +
                "\n" +
                "[Bridge.class getController= " + bridgeInfo.getController()
                .toString() + "\n" +
                "[Bridge.class getFailMode= " + bridgeInfo.getFail_mode()
                .toString() + "\n" +
                "[Bridge.class getPorts= " + bridgeInfo.getPorts().toString() + "\n" +
                '}';
    }
}