package tr.unvercanunlu.parser.iterator.impl;

import java.util.LinkedList;
import lombok.RequiredArgsConstructor;
import tr.unvercanunlu.parser.iterator.Iterator;

@RequiredArgsConstructor
public abstract class BaseIteratorImpl<T> implements Iterator<T> {

  private final LinkedList<T> values;

  private int index = 0;

  @Override
  public boolean hasPrevious() {
    return index > 0;
  }

  @Override
  public boolean hasNext() {
    return index < values.size();
  }

  @Override
  public T previous() {
    index--;

    return values.get(index);
  }

  @Override
  public T next() {
    return values.get(index++);
  }

}
