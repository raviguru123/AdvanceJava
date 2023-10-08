package org.lld.practice.in.memory.sql.model;

public class StrDataType extends ColumnDataType {

    int min_value;
    int max_value;

    public StrDataType(String data_type, int min_value, int max_value) {
        super(DataTypes.STRING);
        this.min_value = min_value;
        this.max_value = max_value;
    }

    public boolean validate(Object val) throws Exception {
        String value = (String) val;
        if (super.validate(val) && value.length() > min_value && value.length() < max_value) {
            throw new Exception("Invalid String value");
        }
        return true;
    }
}
