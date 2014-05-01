package dataTypes;

public class StringType implements DataType {
    String data;

    @Override
    public <T extends DataType> boolean apply(Condition<T> condition) {
        StringType value = (StringType) condition.value;
        switch (condition.operator) {
            case Equals:
                return this.data.compareTo(value.data) == 0;
        }
        return false;
    }
}
