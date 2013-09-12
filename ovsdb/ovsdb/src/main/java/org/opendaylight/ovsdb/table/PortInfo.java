package org.opendaylight.ovsdb.table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

//@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PortInfo {

    @JsonProperty("trunks")
    private Object trunks = new ArrayList<String>();
    @JsonProperty("interfaces")
    private List<String> interfaces = new ArrayList<String>();
    @JsonProperty("name")
    private String name;
    @JsonProperty("tag")
    private Object tag = new ArrayList<String>();
    @JsonProperty("external_ids")
    private Object external_ids;


    @JsonProperty("trunks")
    public Object getTrunks() {
        return trunks;
    }

    @JsonProperty("trunks")
    public void setTrunks(Object trunks) {
        this.trunks = trunks;
    }

    public PortInfo withTrunks(List<String> trunks) {
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

    public PortInfo withName(String name) {
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

    public PortInfo withTag(Object tag) {
        this.tag = tag;
        return this;
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