/**
 * 
 */

package code;

import java.util.Objects;

/**
 * NumStack.
 * {@summary a stack that specifically stores numbers for calculation.}
 * @author Kelvin
 *
 */
public class NumStack {
  private Stack numStack;

  public NumStack() {
    numStack = new Stack();
  }

  /**
   * push.
   * {@summary add a number entry to the stack.}
   * @parami
   */
  public void push(float i) throws BadTypeException {
    Entry numEntry = new Entry(i);
    if (numEntry.getType() != Type.NUMBER) { 
      throw new BadTypeException("Invalid Type!");
    } else {
      numStack.push(numEntry);
    }
  }

  /**
   * pop.
   * {@summary remove the latest number entry from the stack.}
   */
  public float pop() throws EmptyStackException {
    if (numStack.isEmpty()) {
      throw new EmptyStackException("Empty Stack!");
    } else {
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
