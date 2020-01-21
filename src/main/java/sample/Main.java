package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.yaml.snakeyaml.Yaml;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(new File("C:\\Users\\radia\\IdeaProjects\\rob\\src\\main\\resources\\mainwindow.fxml").toURI().toURL()); // Maven hat die Struktur zerschossen, deshalb Hardcoded Path
        Parent root = loader.load();
        primaryStage.setTitle("");
        primaryStage.setScene(new Scene(root));
        primaryStage.setOnCloseRequest(e -> Platform.exit());
        primaryStage.setResizable(false);
        primaryStage.show();
/*
        BufferedReader csvReader = new BufferedReader(new FileReader("C:\\Users\\radia\\IdeaProjects\\rob\\src\\main\\java\\band2HausGartencsv2.csv"));
        String row;
        while ((row = csvReader.readLine()) != null){
            String[] data = row.split(";");
            int i = 0;
            //System.out.println(data[i] + data[i+1] + data[i+2] + Integer.parseInt(data[i+3]));
            answers csvinput = new answers(data[i],data[i+1],data[i+2],Integer.parseInt(data[i+3]));
        }
*/
    }


    public static void main(String[] args) {
        launch(args);
    }
}
