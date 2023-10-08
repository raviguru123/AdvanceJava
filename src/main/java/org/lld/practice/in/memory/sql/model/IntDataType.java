package org.lld.practice.in.memory.sql.model;

public class IntDataType extends ColumnDataType {
    int min_value;
    int max_value;

    public IntDataType(int min_value, int max_value) {
        super(DataTypes.INTEGER);
        this.min_value = min_value;
        this.max_value = max_value;
    }

    public boolean validate(Object val) throws Exception {

        Integer value = (Integer) val;
        if (super.validate(val) && value > min_value && value < max_value) {
            throw new Exception("Invalid Int value");
        }

        return true;
    }
}
