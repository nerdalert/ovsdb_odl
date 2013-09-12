package org.opendaylight.ovsdb.table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Manager {

    private ManagerInfo managerInfo;

    public ManagerInfo getManagerInfo() {
        return managerInfo;
    }

    public void setNew(ManagerInfo managerInfo) {
        this.managerInfo = managerInfo;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "[Manager.class getIs_connected = " + managerInfo
                .getIs_connected().toString() + "\n" +
                "[Manager.class getTarget = " + managerInfo.getTarget()
                .toString() + "\n" +
                '}';
    }
}