package Vue;

import bataillenavale.ChampDeBataille;

public class VueConsole extends PlateauDeJeux implements ModelListener{
	
	private static final long serialVersionUID = 1L;
	ChampDeBataille chb1;
	ChampDeBataille chb2;
	
	public  VueConsole (ChampDeBataille chb1, ChampDeBataille chb2){
		super(chb1, chb2);
		this.chb1=chb1;
		this.chb2=chb2;
		// abonner la vue au modele
		this.chb1.addListener(this); 
		this.chb2.addListener(this);
	}
	
	@Override
	public void modelUpdated(Object source){
	       System.out.println(this.chb1.toString());
	       System.out.println(this.chb2.toString());       
	}

}
