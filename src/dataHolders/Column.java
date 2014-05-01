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

    public <S extends T> boolean apply(Condition<S> condition) {
        return value.apply(condition);
    }
}
