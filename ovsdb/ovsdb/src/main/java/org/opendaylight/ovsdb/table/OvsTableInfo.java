package org.opendaylight.ovsdb.table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OvsTableInfo {

    @JsonProperty("ovs_version")
    private String ovs_version;
    @JsonProperty("cur_cfg")
    private Integer cur_cfg;
    @JsonProperty("manager_options")
    private List<String> manager_options = new ArrayList<String>();
    @JsonProperty("bridges")
    private Object bridges;
    @JsonProperty("external_ids")
    private Object external_ids;

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

    @JsonProperty("manager_options")
    public List<String> getManager_options() {
        return manager_options;
    }

    @JsonProperty("manager_options")
    public void setManager_options(List<String> manager_options) {
        this.manager_options = manager_options;
    }

    @JsonProperty("external_ids")
    public Object getexternal_ids() {
        return external_ids;
    }

    @JsonProperty("external_ids")
    public void setexternal_ids(Object external_ids) {
        this.external_ids = external_ids;
    }

    @Override
    public String toString() {
        return "OvsTableInfo{" +
                "ovs_version='" + ovs_version + '\'' +
                ", cur_cfg=" + cur_cfg +
                ", manager_options=" + manager_options +
                ", bridges=" + bridges +
                '}';
    }
}