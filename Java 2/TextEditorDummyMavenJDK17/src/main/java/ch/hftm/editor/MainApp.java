package ch.hftm.editor;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainApp extends Application {

	private Stage primaryStage;
	private AnchorPane editorView;

	@Override
	public void start(Stage primaryStage) {

		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Text-Editor");

		this.showEditorView();
	}

	/**
	 * Initializes the Editor View
	 */
	public void showEditorView() {
		try {
			// Load person overview.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/fxml/EditorView.fxml"));
			editorView = (AnchorPane) loader.load();

			// Show the scene containing the root layout.
			Scene scene = new Scene(editorView);
			primaryStage.setScene(scene);
			primaryStage.setMinWidth(650);
			primaryStage.setMinHeight(400);
			primaryStage.show();

			// Give the controller access to the main app.
			//EditorController controller = loader.getController();
			//controller.setMainApp(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Returns the main stage.
	 * 
	 * @return
	 */
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
