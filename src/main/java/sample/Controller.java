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
import org.yaml.snakeyaml.Yaml;

import javax.swing.*;
import java.io.*;
import java.net.URL;
import java.util.Map;
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
    private Button MExp;
    @FXML
    private TableView<answers> tableView;
    @FXML
    private TableColumn<answers, String>    qCol;
    @FXML
    private TableColumn<answers, String>    aCol;
    @FXML
    private TableColumn<answers,CheckBox>   cCol;
    @FXML
    private TableColumn<answers, String>    kCol;
    private TableColumn<answers, Integer>   id;
    private TableColumn<answers, CheckBox>  select;

    @FXML
    ObservableList<answers> observableList;


    @Override
    public void initialize(URL url, ResourceBundle resources) {
        qCol.setCellValueFactory(new PropertyValueFactory<answers,String>("question"));
        aCol.setCellValueFactory(new PropertyValueFactory<answers,String>("answer"));
        kCol.setCellValueFactory(new PropertyValueFactory<answers,String>("category"));
        cCol.setCellValueFactory(new PropertyValueFactory<answers,CheckBox>("select"));
        observableList = FXCollections.observableArrayList();   // Initialisiert die Liste
        String row = null;
        BufferedReader csvReader = null;


        try {
            csvReader = new BufferedReader(new FileReader("C:\\Users\\radia\\IdeaProjects\\rob\\src\\main\\java\\database.csv")); // Liest die Database ein
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (true){
            try {
                if (!((row = csvReader.readLine()) != null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            String[] data = row.split("\t");    // Wenn ich \t durch zb ; austausche spackt es aus unerfindlichen gründen rum, deshalb durch tab (ist ja auch egal i guess)

            observableList.add(new answers(data[0],data[1],data[2],Integer.parseInt(data[3])));
        }

        tableView.setItems(observableList);

    }

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


        ObservableList<answers> dataListRemove = FXCollections.observableArrayList();
            for (answers bean : observableList){
                if (bean.getSelect().isSelected()){
                    dataListRemove.add(bean);
                }
            }
        observableList.removeAll(dataListRemove);
        //tableView.getItems().removeAll(tableView.getSelectionModel().getSelectedItem()); // Für einzelne elemtene

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
        int i = 1;
        StringBuilder sb = new StringBuilder();

        for (answers each : observableList){
            try (PrintWriter writer = new PrintWriter(new File("C:\\Users\\radia\\IdeaProjects\\rob\\src\\main\\java\\database.csv"))) {

                sb.append(each.getQuestion());
                sb.append('\t');
                sb.append(each.getAnswer());
                sb.append('\t');
                sb.append(each.getCategory());
                sb.append('\t');
                sb.append(Integer.toString(i));
                sb.append('\n');


                writer.write(sb.toString());

                i++;
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }

        }

        Platform.exit();
        System.exit(0);
    }

    @FXML
    private void MExp(){



        Yaml yaml = new Yaml();

        ObservableList<answers> dataListExport = FXCollections.observableArrayList();
        for (answers tmp : observableList){
            if (tmp.getSelect().isSelected()){
                dataListExport.add(tmp);
            }
        }
        /*
        for (answers each : dataListExport){


        }
        */
        /*
        for (answers each: dataListExport){
            System.out.println(each.getAnswer());
        }
        */

        //Yaml yaml = new Yaml();
        //InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("C:\\Users\\radia\\IdeaProjects\\rob\\src\\main\\java\\export.yaml");
        //answers exp = yaml.load(inputStream);


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

