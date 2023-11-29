/**
 * 
 */

package code;

import java.util.Objects;

/**
 * OpStack.
 * {@summary a stack that specfically stores operators in use.}
 * @author Kelvin
 */
public class OpStack {
  private Stack opStack;

  public OpStack() {
    opStack = new Stack();
  }

  /**
   * push.
   * {@summary add an operator entry to the stack.}
   * @parami
   */
  public void push(Symbol i) throws BadTypeException {
    // TODO Auto-generated method stub
    Entry symEntry = new Entry(i);
    if (symEntry.getType() != Type.SYMBOL) {
      throw new BadTypeException("Invalid Type!");
    } else {
      opStack.push(symEntry);
    }
  }

  public boolean isEmpty() {
    // TODO Auto-generated method stub
    return opStack.isEmpty();
  }

  /**
   * pop.
   * {@summary remove the latest entry of the stack.}
   */
  public Symbol pop() throws EmptyStackException {
    // TODO Auto-generated method stub
    if (opStack.isEmpty()) {
      throw new EmptyStackException("Empty Stack!");
    } else {
      return opStack.pop().getSymbol();
    }
  }

  /**
   * top.
   * {@summary return the latest entry of the stack, for reference.}
   */
  public Symbol top() throws EmptyStackException {
    // TODO Auto-generated method stub
    if (opStack.isEmpty()) { //return exit code when the stack is empty
      throw new EmptyStackException("Empty Stack!");
    } else {
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
