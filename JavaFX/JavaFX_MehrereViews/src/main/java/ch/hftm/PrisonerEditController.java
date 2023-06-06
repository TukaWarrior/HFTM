package ch.hftm;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class PrisonerEditController {
    @FXML
    private TextField firstnameField;
    @FXML
    private TextField lastnameField;

    private Prisoner prisoner;

    public void setPrisoner(Prisoner prisoner) {
        this.prisoner = prisoner;

        // Schreibt den vorherigen Wert ins Textfeld, bevor dieses editiert wird
        firstnameField.setText(prisoner.getFirstname());
        lastnameField.setText(prisoner.getLastname());
    }

    @FXML
    private void onSave() {
        this.prisoner.setFirstname(firstnameField.getText());
        this.prisoner.setLastname(lastnameField.getText());

        App.switchToMainView();
    }

    @FXML
    private void onCancel() {
        App.switchToMainView();
    }
}
