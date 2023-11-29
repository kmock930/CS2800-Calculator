import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class SumVisitorTest {
  
  private LeafNode threeLeaf = new LeafNode(3);
  private LeafNode fourLeaf = new LeafNode(4);
  private Operator plus = Plus.getInstance();
  private Operator minus = Minus.getInstance();
  private Operator times = Times.getInstance();

  @Test
  public void testLeaf() {
    SumVisitor sum = new SumVisitor();
    threeLeaf.accept(sum);
    assertEquals(sum.getAnswer(), 3,0);
  }

  @Test
  public void testNode() {
    SumVisitor sum = new SumVisitor();
    OperatorNode node = new OperatorNode(plus, threeLeaf, fourLeaf);
    node.accept(sum);
    assertEquals(sum.getAnswer(), 7,0);
  }

  @Test
  public void testTree() {
    SumVisitor sum = new SumVisitor();
    OperatorNode node = new OperatorNode(plus, threeLeaf, fourLeaf);
    OperatorNode parent = new OperatorNode(plus, threeLeaf, node);
    parent = new OperatorNode(plus, parent, fourLeaf);
    parent.accept(sum);
    assertEquals(sum.getAnswer(), 14,0);
  }
  
  @Test
  public void testHardTree() {
    SumVisitor sum = new SumVisitor();
    OperatorNode node = new OperatorNode(plus, threeLeaf, fourLeaf);
    OperatorNode parent = new OperatorNode(times, node, node);
    parent = new OperatorNode(minus, parent, fourLeaf);
    parent.accept(sum);
    assertEquals(sum.getAnswer(), 45,0);
  }
}
