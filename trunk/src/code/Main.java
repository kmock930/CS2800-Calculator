package code;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	static FXMLLoader loader;
	static Parent root;

	@Override
	public void start(Stage primaryStage) {
		Scene scene = new Scene(root, 400, 400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	/**
	 * 
	 * @param args The command line arguments
	 * @throws IOException The program exits if it cannot start the GUI
	 * 
	 *                     Bizarrely, and due to a quirk of JavaFx, we have to call
	 *                     FXMLLoader from the main() method within an Application
	 *                     class. Hence the mess, rather than having a separate
	 *                     Runner and Application
	 */
	public static void main(String[] args) throws IOException {
		Boolean ASCII = false;
		ViewInterface v;

		if (System.console() != null) {
			ASCII = true;
		}

		// Create desired view type.
		if (ASCII) {
			v = new AsciiView();
		} else {
			loader = new FXMLLoader(code.Main.class.getResource("GuiConfig.fxml"));
			root = loader.load();
			v = loader.getController();
		}

		// Controller is decoupled from the actual type of view
		new CalcController(v);

		// Start collecting user interactions
		if (ASCII) {
			((AsciiView) v).menu();
			// We need to explicitly exit here because the Application has been
			// automatically started
			System.exit(0);
		} else {
			Application.launch(args);
		}
	}
}
