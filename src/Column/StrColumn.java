package column;

/**
 * Created by anandv on 29/04/14.
 */
public class StrColumn extends Column<String> {

    public StrColumn(String value, String name) {
        super(name, value);
    }

    @Override
    public boolean apply(Condition condition) {
        switch (condition.operator) {
            case Equals:
                return value.compareTo((String) condition.value) == 0;

        }
        return false;
    }

}
