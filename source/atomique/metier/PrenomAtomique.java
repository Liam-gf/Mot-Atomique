package atomique.metier;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedHashSet;

public class PrenomAtomique
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
	
	public PrenomAtomique()
	{
		this.tabSymboleValide = new ArrayList<String>();
	}


	public boolean recupererLettres( String prenom )
	{
		String  lettres    =   "";
		
		if ( ! this.tabSymboleValide.isEmpty() )
			this.tabSymboleValide.clear();
		
		ArrayList<String> tabSymboleCopie  = new ArrayList<>( LISTE_SYMBOLE );
		
		for ( int i = 0; i + 1 < prenom.length(); i ++ )
		{
			lettres = String.valueOf( prenom.charAt(i) );
			
			for ( int j = 0; j < tabSymboleCopie.size(); j ++ )
			{
				if ( lettres.equals( tabSymboleCopie.get(j) ) )
				{
					this.tabSymboleValide.add(tabSymboleCopie.get(j));
				}
			}
			
			lettres = lettres + String.valueOf( prenom.charAt( i + 1 ) );
			
			for ( int j = 0; j < tabSymboleCopie.size(); j ++ )
			{
				if ( lettres.equals( tabSymboleCopie.get(j) ) )
				{
					this.tabSymboleValide.add(tabSymboleCopie.get(j));
				}
			}
		}
		
		for ( String symbole : this.tabSymboleValide )
		{
			System.out.print( symbole + " " );
		}
		System.out.println();
		
		return true;
	}


	public void supprimerOccurence()
	{
		this.tabSymboleValide = new ArrayList<>( new LinkedHashSet<>( tabSymboleValide ) );
	}


	public boolean validerPrenom( String mot )
	{
		ArrayList<String> resultat = new ArrayList<>();
		
		if ( this.Recursive( "", mot, this.tabSymboleValide, resultat ) )
		{
			this.tabSymboleValide = resultat;
			return true;
		}
		return false;
	}

	private boolean Recursive(String construit, String mot, ArrayList<String> symboles, ArrayList<String> resultat)
	{
		if ( construit.equals(mot) ) return true;

		// Si la chaîne construite ne correspond plus au début du mot, on arrête ici
		if (!mot.startsWith(construit)) return false;

		// On teste chaque symbole possible
		for (String s : symboles)
		{
			resultat.add(s);
			if (Recursive(construit + s, mot, symboles, resultat))
			{
				return true; // combinaison trouvée
			}
			resultat.remove(resultat.size() - 1); // backtrack
		}

		return false;
	}


	public ArrayList<String> getTabValide()
	{
		return this.tabSymboleValide;
	}
}
