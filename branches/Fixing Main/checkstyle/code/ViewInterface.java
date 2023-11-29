/**
 * 
 */

package code;

import java.util.function.Consumer;

/**
 * ViewIterface.
 * {@summary get both interfaces ready with their behviors.}
 * @author Kelvin
 *
 */
public interface ViewInterface {
  public String getExpression();

  public void setAnswer(String str);

  public void addCalcObserver(Observer f);

  public void addTypeObserver(Consumer<OpType> l);

  public boolean isinfix();
}
