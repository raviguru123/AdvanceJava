package org.lld.practice.in.memory.sql.model;


import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ColumnDataType<T> {
    DataTypes dataTypes;

    public boolean validate(T val) throws Exception {
        boolean result = false;
        switch (dataTypes) {
            case INTEGER:
                if (val instanceof Integer) {
                    result = true;
                }
                break;
            case DOUBLE:
                if (val instanceof Double) {
                    result = true;
                }
                break;
            case STRING:
                if (val instanceof String) {
                    result = true;
                }
                break;
            default:
                break;
        }
        return result;
    }


}
