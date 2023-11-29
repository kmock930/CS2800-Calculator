public class Controller {
  Calculator c = Calculator.getInstance();
  ViewInterface myView = null;

  private void calculateAction() {
    Double a = c.evaluate(myView.getQuestion());
    myView.setAnswer(a.toString());
  }

  private void changeType(OpType t) {
    myView.setAnswer("Changed to " + t);
  }

  public Controller(ViewInterface v) {
    myView = v;
    v.addCalcObserver(this::calculateAction);
    v.addTypeObserver(this::changeType);
  }

}
