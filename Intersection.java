import java.awt.Point;
import java.util.Vector;


public class Intersection {
    private Vector<Point> position;
    private Vector<Integer> limits;
    private Vector<Vector<Integer>> directions;
    
    public Intersection(Vector<Point> position, Vector<Integer> limits, Vector<Vector<Integer>> directions) {
        this.position = new Vector<Point>();
        this.limits = new Vector<Integer>();
        this.directions = new Vector<Vector<Integer>>();

        for (Point point : position) {
            this.position.add(point);
        }
        for (Integer limit : limits) {
            this.limits.add(limit);
        }
        for (Vector<Integer> direction : directions) {
            this.directions.add(direction);
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
}
