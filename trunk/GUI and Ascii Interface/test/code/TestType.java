package code;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import code.Type;

/**
 * @author Kelvin
 *
 */
class TestType {
	private Type ty;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		
	}

	@Test	//Test 1: test the process of getting a string from a type
	public void testToString() {
		ty = Type.NUMBER;
		String expected = "NUMBER";
		String actual = ty.toString();
		assertEquals(expected,actual); //Test1: toString equals
	}
}