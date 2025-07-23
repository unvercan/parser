package tr.unvercanunlu.parser.core;

import java.util.LinkedList;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import tr.unvercanunlu.parser.exception.InvalidColumnOrderException;
import tr.unvercanunlu.parser.exception.ProcessingException;
import tr.unvercanunlu.parser.factory.ColumnFactory;
import tr.unvercanunlu.parser.iterator.Iterator;
import tr.unvercanunlu.parser.iterator.impl.ColumnIteratorImpl;
import tr.unvercanunlu.parser.validation.Validator;

@RequiredArgsConstructor
public class Row implements Container<Column<?>>, Iterable<Column<?>> {

  @Getter
  private final String raw;

  @Getter
  private final Config config;

  @Override
  public LinkedList<Column<?>> extract() {
    LinkedList<Column<?>> extracted = new LinkedList<>();

    try {
      Validator.validateRaw(Row.class.getSimpleName());

      String[] rawColumns = raw.split(String.valueOf(config.columnSeparator()));

      if (rawColumns.length > config.columnOrder().size()) {
        throw new InvalidColumnOrderException(rawColumns.length, config.columnOrder().size());
      }

      for (int i = 0; i < rawColumns.length; i++) {
        Column<?> column = ColumnFactory.generate(config.columnOrder().get(i), rawColumns[i], config);
        extracted.add(column);
      }

    } catch (Exception e) {
      throw new ProcessingException("Row cannot be extracted", raw, Row.class.getSimpleName(), e);
    }

    return extracted;
  }

  @Override
  public Iterator<Column<?>> getIterator() {
    LinkedList<Column<?>> extracted = extract();
    return new ColumnIteratorImpl(extracted);
  }

}
