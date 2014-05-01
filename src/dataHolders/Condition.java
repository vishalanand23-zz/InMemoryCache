package dataHolders;

/**
 * Created by anandv on 29/04/14.
 */
public class Condition<T> {
    public final String columnName;
    final T value;
    final Operator operator;

    public Condition(String column, T value, Operator operator) {

        this.columnName = column;
        this.value = value;
        this.operator = operator;
    }

    enum Operator {
        Greater, Smaller, Equals, GreaterEquals, SmallerEquals
    }
}
