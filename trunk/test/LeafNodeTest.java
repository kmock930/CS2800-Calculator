import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LeafNodeTest {
  
  @Test
  public void test() {
    LeafNode leaf = new LeafNode(5);
    assertEquals(leaf.getValue(), 5);
  }
  
}
