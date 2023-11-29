/**
 * 
 */
package cs2800;

import java.util.Objects;

/**
 * @author Kelvin
 *
 */
public class NumStack {
	private Stack numStack;
	
	public NumStack() {
		numStack = new Stack();
	}

	public void push(float i) throws BadTypeException{
		Entry NumEntry = new Entry(i);
		if (NumEntry.getType()!=Type.NUMBER) { 
			throw new BadTypeException("Invalid Type!");
		}
		else {
			numStack.push(NumEntry);
		}
	}
	
	public float pop() throws EmptyStackException{
		if (numStack.isEmpty()) {
			throw new EmptyStackException("Empty Stack!");
		}
		else
		{
			return numStack.pop().getValue(); //make it a float value
			
		}
		
	}
	
	public boolean isEmpty() {
		return numStack.isEmpty();
	}
	
	public int size() {
		return numStack.size();
	}

	//hash code and equals method, generated at 28/11/2019
	@Override
	public int hashCode() {
		return Objects.hash(numStack);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof NumStack)) {
			return false;
		}
		NumStack other = (NumStack) obj;
		return Objects.equals(numStack, other.numStack);
	}
	//hash code and equals() ends here.
	
}
