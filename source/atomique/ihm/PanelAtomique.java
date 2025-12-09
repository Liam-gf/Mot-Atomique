package atomique.ihm;

import atomique.Controleur;

import java.util.ArrayList;

import java.awt.Image;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import java.awt.event.*;

import javax.swing.*;

public class PanelAtomique extends JPanel implements ActionListener
{
	private Controleur ctrl;
	
	private JTextField txtMot;
	private JLabel     lblMot;
	private JPanel     panelSchema;
	
	public PanelAtomique( Controleur ctrl )
	{
		this.ctrl = ctrl;
		
		this.setLayout( new GridLayout( 3, 1 ) );
		
		/* ----------------------------- */
		/* Création des composants       */
		/* ----------------------------- */
		
		JPanel panelMot = new JPanel();
		JPanel panelPhrase = new JPanel();
		this.panelSchema   = new JPanel();
		
		this.txtMot     = new JTextField( 30 );
		this.lblMot     = new JLabel    ( "" );
		
		/* ----------------------------- */
		/* Positionnement des composants */
		/* ----------------------------- */
		
		panelMot.add( txtMot );
		panelPhrase.add( lblMot );
		
		this.add(      panelMot );
		this.add(      panelPhrase );
		this.add( this.panelSchema );
		
		/* ------------------------------ */
		/* Activation des composants      */
		/* ------------------------------ */
		
		this.txtMot.addActionListener( this );
	}


	public void actionPerformed( ActionEvent e )
	{
		if ( e.getSource() == this.txtMot )
		{
			String mot = this.getMot().toLowerCase();
			
			this.recupererLettres( mot );
			this.supprimerOccurence();
			
			this.panelSchema.removeAll();
			
			if ( this.validerMot( mot ) )
			{
				this.afficherMot();
				
				this.lblMot.setText( "Le mot " + this.getMot() + " est atomique !" );
			}
			else
			{
				this.lblMot.setText( "Le mot " + this.getMot() + " n'est pas atomique !");
			}
			
			this.panelSchema.revalidate();
			this.panelSchema.repaint();
		}
	}


	public String getMot()
	{
		return this.txtMot.getText();
	}

	public ArrayList<String> getTabValide()
	{
		return this.ctrl.getTabValide();
	}


	public void afficherMot()
	{
		this.panelSchema.setLayout( new FlowLayout( FlowLayout.CENTER, 0, 0 ) );
		
		ArrayList<String> tabValide = this.getTabValide();
		
		for ( String s : tabValide )
		{
			ImageIcon imgIcon = this.ctrl.getImage( s );

			Image img = imgIcon.getImage();

			Image imgRedimensionner = img.getScaledInstance( 150, 150, Image.SCALE_SMOOTH );

			JLabel lbl = new JLabel( new ImageIcon( imgRedimensionner ) );
		
			this.panelSchema.add(lbl);
		}
	}


	public boolean validerMot    ( String mot ) { return this.ctrl.validerMot   ( mot ); }


	public void recupererLettres  ( String mot ) { this.ctrl.recupererLettres( mot ); }
	public void supprimerOccurence()             { this.ctrl.supprimerOccurence();    }
}