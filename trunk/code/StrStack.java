/**
 * 
 */

package code;

import java.util.Objects;

/**
 * StrStack.
 * {@summary a stack that stores a series of strings for the output of
 * infix-to-reverse-polish translation}
 * @author Kelvin
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

  /**
   * push.
   * {@summary add a string entry to the stack.}
   * @params
   */
  public void push(String s) throws BadTypeException {
    // TODO Auto-generated method stub
    Entry enStr = new Entry(s);
    if (enStr.getType() != Type.STRING) {
      throw new BadTypeException("Invalid Type!");
    } else {
      strStack.push(enStr);
    }
  }

  /**
   * pop.
   * {@summary remove the latest entry from the stack.}
   * @return
   */
  public String pop() throws EmptyStackException {
    // TODO Auto-generated method stub
    if (strStack.isEmpty()) {
      throw new EmptyStackException("Empty Stack!");
    } else {
      return strStack.pop().getString();
    }
  }

  public int size() {
    return strStack.size();
  }

  //hash code and equals method, generated at 13/12/2019
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
