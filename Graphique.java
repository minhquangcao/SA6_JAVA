import java.awt.*;
import java.time.Instant;
import java.util.Random;
import java.util.Vector;
public class Graphique extends Canvas{
	
	int tableau[][]= new int [40][40];
	
	VoitureAutonome TabVoiture [] = new VoitureAutonome [4];

	public void init(Graphique g)
	// initialisation
	{
		for (int i=0;i<40;i++){
			for(int j=0;j<40;j++)
			{
				tableau[i][j]=0;
			}
		}
		for( int j=0 ;j<4;j++){TabVoiture[j] = new VoitureAutonome();}
		
	}
	public void initRoute(){
		for (int i=0;i<40;i++){
			for(int j=0;j<40;j++){
				if(i==15||i==16||i==30||i==31){tableau[i][j]=1;}
				if(j==15||j==16||j==30||j==31){tableau[i][j]=1;}
			}
	}
}
	
	public void paint(Graphics g) {
		Toolkit t=Toolkit.getDefaultToolkit();
		Image noir=t.getImage("./photo/noir.jpg");
		Image gris=t.getImage("./photo/gris.jpg");
		Image voiture=t.getImage("./photo/voiture.png");
		
		for ( int k=0 ; k<=39 ; k++){   //x 18
			for ( int l=0 ; l<=39 ; l++){  //y 17
				if (tableau[l][k]== 0){
					g.drawImage(gris,10*k,10*l,this);
				}
				if (tableau[l][k]== 1){
					g.drawImage(noir,10*k,10*l,this);
				
				}
			}
		}		
		for(int i=0;i<4;i++)
		{
			g.drawImage(voiture,10*TabVoiture[i].getPosition().x,10*TabVoiture[i].getPosition().y,this);
		}
	}
	// public void DeplacementGeneral()
	// {
	// 	for(int i = 0; i<4;i++)
	// 	{
	// 		TabVoiture[i].Deplacement(0);
	// 	}
	// }
	public void DeplacementGeneral() {
		Point positionDesiree = new Point(15, 15);
		for (int i = 0; i < 4; i++) {
			VoitureAutonome voiture = TabVoiture[i];
			Point nouvellePosition = voiture.calculeNouvellePosition();
			if (nouvellePosition.equals(positionDesiree)) {
				int newDirection = new Random().nextInt(4);
				Vector<Integer> nouvelleDirection = new Vector<Integer>(1); nouvelleDirection.add(newDirection);
				voiture.changeDirection(positionDesiree, nouvelleDirection);
			} else {
				voiture.Deplacement(1);
			}
		}
	}
	
	
	public void changement(Graphique  g,int a)
	{
		g.tableau[a][a]=1; // ce qui permet de changer les parametre
	}
	

	public static Instant addition(Instant now)
	//fonction qui permet d'additioner le temp
	{
		Instant instant2 = now.plusSeconds(1);
		return instant2;
	}
	
	public static void affichageNum(Graphique m)
	// procedure pour un affichage texte pour effectuer des tests
	{
		for (int i=0;i<40;i++){
			for(int j=0;j<40;j++)
			{
				System.out.print(m.tableau[j][i]);
				if(j==9) System.out.print("\n");
			}
		}
	}





}


