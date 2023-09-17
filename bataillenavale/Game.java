package bataillenavale;

public class Game {
	ChampDeBataille ch1;
	ChampDeBataille ch2;
	JoueurRandom random;
	Joueur joueur;
	public Game(ChampDeBataille ch1,ChampDeBataille ch2, Joueur joueur, JoueurRandom random) {
		this.ch1=ch1;
		this.ch2=ch2;
		this.random=random;
		this.joueur =joueur;
	}
	public void play() {
		while (!(this.chb1.isOver())(this.chb2.isOver())) {
			
			// Assigne les joueurs 
			joueur.setChb(ch1);
		    random.setChb(ch2);
		    
		    //Placer
		    joueur.placer();
		    random.placer();
		    
			//Viser
			joueur.viser();
			random.viser();	
		}
		// Lorsque la partie est terminée, on affiche le vainqueur.
		if (this.game.getWinner() != null) {
			System.out.println(this.() + " a gagne !");

	}
}
	
