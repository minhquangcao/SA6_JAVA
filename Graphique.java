import java.awt.*;
import java.time.Instant;
import java.util.Random;
import java.util.Vector;

 
public class Graphique extends Canvas{
	int nombre_voiture = 8;
	int tableau[][]= new int [20][20];
	int Scale = 50;
	Intersection[] TabInter = new Intersection[4];
	VoitureAutonome[] TabVoiture  = VoitureManage.initTableVoiture();
	
	

	public void init(Graphique g)
	// initialisation
	{
		for (int i=0;i<19;i++){
			for(int j=0;j<20;j++)
			{
				tableau[i][j]=3;
			}
		}
		
		
	}
	public void initRoute(){
		for (int i=0;i<19;i++){
			for(int j=0;j<20;j++){
				if(i==5||i==6||i==13||i==14 ){tableau[i][j]=0;} 
				if(j==5||j==6||j==13||j==14 ){tableau[i][j]=0;}
			}
		}
		for (int k=0;k<4;k++){
			for(int l=8;l<12;l++){
				tableau[k][l]=1;
				tableau[k+8][l]=1;
				tableau[k+16][l]=1;
				tableau[k][l-8]=1;
				tableau[k+8][l-8]=1;
				tableau[k+16][l-8]=1;
				tableau[k][l+8]=1;
				tableau[k+8][l+8]=1;
				tableau[k+16][l+8]=1;
			
			}
		}
		
		

	}
	public void initIntersec()
	{
		
        //afficher pour tester
        //affichageNum(m);
        for(int i = 0; i<4;i++)
        {
        //initialiser les intersection
        TabInter[i] = new Intersection(new Vector<Point>(), null, null);
        /* 
        Intersection inter1 = new Intersection(new Vector<Point>(), null, null);
        Intersection inter2 = new Intersection(new Vector<Point>(), null, null);
        Intersection inter3 = new Intersection(new Vector<Point>(), null, null);
        Intersection inter4 = new Intersection(new Vector<Point>(), null, null);
        */}
        //definir leur positions
        TabInter[0].setPosition(5, 5);
        TabInter[1].setPosition(5,13);
        TabInter[2].setPosition(13, 5);
        TabInter[3].setPosition(13, 13);

	}

	
	public void paint(Graphics g) {
		Toolkit t=Toolkit.getDefaultToolkit();
		Image herbe=t.getImage("./photo/herbe.jpg");
		Image troitoire=t.getImage("./photo/bordure.jpg");
		Image route=t.getImage("./photo/route.jpg");
		Image arbre=t.getImage("./photo/arbre.png");
		Image intersec = t.getImage("./photo/bleu.png");
		Image zonecritique = t.getImage("./photo/marron.png");
		for ( int k=0 ; k<=19 ; k++){   //x 18
			for ( int l=0 ; l<=19 ; l++){  //y 17
				if (tableau[l][k]== 0){
					g.drawImage(route,Scale*k,Scale*l,this);
				}
				if (tableau[l][k]== 1){
					g.drawImage(herbe,Scale*k,Scale*l,this);
				
				}
				if (tableau[l][k]== 3){
					g.drawImage(troitoire,Scale*k,Scale*l,this);
				}
				
				if (tableau[l][k]== 4){
					g.drawImage(arbre,Scale*k,Scale*l,this);
				}
			}
		}		
		if(InIntersec()) {paintIntersection(g,intersec);}
		else {paintIntersection(g, zonecritique);}
		paintVoiture(g);
	}
	public void paintVoiture(Graphics g)
	{	
		Toolkit t=Toolkit.getDefaultToolkit();
		Image voituregauche=t.getImage("./photo/voituregauche.jpg");
		Image voituredroite=t.getImage("./photo/voituredroite.jpg");
		Image voiturehaut=t.getImage("./photo/voiturehaut.jpg");
		Image voiturebas=t.getImage("./photo/voiturebas.jpg");
		for(int i = 0; i < nombre_voiture; i++){
			
			if (TabVoiture[i].getDirection()==0){
				g.drawImage(voiturebas,Scale*TabVoiture[i].getPosition().y,Scale*TabVoiture[i].getPosition().x,this);
			}
			else if (TabVoiture[i].getDirection()==1){
				g.drawImage(voituredroite,Scale*TabVoiture[i].getPosition().y,Scale*TabVoiture[i].getPosition().x,this);
			}
			else if (TabVoiture[i].getDirection()==2){
				g.drawImage(voiturehaut,Scale*TabVoiture[i].getPosition().y,Scale*TabVoiture[i].getPosition().x,this);
			}
			// (TabVoiture[i].getDirection()==3)
			else{
				g.drawImage(voituregauche,Scale*TabVoiture[i].getPosition().y,Scale*TabVoiture[i].getPosition().x,this);
			}
		}
	}
	public void paintIntersection(Graphics g,Image V)
	{
		Toolkit t=Toolkit.getDefaultToolkit();
		
		for (int i = 0;i<4;i++)
		{
			for (int j=0;j<12;j++)
			{
				g.drawImage(V,Scale*TabInter[i].getPosition().get(j).x,Scale*TabInter[i].getPosition().get(j).y,this);
			}
		}
		
	}
		

	public boolean InIntersec()
	{
		boolean bool= false;
		for (int i = 0; i < 4; i++) {
			VoitureAutonome voiture = TabVoiture[i];
			
			boolean is_collision = voiture.checkCollisionAvecIntersection(TabInter);
			// Point nouvellePosition = voiture.calculeNouvellePosition();
			if (is_collision) {
				// System.out.print("true");
				return true;
			}
		}
		
		return bool;
	}

	public void DeplacementGeneral() {
		
		for (int i = 0; i < nombre_voiture; i++) {
			VoitureAutonome voiture = TabVoiture[i];
			
			boolean is_collision = voiture.checkCollisionAvecIntersection(TabInter);
			if (is_collision) {
				System.out.print("collision");
				int newDirection = 0;
				if(voiture.getDirection() == 0 ){
					int directionVoiture[] = {0, 1, 3};
					int choisi_direction = new Random().nextInt(3);
					newDirection = directionVoiture[choisi_direction];
				}
				if(voiture.getDirection() == 1 ){
					int directionVoiture[] = {0, 1, 2};
					int choisi_direction = new Random().nextInt(3);
					newDirection = directionVoiture[choisi_direction];
				}
				if(voiture.getDirection() == 2 ){
					int directionVoiture[] = {1, 2, 3};
					int choisi_direction = new Random().nextInt(3);
					newDirection = directionVoiture[choisi_direction];
				}
				if(voiture.getDirection() == 3 ){
					int directionVoiture[] = {0, 2, 3};
					int choisi_direction = new Random().nextInt(3);
					newDirection = directionVoiture[choisi_direction];
				}					
				voiture.changeDirection(newDirection);
				voiture.Deplacement(TabVoiture[i].getVitesse());
			} else {
				voiture.Deplacement(TabVoiture[i].getVitesse());
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
		for (int i=0;i<19;i++){
			for(int j=0;j<19;j++)
			{
				System.out.print(m.tableau[j][i]);
				if(j==18) System.out.print("\n");
			}
		}
	}
	




}


