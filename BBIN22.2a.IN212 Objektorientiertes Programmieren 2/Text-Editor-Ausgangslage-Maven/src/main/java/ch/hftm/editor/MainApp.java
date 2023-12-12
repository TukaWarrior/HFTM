package ch.hftm.editor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.IOException;

import javafx.application.Application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.nio.charset.Charset;
import java.nio.file.*;

public class MainApp extends Application {

	@FXML
	private Button saveFile;
	@FXML
	private Button readFile;

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

	public static void saveFile(String path, String fileContent){
		Path p = Paths.get(path);
		try {
			BufferedWriter bw = Files.newBufferedWriter(p, Charset.forName("UTF-8"), StandardOpenOption.CREATE,
					StandardOpenOption.APPEND);
			bw.write(fileContent, 0, fileContent.length());
			bw.close();
		} catch (IOException ioe) {
				System.out.println("Error reading file.");
				System.exit(0);;
		}

		public static String loadFile(String path){
			String line = "", fileContent = "";
			Path p = Paths.get(path);
			try {
				BufferedReader fileInput = Files.newBufferedReader(p, Charset.forName("UTF-8"));
				while (line != null){
					line = fileInput.readLine();
					if (line != null){
						fileContent += line;
					}
					fileInput.close();
				}
			} catch (EOFException eofe) {
				System.out.println("No more lines to read.");
				System.exit(0);
			} catch (IOException ioe) {
				System.out.println("Error reading file.");
				System.exit(0);
			}
			return fileContent;
		}

}