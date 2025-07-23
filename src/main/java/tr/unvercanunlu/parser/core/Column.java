package tr.unvercanunlu.parser.core;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import tr.unvercanunlu.parser.exception.ProcessingException;
import tr.unvercanunlu.parser.validation.Validator;

@RequiredArgsConstructor
public abstract class Column<T> implements Parsable<T> {

  @Getter
  private final String raw;

  protected abstract T internalParse();

  @Override
  public T parse() {
    T parsed;

    try {
      Validator.validateRaw(raw);
      parsed = internalParse();

    } catch (Exception e) {
      throw new ProcessingException("Column cannot be parsed", raw, getClass().getSimpleName(), e);
    }

    return parsed;
  }

}
