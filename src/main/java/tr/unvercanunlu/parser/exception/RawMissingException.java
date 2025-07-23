package tr.unvercanunlu.parser.exception;

import lombok.Getter;

public class RawMissingException extends RuntimeException {

  @Getter
  private final String type;

  public RawMissingException(String type) {
    super(String.format("Raw missing: type=%s", type));

    this.type = type;
  }

}
