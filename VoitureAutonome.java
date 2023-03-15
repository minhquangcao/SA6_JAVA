import java.awt.Point;
import java.util.Random;
import java.util.Vector;

public class VoitureAutonome {
    private Point position;
    private int direction;
    private int vitesse;

    // public VoitureAutonome()
    // {
    //     this.vitesse = 1;
    //     // Point[] beginPosition = new Point[] {
    //     //     new Point(6,0), 
    //     //     new Point(14,0),
    //     //     new Point(0,5), 
    //     //     new Point(18,6),
    //     //     new Point(18,14),
    //     //     new Point(0,13),
    //     //     new Point(5,18)
    //     // };

    //     Random rand = new Random();
    //     int nombreAleatoire = rand.nextInt(7) ; // Génère un nombre aléatoire entre 0 et 7

    //     if (nombreAleatoire == 0){position = beginPosition[0]; direction = 1;}    //1:bas 2:gauche 3:haut 4:droite
    //     else if (nombreAleatoire == 1){position = beginPosition[1]; direction = 1;}
    //     else if (nombreAleatoire == 2){position = beginPosition[2]; direction = 0;}
    //     else if (nombreAleatoire == 3){position = beginPosition[3]; direction = 2;}
    //     else if (nombreAleatoire == 4){position = beginPosition[4]; direction = 2;}
    //     else if (nombreAleatoire == 5){position = beginPosition[5]; direction = 0;}
    //     else {position = beginPosition[6]; direction = 3;}  
    // }
    
    public VoitureAutonome(int x, int y, int direction, int vitesse) {
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
    public void Deplacement(int vitesse) {
        int dx = 0, dy = 0;
        switch (direction) {
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

    public void changeDirection(int nouvelleDirection) {
        direction = nouvelleDirection;
    }

    public Point calculeNouvellePosition() {
        Point nouvellePosition = new Point(position);
        int dx = 0, dy = 0;
        switch (direction) {
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

    public boolean checkCollisionAvecIntersection(Intersection[] intersections) {
        for(int i = 0; i < 4; i++) {
           Vector<Point> points = intersections[i].getPosition();

            for (int j = 0; j < 4; j++) {            
                if (this.position.x == points.get(j).x && this.position.y == points.get(j).y){
                    return true;
                }
            }
        }
        return false;
    }
}
