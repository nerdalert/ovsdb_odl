package org.opendaylight.ovsdb.table;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.HashMap;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OvsTable {

    Map<String, OvsTableInfo> ovstableInfo = new HashMap<String, OvsTableInfo>();

    public Map<String, OvsTableInfo> getOvstableInfo() {
        return ovstableInfo;
    }

    public void setOvstableInfo(Map<String, OvsTableInfo> ovstableInfo) {
        this.ovstableInfo = ovstableInfo;
    }

    @JsonAnySetter
    public void add(String key, OvsTableInfo value) {
        ovstableInfo.put(key, value);
    }

    @JsonAnyGetter
    public Map<String, OvsTableInfo> getProperties() {
        return ovstableInfo;
    }

    @Override
    public String toString() {
        return "OvsTable [ovstableInfo=" + ovstableInfo + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((ovstableInfo == null) ? 0 : ovstableInfo.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        OvsTable other = (OvsTable) obj;
        if (ovstableInfo == null) {
            if (other.ovstableInfo != null)
                return false;
        } else if (!ovstableInfo.equals(other.ovstableInfo))
            return false;
        return true;
    }
}