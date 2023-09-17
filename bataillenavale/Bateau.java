package bataillenavale;
import java.util.ArrayList;
public class Bateau {

	protected int x;
	protected int y;
	protected int longueur;
	protected Boolean direction;
	protected int nbimpact;
	protected ArrayList<Cases> listcases;
	protected Obus o;
	
	
	public Bateau (int longueur) {//un bateau est un liste de cases 
		this.x=0;
		this.y=0;
		this.longueur=longueur;
		this.direction=true; 
		this.nbimpact=0;
		listcases= new ArrayList<Cases>();//C'est la liste de cases qui ont la refernce sur un meme bateau?
		this.o=null;
	}
	public void placer(Cases c , boolean dir) { //On ajout des cases au meme bateau
    listcases.add(c);
    }
	
    public void viser() {//?
    	this.nbimpact++;	
	}
    		
    public boolean coule() {
    	if(this.longueur==this.nbimpact) {
    		return true;
    	}
    	else {
    		return false;
    	 }
      }
  
	public String toString () {
		return "<" + this.x + this.y + this.direction +">";
		
	}
	
}
