package cs2800;
import static org.junit.Assert.*;

import java.util.Objects;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import code.Entry;
import code.Stack;
import code.Symbol;
import code.Type;

/**
 * @author Kelvin
 * @see Entry.java
 * @see Stack.java
 */
class TestEntry {
	private Entry en_n;
	private Entry en_s;
	private Entry en;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		en = new Entry(0);
		en_n = new Entry(0); //number
		en_s = new Entry(Symbol.PLUS); //symbol
		en.setString("Hello");
	}

	@Test	//Test1: test retrieving string through Entry class
	public void testGetString() {
		assertEquals("Test1: Compare strings",en.getString(),"Hello"); //Test1: Compare strings
	}
	
	@Test	//Test 2: test retrieving a number through Entry class
	public void testGetValue() {
		en_n.setValue(1);
		assertEquals("Test2: Test get number",en_n.getValue(),1,0); //Test2: Test get number
	}
	
	@Test	//Test 3: test retrieving a symbol through Entry class
	public void setThenGetSymbol() {
		Symbol expected = en_s.getSymbol();
		Symbol actual = en_s.toSymbol("+");
		assertSame(expected,actual); //Test3: set and get symbol from string
	}
	
	@Test	//Test 4: test retrieving the corresponding type of Entry instance
	public void setThenGetType() {
		assertSame(en_s.getType(),Type.SYMBOL); //Test4.1: set and get equal type (Symbol type)
		assertSame(en_n.getType(),Type.NUMBER); //Test4.2: set and get equal type (Number type)
		assertSame(en.getType(),Type.STRING); //Test4.3: set and get equal type (String type)
	}
}
