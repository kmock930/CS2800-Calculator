package code;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import code.NumStack;

class TestNumStack {
	private NumStack ns;

	@BeforeEach
	void setUp() throws Exception {
		ns = new NumStack();
	}
	
	
	@Test	//Test1: test isEmpty() for NumStack
	void testIsEmpty() {
		assertTrue(ns.isEmpty()); //Test1.1: see if the original numstack is empty
		ns.push(9);
		assertFalse(ns.isEmpty());//Test1.2: Alternative test
		ns.pop();
		assertTrue(ns.isEmpty());//Test1.3: test emptiness after pop
	}

}
