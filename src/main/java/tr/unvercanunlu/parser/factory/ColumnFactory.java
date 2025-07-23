package tr.unvercanunlu.parser.factory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import tr.unvercanunlu.parser.column.BooleanColumn;
import tr.unvercanunlu.parser.column.NumericColumn;
import tr.unvercanunlu.parser.column.TextColumn;
import tr.unvercanunlu.parser.column.time.DateColumn;
import tr.unvercanunlu.parser.column.time.DateTimeColumn;
import tr.unvercanunlu.parser.column.time.TimeColumn;
import tr.unvercanunlu.parser.core.Column;
import tr.unvercanunlu.parser.core.Config;
import tr.unvercanunlu.parser.exception.NotImplementedColumnException;
import tr.unvercanunlu.parser.validation.Validator;

public class ColumnFactory {

  private static final Map<Class<?>, BiFunction<String, Config, Column<?>>> COLUMNS = new HashMap<>();

  static {
    COLUMNS.put(NumericColumn.class, (raw, config) -> new NumericColumn(raw));
    COLUMNS.put(BooleanColumn.class, (raw, config) -> new BooleanColumn(raw));
    COLUMNS.put(TextColumn.class, (raw, config) -> new TextColumn(raw));

    COLUMNS.put(DateColumn.class, (raw, config) -> {
      Validator.validateFormat(config.dateFormat(), LocalDate.class.getSimpleName());
      return new DateColumn(raw, config.dateFormat());
    });

    COLUMNS.put(TimeColumn.class, (raw, config) -> {
      Validator.validateFormat(config.timeFormat(), LocalTime.class.getSimpleName());
      return new TimeColumn(raw, config.timeFormat());
    });

    COLUMNS.put(DateTimeColumn.class, (raw, config) -> {
      Validator.validateFormat(config.dateTimeFormat(), LocalDateTime.class.getSimpleName());
      return new DateTimeColumn(raw, config.dateTimeFormat());
    });
  }


  public static Column<?> generate(Class<? extends Column<?>> type, String raw, Config config) {
    if (!COLUMNS.containsKey(type)) {
      throw new NotImplementedColumnException(raw);
    }

    return COLUMNS.get(type).apply(raw, config);
  }

}
