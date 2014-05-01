package dataTypes;

/**
 * Created by anandv on 01/05/14.
 */
public class IntType implements DataType {
    Integer data;

    @Override
    public <T extends DataType> boolean apply(Condition<T> condition) {
        IntType value = (IntType) condition.value;
        switch (condition.operator) {
            case Equals:
                return this.data.equals(value.data);
            case Greater:
                return this.data > value.data;
            case Smaller:
                return this.data < value.data;
            case GreaterEquals:
                return this.data >= value.data;
            case SmallerEquals:
                return this.data <= value.data;
        }
        return false;
    }
}
