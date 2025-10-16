package atomique.metier;

import java.util.LinkedHashSet;
import java.util.ArrayList;
import java.util.List;

public class PrenomAtomique
{
	private static final List<String> LISTE_SYMBOLE = List.of
	(
	        "h" , "he", "li", "be", "b" , "c" , "n" , "o" , "f" , "ne",
	        "na", "mg", "al", "si", "p" , "s" , "cl", "ar", "k" , "ca",
	        "sc", "ti", "v" , "cr", "mn", "fe", "co", "ni", "cu", "zn",
	        "ga", "ge", "as", "se", "br", "kr", "rb", "sr", "y" , "zr",
	        "nb", "mo", "tc", "ru", "rh", "pd", "ag", "cd", "in", "sn",
	        "sb", "te", "i" , "xe", "cs", "ba", "la", "ce", "pr", "nd",
	        "pm", "sm", "eu", "gd", "tb", "dy", "ho", "er", "tm", "yb",
	        "lu", "hf", "ta", "w" , "re", "os", "ir", "pt", "au", "hg",
	        "tl", "pb", "bi", "po", "at", "rn", "fr", "ra", "ac", "th",
	        "pa", "u" , "np", "pu", "am", "cm", "bk", "cf", "es", "fm",
	        "md", "no", "lr", "rf", "db", "sg", "bh", "hs", "mt", "ds",
	        "rg", "cn", "nh", "fl", "mc", "lv", "ts", "og"
	);
	
	private ArrayList<String> tabSymboleValide;
	
	public PrenomAtomique()
	{
		this.tabSymboleValide = new ArrayList<String>();
	}


	public boolean estAtomique2( String prenom )
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
		String construit = "";

		for (String s : this.tabSymboleValide)
		{
			String temp = construit + s;


			if (mot.startsWith(temp))
			{
				resultat.add(s);
				construit = temp;
			}
			else
			{
				if (mot.startsWith(s) && s.length() > 0)
				{
				    resultat.clear();
				    resultat.add(s);
				    construit = s;
				}
			}


			if ( construit.equals(mot) )
				break;
		}

		this.tabSymboleValide = resultat;
		
		for ( String symbole : this.tabSymboleValide )
		{
			System.out.print( symbole + " " );
		}
		System.out.println("------");
		
		return true;
	}


	public ArrayList<String> getTabValide()
	{
		return this.tabSymboleValide;
	}
}
