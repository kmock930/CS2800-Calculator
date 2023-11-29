package code;

/**
 * Empty Stack Exception.
 * {@summary declared to extend an existing exception and to customize my own one.}
 * @author Kelvin
 *
 */
public class EmptyStackException extends IllegalArgumentException {
  public EmptyStackException(String errmsg) {
    super(errmsg);
  }
}
