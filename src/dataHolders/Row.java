package dataHolders;

import dataHolders.dataTypes.Condition;
import dataHolders.dataTypes.DataType;

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

    Row filterColumns(String[] columnsName) {
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

    <T extends DataType> boolean apply(Condition<T> condition) {
        Column rightColumn = null;
        for (Column column : columns) {
            if (column.isNamed(condition.getColumnName())) {
                rightColumn = column;
                break;
            }
        }
        assert rightColumn != null;
        return rightColumn.apply(condition);
    }
}
