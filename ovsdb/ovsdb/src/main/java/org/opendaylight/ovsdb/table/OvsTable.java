package org.opendaylight.ovsdb.table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OvsTable {

    private OvsTableInfo ovsInfo;

    private OvsTableInfo getOvsTableInfo() {
        return ovsInfo;
    }

    private void setNew(OvsTableInfo ovsInfo) {
        this.ovsInfo = ovsInfo;
    }

    @Override
    public String toString() {
        return "OvsTable{" +
                "[OvsTable.class getBridges = " + ovsInfo.getBridges()
                .toString() + "\n" +
                "[OvsTable.class getCur_cfg= " + ovsInfo.getCur_cfg()
                .toString() + "\n" +
                "[OvsTable.class getOvs_version = " + ovsInfo.getOvs_version
                ().toString() + "\n" +
                "[OvsTable.class getManager_options = " + ovsInfo
                .getManager_options().toString() + "\n" +
                '}';
    }
}