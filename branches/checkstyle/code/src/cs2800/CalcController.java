/**
 * 
 */
package cs2800;

/**
 * @author Kelvin
 *
 */
public class CalcController {
	private static CalcController instance = new CalcController();
	private CalcModel model;
	private CalcView view;
	private boolean isinfix;
	private String expr;
	
	private CalcController() {
		//for singleton pattern
	}
	
	public CalcController(CalcModel model,CalcView view) {
		model = new CalcModel();
		view = new CalcView();
		model.setType(true); //value should be according to view
		//need to set isinfix value from view to CalcModel
	}

	public float calculate() {
		// TODO Auto-generated method stub
		return model.evaluate(expr,this.isinfix);
	}

	public boolean expressionType(boolean isinfix) {
		// TODO Auto-generated method stub
		this.isinfix = isinfix;
		return this.isinfix;
	}
	
	public static CalcController getInstance() {
		return instance;
	}

}
