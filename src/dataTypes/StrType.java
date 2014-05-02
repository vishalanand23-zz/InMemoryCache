package dataTypes;

public class StrType implements DataType {
    private final String data;

    public StrType(String data) {
        this.data = data;
    }

    @Override
    public <T extends DataType> boolean apply(Condition<T> condition) {
        StrType value = (StrType) condition.value;
        switch (condition.operator) {
            case Equals:
                return this.data.compareTo(value.data) == 0;
        }
        return false;
    }
}
