package atomique;

import java.util.ArrayList;

import atomique.ihm.FrameAtomique;

import atomique.metier.PrenomAtomique;

public class Controleur
{
	private FrameAtomique  frameAtomique;
	private PrenomAtomique prenomAtomique;
	
	public Controleur()
	{
		this.frameAtomique  = new FrameAtomique ( this );
		this.prenomAtomique = new PrenomAtomique();
	}


	public boolean recupererLettres( String prenom ) { return this.prenomAtomique.recupererLettres( prenom ); }
	public boolean validerPrenom   ( String prenom ) { return this.prenomAtomique.validerPrenom   ( prenom ); }

	public void supprimerOccurence()
	{
		this.prenomAtomique.supprimerOccurence();
	}

	public ArrayList<String> getTabValide()
	{
		return this.prenomAtomique.getTabValide();
	}


	public String getImage( String s )
	{
		return "atomique/images/" + s + ".png";
	}


	public static void main(String[] args)
	{
		new Controleur();
	}
}
