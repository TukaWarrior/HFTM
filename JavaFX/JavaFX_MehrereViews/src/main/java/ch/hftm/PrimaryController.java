package ch.hftm;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class PrimaryController {

    @FXML
    private TableView<Prisoner> prisonerTable;
    @FXML
    private TableColumn<Prisoner, String> firstnameColumn;
    @FXML
    private TableColumn<Prisoner, String> lastnameColumn;

    @FXML
    private Label firstnameLabel;
    @FXML
    private Label lastnameLabel;

    @FXML
    public void initialize() {
        // Initialize the prisoner table with the two columns.
        this.firstnameColumn.setCellValueFactory(cellData -> cellData.getValue().firstnameProperty());
        this.lastnameColumn.setCellValueFactory(cellData -> cellData.getValue().lastnameProperty());

        // Listen for selection changes and show the prisoner details when changed.
        this.prisonerTable.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> this.showPrisonerDetails(newValue));

        // 
        this.prisonerTable.setItems(App.getPrisonerList());
    }

    private void showPrisonerDetails(Prisoner prisoner) {
        if (prisoner != null) {
            // Fill the labels with info from the prisoner object.
            this.firstnameLabel.setText(prisoner.getFirstname());
            this.lastnameLabel.setText(prisoner.getLastname());
        } else {
            // Prisoner is null, remove all the text.
            firstnameLabel.setText("");
            lastnameLabel.setText("");
        }
    }

    @FXML
    public void onEdit() {
        Prisoner selectedPrisoner = prisonerTable.getSelectionModel().getSelectedItem();
        if (selectedPrisoner != null) {
            App.switchToEditView(selectedPrisoner);
            this.showPrisonerDetails(selectedPrisoner);
        } else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Fehlende Auswahl");
            alert.setHeaderText("Kein Insasse gewählt");
            alert.setContentText("Bitte wähle den Insasse aus der Tabelle aus, den du beareiten möchtest.");
            alert.showAndWait();
        }
    }

}
