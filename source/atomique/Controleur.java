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


	public boolean verifierPrenom( String prenom )
	{
		return this.prenomAtomique.estAtomique( prenom );
	}


	public ArrayList<String> getValide()
	{
		return this.prenomAtomique.getValide();
	}


	public String getImage()
	{
		return "atomique/images/Hyrogene.png";
	}

	public static void main(String[] args)
	{
		new Controleur();
	}
}
