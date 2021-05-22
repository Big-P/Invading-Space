package Klassen;

import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class Schuss extends BeweglicheObjekte {
    private final double YBEWEGUNG = 10;

    protected Schuss(double xKoor, double yKoor, Group root) {
        super(xKoor, yKoor, root);
        setzeBreite(5);
        setzeHoehe(10);
        Image img = new Image(getClass().getResource("../Schuss_Rot.png").toExternalForm());
        setzteBild(img);
    }

    public void schiessenHoch() {
        zeichneSchwarz(erhalteBreite(), erhalteHoehe());
        this.yKoor =  erhalteYKoor() - YBEWEGUNG;
        zeichneWeiss(erhalteBreite(), erhalteHoehe());
    }

    public void schiessenRunter() {
        zeichneSchwarz(erhalteBreite(), erhalteHoehe());
        this.yKoor = erhalteYKoor() + YBEWEGUNG;
        zeichneWeiss(erhalteBreite(), erhalteHoehe());
    }

    public boolean pruefeKollisionOben(double yRand) {
        if (erhalteYKoor() - YBEWEGUNG < yRand) {
            return true;
        }
        return false;
    }

    public boolean pruefeKollisionUnten(double yRand) {
        if (erhalteYKoor() + YBEWEGUNG > yRand) {
            return true;
        }
        return false;
    }
}
