package dataTypes;

public class BoolType implements DataType {
    private final Boolean data;

    public BoolType(Boolean data) {
        this.data = data;
    }

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
