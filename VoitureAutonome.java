import java.awt.Point;
import java.util.Random;


public class VoitureAutonome {
    private Point position;
    private int direction;
    private int vitesse;

    public VoitureAutonome()
    {
        this.vitesse = 1;
        Random rand = new Random();
        int nombreAleatoire = rand.nextInt(4); // Génère un nombre aléatoire entre 0 et 3
        if (nombreAleatoire == 0){position = new Point(15,0); direction = 1;}
        else if (nombreAleatoire == 1){position = new Point(30,0); direction = 1;}
        else if (nombreAleatoire == 2){position = new Point(0,15); direction = 2;}
        else {position = new Point(0,30); direction = 1;}
        
        
    }
    public VoitureAutonome(Point position, int direction, int vitesse) {
        this.position = position;
        this.direction = direction;
        this.vitesse = vitesse;
    }
    public void Deplacement(int direction) // direction = 1 = est
    {
        if (direction == 1) {position.y=position.y+1;}
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