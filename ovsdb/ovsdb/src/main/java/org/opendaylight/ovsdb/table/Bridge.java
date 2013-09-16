package org.opendaylight.ovsdb.table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang.builder.ToStringBuilder;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Bridge {

    @JsonProperty("new")
    public BridgeData bridgeData;
    @JsonProperty("old")
    public BridgeData bridgeDataOld;

    public BridgeData getBridgeData() {
        return bridgeData;
    }

    public void setBridgeData(BridgeData bridgeData) {
        this.bridgeData = bridgeData;
    }

    public BridgeData getBridgeDataOld() {
        return bridgeDataOld;
    }

    public void setBridgeDataOld(BridgeData bridgeDataOld) {
        this.bridgeDataOld = bridgeDataOld;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class BridgeData {

        @JsonProperty("name")
        public  String name;
        @JsonProperty("ports")
        public Object ports;
        @JsonProperty("fail_mode")
        public Object fail_mode;
        @JsonProperty("controllerTable")
        public Object controller;
        @JsonProperty("external_ids")
        public Object external_ids;

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

        @JsonProperty("controllerTable")
        public Object getController() {
            return controller;
        }

        @JsonProperty("controllerTable")
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

        @Override
        public String toString() {
            return ToStringBuilder.reflectionToString(this);
        }
    }
}