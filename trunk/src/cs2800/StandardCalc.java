/**
 * 
 */
package cs2800;

import java.util.Objects;

/**
 * @author Kelvin
 *
 */
public class StandardCalc {
	private OpStack values;
	private StrStack str;
	private RevPolishCalc rpCalc;
	private float result;
	private String RevExpr;
	
	public StandardCalc () {
		values = new OpStack(); //input stack
		rpCalc = new RevPolishCalc();
		str = new StrStack(); //output stack
		RevExpr = "";
	}

	public float evaluate(String string) throws InvalidExpressionException{
		// TODO Auto-generated method stub
		String parsedString = string.replaceAll("( )+", " ");
		String trimmedExpr = parsedString.trim();
		String[] arrofTrimmed = trimmedExpr.split(" ");
		String token = "";
		for (int k=0;k<arrofTrimmed.length;++k) {
			token = arrofTrimmed[k];
			if (isNumber(token)) {
				str.push(token);
				continue;
			}
			if (token.equals("(")) {
				values.push(Symbol.LEFT_BRACKET);
				continue;
			}
			if (token.equals(")")){
				while (!values.top().toString().equals("(")) {
					str.push(values.pop().toString());
				}
				values.pop(); //delete the "("
				continue;
			}
			if (precedence(token)==-1) {
				break;
			}
			else {
				while (!values.isEmpty() && precedence(values.top().toString())>=precedence(token)) {
					str.push(values.pop().toString());
				}
				switch (token) {
				case "+":
					values.push(Symbol.PLUS);
					break;
				case "-":
					values.push(Symbol.MINUS);
					break;
				case "*":
					values.push(Symbol.TIMES);
					break;
				case "/":
					values.push(Symbol.DIVIDE);
					break;
				default:
					throw new InvalidExpressionException("Invalid operation found!");
				}
			}
		}
		while (values.size()>0) {
			str.push(values.pop().toString());
		}
		
		while (str.size()>0) {
			RevExpr += str.pop();
		}
		
		String reverse = "";
		for (int c=RevExpr.length()-1;c>=0;--c) {
			reverse += RevExpr.charAt(c) + " ";
		}
		RevExpr = reverse;
		
		result = rpCalc.evaluate(RevExpr);
		return result;
}
	
	private boolean isNumber(String str) {
		try {
			Float.parseFloat(str);
		}
		catch (Exception e) {
			return false;
		}
		return true;
	}
	
    private static int precedence(String operator)
    {
        switch(operator){
            case "(": case ")": return 0;
            case "+": case "-": return 1;
            case "*": case "/": return 2;
            case "=": return 3;
            default: return -1;
        }
    }

    //hash code and equals method, generated at 01/12/2019
	@Override
	public int hashCode() {
		return Objects.hash(RevExpr, result, rpCalc, str, values);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof StandardCalc)) {
			return false;
		}
		StandardCalc other = (StandardCalc) obj;
		return Objects.equals(RevExpr, other.RevExpr)
				&& Float.floatToIntBits(result) == Float.floatToIntBits(other.result)
				&& Objects.equals(rpCalc, other.rpCalc) && Objects.equals(str, other.str)
				&& Objects.equals(values, other.values);
	}
	//hash code and equals() ends here.
}
