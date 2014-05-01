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
        assert row.assertStructure(structure);
        rows.add(row);
    }

    public Iterable<Row> query(String[] columnName, Condition condition, Iterable<String> columnNameList) {
        return filter(rows, condition, columnNameList);
    }

    private List<Row> filter(List<Row> currentRows, Condition condition, Iterable<String> columnNameList) {
        List<Row> newRows = new ArrayList<Row>();
        for (Row currentRow : currentRows) {
            if (currentRow.apply(condition)) newRows.add(currentRow.filter(columnNameList));
        }
        return newRows;
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
