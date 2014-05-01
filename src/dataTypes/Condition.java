package dataTypes;

public class Condition<T extends DataType> {
    public final T value;
    public final Operator operator;
    final String columnName;

    public Condition(String column, T value, Operator operator) {
        this.columnName = column;
        this.value = value;
        this.operator = operator;
    }

    public String getColumnName() {
        return columnName;
    }

    enum Operator {
        Greater, Smaller, Equals, GreaterEquals, SmallerEquals
    }
}
