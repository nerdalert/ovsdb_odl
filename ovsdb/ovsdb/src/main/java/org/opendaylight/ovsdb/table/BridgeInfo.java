package org.opendaylight.ovsdb.table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BridgeInfo {

    @JsonProperty("name")
    private String name;
    @JsonProperty("ports")
    private Object ports;
    @JsonProperty("fail_mode")
    private Object fail_mode;
    @JsonProperty("controller")
    private Object controller;
    @JsonProperty("external_ids")
    private Object external_ids;

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("ports")
    public Object getPorts() {
        return ports;
    }

    @JsonProperty("ports")
    public void setPorts(Object ports) {
        this.ports = ports;
    }

    @JsonProperty("fail_mode")
    public Object getFail_mode() {
        return fail_mode;
    }

    @JsonProperty("fail_mode")
    public void setFail_mode(Object fail_mode) {
        this.fail_mode = fail_mode;
    }

    @JsonProperty("controller")
    public Object getController() {
        return controller;
    }

    @JsonProperty("controller")
    public void setController(Object controller) {
        this.controller = controller;
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