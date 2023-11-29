/**
 * This is the visitor pattern for visiting an expression tree.
 * Every type of TreeNode must have a visit() method in any implementation.
 *  
 * Referenced a class from Dave
 * @author dave
 *
 */
public interface Visitor {
  public void visit(OperatorNode node);
  
  public void visit(LeafNode node);
}
