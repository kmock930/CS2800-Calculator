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

  /**
   * Stack Class without size declaration.
  * {@summary This is a constructor for those stacks that are not defined with their sizes.}
  * <ul>
  * <li>The default size value is 0 (ie. empty stack).</li>
  * <li>A new stack is defined here.</li>
  *</ul>
  */
  public Stack() {
    size = 0;
    entries = new ArrayList<Entry>(size);
  }

  /**
  * Stack Class with size declaration.
  * {@summary This is a constructor for those stacks that are defined with known sizes.}
  * @params A customized size of the stack
  */
  public Stack(int s) throws ArrayIndexOutOfBoundsException {
    if (s <= 0) {
      throw new ArrayIndexOutOfBoundsException("Invalid stack size!");
    } else {
      size = s;
      entries = new ArrayList<Entry>(size);
    }
  }

  /**
   * push.
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
   * top.
   * {@summary This method is basically getting the top entry in the stack.}
   * @return The last entry in the stack (ie. at the top based on LIFO mechanism).
   */
  public Entry top() throws EmptyStackException {
    // TODO Auto-generated method stub
    if (isEmpty()) { //return exit code when the stack is empty
      throw new EmptyStackException("Empty Stack!");
    } else {
      return entries.get(size - 1);
    }
  }

  /**
   * size.
   * {@summary As the stack is continuously appended, this method is to retrieve the size of it.}
   * @return current size of the stack.
   */
  public int size() {
    // TODO Auto-generated method stub
    return this.size;
  }

  /**
   * pop.
   * {@summary This method is to remove the top entry from the stack and recognize what is removed.}
  */
  public Entry pop() throws EmptyStackException,BadTypeException {
    // TODO Auto-generated method stub
    Entry newestNum = new Entry(-1);
    Entry newestSym = new Entry(Symbol.INVALID);
    Entry newestStr = new Entry("Invalid");
    if (isEmpty()) { //throw an exception when the stack is empty
      throw new EmptyStackException("Empty Stack!");
    } else {
      //assign the top entry to the right type of variable
      if (entries.get(size - 1).getType() == Type.NUMBER) {
        newestNum = entries.get(size - 1);
        entries.remove(size - 1); //remove newest entry
        --size;
        return newestNum;
      } else if (entries.get(size - 1).getType() == Type.SYMBOL) {
        newestSym = entries.get(size - 1);
        entries.remove(size - 1); //remove newest entry
        --size;
        return newestSym;
      } else if (entries.get(size - 1).getType() == Type.STRING) {
        newestStr = entries.get(size - 1);
        entries.remove(size - 1); //remove newest entry
        --size;
        return newestStr;
      } else {
        throw new BadTypeException("Entry does not support the type of " + entries.get(size - 1));
      }
    }
  }

  /**
   * isEmpty.
   * {@summary check whether the stack is empty, of no entries inside, or not.}
   */
  public boolean isEmpty() {
    return size == 0;
  }

  //hash code and equals method, generated at 13/12/2019
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
