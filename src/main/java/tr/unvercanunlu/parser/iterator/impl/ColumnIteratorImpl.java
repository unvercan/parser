package tr.unvercanunlu.parser.iterator.impl;

import java.util.LinkedList;
import tr.unvercanunlu.parser.core.Column;

public class ColumnIteratorImpl extends BaseIteratorImpl<Column<?>> {

  public ColumnIteratorImpl(LinkedList<Column<?>> values) {
    super(values);
  }

}
