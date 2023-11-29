import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MinusTest {
  
  @Test
  public void test() {
    Minus minus = Minus.getInstance();
    assertEquals(minus.eval(3, 4), -1,0);
  }
}
