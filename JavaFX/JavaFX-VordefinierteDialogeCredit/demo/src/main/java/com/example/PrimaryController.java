package com.example;

import java.io.IOException;
import java.util.Optional;
import java.util.Random;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;


public class PrimaryController {

    private static final String[] FIRST_THREE_NUMBERS = { "079", "077", "076", "078" };
    private static final int MIDDLE_THREE_DIGITS = 999;
    private static final int MIDDLE_TWO_DIGITS = 99;
    private static final int LAST_TWO_DIGITS = 99;

    private static String generateNumberString() {
        Random random = new Random();
        String firstThreeNumbers = FIRST_THREE_NUMBERS[random.nextInt(FIRST_THREE_NUMBERS.length)];
        String middleThreeDigits = String.format("%03d", random.nextInt(MIDDLE_THREE_DIGITS + 1));
        String middleTwoDigits = String.format("%02d", random.nextInt(MIDDLE_TWO_DIGITS + 1));
        String lastTwoDigits = String.format("%02d", random.nextInt(LAST_TWO_DIGITS + 1));
        return firstThreeNumbers + " " + middleThreeDigits + " " + middleTwoDigits + " " + lastTwoDigits;
    }

    @FXML
    private void switchToSecondary() throws IOException {

        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Wow! Das ist schlecht");
        alert.setHeaderText("Gib deine Telefonnummer ein");
        alert.setContentText("Ist eine von denen deine Nummer?");

        ButtonType buttonType1 = new ButtonType(generateNumberString());
        ButtonType buttonType2 = new ButtonType(generateNumberString());
        ButtonType buttonType3 = new ButtonType(generateNumberString());
        ButtonType buttonType4 = new ButtonType(generateNumberString());
        ButtonType buttonType5 = new ButtonType(generateNumberString());
        ButtonType buttonType6 = new ButtonType(generateNumberString());
        ButtonType buttonType7 = new ButtonType("Nein");

        alert.getButtonTypes().setAll(buttonType1, buttonType2, buttonType3, buttonType4, buttonType5, buttonType6, buttonType7);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonType7) {
            switchToSecondary();
        } else if (result.get() == buttonType1) {
        } else if (result.get() == buttonType2) {
        } else if (result.get() == buttonType3) {
        } else if (result.get() == buttonType4) {
        } else if (result.get() == buttonType5) {
        } else if (result.get() == buttonType6) {
        } else { 
        }
    }
}