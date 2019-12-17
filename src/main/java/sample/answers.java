package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.Yaml;

/* Klasse zur verwaltung der Fragen*/
public class answers {
        private String  question;
        private String  answer;
        private String  category;
        private int     id;

        public answers(String q, String a){
            this.question   = q;
            this.answer     = a;
        }

/*===============================| Getter / Setter |===============================*/
        public String   GetQuestion()           {return this.question;}
        public void     SetQuestion(String s)   {this.question = s;}
        public String   GetCategory()           {return this.category;}
        public void     SetCategory(String s)   {this.category = s;}
        public String   GetAnswer()             {return this.answer;}
        public void     SetAnswer(String s)     {this.answer = s;}
        public int      GetId()                 { return this.id; }
        public void     Setid(int i)            { this.id = i; }
/*=================================================================================*/

}
