import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TimesTest {
  
  @Test
  public void test() {
    Times times = Times.getInstance();
    assertEquals(times.eval(3, 4), 12,0);
  }
}
