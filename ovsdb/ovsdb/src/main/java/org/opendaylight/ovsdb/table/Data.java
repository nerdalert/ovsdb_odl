package org.opendaylight.ovsdb.table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;


@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class Data {

    @JsonProperty("id")
    private int id;
    @JsonProperty("error")
    private Object error;
    @JsonProperty("result")
    private Results Results;


    public int Id() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Object getError() {
        return error;
    }
    public void setError(Object error) {
        this.error = error;
    }
    public Results getResults() {
        return Results;
    }
    public void setResults(Results results) {
        this.Results = results;
    }

    @Override
    public String toString() {
        return "Data{" +
                "id=" + id +
                ", error=" + error +
                ", Results=" + Results +
                '}';
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    //Has to be Static inner-classes dont map w/o it per Tatu in #jackson
    public static class Results {
        @JsonProperty("syntax")
        private String syntax;
        @JsonProperty("details")
        private String details;
        @JsonProperty("Port")
        private Map<String, Port> port;
        @JsonProperty("Open_vSwitch")
        private Map<String, OvsTable> ovstable;
        @JsonProperty("Controller")
        private Map<String, Controller> controller;
        @JsonProperty("Interface")
        private Map<String, Interface> interfaces;
        @JsonProperty("Bridge")
        private Map<String, Bridge> bridge;
        @JsonProperty("Manager")
        private Map<String, Manager> manager;

        public Map<String, Bridge> getBridge() {
            return bridge;
        }

        public void setBridge(Map<String, Bridge> bridge) {
            this.bridge = bridge;
        }

        public Map<String, Manager> getManager() {
            return manager;
        }

        public void setManager(Map<String, Manager> manager) {
            this.manager = manager;
        }

        public Map<String,Port> getPort() {
            return port;
        }

        public void setPort(Map<String,Port> port) {
            this.port = port;
        }

        public Map<String, Controller> getController() {
            return controller;
        }

        public void setController(Map<String, Controller> controller) {
            this.controller = controller;
        }

        public Map<String, Interface> getInterface() {
            return interfaces;
        }

        public void setInterface(Map<String, Interface> interfaces) {
            this.interfaces = interfaces;
        }

        public Map<String, OvsTable> getOvsTable() {
            return ovstable;
        }

        public void setOvsTable(Map<String, OvsTable> ovstable) {
            this.ovstable = ovstable;
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

        @Override
        public String toString() {
            return "Results{" +
                    "syntax='" + syntax + '\'' +
                    ", details='" + details + '\'' +
                    ", port=" + port +
                    ", ovstable=" + ovstable +
                    ", controller=" + controller +
                    ", interfaces=" + interfaces +
                    ", bridge=" + bridge +
                    ", manager=" + manager +
                    '}';
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Results)) return false;

            Results results = (Results) o;

            if (!bridge.equals(results.bridge)) return false;
            if (!controller.equals(results.controller)) return false;
            if (!details.equals(results.details)) return false;
            if (!interfaces.equals(results.interfaces)) return false;
            if (!manager.equals(results.manager)) return false;
            if (!ovstable.equals(results.ovstable)) return false;
            if (!port.equals(results.port)) return false;
            if (!syntax.equals(results.syntax)) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = syntax.hashCode();
            result = 31 * result + details.hashCode();
            result = 31 * result + port.hashCode();
            result = 31 * result + ovstable.hashCode();
            result = 31 * result + controller.hashCode();
            result = 31 * result + interfaces.hashCode();
            result = 31 * result + bridge.hashCode();
            result = 31 * result + manager.hashCode();
            return result;
        }
    }
}
