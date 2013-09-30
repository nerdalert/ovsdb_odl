package org.opendaylight.ovsdb.table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OvsTable {

    @JsonProperty("new")
    public OvsTableData ovsTableData;
    @JsonProperty("old")
    public OvsTableData ovsTableDataOld;

    public OvsTableData getOvsTableData() {
        return ovsTableData;
    }

    public void setOvsTableData(OvsTableData ovsTableData) {
        this.ovsTableData = ovsTableData;
    }

    public OvsTableData getOvsTableDataOld() {
        return ovsTableDataOld;
    }

    public void setOvsTableDataOld(OvsTableData ovsTableDataOld) {
        this.ovsTableDataOld = ovsTableDataOld;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this) +"\n";
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public class OvsTableData {

        @JsonProperty("ovs_version")
        private String ovs_version;
        @JsonProperty("cur_cfg")
        private Integer cur_cfg;
        @JsonProperty("bridges")
        private Object bridges;
        @JsonProperty("external_ids")
        private Object external_ids;
        @JsonProperty("manager_options")
        private Object manager_options;

        @JsonProperty("ovs_version")
        public String getOvs_version() {
            return ovs_version;
        }

        @JsonProperty("ovs_version")
        public void setOvs_version(String ovs_version) {
            this.ovs_version = ovs_version;
        }

        @JsonProperty("cur_cfg")
        public Integer getCur_cfg() {
            return cur_cfg;
        }

        @JsonProperty("cur_cfg")
        public void setCur_cfg(Integer cur_cfg) {
            this.cur_cfg = cur_cfg;
        }

        @JsonProperty("bridges")
        public Object getBridges() {
            return bridges;
        }

        @JsonProperty("bridges")
        public void setBridges(Object bridges) {
            this.bridges = bridges;
        }


        @JsonProperty("external_ids")
        public Object getexternal_ids() {
            return external_ids;
        }

        @JsonProperty("external_ids")
        public void setexternal_ids(Object external_ids) {
            this.external_ids = external_ids;
        }

        public Object getManager_options() {
            return manager_options;
        }

        public void setManager_options(Object manager_options) {
            this.manager_options = manager_options;
        }

        @Override
        public String toString() {
            return ToStringBuilder.reflectionToString(this);
        }
    }
}