package dataHolders.dataTypes;

/**
 * Created by anandv on 01/05/14.
 */
public class BoolType implements DataType {
    Boolean data;

    @Override
    public <T extends DataType> boolean apply(Condition<T> condition) {
        BoolType value = (BoolType) condition.value;
        switch (condition.operator) {
            case Equals:
                return this.data == value.data;
        }
        return false;
    }
}
