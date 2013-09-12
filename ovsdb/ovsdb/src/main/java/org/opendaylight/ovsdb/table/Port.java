package org.opendaylight.ovsdb.table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Port {

    private PortInfo portInfo;

    public PortInfo getPortInfo() {
        return portInfo;
    }

    public void setNew(PortInfo portInfo) {
        this.portInfo = portInfo;
    }

    @Override
    public String toString() {
        return "Port.class getName = " + portInfo.getName().toString() + "]\n" +
                "[Port.class,PortInfo getInterfaces = " + portInfo
                .getInterfaces().toString() + "]\n" +
                "[Port.class,PortInfo getTag = " + portInfo.getTag().toString
                () + "]\n" +
                "[Port.class,PortInfo getTrunks = " + portInfo.getTrunks()
                .toString() + "]\n";
        //Remove to debug ext_id   "[Port.class getExternal_ids = " + portInfo.getexternal_ids().toString() + "]\n";
    }
}