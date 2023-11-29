package code;

/**
 * Bad Type Exception.
 * {@summary declared to extend an existing exception and to customize my own one.}
 * @author Kelvin
 *
 */
public class BadTypeException extends IllegalArgumentException {
  public BadTypeException(String errmsg) {
    super(errmsg);
  }
}
