package org.opendaylight.ovsdb.table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)

public class EchoReply {

    public EchoReply() {
        this.id = "echo";
    }

    @JsonProperty("result")
    private List<Object> result = new ArrayList<Object>();
    @JsonProperty("id")
    private String id;

    @JsonProperty("result")
    public List<Object> getResult() {
        return result;
    }

    @JsonProperty("result")
    public void setResult(List<Object> result) {
        this.result = result;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = "echo";
    }

    @Override
    public String toString() {
        return result + id;
    }

}