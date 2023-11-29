/**
 * 
 */
package cs2800;

import java.util.Objects;

/**
 * @author Kelvin
 *
 */
public class OpStack {
	private Stack opStack;

	public OpStack() {
		opStack = new Stack();
	}
	
	public void push(Symbol i) throws BadTypeException{
		// TODO Auto-generated method stub
		Entry SymEntry = new Entry(i);
		if (SymEntry.getType()!=Type.SYMBOL) {
			throw new BadTypeException("Invalid Type!");
		}
		else {
			opStack.push(SymEntry);
		}
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return opStack.isEmpty();
	}

	public Symbol pop() throws EmptyStackException{
		// TODO Auto-generated method stub
		if (opStack.isEmpty()) {
			throw new EmptyStackException("Empty Stack!");
		}
		else {
			return opStack.pop().getSymbol();
		}
	}
	
	public Symbol top() throws EmptyStackException{
		// TODO Auto-generated method stub
		if (opStack.isEmpty()) //return exit code when the stack is empty
		{
			throw new EmptyStackException("Empty Stack!");
		}
		else
		{
			return opStack.top().getSymbol();
		}
	}
	
	public int size() {
		return opStack.size();
	}

	//hash code and equals method, generated at 29/11/2019
	@Override
	public int hashCode() {
		return Objects.hash(opStack);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof OpStack)) {
			return false;
		}
		OpStack other = (OpStack) obj;
		return Objects.equals(opStack, other.opStack);
	}
	//hash code and equals() ends here.	
	
}
