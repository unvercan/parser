package tr.unvercanunlu.parser.core;

import java.util.LinkedList;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import tr.unvercanunlu.parser.iterator.Iterator;
import tr.unvercanunlu.parser.iterator.impl.RowIteratorImpl;

@RequiredArgsConstructor
public class Parser implements Container<Row>, Iterable<Row> {

  @Getter
  private final String content;

  @Getter
  private final Config config;

  @Override
  public LinkedList<Row> extract() {
    String[] rawRows = content.split(String.valueOf(config.rowSeparator()));

    LinkedList<Row> extracted = new LinkedList<>();
    for (String rawRow : rawRows) {
      Row row = new Row(rawRow, config);
      extracted.add(row);
    }

    return extracted;
  }

  @Override
  public Iterator<Row> getIterator() {
    LinkedList<Row> extracted = extract();
    return new RowIteratorImpl(extracted);
  }

}
