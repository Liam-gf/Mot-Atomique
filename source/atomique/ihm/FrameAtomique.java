package atomique.ihm;

import atomique.Controleur;

import javax.swing.*;

public class FrameAtomique extends JFrame
{
	private Controleur    ctrl;
	private PanelAtomique panelAtomique;
	
	public FrameAtomique( Controleur ctrl )
	{
		this.ctrl = ctrl;
		
		this.setTitle   (   " Mot Atomique "   );
		this.setSize    (      1000, 600       );
		this.setLocation(       400, 200       );
		
		/* ------------------------------ */
		/* Création des composants        */
		/* ------------------------------ */
		
		this.panelAtomique = new PanelAtomique( this.ctrl );
		
		/* ------------------------------ */
		/* Positionnement des composants  */
		/* ------------------------------ */
		
		this.add( this.panelAtomique );
		
		/* ------------------------------ */
		/* Activation des composants      */
		/* ------------------------------ */
		
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		this.setVisible( true );
	}
}
