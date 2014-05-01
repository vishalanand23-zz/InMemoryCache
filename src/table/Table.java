package table;

import column.Column;
import column.Condition;
import row.Row;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anandv on 27/04/14.
 */
public class Table {
    private final List<Row> rows = new ArrayList<Row>();

    private final List<Column> structure;

    public Table(List<Column> structure) {
        this.structure = structure;
    }

    public void addRow(Row row) {
        rows.add(row);
    }

    public Iterable<Row> query(String[] columnName) {
        return rows;
    }

    private List<Row> filter(List<Row> currentRows, Condition condition) {
        List<Row> newRows = new ArrayList<Row>();
        for (Row currentRow : currentRows) {
            if (currentRow.apply(condition)) newRows.add(currentRow);
        }
        return newRows;
    }

    public Column getColumn(String name) {
        for (Column column : structure) {
            if (column.isNamed(name)) return column;
        }
        return null;
    }

//    public Iterable<Row> queryOverAnd(String[] columnName, Condition[] conditions) {
//        List<Row> currentRows = rows;
//        for (Condition condition : conditions) {
//            currentRows = filter(currentRows, condition);
//        }
//        return currentRows;
//    }
//
//    public Iterable<Row> queryOverOr(Condition[] conditions) {
//        Set<Row> currentRows = new TreeSet<Row>();
//        for (Condition condition : conditions) {
//            currentRows.addAll(filter(rows, condition));
//        }
//        return currentRows;
//    }
}
