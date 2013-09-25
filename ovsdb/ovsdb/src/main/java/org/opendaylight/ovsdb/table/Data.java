package org.opendaylight.ovsdb.table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Data {

    @JsonProperty("id")
    private int id;
    @JsonProperty("error")
    private Object error;
    @JsonProperty("result")
    private Results results;
    @JsonProperty("method")
    private String method;
    @JsonProperty("params")
    private ArrayList<Results> params;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Object getError() {
        return error;
    }

    public void setError(Object error) {
        this.error = error;
    }

    public Results getResults() {
        return results;
    }

    public void setResults(Results results) {
        this.results = results;
    }

    public ArrayList<Results> getParams() {
        return params;
    }

    public void setParams(ArrayList<Results> params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    //Has to be Static inner-classes dont map w/o it per Tatu in #jackson
    public static class Results {
        @JsonProperty("syntax")
        public String syntax;
        @JsonProperty("details")
        public String details;
        @JsonProperty("Port")
        public Map<String, Port> portTable;
        @JsonProperty("Open_vSwitch")
        public Map<String, OvsTable> ovsTable;
        @JsonProperty("Controller")
        public Map<String, Controller> controllerTable;
        @JsonProperty("Interface")
        public Map<String, Interface> interfacesTable;
        @JsonProperty("Bridge")
        public Map<String, Bridge> bridgeTable;
        @JsonProperty("Manager")
        public Map<String, Manager> managerTable;

        public Map<String, Bridge> getBridgeTable() {
            return bridgeTable;
        }

        public void setBridgeTable(Map<String, Bridge> bridgeTable) {
            this.bridgeTable = bridgeTable;
        }

        public Map<String, Manager> getManagerTable() {
            return managerTable;
        }

        public void setManagerTable(Map<String, Manager> managerTable) {
            this.managerTable = managerTable;
        }

        public Map<String, Port> getPortTable() {
            return portTable;
        }

        public void setPortTable(Map<String, Port> portTable) {
            this.portTable = portTable;
        }

        public Map<String, Controller> getControllerTable() {
            return controllerTable;
        }

        public void setControllerTable(Map<String, Controller> controllerTable) {
            this.controllerTable = controllerTable;
        }

        @JsonProperty("Interface")
        public Map<String, Interface> getInterface() {
            return interfacesTable;
        }

        @JsonProperty("Interface")
        public void setInterface(Map<String, Interface> interfaces) {
            this.interfacesTable = interfaces;
        }

        public Map<String, OvsTable> getOvsTable() {
            return ovsTable;
        }

        public void setOvsTable(Map<String, OvsTable> ovstable) {
            this.ovsTable = ovstable;
        }

        public String getSyntax() {
            return syntax;
        }

        public void setSyntax(String syntax) {
            this.syntax = syntax;
        }

        public String getDetails() {
            return details;
        }

        public void setDetails(String details) {
            this.details = details;
        }

//        @Override
//        public String toString() {
//            return ToStringBuilder.reflectionToString(this);
//        }
    }
}
