/**
 * A TreeNode in an expression tree.
 * 
 * <p>Since it can be visited it must have an accept() method.
 * 
 * Referenced a class from Dave
 * @author dave
 *
 */
public interface TreeNode {
  public void accept(Visitor visitor);
}
