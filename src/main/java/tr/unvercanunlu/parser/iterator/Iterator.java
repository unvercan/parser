package tr.unvercanunlu.parser.iterator;

public interface Iterator<T> {

  boolean hasPrevious();

  boolean hasNext();

  T previous();

  T next();

}
