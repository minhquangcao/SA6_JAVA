import java.awt.*;
import java.time.Instant;
public class Graphique extends Canvas{
	

	int tableau[][]={  
		{ 1, 1, 4, 3, 0, 0, 3, 1 , 4, 1, 1, 3, 0, 0, 3, 4, 4, 1 },
		{ 1, 1, 1, 3, 0, 0, 3, 4, 1, 4, 1, 3, 0, 0, 3, 4, 1, 1 },
		{ 3, 3, 3, 3, 0, 0, 3, 3 , 3, 3, 3, 3, 0, 0, 3, 3, 3, 3 },
		{ 0, 0, 0, 0, 0, 0, 0, 0 , 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
		{ 0, 0, 0, 0, 0, 0, 0, 0 , 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
		{ 3, 3, 3, 3, 0, 0, 3, 3 , 3, 3, 3, 3, 0, 0, 3, 3, 3, 3 },
		{ 4, 1, 1, 3, 0, 0, 3, 1 , 1, 1, 1, 3, 0, 0, 3, 1, 1, 4 },
		{ 1, 1, 4, 3, 0, 0, 3, 1 , 4, 4, 1, 3, 0, 0, 3, 1, 4, 1 },
		{ 3, 3, 3, 3, 0, 0, 3, 3 , 3, 3, 3, 3, 0, 0, 3, 3, 3, 3 },
		{ 0, 0, 0, 0, 0, 0, 0, 0 , 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
		{ 0, 0, 0, 0, 0, 0, 0, 0 , 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
		{ 3, 3, 3, 3, 0, 0, 3, 3 , 3, 3, 3, 3, 0, 0, 3, 3, 3, 3 },
		{ 1, 4, 1, 3, 0, 0, 3, 4 , 1, 1, 1, 3, 0, 0, 3, 1, 1, 1 },
		{ 3, 3, 3, 3, 0, 0, 3, 1 , 1, 4, 1, 3, 0, 0, 3, 1, 1, 1 },
		{ 0, 0, 0, 0, 0, 0, 3, 1 , 1, 1, 1, 3, 0, 0, 3, 1, 4, 1 },
		{ 0, 0, 0, 0, 0, 0, 3, 4 , 1, 1, 4, 3, 0, 0, 3, 1, 4, 1 },
		{ 3, 3, 3, 3, 0, 0, 3, 1 , 1, 1, 1, 3, 0, 0, 3, 1, 1, 4 },};
	
	

	public void paint(Graphics g) {
		Toolkit t=Toolkit.getDefaultToolkit();
		Image herbe=t.getImage("herbe.jpg");
		Image troitoire=t.getImage("bordure.jpg");
		Image route=t.getImage("route.jpg");
		Image voiture=t.getImage("voiture.jpg");
		Image arbre=t.getImage("arbre.png");
		
		for ( int k=0 ; k<=18 ; k++){   //x 18
			for ( int l=0 ; l<=16 ; l++){  //y 18
				if (tableau[l][k]== 0){
					g.drawImage(route,50*k,50*l,this);
				}
				if (tableau[l][k]== 1){
					g.drawImage(herbe,50*k,50*l,this);
				
				}
				if (tableau[l][k]== 2){
					g.drawImage(voiture,50*k,50*l,this);
				}
				if (tableau[l][k]== 3){
					g.drawImage(troitoire,50*k,50*l,this);
				}
				
				if (tableau[l][k]== 4){
					g.drawImage(arbre,50*k,50*l,this);
				}
			
			}
		}		
		for(int i=0;i<4;i++)
		{
			g.drawImage(voiture,10*TabVoiture[i].getPosition().x,10*TabVoiture[i].getPosition().y,this);
		}
	}
	public void DeplacementGeneral()
	{
		for(int i = 0; i<4;i++)
		{
			TabVoiture[i].Deplacement(1);
		}
	}


	public void deplacementE(Graphique  g,int a1,int b1 )
	{
		
		g.tableau[a1][b1]=2; 
		g.tableau[a1][b1-1]=0;
	}
	public void deplacementO(Graphique  g,int a2,int b2 )
	{
		
		g.tableau[a2][b2]=2; 
		g.tableau[a2][b2+1]=0;
	}

	public void deplacementS(Graphique  g,int a3,int b3 )
	{
		
		g.tableau[a3][b3]=2; 
		g.tableau[a3-1][b3]=0;
	}

	public void deplacementN(Graphique  g,int a4,int b4 )
	{
		
		g.tableau[a4][b4]=2; 
		g.tableau[a4+1][b4]=0;
	}	

	public static Instant addition(Instant now)
	//fonction qui permet d'additioner le temp
	{
		Instant instant2 = now.plusSeconds(1);
		Instant instant2 = now.plusSeconds(1);
		return instant2;
	}
	


}


