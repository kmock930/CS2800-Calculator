/**
 * 
 */
package cs2800;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Kelvin
 *
 */
class TestCalcController {
	private CalcController cc;
	private float result;
	private boolean exprType;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		cc = new CalcController();
		result = 0;
	}

	@Test
	void testCalculate() {
		result = cc.calculate();
		assertEquals(result,63,0);
	}

	@Test
	void testExpressionType() {
		exprType = cc.expressionType(true); //infix
		assertSame(exprType,true);
	}
}
