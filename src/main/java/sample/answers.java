package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.CheckBox;

/* Klasse zur verwaltung der Fragen*/
public class answers {
        private SimpleStringProperty  question;
        private SimpleStringProperty  answer;
        private SimpleStringProperty  category;
        private SimpleIntegerProperty id;
        private CheckBox              select;

        public answers(String q, String a, String c, int i){                                                            //Standard Konstruktor, Die Strings müssen Simple Strings sein für die Tabelle
            this.question   = new SimpleStringProperty(q);
            this.answer     = new SimpleStringProperty(a);
            this.category   = new SimpleStringProperty(c);
            this.id         = new SimpleIntegerProperty(i);
            this.select     = new CheckBox();
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

        public CheckBox getSelect()             {return this.select ;}
        public void     setSelect(CheckBox c)   {this.select  = c;}
/*=================================================================================*/

}
