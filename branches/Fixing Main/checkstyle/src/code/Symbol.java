package code;

/**
 * @author Kelvin
 * An enum class for declaring symbols used in the calculator.
 */

public enum Symbol{
	LEFT_BRACKET,
	RIGHT_BRACKET,
	TIMES,
	DIVIDE,
	PLUS,
	MINUS,
	INVALID;

	
	Symbol(){}
	
	
	
	@Override
	public String toString() {
		switch(this) {
		case LEFT_BRACKET: return "(";
		case RIGHT_BRACKET: return ")";
		case TIMES: return "*";
		case DIVIDE: return "/";
		case PLUS: return "+";
		case MINUS: return "-";
		case INVALID: return "INVALID"; // cannot be calculated cases
		default: throw new IllegalArgumentException(); // not recognized input
		}
	}
}