package row;

import column.Column;
import column.Condition;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anandv on 27/04/14.
 */
public class Row {
    private final ArrayList<Column> values = new ArrayList<Column>();

    public List<Column> filter(Iterable<String> columnsName) {
        List<Column> newColumns = new ArrayList<Column>();
        for (Column value : values) {
            for (String columnName : columnsName) {
                if (value.isNamed(columnName)) {
                    newColumns.add(value);
                    break;
                }
            }
        }
        return newColumns;
    }

    public boolean apply(Condition condition) {
        ArrayList<String> columnsName = new ArrayList<String>();
        columnsName.add(condition.columnName);
        Column column = filter(columnsName).get(0);
        return column.apply(condition);
    }
}
