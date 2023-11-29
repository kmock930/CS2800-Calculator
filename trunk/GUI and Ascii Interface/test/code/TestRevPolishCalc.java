package code;
import static org.junit.Assert.*;

import java.util.Objects;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import code.Entry;
import code.RevPolishCalc;
import code.Stack;

/**
 * @author Kelvin
 * @see Entry.java
 * @see Stack.java
 */
class TestRevPolishCalc {	
	private RevPolishCalc vexpr;
	private float result;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		vexpr = new RevPolishCalc();
	}

	@Test	//Test1: test the evaluation result
	public void testEvaluate() {
		result = vexpr.evaluate("5 6 7 + * 2 -");
		assertEquals(result,63.0,0);
	}	
}
