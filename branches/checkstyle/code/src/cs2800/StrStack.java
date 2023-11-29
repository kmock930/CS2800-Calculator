/**
 * 
 */
package cs2800;

import java.util.Objects;

/**
 * @author Kelvin
 *
 */
public class StrStack {
	private Stack strStack;
	
	public StrStack() {
		strStack = new Stack();
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return strStack.isEmpty();
	}

	public void push(String s) throws BadTypeException{
		// TODO Auto-generated method stub
		Entry en_str = new Entry(s);
		if (en_str.getType()!=Type.STRING) {
			throw new BadTypeException("Invalid Type!");
		}
		else {
			strStack.push(en_str);
		}
	}

	public String pop() throws EmptyStackException{
		// TODO Auto-generated method stub
		if (strStack.isEmpty()) {
			throw new EmptyStackException("Empty Stack!");
		}
		else {
			return strStack.pop().getString();
		}
	}
	
	public int size() {
		return strStack.size();
	}

	//hash code and equals method, generated at 13/11/2019
	@Override
	public int hashCode() {
		return Objects.hash(strStack);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof StrStack)) {
			return false;
		}
		StrStack other = (StrStack) obj;
		return Objects.equals(strStack, other.strStack);
	}
	//hash code and equals() ends here.	
}
