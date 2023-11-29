package cs2800;
import static org.junit.Assert.*;

import java.util.Objects;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import code.Entry;
import code.OpStack;
import code.Stack;
import code.Symbol;

/**
 * @author Kelvin
 * @see Entry.java
 * @see Stack.java
 */
class TestOpStack {	
	private OpStack st;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		st = new OpStack();
	}

	@Test	//Test1: test isEmpty() for Opstack
	public void testEmpty() {
		assertTrue("Test1.1: nothing's done with the stack",st.isEmpty()); //Test1.1: nothing's done with the stack
		st.push(Symbol.PLUS);
		assertFalse("Test1.2: test not empty after push",st.isEmpty()); //Test1.2: test not empty after push
		st.pop();
		assertTrue("Test1.3: nothing's done with the stack",st.isEmpty()); //Test1.3: test empty after a push and a pop
	}
	
	
}
