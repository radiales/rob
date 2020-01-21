package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.CheckBox;

import java.awt.*;

/*
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.Yaml;
*/
/* Klasse zur verwaltung der Fragen*/
public class answers {
        private SimpleStringProperty  question;
        private SimpleStringProperty  answer;
        private SimpleStringProperty  category;
        private SimpleIntegerProperty id;
       // private CheckBox cBox;

        public answers(String q, String a, String c, int i){
            this.question   = new SimpleStringProperty(q);
            this.answer     = new SimpleStringProperty(a);
            this.category   = new SimpleStringProperty(c);
            this.id         = new SimpleIntegerProperty(i);
            //this.cBox       = cb;
        }

/*===============================| Getter / Setter |===============================*/
        public String   getQuestion()           {return this.question.get();}
        public void     setQuestion(String s)   {this.question = new SimpleStringProperty(s);}

        public String   getCategory()           {return this.category.get();}
        public void     setCategory(String s)   {this.category = new SimpleStringProperty(s);}

        public String   getAnswer()             {return this.answer.get();}
        public void     setAnswer(String s)     {this.answer = new SimpleStringProperty(s);}

        public int      getId()                 { return this.id.get(); }
        public void     setId(int i)            { this.id = new SimpleIntegerProperty(i); }

        //public CheckBox GetCheckbox()           {return this.cBox;}
        //public void     SetCheckbox(CheckBox c) {this.cBox = c;}
/*=================================================================================*/

}
