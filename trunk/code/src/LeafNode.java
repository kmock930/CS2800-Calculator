/**
 * A TreeNode in an expression tree is either a leaf or an operator with 
 * two children: this is the leaf.
 * It contains the value so that its parent can evaluate its operator.
 * 
 * <p>Since it can be visited it must have an accept() method - which is of course trivial.
 * 
 * Referenced a class from Dave
 * @author dave
 *
 */
public class LeafNode implements TreeNode {
  private int value;
  
  LeafNode(int value) {
    this.value = value;
  }
  
  int getValue() {
    return value;
  }
  
  /**
   * @param visitor accumulates data from this tree node in its visit() method.
   */
  public void accept(Visitor visitor) {
    visitor.visit(this);
  }

}
