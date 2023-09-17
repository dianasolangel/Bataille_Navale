package bataillenavale;

public class Cases {
	protected int ligne;
	protected int colonne;
	protected Bateau b;
	protected Obus o;
	protected ChampDeBataille chmp;

	
	public Cases (int ligne,int colonne, ChampDeBataille chmp) {
		this.ligne=ligne;
		this.colonne=colonne;
		this.chmp=chmp;
		this.b=null;
		this.o=null;
		}
	
	public int getLigne() {
		return this.ligne;
	}
		
	public int getColonne() {
		return this.colonne;
	}
	public Obus getObus() {
		return this.o;
	}
	public Bateau getBateau() {
		if(this.b != null) {
		return this.b;}
		else {
			return null;
		}
	}
	public String toString () {
		if (this.b==null && this.o==null) { //case vide
			return " ";}
		else if (this.b!=null && this.o!=null){
			return "x";// bateau touché
		}
		else if (this.b==null && this.o!=null) {
			return "!"; //essaie de viser le bateau
		}
		else {
			return ".";}//on a un bateau cachée
	}
	public void placer (Bateau b, boolean dir) {
		this.b= b;
		b.placer(this, dir);
	}
	public void viser (Obus o) {
		this.o=o;
		if (b!= null) {
			b.viser();
		}
		
	}
}
