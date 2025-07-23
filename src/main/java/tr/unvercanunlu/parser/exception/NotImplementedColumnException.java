package tr.unvercanunlu.parser.exception;

import lombok.Getter;

public class NotImplementedColumnException extends RuntimeException {

  @Getter
  private final String raw;

  public NotImplementedColumnException(String raw) {
    super(String.format("Not implemented column: raw=%s", raw));

    this.raw = raw;
  }

}
