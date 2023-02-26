import javax.swing.JFrame;
import java.lang.Thread;
import java.time.Instant;
import java.util.Vector;
import java.awt.Point;

public class Main extends Graphique{

    public static void main(String[] args) {
        Graphique m=new Graphique();
        m.init(m);
        m.initRoute();
        
        //afficher pour tester
        affichageNum(m);

        //initialiser les intersection
        Intersection inter1 = new Intersection(new Vector<Point>(), null, null);
        Intersection inter2 = new Intersection(new Vector<Point>(), null, null);
        Intersection inter3 = new Intersection(new Vector<Point>(), null, null);
        Intersection inter4 = new Intersection(new Vector<Point>(), null, null);
        //definir leur positions
        inter1.setPosition(15, 15);
        inter2.setPosition(15, 30);
        inter3.setPosition(30, 15);
        inter4.setPosition(30, 30);

        JFrame f=new JFrame();
        int a = 0;
        Instant now = Instant.now();
        f.add(m);
        f.setSize(550,550);
        f.setVisible(true);
        while(a<30)
        {
            //f.add(m);
            if(Instant.now().isBefore(addition(now))){ 
                //on affiche un nouveau carré noir chaque 1 seconde. 

     /******************************************************* 
      *  Ici on va utiliser des fonctions qui manipule les  *
      *  Thread a fin d'effectuer une attente de type wait  *
      *  et on interompe le sommeil de la fonction          *
      *******************************************************/ 

                try{
                //System.out.print("On attend encore c'est pas fait\n");
                Thread.sleep(500);//une attente de 0.5 seconde
                } catch (InterruptedException e){System.out.checkError();}
            }
            else {
            //System.out.print("C'est Bon \n");	
            m.DeplacementGeneral();
            
            //m.changement(m, a);//appel a la fonction qui change les parametre dans le tableau
            a++;//incrementation du compteur
            f.add(m);//ce qui permet d'actualiser le buffer
            f.repaint();//actualise l'affichage
            now = Instant.now();// réinitialise le temps
            }
            
            
        }
        System.exit(0); //ce qui permet de quitter l'application a la fin de la boucle
    }
}
