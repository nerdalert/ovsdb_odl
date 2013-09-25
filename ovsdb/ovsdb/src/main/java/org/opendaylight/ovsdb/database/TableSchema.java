package org.opendaylight.ovsdb.database;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class TableSchema {
    @JsonProperty("columns")
    public Map<String, ColumnSchema> columns;
    @JsonProperty("maxRows")
    public Integer maxRows;
    @JsonProperty("isRoot")
    public Boolean isRoot;
    @JsonProperty("indexes")
    public Object indexes;

    public Map<String, ColumnSchema> getColumns(){
        return this.columns;
    }
}
