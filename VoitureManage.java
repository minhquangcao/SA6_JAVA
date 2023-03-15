import java.awt.Point;
import java.util.Random;

public class VoitureManage {
    private static int numVoiture = 8;
    private static Point[] beginPosition = new Point[] {
        new Point(6,0), 
        new Point(14,0),
        new Point(0,5), 
        new Point(18,6),
        new Point(18,14),
        new Point(0,13),
        new Point(5,18),
        new Point(13,18)

    };
    private static boolean[] usedPosition = new boolean[]{
        false,
        false,
        false,
        false,
        false,
        false,
        false,
        false
    };
    static VoitureAutonome[] initTableVoiture(){
        VoitureAutonome[] tabVoiture = new VoitureAutonome[numVoiture];
        // Random rand = new Random();
        // Point position;
        int direction;
        // int compte = 0;
        for(int i = 0; i < numVoiture; i++){
            // int nombreAleatoire = compte; // Génère un nombre aléatoire entre 0 et 7

            if (i == 0 ){direction = 1;}    //1:bas 2:gauche 3:haut 4:droite
            else if (i == 1 ){direction = 1;}
            else if (i == 2 ){direction = 0;}
            else if (i == 3 ){direction = 2;}
            else if (i == 4 ){direction = 2;}
            else if (i == 5 ){direction = 0;}
            else if (i == 6 ){direction = 3;}
            else {direction = 3;} 
            //used position
            // usedPosition[nombreAleatoire] = true; 
            //create voiture
            tabVoiture[i] = new VoitureAutonome(beginPosition[i].x, beginPosition[i].y, direction, 1);
            // compte ++;
        }

        return tabVoiture;
        
    };

};
