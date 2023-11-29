// A classical Singleton - notice that it is final.

package code;

import java.util.Objects;

/**
 * CalcModel.
 * {@summary calling the appropriate evaluation according to expression,
 * and store results in memory.}
 * @author Dave
 * @author Kelvin
 *
 */
public final class CalcModel {
  private float result;
  private RevPolishCalc revPol;
  private StandardCalc standCalc;
  private NumStack calcMem;
  
  private CalcModel() {
    result = 0; //initialize the calculator's result
    revPol = new RevPolishCalc();
    standCalc = new StandardCalc();
  }
  
  private static CalcModel instance = null;
  
  /**
   * getInstance.
   * {@summary creating an instance as part of the singleton's behavior.}
   * @returninstance
   */
  public static CalcModel getInstance() {
    if (instance == null) {
      instance = new CalcModel();
    }
    return instance;
  }

  /**
   * evaluate.
   * {@summary call an evaluate() according to notation of expression.}
   * @paramexpr
   * @paraminfix
   * @returnresult the result
   */
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

  /**
   * getCalcMem.
   * {@summary obtain the latest result calculated.}
   */
  public float getCalcMem() throws EmptyStackException {
    if (calcMem.size() > 0) {
      return calcMem.pop(); //get the most recent value from calculator memory
    } else {
      throw new EmptyStackException("Empty Memory!");
    }
  }
  //hash code and equals method, generated at 12/12/2019
  
  @Override
  public int hashCode() {
    return Objects.hash(calcMem, result, revPol, standCalc);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof CalcModel)) {
      return false;
    }
    CalcModel other = (CalcModel) obj;
    return Objects.equals(calcMem, other.calcMem)
            && Float.floatToIntBits(result) == Float.floatToIntBits(other.result)
            && Objects.equals(revPol, other.revPol) && Objects.equals(standCalc, other.standCalc);
  }
  //hash code and equals() ends here.
}