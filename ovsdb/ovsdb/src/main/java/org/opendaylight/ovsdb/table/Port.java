package org.opendaylight.ovsdb.table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Port {

    @JsonProperty("new")
    public PortData portData;
    @JsonProperty("old")
    public PortData portDataOld;

    public PortData getPortData() {
        return portData;
    }

    public void setPortData(PortData portData) {
        this.portData = portData;
    }

    public PortData getPortDataOld() {
        return portDataOld;
    }

    public void setPortDataOld(PortData portDataOld) {
        this.portDataOld = portDataOld;
    }

    @Override
    public String toString() {
        return portData.getName();
    }

    public static class PortData extends Port {

        @JsonProperty("trunks")
        public Object trunks = new ArrayList<String>();
        @JsonProperty("interfaces")
        public List<String> interfaces = new ArrayList<String>();
        @JsonProperty("name")
        public String name;
        @JsonProperty("tag")
        public Object tag = new ArrayList<String>();
        @JsonProperty("external_ids")
        public Object external_ids;


        @JsonProperty("trunks")
        public Object getTrunks() {
            return trunks;
        }

        @JsonProperty("trunks")
        public void setTrunks(Object trunks) {
            this.trunks = trunks;
        }

        public PortData withTrunks(List<String> trunks) {
            this.trunks = trunks;
            return this;
        }

        @JsonProperty("interfaces")
        public List<String> getInterfaces() {
            return interfaces;
        }

        @JsonProperty("interfaces")
        public void setInterfaces(List<String> interfaces) {
            this.interfaces = interfaces;
        }

        @JsonProperty("name")
        public String getName() {
            return name;
        }

        @JsonProperty("name")
        public void setName(String name) {
            this.name = name;
        }

        public PortData withName(String name) {
            this.name = name;
            return this;
        }

        @JsonProperty("tag")
        public Object getTag() {
            return tag;
        }

        @JsonProperty("tag")
        public void setTag(Object tag) {
            this.tag = tag;
        }

        @JsonProperty("external_ids")
        public Object getExternal_ids() {
            return external_ids;
        }

        @JsonProperty("external_ids")
        public void setExternal_ids(Object external_ids) {
            this.external_ids = external_ids;
        }

        @Override
        public String toString() {
            return ToStringBuilder.reflectionToString(this);
        }
    }
}