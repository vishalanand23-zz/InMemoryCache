package dataHolders;

/**
 * Created by anandv on 01/05/14.
 */
public class BoolColumn extends Column<Boolean> {

    public BoolColumn(String name, Boolean value) {
        super(name, value);
    }

    @Override
    public boolean apply(Condition condition) {
        switch (condition.operator) {
            case Equals:
                return value == condition.value;

        }
        return false;
    }
}
