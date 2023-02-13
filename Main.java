import javax.swing.JFrame;
import java.lang.Thread;
import java.time.Instant;


public class Main extends Graphique{

    public static void main(String[] args) {
        Graphique m=new Graphique();
        JFrame f=new JFrame();
        int a1 = 4;                 //position de la voiture 1 (pour les tests)
        int b1 = 1;

        int a2 = 3;
        int b2 = 15;
        
        int a3 = 1;
        int b3 = 4;
        
        int a4 = 15;
        int b4 = 13;
    
        Instant now = Instant.now();
        f.add(m);
        f.setSize(920,900);         //format de la fenêtre
        f.setVisible(true);
        while(b1<=16)
        {
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
            
            
            m.deplacementE(m, a1,b1);   // fonction deplacement vers l'Est 
            m.deplacementO(m, a2,b2);
            m.deplacementS(m, a3,b3);
            m.deplacementN(m, a4,b4);
            //m.maj(m,a2,b2);
            
            if (b1<=16){
                b1++;                   //deplacement sur l'axe y
            }
            
            if (b2>=1){
                b2--;    
            }

            if (a3<=15){
                a3++;    
            }
            
            if (a4>=1){
                a4--;    
            }

            //incrementation du compteur
            f.add(m);//ce qui permet d'actualiser le buffer
            f.repaint();//actualise l'affichage
            now = Instant.now();// réinitialise le temps
            }
            
            
        }
        System.exit(0); //ce qui permet de quitter l'application a la fin de la boucle
    }
}
