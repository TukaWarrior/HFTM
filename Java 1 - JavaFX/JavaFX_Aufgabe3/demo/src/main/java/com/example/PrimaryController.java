package com.example;

import java.io.IOException;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

public class PrimaryController {


    @FXML
    private static ObservableList<Entry> entryList;

    // @FXML 
    // private TableView<Entry, String> columnFirstName;

    // @FXML 
    // private TableView<Entry, String> columnLastName;

    @FXML
    private void onActionNew() throws IOException {
        System.out.println("New");
    }
    
    @FXML
    private void onActionEdit() throws IOException {
        System.out.println("Edit");
    }

    @FXML
    private void onActionSave() throws IOException {
        System.out.println("Save");
    }

    private Entry entry1 = new Entry("Andeson", "Andre");
    private Entry entry2 = new Entry("Bubba", "Bart");

    ObservableList<Entry> observableList = FXCollections.observableList(entryList);



}