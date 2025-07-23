package tr.unvercanunlu.parser.validation;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import tr.unvercanunlu.parser.exception.FormatMissingException;
import tr.unvercanunlu.parser.exception.RawMissingException;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Validator {

  public static void validateFormat(String format, String type) throws FormatMissingException {
    if ((format == null) || format.trim().isEmpty()) {
      throw new FormatMissingException(type);
    }
  }

  public static void validateRaw(String raw) throws RawMissingException {
    if (raw == null) {
      throw new RawMissingException(raw);
    }
  }
}
