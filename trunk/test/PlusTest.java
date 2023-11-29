import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PlusTest {
  
  @Test
  public void test() {
    Plus plus = Plus.getInstance();
    assertEquals(plus.eval(3, 4), 7,0);
  }
}
