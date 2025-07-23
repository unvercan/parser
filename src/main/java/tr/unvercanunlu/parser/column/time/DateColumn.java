package tr.unvercanunlu.parser.column.time;

import java.time.LocalDate;

public class DateColumn extends BaseTimeColumn<LocalDate> {

  public DateColumn(String raw, String format) {
    super(raw, format);
  }

  @Override
  protected LocalDate internalParse() {
    return LocalDate.parse(getRaw().trim(), getFormatter());
  }

}
