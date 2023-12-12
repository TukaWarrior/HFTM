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
	private Text actualPathText;

	@FXML
	private void initialize() {
		try {
			FileAccess.initializeActualPath();

			if (FileAccess.getLastSaveDate() == null) {
				this.actualPathText.setText("Standard-Pfad: " + FileAccess.getActualDirectoryString());
			} else {
				this.actualPathText.setText("Letzter Speicherort (vom " + FileAccess.getLastSaveDate() + "): "
						+ FileAccess.getActualDirectoryString());
				this.pathField.setText(FileAccess.getActualFileString());
			}
		} catch (Exception e) {
			this.actualPathText.setText("Standard-Pfad: " + FileAccess.getActualDirectoryString());

			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Exception: " + e.getClass().getName());
			alert.setHeaderText(null);
			alert.setContentText("Error-Message: " + e.getMessage());
			alert.showAndWait();
		}
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
		// TODO: Auskommentieren für Aufgabe Teil 2 c)
		// this.actualPathText.setText("Aktueller-Pfad: " +
		// FileAccess.getActualDirectoryString());
		// this.pathField.setText(FileAccess.getActualFileString());
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
		// TODO: Auskommentieren für Aufgabe Teil 2 c)
		// this.actualPathText.setText("Aktueller-Pfad: " +
		// FileAccess.getActualDirectoryString());
		// this.pathField.setText(FileAccess.getActualFileString());
	}
}
