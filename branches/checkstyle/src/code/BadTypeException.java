package code;

/**
 * @author Kelvin
 *
 */
public class BadTypeException extends IllegalArgumentException{
	public BadTypeException (String errmsg) {
		super(errmsg);
	}
}
