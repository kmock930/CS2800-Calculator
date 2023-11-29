/**
 * 
 */
package cs2800;

import java.util.Objects;

/**
 * @author Kelvin
 *
 */
public class CalcModel {
	private Calculator revPolish;
	private Calculator Standard;
	private Calculator current;
	private boolean infix;
	private float result;
	private NumStack CalcMem;
	
	public CalcModel() {
		result = 0; //initialize the calculator's result
	}
	
	public float evaluate(String expr,boolean infix) {
		// TODO Auto-generated method stub
		if (infix) {
			//call standardCalc
			current = Standard;
			result = current.evaluate(expr);
		}
		else {
			//call revPolishCalc
			current = revPolish;
			result = current.evaluate(expr);
		}
		CalcMem.push(result); //saves the result to memory after calculation
		return result;
	}
	
	public float getCalcMem() throws EmptyStackException{
		if (CalcMem.size()>0) {
			return CalcMem.pop(); //get the most recent value from calculator memory
		}
		else {
			throw new EmptyStackException("Empty Memory!");
		}
	}

	public void setType(boolean infix) {
		// TODO Auto-generated method stub
		this.infix = infix;
	}
	
	public boolean getType() {
		// TODO Auto-generated method stub
		return this.infix;
	}
	
	public float getValue() {
		return result;
	}
	
	//hash code and equals method, generated at 02/12/2019
	//hash code and equals() ends here.
}
