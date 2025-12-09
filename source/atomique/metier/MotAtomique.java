package atomique.metier;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedHashSet;

public class MotAtomique
{
	private static final List<String> LISTE_SYMBOLE = List.of
	(
		"h" , "he", "li", "be", "b" , "c" , "n" , "o" , "f" , "ne", "na", "mg", "al", "si", "p" ,
		"s" , "cl", "ar", "k" , "ca", "sc", "ti", "v" , "cr", "mn", "fe", "co", "ni", "cu", "zn",
		"ga", "ge", "as", "se", "br", "kr", "rb", "sr", "y" , "zr", "nb", "mo", "tc", "ru", "rh",
		"pd", "ag", "cd", "in", "sn", "sb", "te", "i" , "xe", "cs", "ba", "la", "ce", "pr", "nd",
		"pm", "sm", "eu", "gd", "tb", "dy", "ho", "er", "tm", "yb", "lu", "hf", "ta", "w" , "re",
		"os", "ir", "pt", "au", "hg", "tl", "pb", "bi", "po", "at", "rn", "fr", "ra", "ac", "th",
		"pa", "u" , "np", "pu", "am", "cm", "bk", "cf", "es", "fm", "md", "no", "lr", "rf", "db",
		"sg", "bh", "hs", "mt", "ds", "rg", "cn", "nh", "fl", "mc", "lv", "ts", "og"
	);
	
	private ArrayList<String> tabSymboleValide;
	
	public MotAtomique()
	{
		this.tabSymboleValide = new ArrayList<String>();
	}


	public void recupererLettres( String Mot )
	{
		String lettres = "";
		
		if ( ! this.tabSymboleValide.isEmpty() )
			this.tabSymboleValide.clear();
		
		ArrayList<String> tabSymboleCopie  = new ArrayList<>( LISTE_SYMBOLE );
		
		for ( int i = 0; i + 1 < Mot.length(); i ++ )
		{
			lettres = String.valueOf( Mot.charAt(i) );
			ajouterLettresValides( lettres, tabSymboleCopie );
			
			lettres = lettres + String.valueOf( Mot.charAt( i + 1 ) );
			ajouterLettresValides( lettres, tabSymboleCopie );
		}
	}


	public void ajouterLettresValides( String lettres, ArrayList<String> tabSymboleCopie )
	{
		if ( tabSymboleCopie.contains( lettres ) )
			this.tabSymboleValide.add( lettres );
	}


	public void supprimerOccurrence()
	{
		this.tabSymboleValide = new ArrayList<>( new LinkedHashSet<>( tabSymboleValide ) );
	}


	public boolean validerMot( String mot )
	{
		ArrayList<String> resultat = new ArrayList<>();
		
		if ( this.trouverRecursivement( "", mot, this.tabSymboleValide, resultat ) )
		{
			this.tabSymboleValide = resultat;
			return true;
		}
		return false;
	}

	private boolean trouverRecursivement( String construit, String mot, ArrayList<String> listeSymboles, ArrayList<String> resultat )
	{
		if (   construit.equals( mot  ) )    return true;
		if ( ! mot.startsWith( construit ) ) return false;

		for ( String s : listeSymboles )
		{
			resultat.add(s);
			if ( trouverRecursivement( construit + s, mot, listeSymboles, resultat ) )
			{
				return true;
			}

			resultat.remove(resultat.size() - 1);
		}

		return false;
	}


	public ArrayList<String> getTabValide()
	{
		return this.tabSymboleValide;
	}
}
