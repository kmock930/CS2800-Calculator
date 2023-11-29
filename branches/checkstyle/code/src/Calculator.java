// A classical Singleton - notice that it is final.
package application;

public final class Calculator {
  private Calculator() {}
  private static Calculator instance = null;
  
  public static Calculator getInstance() {
    if (instance == null) {
      instance = new Calculator();
    }
    return instance;
  }

  public Double evaluate(String text) {
      return 23.45;
  }
}
