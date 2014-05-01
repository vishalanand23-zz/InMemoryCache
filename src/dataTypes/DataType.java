package dataTypes;

public interface DataType {
    <T extends DataType> boolean apply(Condition<T> condition);
}
