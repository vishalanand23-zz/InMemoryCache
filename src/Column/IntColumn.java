package column;

/**
 * Created by anandv on 29/04/14.
 */
public class IntColumn extends Column<Integer> {

    public IntColumn(String name, Integer value) {
        super(name, value);
    }

    @Override
    public boolean apply(Condition condition) {
        switch (condition.operator) {
            case Equals:
                return value.compareTo((Integer) condition.value) == 0;
            case Greater:
                return value.compareTo((Integer) condition.value) > 0;
            case Smaller:
                return value.compareTo((Integer) condition.value) < 0;
            case GreaterEquals:
                return value.compareTo((Integer) condition.value) >= 0;
            case SmallerEquals:
                return value.compareTo((Integer) condition.value) <= 0;

        }
        return false;
    }

}
