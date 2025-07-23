package tr.unvercanunlu.parser.column.time;

import java.time.LocalDateTime;

public class DateTimeColumn extends BaseTimeColumn<LocalDateTime> {

  public DateTimeColumn(String raw, String format) {
    super(raw, format);
  }

  @Override
  protected LocalDateTime internalParse() {
    return LocalDateTime.parse(getRaw().trim(), getFormatter());
  }

}
