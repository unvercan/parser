package tr.unvercanunlu.parser.column;

import tr.unvercanunlu.parser.core.Column;

public class NumericColumn extends Column<Double> {

  public NumericColumn(String raw) {
    super(raw);
  }

  @Override
  protected Double internalParse() {
    return Double.parseDouble(getRaw().trim());
  }

}
