package tr.unvercanunlu.parser.column;

import tr.unvercanunlu.parser.core.Column;

public class BooleanColumn extends Column<Boolean> {

  public BooleanColumn(String raw) {
    super(raw);
  }

  @Override
  protected Boolean internalParse() {
    return Boolean.parseBoolean(getRaw().trim());
  }

}
