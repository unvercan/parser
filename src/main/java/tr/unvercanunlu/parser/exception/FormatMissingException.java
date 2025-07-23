package tr.unvercanunlu.parser.exception;

import lombok.Getter;

public class FormatMissingException extends RuntimeException {

  @Getter
  private final String type;

  public FormatMissingException(String type) {
    super(String.format("Format missing: type=%s", type));

    this.type = type;
  }

}
