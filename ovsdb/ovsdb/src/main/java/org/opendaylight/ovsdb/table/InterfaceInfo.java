package org.opendaylight.ovsdb.table;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class InterfaceInfo {

    @JsonProperty("name")
    private String name;
    // @JsonProperty("type")
    private String type;
    @JsonProperty("options")
    private Object options;
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

    //  @JsonProperty("type")
    public String getType() {
        return type;
    }

    //  @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("options")
    public Object getOptions() {
        return options;
    }

    @JsonProperty("options")
    public void setOptisons(Object options) {
        this.options = options;
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