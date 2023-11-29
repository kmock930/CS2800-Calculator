/**
 * 
 */
package cs2800;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Kelvin
 *
 */
class TestCalcModel {
	private CalcModel cm;
	private float result;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		cm = new CalcModel();
	}
	
	@Test //Test1: test both notations' expressions using 2 param version of method
	void testTwoParam() {
		result = cm.evaluate("( 5 * ( 6 + 7 ) ) - 2",true);
		assertEquals(result,63.0,0); //test 1.1: infix
		
		result = cm.evaluate("5 6 7 + * 2 -",false);
		assertEquals(result,63.0,0); //test1.2: reverse polish
	}
	
	@Test //Test2: test setType()
	void testSetType() {
		cm.setType(true);
		assertEquals(cm.getType(),true); //test2.1: test if setting types correctly
	}

}
