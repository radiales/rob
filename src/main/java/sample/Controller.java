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
import javafx.stage.StageStyle;
import org.yaml.snakeyaml.Yaml;

import javax.swing.*;
import java.io.*;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    //================================== Variablen ===================================//

    @FXML
    private TextField questBox;                                                                                         // Deklaration der Variablen im UI, Fragen,- Antworten,- und Kategoriebox
    @FXML
    private TextField ansBox;
    @FXML
    private TextField katBox;
    @FXML
    private TableView<answers>              tableView;                                                                  // Liste um später die Daten in der Tabelle anzuzeigen
    @FXML
    private TableColumn<answers, String>    qCol;                                                                       // Variable für die Fragen Spalte
    @FXML
    private TableColumn<answers, String>    aCol;                                                                       // Variable für die Antworten Spalte
    @FXML
    private TableColumn<answers,CheckBox>   cCol;                                                                       // Variable für die Auswahlbox Spalte
    @FXML
    private TableColumn<answers, String>    kCol;                                                                       // Variable für die Kategorie Spalte
    @FXML
    ObservableList<answers>                 observableList;                                                             // Liste für die JavaFX anzeige

    //================================= Initialisierung =================================//
    @Override
    public void initialize(URL url, ResourceBundle resources) {
        qCol.setCellValueFactory(new PropertyValueFactory<answers,String>("question"));                               // Setzt die Spalten auf die dazugehörigen Elemente der Answer Klasse, muss genauso heißen wie die Variablen der Klasse
        aCol.setCellValueFactory(new PropertyValueFactory<answers,String>("answer"));                                 // und die Get/Setter müssen alle den Muster entsprechen
        kCol.setCellValueFactory(new PropertyValueFactory<answers,String>("category"));
        cCol.setCellValueFactory(new PropertyValueFactory<answers,CheckBox>("select"));
        observableList =            FXCollections.observableArrayList();                                                // Initialisiert die Liste
        String row =                null;
        BufferedReader csvReader =  null;


        try {
            csvReader = new BufferedReader(new FileReader("database.csv"));                                     // Liest die Database ein
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (true){
            try {
                if (!((row = csvReader.readLine()) != null)) break;                                                     // Wenn die Datei leer ist, stop!
            } catch (IOException e) {
                e.printStackTrace();
            }
            String[] data = row.split(";");                                                                       // Splittet die Eingelesenen Strings bei jeden Semikolon

            observableList.add(new answers(data[0],data[1],data[2],Integer.parseInt(data[3])));                         // Setzt die eben gesplitteten Daten in die JavaFX Liste
        }

        tableView.setItems(observableList);                                                                             // Zeigt die Daten an

    }

    public Controller() {
    }
    //================================= Fragen löschen =================================//
    @FXML
    private void MDel(){                                                                                                // Funktion für den "Auswahl löschen" Button


        ObservableList<answers> dataListRemove = FXCollections.observableArrayList();                                   // Erstellt neue Liste in dem die zu löschenden Elemente zwischengespeichert werden
            for (answers bean : observableList){
                if (bean.getSelect().isSelected()){
                    dataListRemove.add(bean);
                }
            }
        observableList.removeAll(dataListRemove);                                                                       // Alle Fragen die selected wurden werden nun aus der Ursprungsliste gelöscht

    }

    //================================= Programm Beenden =================================//
    @FXML
    private void MEnd(){                                                                                                // Fuktion für den "Beenden" "Button
        int i = 1;                                                                                                      // Zählvariable um die Daten die gespeichert werden vernünftig zu Nummerieren
        StringBuilder sb = new StringBuilder();

        for (answers each : observableList){                                                                            // Für alle Einträge in der Liste wird ein Eintrag in der Database.csv angelegt
            try (PrintWriter writer = new PrintWriter(new File("database.csv"))) {

                sb.append(each.getQuestion());
                sb.append(';');
                sb.append(each.getAnswer());
                sb.append(';');
                sb.append(each.getCategory());
                sb.append(';');
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
    //================================= Fragen exportieren =================================//
    @FXML
    private void MExp(){                                                                                                // Funktion um die Ausgewählten Fragen zu einer YAML DAtei zu Exportieren

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

    //================================= Frage eingeben =================================//

    @FXML
    private void bAdd(){                                                                                                // Funktion um eine Neue Frage hinzuzufügen

            if (!questBox.getText().isEmpty() && !ansBox.getText().isEmpty() && !katBox.getText().isEmpty()) {          // Check ob auch in jeden Feld etwas steht

            answers newquestion = new answers(questBox.getText(), ansBox.getText(), katBox.getText(), 0);            // Erstellt neus Fragenobjekt und speichert zwischen, ID ist erstmal irrelevant wird beim Beenden vergeben und gespeichert
            tableView.getItems().add(newquestion);                                                                      // Fügt die Fragen der Liste hinzu
            questBox.clear();                                                                                           // Macht die Textfelder Frei für neue Eingabe
            ansBox.clear();
            katBox.clear();
        }
    }

    //=================================================================================//
}

