package tr.unvercanunlu.parser.column.time;

import java.time.LocalTime;

public class TimeColumn extends BaseTimeColumn<LocalTime> {

  public TimeColumn(String raw, String format) {
    super(raw, format);
  }

  @Override
  protected LocalTime internalParse() {
    return LocalTime.parse(getRaw().trim(), getFormatter());
  }

}
