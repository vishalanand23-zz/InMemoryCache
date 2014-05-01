package parser;

import dataHolders.Column;
import dataTypes.Condition;
import dataTypes.IntType;

public class Runner {
    public static void main(String[] args) {
        Condition<IntType> c = new Condition<IntType>("marks", new IntType(95), Condition.Operator.Smaller);
        Column<IntType> column = new Column<IntType>("marks", new IntType(66));
        System.out.println(column.apply(c));
    }
}
