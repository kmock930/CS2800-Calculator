/**
 * This is filled by the fxml loader at runtime!
 */

import java.util.function.Consumer;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;

public class GUIView implements ViewInterface {

  public void addCalcObserver(Observer f) {
    calcButton.setOnAction(new EventHandler<ActionEvent>() {

      @Override
      public void handle(ActionEvent event) {
        f.tell();
      }
    });
  }

  public void addTypeObserver(Consumer<OpType> l) {
    type.selectedToggleProperty().addListener(
        new ChangeListener<Toggle>() {
          @Override
          public void changed(ObservableValue<? extends Toggle> observable,
              Toggle from, Toggle to) {
            l.accept(to == infixButton ? OpType.INFIX : OpType.POSTFIX);
          }
        });
  }

  public String getQuestion() {
    return question.getText();
  }

  public void setAnswer(String a) {
    answer.setText(a);
  }
  ///////////////////////////////////////////////////////////////////

  @FXML
  // fx:id="calcButton"
  private Button calcButton; // Value injected by FXMLLoader

  @FXML
  // fx:id="infixButton"
  private RadioButton infixButton; // Value injected by FXMLLoader

  @FXML
  // fx:id="type"
  private ToggleGroup type; // Value injected by FXMLLoader

  @FXML
  // fx:id="postfixButton"
  private RadioButton postfixButton; // Value injected by FXMLLoader

  @FXML
  // fx:id="question"
  private TextField question; // Value injected by FXMLLoader

  @FXML
  // fx:id="answer"
  private Label answer; // Value injected by FXMLLoader
}
