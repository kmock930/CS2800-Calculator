package code;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * TestEntry.
 * @author Kelvin
 * @see Entry.java
 * @see Stack.java
 */
class TestEntry {
  private Entry numEn;
  private Entry symEn;
  private Entry strEn;

  /**
   * setUp.
   */
  @BeforeEach
  public void setUp() throws Exception {
    strEn = new Entry("");
    numEn = new Entry(0); //number
    symEn = new Entry(Symbol.PLUS); //symbol
    strEn.setString("Hello");
  }

  @Test//Test1: test retrieving string through Entry class
  public void testGetString() {
    assertEquals("Test1: Compare strings",strEn.getString(),"Hello"); //Test1: Compare strings
  }

  @Test//Test 2: test retrieving a number through Entry class
  public void testGetValue() {
    numEn.setValue(1);
    assertEquals("Test2: Test get number",numEn.getValue(),1,0); //Test2: Test get number
  }

  @Test//Test 3: test retrieving a symbol through Entry class
  public void setThenGetSymbol() {
    Symbol expected = symEn.getSymbol();
    Symbol actual = symEn.toSymbol("+");
    assertSame(expected,actual); //Test3: set and get symbol from string
  }

  @Test//Test 4: test retrieving the corresponding type of Entry instance
  public void setThenGetType() {
    assertSame(symEn.getType(),Type.SYMBOL); //Test4.1: set and get equal type (Symbol type)
    assertSame(numEn.getType(),Type.NUMBER); //Test4.2: set and get equal type (Number type)
    assertSame(strEn.getType(),Type.STRING); //Test4.3: set and get equal type (String type)
  }
}
