package tr.unvercanunlu.parser.core;

import tr.unvercanunlu.parser.iterator.Iterator;

public interface Iterable<T> {

  Iterator<T> getIterator();

}
