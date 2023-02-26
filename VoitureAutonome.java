import java.awt.Point;
import java.util.Random;
import java.util.Vector;

public class VoitureAutonome {
    private Point position;
    private Vector<Integer> direction;
    private int vitesse;

    public VoitureAutonome()
    {
        this.vitesse = 1;
        Random rand = new Random();
        int nombreAleatoire = rand.nextInt(5); // Génère un nombre aléatoire entre 0 et 3
        if (nombreAleatoire == 0){position = new Point(15,0); direction = new Vector<Integer>(1); direction.add(1);}
        else if (nombreAleatoire == 1){position = new Point(30,0); direction = new Vector<Integer>(1); direction.add(1);}
        else if (nombreAleatoire == 2){position = new Point(0,15); direction = new Vector<Integer>(1); direction.add(2);}
        else {position = new Point(0,30); direction = new Vector<Integer>(1); direction.add(1);}
        
        
    }
    public VoitureAutonome(int x, int y, Vector<Integer> direction, int vitesse) {
        position = new Point(x, y);
        this.direction = direction;
        this.vitesse = vitesse;
    }

    public Point getPosition() {
        return position;
    }
    public void setPosition(Point position) {
        this.position = position;
    }
    public Vector<Integer> getDirection() {
        return direction;
    }
    public void setDirection(Vector<Integer> direction) {
        this.direction = direction;
    }
    public int getVitesse() {
        return vitesse;
    }
    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }
    public void Deplacement(int vitesse) {
        int dx = 0, dy = 0;
        switch (direction.get(0)) {
            case 0:
                dx = vitesse;
                break;
            case 1:
                dy = vitesse;
                break;
            case 2:
                dx = -vitesse;
                break;
            case 3:
                dy = -vitesse;
                break;
        }
        position.translate(dx, dy);
    }

    public void changeDirection(Point nouvellePosition, Vector<Integer> nouvelleDirection) {
        position = nouvellePosition;
        direction = nouvelleDirection;
    }

    public Point calculeNouvellePosition() {
        Point nouvellePosition = new Point(position);
        int dx = 0, dy = 0;
        switch (direction.get(0)) {
            case 0:
                dx = 1;
                break;
            case 1:
                dy = 1;
                break;
            case 2:
                dx = -1;
                break;
            case 3:
                dy = -1;
                break;
        }
        nouvellePosition.translate(dx, dy);
        return nouvellePosition;
    }
    // public void Deplacement(int direction) // direction = 1 = est
    // {
    //     if (direction == 0) {
    //         position.y=position.y + 1;
    //     }
    //     if (direction == 1)
    //     {
    //         position.x=position.x + 1;
    //     }
    //     if (direction == 2){
    //         position.y = position.y - 1;
    //     }
    //     if (direction == 3){
    //         position.x = position.x + 1;
    //     }
        
    // }
  
    // public void changerDirection(Point nouvellePosition, Vector<Integer> nouvelleDirection) {
    //     position = nouvellePosition;
    //     direction.set(0, nouvelleDirection.get(0));
    // }
    // public Point calculeNouvellePosition() {
    //     Point positionActuelle = getPosition();
    //     Vector<Integer> direction = getDirection();
    //     int x = positionActuelle.x;
    //     int y = positionActuelle.y;
    //     if (direction.get(0) == 0) { // vers le haut
    //         y--;
    //     } else if (direction.get(0) == 1) { // vers la droite
    //         x++;
    //     } else if (direction.get(0) == 2) { // vers le bas
    //         y++;
    //     } else { // vers la gauche
    //         x--;
    //     }
    //     return new Point(x, y);
    // }
    
}
