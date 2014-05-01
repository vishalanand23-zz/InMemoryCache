package dataHolders;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anandv on 27/04/14.
 */
public class Row {

    private final List<Column> columns;

    public Row(List<Column> columns) {
        this.columns = columns;
    }

    public Row filter(Iterable<String> columnsName) {
        List<Column> newColumns = new ArrayList<Column>();
        for (Column value : columns) {
            for (String columnName : columnsName) {
                if (value.isNamed(columnName)) {
                    newColumns.add(value);
                    break;
                }
            }
        }
        return new Row(newColumns);
    }

    public boolean apply(Condition condition) {
        Column rightColumn = null;
        for (Column column : columns) {
            if (column.isNamed(condition.columnName)) {
                rightColumn = column;
                break;
            }
        }
        assert rightColumn != null;
        return rightColumn.apply(condition);
    }
}
