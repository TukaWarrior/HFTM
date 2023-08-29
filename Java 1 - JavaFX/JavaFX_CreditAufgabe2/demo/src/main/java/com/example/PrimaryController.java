package com.example;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class PrimaryController {

    // Fields
    @FXML
    private Text prisoner1Lastname;
    @FXML
    private Text prisoner1Firstname;
    @FXML
    private Text prisoner2Lastname;
    @FXML
    private Text prisoner2Firstname;
    @FXML
    private VBox editBox;
    @FXML
    private TextField lastnameField;
    @FXML
    private TextField firstnameField;
    @FXML
    private Button button;

    // Create Objects
    private Prisoner prisoner1 = new Prisoner("Bubba", "John");
    private Prisoner prisoner2 = new Prisoner("Twitch", "Fred");
    private Prisoner editingPrisoner;

    @FXML
    public void initialize() {
        this.prisoner1Lastname.textProperty().bind(prisoner1.lastnameProperty());
        this.prisoner1Firstname.textProperty().bind(prisoner1.firstnameProperty());

        this.prisoner2Lastname.textProperty().bind(prisoner2.lastnameProperty());
        this.prisoner2Firstname.textProperty().bind(prisoner2.firstnameProperty());
    }

    @FXML
    public void onEdit1() {
        this.startEditing(prisoner1);
    }

    @FXML
    public void onEdit2() {
        this.startEditing(prisoner2);
    }

    @FXML
    public void onSave() {
        this.editBox.setDisable(true);
        editingPrisoner.setFirstname(this.firstnameField.getText());
        editingPrisoner.setLastname(this.lastnameField.getText());
    }

    private void startEditing(Prisoner p) {
        this.editBox.setDisable(false);
        this.editingPrisoner = p;
        this.lastnameField.setText(p.getLastname());
        this.firstnameField.setText(p.getFirstname());
    }
}