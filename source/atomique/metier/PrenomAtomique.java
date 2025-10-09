package atomique.metier;

import java.util.ArrayList;
import java.util.List;

public class PrenomAtomique
{
	private static final List<String> LISTE_SYMBOLE = List.of
	(
	        "h" , "he", "li", "be",  "b", "c" , "n" , "o" , "f" , "ne",
	        "na", "mg", "al", "si",  "p", "s" , "cl", "ar", "k" , "ca",
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


	public boolean estAtomique( String prenom )
	{
		String  lettres    =   "";
		boolean existe     = true;

		if ( this.tabSymboleValide.isEmpty() )
			this.tabSymboleValide.clear();

		ArrayList<String> tabSymboleCopie  = new ArrayList<>( LISTE_SYMBOLE );
		
		int i = 0;
		
		while ( existe == true && i < prenom.length() - 1 )
		{
			existe = false;
			
			lettres = String.valueOf( prenom.charAt(i) );
			
			for ( int j = 0; j < tabSymboleCopie.size(); j ++ )
			{
				if ( lettres.equals( tabSymboleCopie.get(j) ) )
				{
					existe = true;
					this.tabSymboleValide.add(tabSymboleCopie.get(j));
				}
			}
			
			
			lettres = lettres + String.valueOf( prenom.charAt( i + 1 ) );
			
			for ( int j = 0; j < tabSymboleCopie.size(); j++ )
			{
				if ( lettres.equals( tabSymboleCopie.get(j) ) )
				{
					existe     = true;
					this.tabSymboleValide.add(tabSymboleCopie.get(j));
				}
			}
			
			if ( existe == true )
			{
				i += 2;
			}
		}
		

		if ( i == prenom.length() )
		{
			for ( String symbole : this.tabSymboleValide )
			{
				System.out.print( symbole + " " );
			}
			System.out.println();

			return true;
		}
		
		return false;
	}


	public ArrayList<String> getValide()
	{
		return this.tabSymboleValide;
	}
}
