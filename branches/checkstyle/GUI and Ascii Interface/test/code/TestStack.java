package code;
import static org.junit.Assert.*;

import java.util.Objects;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import code.Entry;
import code.Stack;

/**
 * @author Kelvin
 * @see Entry.java
 * @see Stack.java
 */
class TestStack {	
	private Stack st;
	private Entry en_n;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		st = new Stack();
		en_n = new Entry(0);
	}

	@Test	//Test 1: test updating a value to the stack
	public void pushThenTop() {
		st.push(en_n);
		assertSame(en_n,st.top()); //Test 1.1: push then Top
		assertFalse("Not empty after pushing an entry",st.isEmpty()); //Test 1.2: Not Empty after pushing
	}
	
	@Test	//Test 2: test if it returns the correct stack size
	public void pushThenSize() {
		st.push(en_n);
		assertEquals("Test2: push then size",1,st.size()); //Test 2: check size after 1 push
	}
	
	@Test	//Test 3: test deleting an item from the stack
	public void pushThenPop() {
		st.push(en_n);
		assertEquals("Test3: Push then pop",en_n,st.pop()); //Test3: push then pop
	}
	

	@Test	//Test 4: test emptiness
	public void testEmpty() {
		assertTrue("Test4: nothing's done with the stack",st.isEmpty()); //Test4: nothing's done with the stack
		st.push(en_n);
		assertFalse("Test4: test not empty after changing size",st.isEmpty()); //Test4.1: test not empty after changing size
		st.pop();
		assertTrue("Test4: nothing's done with the stack",st.isEmpty()); //Test4.2: after a push and a pop
	}
}
