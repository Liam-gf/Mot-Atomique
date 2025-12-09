package atomique;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import atomique.ihm.FrameAtomique;

import atomique.metier.MotAtomique;

public class Controleur
{
	private FrameAtomique  frameAtomique;
	private MotAtomique    motAtomique;
	
	public Controleur()
	{
		this.frameAtomique  = new FrameAtomique ( this );
		this.motAtomique = new MotAtomique();
	}


	public void    recupererLettres( String Mot ) { this.motAtomique.recupererLettres( Mot ); }
	public boolean validerMot      ( String Mot ) { return this.motAtomique.validerMot   ( Mot ); }

	public void supprimerOccurence()
	{
		this.motAtomique.supprimerOccurrence();
	}

	public ArrayList<String> getTabValide()
	{
		return this.motAtomique.getTabValide();
	}


	public ImageIcon getImage( String s )
	{
		return new ImageIcon( "source/atomique/images/" + s + ".png" );
	}


	public static void main( String[] args )
	{
		new Controleur();
	}
}
