package dataHolders.dataTypes;

/**
 * Created by anandv on 01/05/14.
 */
public interface DataType {
    <T extends DataType> boolean apply(Condition<T> condition);
}
