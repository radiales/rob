package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;



public class Controller {

    @FXML
    private TextField questBox;

    @FXML
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

}

