package tr.unvercanunlu.parser.iterator.impl;

import java.util.LinkedList;
import tr.unvercanunlu.parser.core.Row;

public class RowIteratorImpl extends BaseIteratorImpl<Row> {

  public RowIteratorImpl(LinkedList<Row> values) {
    super(values);
  }

}
