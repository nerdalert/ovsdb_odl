package org.opendaylight.ovsdb.table;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ManagerInfo {

    @JsonProperty("target")
    private String target;
    @JsonProperty("is_connected")
    private Boolean is_connected;
    @JsonProperty("external_ids")
    private Object external_ids;

    @JsonProperty("is_connected")
    public Boolean getIs_connected() {
        return is_connected;
    }

    @JsonProperty("is_connected")
    public void setIs_connected(Boolean is_connected) {
        this.is_connected = is_connected;
    }

    @JsonProperty("target")
    public String getTarget() {
        return target;
    }

    @JsonProperty("target")
    public void setTarget(String target) {
        this.target = target;
    }

    @JsonProperty("external_ids")
    public Object getexternal_ids() {
        return external_ids;
    }

    @JsonProperty("external_ids")
    public void setexternal_ids(Object external_ids) {
        this.external_ids = external_ids;
    }

}