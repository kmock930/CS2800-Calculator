/**
 * 
 */

package code;

/**
 * Invalid Expression Exception.
 * {@summary declared to extend an existing exception and to customize my own one.}
 * @author Kelvin
 *
 */
public class InvalidExpressionException extends IllegalArgumentException {
  public InvalidExpressionException(String errmsg) {
    super(errmsg);
  }
}
