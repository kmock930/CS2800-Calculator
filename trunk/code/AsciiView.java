package code;

import java.util.Objects;

/**
 * @author Dave
 */

import java.util.Scanner;
import java.util.function.Consumer;

/**
 * AsciiView.
 * @see ViewInterface
 * @author Dave
 * @author Kelvin
 */
public class AsciiView implements ViewInterface {
  private String question;
  public Observer calc = null;
  public Consumer<OpType> changeType = null;
  private boolean infix;

  /**
   * Menu.
   * {@summary This is a method responding to command line inputs of the calculator.}
   */
  public void menu() {
    Scanner s = new Scanner(System.in);
    boolean finished = false;
    help();

    // The order of these checks is critical because hasNext blocks
    while (!finished && s.hasNext()) {
      String t = s.next();
      switch (t.charAt(0)) {
        case 'C':
        case 'c':
          if (calc != null) {
            calc.tell();
          }
          break;
        case 'I':
        case 'i':
          if (changeType != null) {
            changeType.accept(OpType.INFIX);
            infix = true;
          }
          break;
        case 'P':
        case 'p':
          if (changeType != null) {
            changeType.accept(OpType.POSTFIX);
            infix = false;
          }
          break;
        case '?':
          question = t.substring(1);
          System.out.println("Question set to: " + question);
          break;
        case 'Q':
        case 'q':
          System.out.println("Bye");
          finished = true;
          break;
        default:
          help();
      }
    }
    s.close();
  }

  private void help() {
    System.out.println("Use one of the following:");
    System.out.println("  ?Expression - to set expression");
    System.out.println("  P - to change to postfix");
    System.out.println("  I - to change to infix");
    System.out.println("  C - to calculate");
    System.out.println("  Q - to exit");
  }

  public void addCalcObserver(Observer f) {
    calc = f;
  }

  @Override
  public void addTypeObserver(Consumer<OpType> l) {
    changeType = l;
  }

  public String getExpression() {
    return question;
  }

  public void setAnswer(String a) {
    System.out.println("Answer is just around the corner");
  }

  @Override
  public boolean isinfix() {
    // TODO Auto-generated method stub
    return infix;
  }

  //hash code and equals method, generated at 12/12/2019
  @Override
  public int hashCode() {
    return Objects.hash(calc, changeType, infix, question);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof AsciiView)) {
      return false;
    }
    AsciiView other = (AsciiView) obj;
    return Objects.equals(calc, other.calc)
      && Objects.equals(changeType, other.changeType)
      && infix == other.infix
      && Objects.equals(question, other.question);
  }
  //hash code and equals() ends here.
}
