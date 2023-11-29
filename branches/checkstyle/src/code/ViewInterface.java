/**
 * 
 */
package code;

import java.util.function.Consumer;

/**
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
