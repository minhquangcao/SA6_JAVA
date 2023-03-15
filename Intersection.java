import java.awt.Point;
import java.util.Vector;


public class Intersection {
    private Vector<Point> position;
    private Vector<Integer> limits;
    private Vector<Vector<Integer>> directions;
    private static int SIZE = 12;    

    

    // methode d'initialisation d'une intersection
    public Intersection(Vector<Point> position, Vector<Integer> limits, Vector<Vector<Integer>> directions) {
        this.position = new Vector<Point>();
        this.limits = new Vector<Integer>();
        this.directions = new Vector<Vector<Integer>>();

        if (position != null && position.size() > 0) {
            for (Point point: position) {
                this.position.add(point);
            }
        }
        if (limits != null && limits.size() > 0) {
            for (Integer limit : limits) {
                this.limits.add(limit);
            }
        }
        if (directions != null && directions.size() > 0) {
            for (Vector<Integer> direction : directions) {
                this.directions.add(direction);
            }
        }

        
    } 
    public void setDirections(Vector<Vector<Integer>> directions) {
        for (Vector<Integer> direction : directions) {
            this.directions.add(direction);
        }
    }
    public void setLimits(Vector<Integer> limits) {
        for (Integer limit : limits) {
            this.limits.add(limit);
        }
    }
    public Vector<Point> getPosition() {
        return position;
    }
    public Vector<Integer> getLimits() {
        return limits;
    }
    public Vector<Vector<Integer>> getDirections() {
        return directions;
    }

    //fonction pour initialiser les positions de l'intersection
    public void setPosition(int x, int y) {
        position.add(new Point(x, y));
        position.add(new Point(x, y + 1));
        position.add(new Point(x + 1, y + 1));
        position.add(new Point(x + 1, y));
        position.add(new Point(x - 1, y));
        position.add(new Point(x - 1, y + 1));
        position.add(new Point(x, y + 2));
        position.add(new Point(x + 1, y + 2));
        position.add(new Point(x + 2, y + 1));
        position.add(new Point(x + 2, y));
        position.add(new Point(x + 1, y - 1));
        position.add(new Point(x, y - 1));
    }
    
}
