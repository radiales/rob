package sample;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {

//================================== Main Window ===================================//
    // To Do: Excel Button und Löschen Button Funktion Hinzufügen
    @FXML
    private Button MainAdd;
    @FXML
    private Button Mabt;
    @FXML
    private Button MainEnd;
    @FXML
    private Button MainDel;
    @FXML
    private Button MainExcel;
    @FXML
    private TableView<answers> tableView;
    @FXML
    private TableColumn<answers, String>    qCol;
    @FXML
    private TableColumn<answers, String>    aCol;
    @FXML
    private TableColumn<answers, String>    kCol;
    private TableColumn<answers, Integer>   id;
    private TableColumn<answers, CheckBox>  select;

    @Override
    public void initialize(URL url, ResourceBundle resources) {
        qCol.setCellValueFactory(new PropertyValueFactory<answers,String>("question"));
        aCol.setCellValueFactory(new PropertyValueFactory<answers,String>("answer"));
        kCol.setCellValueFactory(new PropertyValueFactory<answers,String>("category"));

        tableView.setItems(observableList);
    }

    ObservableList<answers> observableList= FXCollections.observableArrayList(
            new answers("Wie groß bin ich","1.98 Meter", "KEvin",1)
    );


    public Controller() {
    }

    @FXML
    private void MAdd(ActionEvent event){
        try {
            FXMLLoader loader = new FXMLLoader(new File("C:\\Users\\radia\\IdeaProjects\\rob\\src\\main\\resources\\sample.fxml").toURI().toURL()); // Maven hat die Struktur zerschossen, deshalb Hardcoded Path
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("My New Stage Title");
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide(); // Hide this current window (if this is what you want)
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void MDel(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("UC");
        alert.setHeaderText(null);
        alert.setContentText("Under Construction");

        alert.showAndWait();
    }

    @FXML
    private void abt(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText(null);
        alert.setContentText("Written by Kevin Holz\n Copyright 2019");

        alert.showAndWait();
    }

    @FXML
    private void MEnd(){
        Platform.exit();
        System.exit(0);
    }

//==================================================================================//

//================================= Frage eingeben =================================//
    @FXML
    private TextField questBox;
    @FXML
    private TextField ansBox;
    @FXML
    private TextField katBox;
    @FXML
    private Button bAdd;
    private Button exitBtn;

    @FXML
    private void bAdd(){
        answers newquestion = new answers(questBox.getText(),ansBox.getText(),katBox.getText(),0);
        tableView.getItems().add(newquestion);
        questBox.clear();
        ansBox.clear();
        katBox.clear();
    }

//=================================================================================//
}

