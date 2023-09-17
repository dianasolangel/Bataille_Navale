package bataillenavale;

public class Joueur implements Player{ 
	protected  ChampDeBataille chb1;
	protected  ChampDeBataille chb2;
	protected Obus o;
	public String nom;
	
	public Joueur (String nom) {
		this.nom=nom;	
		this.chb1=null;
	}
   public void setChb(ChampDeBataille chb1){ 
	   this.chb1=chb1;

  }
   public ChampDeBataille getChb(){
	   return this.chb1;

  }
	public void placer(Bateau b, int x, int y , boolean dir) {
		this.chb1.placer(b, x, y, dir);
		}
	
	public void viser(ChampDeBataille chb1, int ligne , int colonne, Obus o) {
		//if(chb1.enemie==true) {
		//this.chb1.viser(ligne,colonne,o);
	  //}
	  chb1.viser(ligne,colonne,o);
	 }
	 public String toString() {
		return "Le joueur est:"+ this.nom; 
	 }
	 public void changerdechmp() {
		 
	 }

 }

