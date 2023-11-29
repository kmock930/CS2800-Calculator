/**
 * 
 */
package cs2800;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import code.StandardCalc;

/**
 * @author Kelvin
 *
 */
class TestStandardCalc {
	private StandardCalc vexpr;
	private float result;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		vexpr = new StandardCalc();
	}

	@Test
	void test() {
		result = vexpr.evaluate("( 5 * ( 6 + 7 ) ) - 2");
		assertEquals(result,63.0,0);
	}

}
