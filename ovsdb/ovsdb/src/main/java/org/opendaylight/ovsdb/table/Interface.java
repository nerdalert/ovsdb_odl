package org.opendaylight.ovsdb.table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Interface {

    private InterfaceInfo interfaceInfo;

    public InterfaceInfo getPortInfo() {
        return interfaceInfo;
    }

    public void setNew(InterfaceInfo interfaceInfo) {
        this.interfaceInfo = interfaceInfo;
    }

    @Override
    public String toString() {
        return "Interface{" +
                "Interface.class getName = " + interfaceInfo.getName()
                .toString() + "\n" +
                "Interface.class getOptions = " + interfaceInfo.getOptions()
                .toString() + "\n" +
                "Interface.class getType = " + interfaceInfo.getType()
                .toString() + "\n" +
                '}';
    }
}