package code;

import java.util.Objects;

/**
 * @author Kelvin
 */

/**
 * Entry Class.
 * Demonstrating a customized Entry type that is supposed to read in values from the calculator panel.
 * The entry values are to be integrated into the stack class, which is a list-based customized datatype.
 * @see Stack.java
 */
public class Entry {
  private String str; //for storing temporary inputs or formulated error messages
  private float number;
  private Type type;
  private Symbol other;
	
  //a set of constructors to recognize the type of inputted character
  /**
   * Constructor for float number input entries.
   * {@summary initializing the type and value of entry}
   * @exception avoid all kinds of exceptions and errors
   * @param value recognized a single float digit
  */
  public Entry(String str) {
    this.str = str;
    this.type = Type.STRING;
  }
	
  public Entry(float value) {
    this.number = value;
    this.type = Type.NUMBER;
  }
	
  /**
   * Constructor for a Symbol type character input entries.
   * {@summary initializing the type and value of entry}
   * @exception avoid all kinds of exceptions and errors
   * @param value recognized a single Symbol digit, defined in another enum class.
   * @see Symbol.java
  */
  public Entry(Symbol which) {
    this.other = which;
    this.type = Type.SYMBOL;
  }

  //retrieve the input if it is a symbol
  /**
   * getSymbol.
   * {@summary a getter method for the Symbol of current entry if it is in type SYMBOL.}
   * @exception avoid all kinds of exceptions and errors
  */
  public Symbol getSymbol() throws BadTypeException {
    if (this.type != Type.SYMBOL) {
      Type temp = this.type;
      this.type = Type.INVALID;
      throw new BadTypeException("Entered value is not a valid symbol: "+temp.toString()+" found :(");
    } else {
      return other;
    }
  }

  /**
   * tosymbol.
   * {@summary convert string inputs to Symbol type values that can be computed.}
   * @param s the operation that the user inputs. Receive as a string.
   * @return the corresponding Symbol type value of the string input.
   */
   public Symbol toSymbol(String s) {
		switch (s) {
		case "(": return Symbol.LEFT_BRACKET;
		case ")": return Symbol.RIGHT_BRACKET;
		case "x": return Symbol.TIMES;
		case "/": return Symbol.DIVIDE;
		case "+": return Symbol.PLUS;
		case "-": return Symbol.MINUS;
		case "INVALID": return Symbol.INVALID;
		default: throw new IllegalArgumentException();
		}
	}
	
	/**
	 * {@summary a setter method for the type of entry.}
	 * @param t Customize the type of the entry. Receive Type-typed value as the input.
	 * @exception avoid all kinds of exceptions and errors
	 */
	public void setType(Type t) throws BadTypeException {
		boolean badtype = false;
		for (Type typecounter:Type.values()) {
			if (t!=typecounter) {
				badtype = true;
			}
			else
			{
				badtype = false;
				break;
			}
		}
		if (badtype == true) {
			Type temp = this.type;
			this.type = Type.INVALID;
			throw new BadTypeException("Entered value is not a valid type: "+temp.toString()+" found :(");
		}
		else
		{
			this.type = t;
		}
	}
	/**
	 * {@summary a getter method for the type of entry.}
	 * @return a Type-typed value of the current entry.
	 */
	public Type getType()
	{
		return type;
	}
	
	/**
	 * {@summary a setter method for str variable to customize a string for either a user-entered calculation expression or a formulated error message.}
	 * @param s a string type value for the user to customize the expression or the developer to formulate the error message.
	 * @exception avoid all kinds of exceptions and errors
	 */
	public void setString(String s) {
			this.str = s;
			this.type = Type.STRING;
	}
	/**
	 * {@summary a getter method for the string.}
	 * @exception avoid all kinds of exceptions and errors
	 * @return the relevant string
	 */
	public String getString() throws BadTypeException {
		if (this.type != Type.STRING) {
			Type temp = this.type;
			this.type = Type.INVALID;
			throw new BadTypeException("Entered value is not a valid String type: "+temp.toString()+" found :(");
		}
		else
		{
			return this.str;
		}
	}
	
	/**
	 * {@summary a getter method for the float value of the entry.}
	 * @exception avoid all kinds of exceptions and errors
	 * @return a float number value.
	 */
	public float getValue() throws BadTypeException
	{
		if (this.type != Type.NUMBER) {
			Type temp = this.type;
			this.type = Type.INVALID;
			throw new BadTypeException("Entered value is not a valid float number: "+temp.toString()+" found :(");
		}
		else
		{
			return this.number;
		}
	}
	
	/**
	 * {@summary a setter method for the float value of the entry.}
	 * @param n a customized input of a float number value of data.
	 * @exception avoid all kinds of exceptions and errors
	 */
	public void setValue(float n) throws BadTypeException{
		if (this.type != Type.NUMBER) {
			Type temp = this.type;
			this.type = Type.INVALID;
			throw new BadTypeException("Entered value is not a valid float number: "+temp.toString()+" found :(");
		}
		else
		{
			this.number = n;
			this.type = Type.NUMBER;
		}
	}

	//hash code and equals method, generated at 12/12/2019
	@Override
	public int hashCode() {
		return Objects.hash(number, other, str, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Entry)) {
			return false;
		}
		Entry other = (Entry) obj;
		return Float.floatToIntBits(number) == Float.floatToIntBits(other.number) && this.other == other.other
				&& Objects.equals(str, other.str) && type == other.type;
	}
	//hash code and equals() ends here.
	
}