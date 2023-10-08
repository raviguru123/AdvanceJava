package org.lld.practice.in.memory.sql.model;

import java.util.HashMap;
import java.util.Map;

public class Table {
    String table_name;
    TableSchema table_schema;

    String primary_key;

    Map<String, Map<String, SchemaMember>> row_data;

    public void insertData(HashMap<String, SchemaMember> schemaMemberHashMap) {

    }

}
