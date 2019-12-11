package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.yaml.snakeyaml.Yaml;

import java.io.File;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(new File("C:\\Users\\radia\\IdeaProjects\\rob\\src\\main\\resources\\sample.fxml").toURI().toURL()); // Maven hat die Struktur zerschossen, deshalb Hardcoded Path
        Parent root = loader.load();
        primaryStage.setTitle("Fragen Hinzufügen");
        primaryStage.setScene(new Scene(root, 640, 350));
        primaryStage.setOnCloseRequest(e -> Platform.exit());
        primaryStage.setResizable(false);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
