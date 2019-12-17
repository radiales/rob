package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;


public class Controller {

//================================== Main Window ===================================//
    @FXML
    private Button MainAdd;

    @FXML
    private void MAdd(ActionEvent event){
        try {
            FXMLLoader loader = new FXMLLoader(new File("C:\\Users\\radia\\IdeaProjects\\rob\\src\\main\\resources\\sample.fxml").toURI().toURL()); // Maven hat die Struktur zerschossen, deshalb Hardcoded Path
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("My New Stage Title");
            stage.setScene(new Scene(root, 450, 450));
            stage.show();
            // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

//==================================================================================//

//================================= Frage eingeben =================================//
    @FXML
    private TextField questBox;
    private TextField ansBox;
    private Button exitBtn;
    private Button okBtn;

    @FXML
    private void exit() {                                       // Handler für den Exit Button des UI's
        Platform.exit();
        System.exit(0);

    }

    @FXML
    private void ok() {
        answers ans = new answers(questBox.getText(),ansBox.getText());


        // To Do, Text einfach aus Textbox Nehmen und in YAML hauen
    }
//=================================================================================//
}

