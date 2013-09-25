package org.opendaylight.ovsdb.table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)

public class EchoRequest {

    public EchoRequest() {
        this.id = "echo";
        this.params = params;
        this.method = "echo";
    }

    @JsonProperty("method")
    private String method;
    @JsonProperty("params")
    private List<Object> params = new ArrayList<Object>();
    @JsonProperty("id")
    private String id;

    @JsonProperty("method")
    public String getMethod() {
        return method;
    }

    @JsonProperty("method")
    public void setMethod(String method) {
        this.method = method;
    }

    @JsonProperty("params")
    public List<Object> getParams() {
        return params;
    }

    @JsonProperty("params")
    public void setParams(List<Object> params) {
        this.params = params;
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
        return "EchoRequest{" +
                "method='" + method + '\'' +
                ", params=" + params +
                ", id='" + id + '\'' +
                '}';
    }
}