package tr.unvercanunlu.parser.column.time;

import java.time.format.DateTimeFormatter;
import lombok.Getter;
import tr.unvercanunlu.parser.core.Column;

public abstract class BaseTimeColumn<T> extends Column<T> {

  @Getter
  private final String format;

  @Getter
  private final DateTimeFormatter formatter;

  protected BaseTimeColumn(String raw, String format) {
    super(raw);

    this.format = format;
    this.formatter = DateTimeFormatter.ofPattern(format);
  }

}
