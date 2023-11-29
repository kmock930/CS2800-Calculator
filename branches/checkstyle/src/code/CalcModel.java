// A classical Singleton - notice that it is final.
package code;

/**
 * 
 * @author Dave
 * @author Kelvin
 *
 */
public final class CalcModel {
  private float result;
  private RevPolishCalc revPol;
  private StandardCalc standCalc;
  private NumStack CalcMem;
  
  private CalcModel() {
	  result = 0; //initialize the calculator's result
	  revPol = new RevPolishCalc();
	  standCalc = new StandardCalc();
  }
  private static CalcModel instance = null;
  
  public static CalcModel getInstance() {
    if (instance == null) {
      instance = new CalcModel();
    }
    return instance;
  }

  public float evaluate(String expr,boolean infix) {
	  if (infix) {
		//call standardCalc
		result = standCalc.evaluate(expr);
	  } else {
		//call revPolishCalc
		result = revPol.evaluate(expr);		
	  }
	  return result;  
  }
  
  public float getCalcMem() throws EmptyStackException{
    if (CalcMem.size()>0) {
      return CalcMem.pop(); //get the most recent value from calculator memory
    } else {
      throw new EmptyStackException("Empty Memory!");
    }
  }
  //hash code and equals method, generated at 02/12/2019
  //hash code and equals() ends here.
}