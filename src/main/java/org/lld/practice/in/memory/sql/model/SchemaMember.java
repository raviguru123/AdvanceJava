package org.lld.practice.in.memory.sql.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SchemaMember {
    String column_name;
    ColumnDataType column_type;
    boolean required;
    boolean allow_none;

    public SchemaMember(String column_name, ColumnDataType column_type) {
        this.column_name = column_name;
        this.column_type = column_type;
        this.required = true;
        this.allow_none = false;
    }

    public boolean validateValue(Object val) throws Exception {
        if (val == null && this.allow_none == false) {
            throw new Exception("Null is not allowed");
        }
        return column_type.validate(val);
    }
}
