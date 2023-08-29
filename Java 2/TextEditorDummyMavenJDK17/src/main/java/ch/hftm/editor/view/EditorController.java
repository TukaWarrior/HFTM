package ch.hftm.editor.view;

import ch.hftm.editor.service.FileAccess;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class EditorController {

	@FXML
	private TextField pathField;
	@FXML
	private TextArea contentArea;
	@FXML
	private Text defaultPathText;

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
		defaultPathText.setText("Standard-Pfad: " + FileAccess.getDefaultPathString());
	}

	@FXML
	private void saveFile() {
		try {
			FileAccess.saveFile(pathField.getText(), contentArea.getText());
		} catch (Exception e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Exception: " + e.getClass().getName());
			alert.setHeaderText(null);
			alert.setContentText("Error-Message: " + e.getMessage());
			alert.showAndWait();
		}
	}
	
	@FXML
	private void loadFile() {
		try {
			String content = FileAccess.readFile(pathField.getText());
			this.contentArea.setText(content);
		} catch (Exception e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Exception: " + e.getClass().getName());
			alert.setHeaderText(null);
			alert.setContentText("Error-Message: " + e.getMessage());
			alert.showAndWait();
		}
	}
}
