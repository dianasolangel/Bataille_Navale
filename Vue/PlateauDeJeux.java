package Vue;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Controleur.VueGraphique;
//VUE
import bataillenavale.ChampDeBataille;
public class PlateauDeJeux extends JFrame  {
	private static final long serialVersionUID = 1L;
	protected ChampDeBataille ch1, ch2;//modele
    protected VueGraphique vue1, vue2; //vuetraffic
    public JButton button;
    public static boolean  etatPlacerViser = true;

    
    public PlateauDeJeux(ChampDeBataille ch1, ChampDeBataille ch2) {
    	super("Champ de Bataille ");
    	this.ch1 = ch1;
    	this.ch2 = ch2;
	    this.setPreferredSize(new Dimension(VueGraphique.TAILLECASE*this.ch1.getLignes(),this.ch1.getColonnes()*VueGraphique.TAILLECASE));
	    Dimension dimButton = new Dimension(30, 50);
	    Container cp= this.getContentPane();
	    //JPANEL
	    JPanel panel= new JPanel();
		this.add(panel);
		panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
		panel.setLayout(new GridLayout(2,2));
		this.vue1 = new VueGraphique(this.getChampDeBataille1(),this.getChampDeBataille2());
		this.vue2 = new VueGraphique(this.getChampDeBataille2(),this.getChampDeBataille1());
		panel.add(this.getVueGraphique1(),BorderLayout.WEST);
		panel.add(this.getVueGraphique2(),BorderLayout.EAST);
		
		//JLABEL
		JLabel label = new JLabel();
		panel.add(label);
		String RulesGame = "<html>COMMENT JOUER?<P>"+"<html>1)Placez vos bateaux, pour placer ceux du machine clickez droit sur son champ de bataille 5 fois<P>"+"<html>pour placer clickdroit et pour changer de direction clickgauche<P>" +
				 "<html>2)Clickez le bouton pour changer à viser et commencez à viser les bateaux de votre opponent <P>";
		label.setText(RulesGame);
		
		//BUTTON
		this.button = new JButton("CLICKEZ POUR VISER"); 
		this.button.setPreferredSize(dimButton);
		this.button.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						changerEtatPlacerViser();
				    	if (etatPlacerViser==true) {
				    		button.setText("CLICKEZ POUR VISER");}
				    	else {
				    		button.setText("CLICKEZ POUR PLACER");
				  
				    		}
				    	}
					}
				);
		panel.add(button,BorderLayout.WEST);
		cp.add(panel);
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("BATAILLE NAVALE");
		this.pack();
		this.setVisible(true);
		
	
    }
    
    public JButton getNextStep() {
		return this.button;
	}
    public VueGraphique getVueGraphique1() {
		return this.vue1;
	}
    private  VueGraphique getVueGraphique2() {
		return this.vue2;
	}
	private ChampDeBataille getChampDeBataille1() {
		return this.ch1;
	}
	private ChampDeBataille getChampDeBataille2() {
		return this.ch2;
	}
	static public void changerEtatPlacerViser(){ 
	      etatPlacerViser = !(etatPlacerViser);
	}
 }