package code;
import java.util.*;

/**
 * @author Kelvin
 * @see Entry.java
 */

/**<h1>Stack Class</h1>
 * Demonstrates a customized stack that is supposed to store Entry type values.
 * Those values are also defined in another class.
 * The stack adopts the list interface of arraylist type.
 */
public class Stack {
	private int size;
	private ArrayList<Entry> entries;
	
	/**<h1>Stack Class without size declaration</h1>
	 * {@summary This is a constructor for those stacks that are not defined with their sizes.}
	 * <ul>
	 * <li>The default size value is 0 (ie. empty stack).</li>
	 * <li>A new stack is defined here.</li>
	 *</ul>
	 */
	public Stack()
	{
		size=0;
		entries = new ArrayList<Entry>(size);
	}
	
	/**<h1>Stack Class with size declaration</h1>
	 * {@summary This is a constructor for those stacks that are defined with known sizes.}
	 * @param s A customized size of the stack
	 */
	public Stack(int s) throws ArrayIndexOutOfBoundsException
	{
		if (s<=0)
		{
			throw new ArrayIndexOutOfBoundsException("Invalid stack size!");
		}
		else
		{
			size=s;
			entries = new ArrayList<Entry>(size);
		}
	}
	
	/**
	 * {@summary Add an item to the stack.}
	 * @param i The entry the user wants to add into the stack.
	 */
	public void push(Entry i) {
		// TODO Auto-generated method stub
		entries.add(i); //add an item to the top of the stack (ie. the last item)
						   //increment size when pushing an item so that the size of stack keeps updated
		if (entries.get(size) != null) {
			++size;
		}
	}
	
	/**
	 * {@summary This method is basically getting the top entry in the stack.}
	 * @return The last entry in the stack (ie. at the top based on LIFO mechanism).
	 */
	public Entry top() throws EmptyStackException{
		// TODO Auto-generated method stub
		if (isEmpty()) //return exit code when the stack is empty
		{
			throw new EmptyStackException("Empty Stack!");
		}
		else
		{
			return entries.get(size-1);
		}
	}

	/**
	 * As the stack is continuously appended, this method is to retrieve the size of it.
	 * @return current size of the stack.
	 */
	public int size() {
		// TODO Auto-generated method stub
		return this.size;
	}

	/**
	 * This method is to remove the top entry from the stack and recognize what is removed.
	 * @return The removed entry.
	 */
	public Entry pop() throws EmptyStackException,BadTypeException{
		// TODO Auto-generated method stub
		Entry newestEntry_Num = new Entry(-1);
		Entry newestEntry_Sym = new Entry(Symbol.INVALID);
		Entry newestEntry_Str = new Entry("Invalid");
		if (isEmpty()) //throw an exception when the stack is empty
		{
			throw new EmptyStackException("Empty Stack!");
		}
		else
		{
			//assign the top entry to the right type of variable
			if (entries.get(size-1).getType()==Type.NUMBER)
			{
				newestEntry_Num = entries.get(size-1);
				entries.remove(size-1); //remove newest entry
				--size;
				return newestEntry_Num;
			}
			else if (entries.get(size-1).getType()==Type.SYMBOL)
			{
				newestEntry_Sym = entries.get(size-1);
				entries.remove(size-1); //remove newest entry
				--size;
				return newestEntry_Sym;
			}
			else if (entries.get(size-1).getType()==Type.STRING) {
				newestEntry_Str = entries.get(size-1);
				entries.remove(size-1); //remove newest entry
				--size;
				return newestEntry_Str;
			}
			else {
				throw new BadTypeException("Entry does not support the type of "+entries.get(size-1));
			}
		}
	}
	
	/**
	 * {@summary check whether the stack is empty, of no entries inside, or not.}
	 * @return a boolean evaluated result of the emptiness status.
	 */
	public boolean isEmpty()
	{
		return size==0;
	}

	//hash code and equals method, generated at 13/11/2019
	@Override
	public int hashCode() {
		return Objects.hash(entries, size);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Stack)) {
			return false;
		}
		Stack other = (Stack) obj;
		return Objects.equals(entries, other.entries) && size == other.size;
	}
	//hash code and equals() ends here.
}
