package parser;

import dataHolders.Column;
import dataTypes.Condition;
import dataTypes.IntType;
import dataTypes.StrType;

import java.util.ArrayList;

public class Runner {
    public static void main(String[] args) {
        Condition<IntType> c = new Condition<IntType>("marks", new IntType(95), Condition.Operator.Smaller);
        Column<IntType> column1 = new Column<IntType>("marks", new IntType(66));
        Column<StrType> column2 = new Column<StrType>("marks", new StrType("huh"));
        ArrayList<Column> a = new ArrayList<Column>();
        a.add(column1);
        a.add(column2);
        for (Column column : a) {
            System.out.println(column.apply(c));
        }
    }
}
