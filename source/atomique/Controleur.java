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

/*
	public ArrayList<String> comparerPrenom( String prenom )
	{
		return this.prenomAtomique.estCompare( prenom );
	}*/


	public ArrayList<String> getTabValide()
	{
		return this.prenomAtomique.getTabValide();
	}


	public String getImage( String s )
	{
		//return "atomique/images/" + s + ".png";
		return "atomique/images2/ac.png";
	}


	public static void main(String[] args)
	{
		new Controleur();
	}
}
