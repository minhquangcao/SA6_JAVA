import java.awt.*;
import java.time.Instant;
public class Graphique extends Canvas{
	
	int tableau[][]= new int [10][10];

	public void init(Graphique g)
	// initialisation
	{
		for (int i=0;i<10;i++){
			for(int j=0;j<10;j++)
			{
				tableau[i][j]=0;
			}
		}
	}


	public void paint(Graphics g) {
		Toolkit t=Toolkit.getDefaultToolkit();
		Image noir=t.getImage("noir.jpg");
		Image gris=t.getImage("gris.jpg");
		Image voiture=t.getImage("voiture.png");
		
		for ( int k=0 ; k<=9 ; k++){   //x 18
			for ( int l=0 ; l<=9 ; l++){  //y 17
				if (tableau[l][k]== 0){
					g.drawImage(gris,50*k,50*l,this);
				}
				if (tableau[l][k]== 1){
					g.drawImage(noir,50*k,50*l,this);
				
				}
				if (tableau[l][k]== 2){
					g.drawImage(voiture,50*k,50*l,this);
				}
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
		Instant instant2 = now.plusSeconds(4);
		return instant2;
	}
	
	public static void affichageNum(Graphique m)
	// procedure pour un affichage texte pour effectuer des tests
	{
		for (int i=0;i<10;i++){
			for(int j=0;j<10;j++)
			{
				System.out.print(m.tableau[j][i]);
				if(j==9) System.out.print("\n");
			}
		}
	}





}


