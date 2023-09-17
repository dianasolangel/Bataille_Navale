package bataillenavale;

import Vue.PlateauDeJeux;

public class Main {

	public static void main(String[] args) {
		Joueur j1 = new Joueur("1");
		JoueurRandom j2 = new JoueurRandom();

		ChampDeBataille chb1 = new ChampDeBataille(false,10, 10, j1);
		ChampDeBataille chb2 = new ChampDeBataille(true, 10, 10, j2);
	    
		PlateauDeJeux pj1= new PlateauDeJeux(chb1,chb2);
		j1.setChb(chb1);
		j2.setChb(chb2);
		
		
	    //while (!(chb1.isOver())||!(chb2.isOver())){
		
		/*if(chb1.isOver()) {
			
    		System.out.println(chb2.getJoueur() + " a gagne !");
    	}
    	else if(chb2.isOver()) {
    		
    		System.out.println(chb2.getJoueur() + " a gagne !");
    	}   	if(chb1.isOver()) {
		    		System.out.println(chb2.getJoueur() + " a gagne !");
		    	}
		    	else if(chb2.isOver()) {
		    		System.out.println(chb2.getJoueur() + " a gagne !");
    	}*/
	}
}
