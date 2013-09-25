package org.opendaylight.ovsdb.table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang.builder.ToStringBuilder;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Manager {

    @JsonProperty("new")
    public ManagerData managerData;
    @JsonProperty("old")
    public ManagerData managerDataOld;

    public ManagerData getManagerData() {
        return managerData;
    }

    public void setManagerData(ManagerData managerData) {
        this.managerData = managerData;
    }

    public ManagerData getManagerDataOld() {
        return managerDataOld;
    }

    public void setManagerDataOld(ManagerData managerDataOld) {
        this.managerDataOld = managerDataOld;
    }

    public static class ManagerData {
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

        @Override
        public String toString() {
            return ToStringBuilder.reflectionToString(this);
        }
    }
}