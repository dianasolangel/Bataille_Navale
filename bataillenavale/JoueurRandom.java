package bataillenavale;

import java.util.Random; 


public class JoueurRandom implements Player {
	
	protected ChampDeBataille chb2;
    private Random rd;
	public String nom;
	
	public JoueurRandom() {
		this.rd = new Random();
		this.chb2=null;
	
	}
	@Override
	public void placer (Bateau b, int x, int y , boolean dir) { 
		x=(int)(Math.random()*getChb().getLignes()-1); //on tire entre 0 et le nombre de lignes du Champ de Bataille
        y=(int)(Math.random()*getChb().getColonnes()-1);//on tire entre 0 et le nombre de colonnes du Champ de Bataille
        dir=rd.nextBoolean();
        this.getChb().placer(b, x,y, dir);
	 }
	
	@Override
	public void viser(ChampDeBataille chb, int ligne , int colonne, Obus o ) {
		ligne=(int)(Math.random()*getChb().getLignes()); //on tire entre 0 et le nombre de lignes du Champ de Bataille
        colonne=(int)(Math.random()*getChb().getLignes());//on tire entre 0 et le nombre de colonnes du Champ de Bataille
        chb.viser(ligne,colonne,o);	
       
		}
    
	@Override
	public void setChb(ChampDeBataille chb) {
		this.chb2=chb; 
		
	}
	@Override
	public ChampDeBataille getChb() {
		return this.chb2;
		
	
	}
	
}
	
	
