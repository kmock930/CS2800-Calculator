package cs2800;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import code.Symbol;

/**
 * @author Kelvin
 *
 */
class TestSymbol {
	private Symbol sym;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
	}

	@Test	//Test 1: test the process of getting a string from a symbol
	public void testToString() {
		sym = Symbol.DIVIDE;
		String expected = "/";
		String actual = sym.toString();
		assertEquals(actual,expected); //Test1: test toString same as symbol
	}
	
	@Test	//Test 2: Alternative testing (similar to test 1)
	public void testNotToString() {
		sym = Symbol.RIGHT_BRACKET;
		String unexpected = ",";
		String actual = sym.toString();
		assertNotEquals(unexpected,actual); //Test2: error case checking
	}
	
	@Test	//Test 3: test if the symbol and the corresponding string matches
	public void testSymbolToString() {
		sym = Symbol.MINUS;
		String a = "MINUS";
		String b = sym.toString();
		assertNotEquals(a,b); //Test3: cross type checking
	}

}
