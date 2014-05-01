package dataHolders;

import dataHolders.dataTypes.Condition;
import dataHolders.dataTypes.DataType;

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
        assert nullValuesInStructure();
    }

    public void addRow(Row row) {
        assert assertStructure(row);
        rows.add(row);
    }

    public <T extends DataType> Iterable<Row> query(Condition<T> condition, String[] columnNameList) {
        return filter(rows, condition, columnNameList);
    }

    private <T extends DataType> List<Row> filter(List<Row> currentRows, Condition<T> condition, String[] columnNameList) {
        List<Row> newRows = new ArrayList<Row>();
        for (Row currentRow : currentRows) {
            if (currentRow.apply(condition)) newRows.add(currentRow.filterColumns(columnNameList));
        }
        return newRows;
    }

    private boolean assertStructure(Row row) {
        return false;
    }

    private boolean nullValuesInStructure() {
        return false;
    }

//    public Iterable<Row> queryOverAnd(String[] columnName, Condition[] conditions) {
//        List<Row> currentRows = rows;
//        for (Condition condition : conditions) {
//            currentRows = filterColumns(currentRows, condition);
//        }
//        return currentRows;
//    }
//
//    public Iterable<Row> queryOverOr(Condition[] conditions) {
//        Set<Row> currentRows = new TreeSet<Row>();
//        for (Condition condition : conditions) {
//            currentRows.addAll(filterColumns(rows, condition));
//        }
//        return currentRows;
//    }
}
