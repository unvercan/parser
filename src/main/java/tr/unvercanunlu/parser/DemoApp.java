package tr.unvercanunlu.parser;

import java.util.LinkedList;
import tr.unvercanunlu.parser.column.BooleanColumn;
import tr.unvercanunlu.parser.column.NumericColumn;
import tr.unvercanunlu.parser.column.TextColumn;
import tr.unvercanunlu.parser.column.time.DateColumn;
import tr.unvercanunlu.parser.core.Column;
import tr.unvercanunlu.parser.core.Config;
import tr.unvercanunlu.parser.core.Parser;
import tr.unvercanunlu.parser.core.Row;
import tr.unvercanunlu.parser.iterator.Iterator;

public class DemoApp {

  public static void main(String[] args) {
    // sample input
    String content = """
        2024-05-01,true,Apple,10.5
        2024-05-02,false,Banana,20.0
        """;

    // column type order
    LinkedList<Class<? extends Column<?>>> columnOrder = new LinkedList<>();
    columnOrder.add(DateColumn.class);
    columnOrder.add(BooleanColumn.class);
    columnOrder.add(TextColumn.class);
    columnOrder.add(NumericColumn.class);

    // config
    Config config = new Config(
        '\n',
        ',',
        columnOrder,
        "yyyy-MM-dd",
        null,
        null
    );

    // parser
    Parser parser = new Parser(content, config);

    // row iterator
    Iterator<Row> rowIterator = parser.getIterator();

    // iterating row
    while (rowIterator.hasNext()) {
      Row row = rowIterator.next();
      System.out.println("Row:");

      // column iterator
      Iterator<Column<?>> columnIterator = row.getIterator();

      // iterating column in the row
      while (columnIterator.hasNext()) {
        Column<?> column = columnIterator.next();
        System.out.printf(" - [%s] %s%n", column.getClass().getSimpleName(), column.parse());
      }
    }
  }

}