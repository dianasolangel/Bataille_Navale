
package Controleur;
import javax.swing.BorderFactory;
//import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Vue.ModelListener;
import Vue.PlateauDeJeux;
import bataillenavale.Bateau;
import bataillenavale.Cases;
import bataillenavale.ChampDeBataille;
import bataillenavale.Obus;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


//CONTROLEUR 
public class VueGraphique extends JPanel implements ModelListener, MouseListener {
	 private static final long serialVersionUID = 1L;
	 
	 protected ChampDeBataille chb1;
	 protected ChampDeBataille chb2;
	 public static int TAILLECASE=30;
	 protected boolean dir;
	 public int longueur=5;

	 public VueGraphique(ChampDeBataille chb1, ChampDeBataille chb2) {
		 
	 this.chb1=chb1;
	 this.chb1.addListener(this);
	 this.addMouseListener (this);
	 this.setPreferredSize(new Dimension(TAILLECASE*chb1.getLignes(),chb1.getColonnes()*TAILLECASE));
	 this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true)); 
     this.setVisible(true);
     this.chb2=chb2;
	 }
	 
	 @Override
	 public void modelUpdated(Object source) {
		 super.repaint();
	 }
	 
	 public void paintComponent(Graphics g ){ 
		 super.paintComponent(g);
	  
	     for (int i = 0; i < this.chb1.getLignes(); i++) {
	    	 for (int j=0; j<this.chb1.getColonnes(); j++) {
	    		 dessinerCase(this.chb1.plateau[i][j], g );
	     }
	  }
	 }
	 public void dessinerCase(Cases zone, Graphics g){//position
		 
		 int x= zone.getLigne();
	     int y= zone.getColonne();
	     g.setColor(Color.BLACK);
		 g.drawRect(x*TAILLECASE, y*TAILLECASE,TAILLECASE,TAILLECASE);
		 if (zone.getObus()==null && zone.getBateau()==null ) {//Mer
		     g.setColor(Color.WHITE);}
	     else if (zone.getObus()!=null && zone.getBateau()!=null && ( this.chb1.enemie==true ||  this.chb1.enemie!=true)) { //touché
	    	 g.setColor(Color.RED);}
		 else if (zone.getObus()!=null && zone.getBateau()==null ) {//essaie de viser 
		     g.setColor(Color.GREEN);}
		 else if (zone.getObus()== null && zone.getBateau()!= null && this.chb1.enemie!=true){//bateau placé 
		     g.setColor(Color.CYAN);}  
		 else if (zone.getObus()== null && zone.getBateau()!= null && this.chb1.enemie==true){//bateau placé 
		     g.setColor(Color.WHITE);} 
			 
		 g.fillRect(x*TAILLECASE,y*TAILLECASE, TAILLECASE, TAILLECASE); 
		 }
	
	 public void viserClick(int ligne,int colonne) { //AQUI ESTA EL PROBLEMA 
		 if(this.chb2.enemie!=true) {
			 this.chb1.getJoueur().viser(this.chb2, ligne, colonne, new Obus());
			 repaint();}
		 if (this.chb1.enemie==true) {
			this.chb2.getJoueur().viser(this.chb1, ligne, colonne, new Obus());
			repaint();}
	 }
	 public void  placerBateauClick(int ligne, int colonne, int longeur, boolean dir) { 
		 this.chb1.getJoueur().placer(new Bateau(longeur), ligne, colonne, dir);
		 repaint();
	 }

	@Override
	 public void mouseClicked(MouseEvent e) {
		 if (e.getButton()==MouseEvent.BUTTON1 && PlateauDeJeux.etatPlacerViser==true ){//click gauche change la direction et click droit place 
			 dir=!dir;
			 //rectifierBateau();
             repaint();
             return;
		 }
		 int x=e.getX();// on recupere les click sur le tableau de jeu
         int y=e.getY();
         System.out.println("etat "+ PlateauDeJeux.etatPlacerViser);
         System.out.println("x =" + x + ", "+ y);
         int lig =x/TAILLECASE;
         int col = y/TAILLECASE;
         System.out.println("lig=" + lig + ", "+ "Col="+ col);
         
         if(PlateauDeJeux.etatPlacerViser==true) {
             if (dir==true){//HORIZONTALE
            	 this.placerBateauClick(lig, col, longueur, true);}
             else { //VERTICALE
            	 this.placerBateauClick(lig, col, longueur, false);}
            longueur--;
            repaint();
        	 }
    
         else if(PlateauDeJeux.etatPlacerViser==false){ 
         	this.viserClick(lig,col);
         	repaint();}
         
	     /*else if(PlateauDeJeux.etatPlacerViser==false && (chb1.isOver() || chb2.isOver())) {
	    	 this.wins();
	    	 
	     }*/
	    }
	    @Override
	    public void mousePressed(MouseEvent e) {

	    }

	    @Override
	    public void mouseReleased(MouseEvent e) {

	    }

	    @Override
	    public void mouseEntered(MouseEvent e) {

	    }
	    @Override
	    public void mouseExited(MouseEvent e) {

	    }
	    /*public Player wins () {
	    	Player winner=null;
	    	if(this.chb1.isOver()) {
	    		winner = this.chb2.getJoueur();}
	    	else if(this.chb2.isOver()) {
	    		winner = this.chb1.getJoueur();
	    	}
	    	return winner;
	    }*/
			 
}


