package dataHolders;

import dataTypes.Condition;
import dataTypes.DataType;

public class Column<T extends DataType> {

    public final String name;
    public final T value;

    public Column(String name, T value) {
        this.name = name;
        this.value = value;
    }

    boolean isNamed(String columnsName) {
        return name.equals(columnsName);
    }

    <T extends DataType> boolean apply(Condition<T> condition) {
        return value.apply(condition);
    }
}
