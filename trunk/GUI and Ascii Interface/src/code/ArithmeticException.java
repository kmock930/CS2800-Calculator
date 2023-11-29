/**
 * 
 */

package code;

/**
 * Arithmetic Exception.
 * {@summary declared to extend an existing exception and to customize my own one.}
 * @author Kelvin
 */
public class ArithmeticException extends IllegalArgumentException {
  public ArithmeticException(String errmsg) {
    super(errmsg);
  }
}
