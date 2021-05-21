package GUI;

import Klassen.DelimException;
import Klassen.EmptyException;
import Klassen.ScoreListe;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import Klassen.Spieler;

public class Startbildschirmcontroller {

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField txt_Namensfeld;
    @FXML
    private Label lbl_highscorename;
    @FXML
    private Label lbl_highcorepunkte;


    public void normal(ActionEvent e)throws IOException{
        System.out.println("Spielmodus: Normal");
        wechselZuGamescreen(e,0);
    }
    public void hölle(ActionEvent e) throws IOException {
        System.out.println("Spielmodus: HÖLLE");
        wechselZuGamescreen(e,1);
    }

    public void wechselZuGamescreen(ActionEvent e, int mode) throws IOException {
        //Main klasse des Spielbildschirms
        //TODO: Überprüfung text leer und kein komma
        try {
            Spieler spieler = new Spieler(txt_Namensfeld.getText());
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Spielbildschirm.fxml"));
            root = loader.load();
            Spielbildschirmcontroller spielcontroller = loader.getController();
            //ab hier soll der spielbildschirmcontroller übernehmen
            spielcontroller.aktiviereSpielfeld(e, spieler, root,mode);
        } catch (DelimException ex){
            System.out.println(ex.getMessage());
            //TODO: Popup
        } catch (EmptyException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void setzeHighscorespieler() throws IOException{
        ScoreListe scoreListe = new ScoreListe("./res/spielerdaten.txt");
        lbl_highscorename.setText(scoreListe.spielerlisteIndexAusgabe(0).erhalteName());
        lbl_highcorepunkte.setText(scoreListe.spielerlisteIndexAusgabe(0).erhaltePunkte()+"");
    }

}
