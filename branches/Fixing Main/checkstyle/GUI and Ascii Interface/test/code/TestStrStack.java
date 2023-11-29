package code;
import static org.junit.Assert.*;

import java.util.Objects;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import code.Entry;
import code.Stack;
import code.StrStack;

/**
 * @author Kelvin
 * @see Entry.java
 * @see Stack.java
 */
class TestStrStack {	
	private StrStack st;
	private String testString;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		st = new StrStack();
		testString = new String("Hello");
	}

	@Test	//Test1: test isEmpty() for Opstack
	public void testEmpty() {
		assertTrue("Test1.1: nothing's done with the stack",st.isEmpty()); //Test1.1: nothing's done with the stack
		st.push(testString);
		assertFalse("Test1.2: test not empty after push",st.isEmpty()); //Test1.2: test not empty after push
		st.pop();
		assertTrue("Test1.3: nothing's done with the stack",st.isEmpty()); //Test1.3: test empty after a push and a pop
	}
	
	
}
