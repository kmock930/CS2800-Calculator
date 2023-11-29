package code;

import java.util.Objects;

/**
 * CalcController.
 * {@summary singleton pattern.}
 * @authro Dave
 * @author Kelvin
 *
 */
public class CalcController {
  CalcModel calcModel = CalcModel.getInstance();
  ViewInterface myView = null;

  private void calculateAction() {
    float a = calcModel.evaluate(myView.getExpression(),myView.isinfix());
    String str = String.valueOf(a);
    myView.setAnswer(str);
  }

  private void changeType(OpType t) {
    myView.setAnswer("Changed to " + t);
  }

  /**
   * CalcController.
   * {@summary constructor to setup the observer}
   * @paramv
   */
  public CalcController(ViewInterface v) {
    myView = v;
    v.addCalcObserver(this::calculateAction);
    v.addTypeObserver(this::changeType);
  }

  //hash code and equals method, generated at 12/12/2019
  @Override
  public int hashCode() {
    return Objects.hash(calcModel, myView);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof CalcController)) {
      return false;
    }
    CalcController other = (CalcController) obj;
    return Objects.equals(calcModel, other.calcModel) && Objects.equals(myView, other.myView);
  }
  //hash code and equals() ends here.
}