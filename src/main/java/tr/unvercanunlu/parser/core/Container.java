package tr.unvercanunlu.parser.core;

import java.util.LinkedList;

public interface Container<T> {

  LinkedList<T> extract();

}
