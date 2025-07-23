package tr.unvercanunlu.parser.column;

import tr.unvercanunlu.parser.core.Column;

public class TextColumn extends Column<String> {

  public TextColumn(String raw) {
    super(raw);
  }

  @Override
  protected String internalParse() {
    return getRaw().trim();
  }

}
