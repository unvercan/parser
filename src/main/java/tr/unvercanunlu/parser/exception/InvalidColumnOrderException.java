package tr.unvercanunlu.parser.exception;

import lombok.Getter;

public class InvalidColumnOrderException extends RuntimeException {

  @Getter
  private final int current;

  @Getter
  private final int expected;

  public InvalidColumnOrderException(int current, int expected) {
    super(String.format("Column size not match: current=%d expected=%d", current, expected));

    this.current = current;
    this.expected = expected;
  }

}
