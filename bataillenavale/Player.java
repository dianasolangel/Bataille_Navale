package bataillenavale;

public interface Player {
	
	public void placer(Bateau b, int x, int y , boolean dir);
	public void viser(ChampDeBataille chb, int ligne , int colonne, Obus o);
	public void setChb(ChampDeBataille chb);
	public ChampDeBataille getChb();
	
}
