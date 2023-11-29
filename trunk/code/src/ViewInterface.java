import java.util.function.Consumer;

public interface ViewInterface {

  void addCalcObserver(Observer f);

  void addTypeObserver(Consumer<OpType> l);

  String getQuestion();

  void setAnswer(String a);
  ///////////////////////////////////////////////////////////////////

}