import java.awt.Point;

public class VoitureAutonome {
    private Point position;
    private int direction;
    private int vitesse;

    public VoitureAutonome(Point position, int direction, int vitesse) {
        this.position = position;
        this.direction = direction;
        this.vitesse = vitesse;
    }

    public Point getPosition() {
        return position;
    }
    public void setPosition(Point position) {
        this.position = position;
    }
    public int getDirection() {
        return direction;
    }
    public void setDirection(int direction) {
        this.direction = direction;
    }
    public int getVitesse() {
        return vitesse;
    }
    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }

}