/**
 * 
 */
package cs2800;

import java.util.Objects;

/**
 * @author Kelvin
 *
 */
public class RevPolishCalc {
	private NumStack values;
	private float result;
	
	public RevPolishCalc() {
		values = new NumStack();
		result = 0;
	}
	
    private static String parseExpression(String expr) {
        String parsedExpr = expr.replaceAll("[^\\^\\*\\+\\-\\d/\\s]", "");
        String trimmedExpr = parsedExpr.replaceAll("\\s+", " ");
        return trimmedExpr;
    }
	
	public float evaluate(String expr) throws InvalidExpressionException,ArithmeticException{
		String validExpr = parseExpression(expr);
		NumStack stack = new NumStack();
		float firstOperand = 0;
		float secondOperand = 0;
		
		for (String token:validExpr.split(" ")) {
			switch (token) {
			case "+":
				secondOperand = stack.pop();
				firstOperand = stack.pop();
				stack.push(firstOperand + secondOperand);
				break;
			case "-":
				secondOperand = stack.pop();
				firstOperand = stack.pop();
                stack.push(firstOperand - secondOperand);
                break;
			case "*":
				secondOperand = stack.pop();
				firstOperand = stack.pop();
                stack.push(firstOperand * secondOperand);
                break;
			case "/":
				secondOperand = stack.pop();
				firstOperand = stack.pop();
                if (secondOperand == 0.0) {
                    throw new ArithmeticException("Division by 0 error: Cannot divide by zero!");
                }
                stack.push(firstOperand / secondOperand);
                break;
            default: //read a number
                stack.push(Float.parseFloat(token));
			}
		}
		result = stack.pop();
		return result;
	}

	//hash code and equals method, generated at 01/12/2019
	@Override
	public int hashCode() {
		return Objects.hash(result, values);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof RevPolishCalc)) {
			return false;
		}
		RevPolishCalc other = (RevPolishCalc) obj;
		return Float.floatToIntBits(result) == Float.floatToIntBits(other.result)
				&& Objects.equals(values, other.values);
	}
	//hash code and equals() ends here.
}