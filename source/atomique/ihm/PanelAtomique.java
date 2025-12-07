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
	
	private JTextField txtPrenom;
	private JLabel     lblPrenom;
	private JPanel     panelSchema;
	
	public PanelAtomique( Controleur ctrl )
	{
		this.ctrl = ctrl;
		
		this.setLayout( new GridLayout( 3, 1 ) );
		
		/* ----------------------------- */
		/* Création des composants       */
		/* ----------------------------- */
		
		JPanel panelPrenom = new JPanel();
		JPanel panelPhrase = new JPanel();
		this.panelSchema   = new JPanel();
		
		this.txtPrenom     = new JTextField( 30 );
		this.lblPrenom     = new JLabel    ( "" );
		
		/* ----------------------------- */
		/* Positionnement des composants */
		/* ----------------------------- */
		
		panelPrenom.add( txtPrenom );
		panelPhrase.add( lblPrenom );
		
		this.add(      panelPrenom );
		this.add(      panelPhrase );
		this.add( this.panelSchema );
		
		/* ------------------------------ */
		/* Activation des composants      */
		/* ------------------------------ */
		
		this.txtPrenom.addActionListener( this );
	}


	public void actionPerformed( ActionEvent e )
	{
		if ( e.getSource() == this.txtPrenom )
		{
			String mot = this.getPrenom();
			
			this.recupererLettres( mot );
			this.supprimerOccurence();
			
			this.panelSchema.removeAll();
			
			if ( this.validerPrenom( mot ) )
			{
				this.afficherMot();
				
				this.lblPrenom.setText( "Le prénom " + mot + " est atomique !" );
			}
			else
			{
				this.lblPrenom.setText( "Le prénom " + mot + " n'est pas atomique !");
			}
			
			this.panelSchema.revalidate();
			this.panelSchema.repaint();
		}
	}


	public String getPrenom()
	{
		return this.txtPrenom.getText().toLowerCase();
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
			JLabel lbl = new JLabel( new ImageIcon(new ImageIcon(this.ctrl.getImage(s)).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
		
			this.panelSchema.add(lbl);
		}
	}


	public boolean recupererLettres ( String mot ) { return this.ctrl.recupererLettres( mot ); }
	public boolean validerPrenom  ( String mot ) { return this.ctrl.validerPrenom ( mot ); }


	public void supprimerOccurence()
	{
		this.ctrl.supprimerOccurence();
	}
}