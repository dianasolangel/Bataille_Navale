package bataillenavale;

import java.util.ArrayList;

import Vue.AbstractListenableModel;
import Vue.PlateauDeJeux;
//MODELE
public class ChampDeBataille extends AbstractListenableModel { 

	public Cases [][] plateau;
	public int lignes;
	public int colonnes;
	public Player j1;
	private ArrayList<Bateau> bateaux;
	public boolean enemie=false;
    
	public ChampDeBataille (boolean enemie, int lignes,int colonnes, Player j1) {
		super();
		this.enemie=enemie; //si c'est le champ enemie ou pas 
		this.lignes=lignes;
		this.colonnes=colonnes;
		plateau = new Cases[lignes][colonnes];//on crée le plateau de jeu à partir des cases 
		
		for (int i = 0; i < lignes; i++) {
	        for (int j = 0; j < colonnes; j++) {
		      this.plateau[i][j] = new Cases(i, j,this);
	        }
	    this.j1=j1;
		this.j1.setChb(this);
		this.bateaux=new ArrayList<Bateau>(); //liste de bateau qui appartiennet à ce champ de bataille 
		 }
	}
	
	public int getLignes() {
		return this.lignes;
	}
	public int getColonnes() {
		return this.colonnes;
	}
	
	public String toString() { 
		String res="";
		for(int i=0; i<lignes;i++) {
			for(int j=0;j<colonnes;j++) {
				res += plateau[i][j].toString();
			}
			res += "\n";
		}
		return res;
	}
	public boolean isValidCases (int x, int y) {
		
		boolean valid;
	
		// Vérifie que la case soit dedans les marges
		valid = (x<=this.lignes && y<=this.colonnes);
		
		// Vérifie que la case ne soit pas déjà occupée.
		valid = valid && (plateau[x][y].getBateau()==null || plateau[x][y].getObus()==null);

		return valid;}
	
	public void  placer(Bateau b, int ligne , int colonne, boolean dir) {
		if (dir==true){//horizontale
			for(int i=0; i<b.longueur ;i++) {
				if (isValidCases(ligne+i,colonne)==true && ligne+b.longueur<this.getColonnes() && colonne<this.getLignes()) { //on verifie que les cases soient valides et aussi qu'on soit dedans le tabelau de jeu 
					plateau[ligne+i][colonne].placer(b,dir);}
			    }
			  }
		else { //verticale
			for(int j=0; j<b.longueur ;j++) { 
				if (isValidCases(ligne,colonne+j)==true && colonne+b.longueur<this.getColonnes() && ligne<this.getColonnes()) {//pareil ici 
					plateau[ligne][colonne+j].placer(b,dir);}
					}
			}
	    Bateaux(b);//on l'ajout à la liste de bateaux dans de ce champ de bataille
		this.fireChange();
		}
    
    public void viser(int ligne ,int colonne, Obus obus) {
    plateau[ligne][colonne].viser(obus);
    
    this.fireChange();
    }
    
	public Player getJoueur() {
		return this.j1;
	}	
	public boolean Bateaux (Bateau b){
		return bateaux.add(b);
		
	}
	public ArrayList<Bateau> getlistebateau() {
		return this.bateaux;}
	
    public int nbcoule() { 
    	int comp=0;
    	for(Bateau b:getlistebateau()) {
    		if (b.coule()) {
    			comp++;
    		}
    		else {
    			comp=comp+0;
    		}
    		
    	}    	return comp;	
    }


    public boolean isOver1() { //1er option 
    	boolean fini=true;
    	if (PlateauDeJeux.etatPlacerViser==false) {
    		for (Bateau  b : this.bateaux){
    			if(b.coule()) {
    				return fini;
    			}
    			return !fini;}	
    		}
		return fini;
	}
    public boolean isOver2() { //Si le nb de bateau coule est egaux au nombre de bateau d'un champ de bataille
    	boolean fini=true;
    	if (PlateauDeJeux.etatPlacerViser==false) {
    		if(this.nbcoule()==5) {
    			fini = true;}
    		}
    	    else {
    	    	fini=false; 	
    	}
    	return fini;
	}
    

    public Player winner (ChampDeBataille chb1, ChampDeBataille chb2) { //REVISER PLUTOT EN FONCTION DE ISOVER
    	Player winner=(Player) chb1;//??
    	
    	for (Bateau b1: chb1.bateaux) { 
    		if (b1.coule()) {
    			winner =chb2.getJoueur();
    		}
    		winner=null;	
         }
    	for (Bateau b2: chb2.bateaux) {
    		if (b2.coule()) {
    			winner =chb1.getJoueur();
    		}
    		winner=null;
       }
       return winner;
  }
}


