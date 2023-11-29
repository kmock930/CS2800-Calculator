/**
 * 
 */
package cs2800;

import java.util.function.Consumer;

/**
 * @author Kelvin
 *
 */
public interface ViewInterface {
	public String getExpression();
	public void setAnswer(String str);
	public void addCalcObserver(Runnable f);
	public void addTypeObserver(Consumer<Symbol> I);
}
