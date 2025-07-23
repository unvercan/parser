package tr.unvercanunlu.parser.exception;

public class ProcessingException extends RuntimeException {

  public ProcessingException(String message, String raw, String type, Throwable cause) {
    super(String.format("%s: raw=%s type=%s reason=%s", message, raw, type, cause.getMessage()), cause);
  }

}
