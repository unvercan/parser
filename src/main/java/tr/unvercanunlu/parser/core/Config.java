package tr.unvercanunlu.parser.core;

import java.util.LinkedList;

public record Config(
    char rowSeparator,
    char columnSeparator,
    LinkedList<Class<? extends Column<?>>> columnOrder,
    String dateFormat,
    String timeFormat,
    String dateTimeFormat
) {

}
