package org.lld.practice.in.memory.sql.model;

import java.util.HashMap;
import java.util.Map;

public class TableSchema {
    Map<String, SchemaMember> schemaMemberMap;
    boolean allow_undefined;

    public TableSchema() {
        this.schemaMemberMap = new HashMap<>();
        this.allow_undefined = false;
    }

    public TableSchema(boolean allow_undefined) {
        this.schemaMemberMap = new HashMap<>();
        this.allow_undefined = allow_undefined;
    }

    public void addSchemaMember(SchemaMember schemaMember) {
        this.schemaMemberMap.put(schemaMember.getColumn_name(), schemaMember);
    }

    public Map<String, SchemaMember> validateRowData(HashMap<String, SchemaMember> row_data) throws Exception {
        Map<String, SchemaMember> validated_data = new HashMap<>();

        for (Map.Entry<String, SchemaMember> schemaMemberEntry : row_data.entrySet()) {

            if (!this.schemaMemberMap.containsKey(schemaMemberEntry.getKey()) && allow_undefined == false) {
                throw new Exception("undefined schema member not allowed");
            }

            if (!this.schemaMemberMap.containsKey(schemaMemberEntry.getKey())) {
                validated_data.put(schemaMemberEntry.getKey(), schemaMemberEntry.getValue());
                continue;
            }
            this.schemaMemberMap.get(schemaMemberEntry.getKey()).validateValue(schemaMemberEntry.getValue());
            validated_data.put(schemaMemberEntry.getKey(), schemaMemberEntry.getValue());

        }
        return validated_data;
    }
}
