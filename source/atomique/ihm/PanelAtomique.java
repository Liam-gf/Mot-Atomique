package atomique.ihm;

import atomique.Controleur;

import java.awt.event.*;
import java.util.ArrayList;
import java.awt.GridLayout;

import java.awt.Image;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelAtomique extends JPanel implements ActionListener
{
	private Controleur   ctrl;
	
	private JTextField    txtPrenom;
	private JLabel        lblPrenom;
	
	private JPanel panelSchema;
	
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
		
		panelPrenom.add(txtPrenom);
		panelPhrase.add(lblPrenom);
		
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
			this.ctrl.verifierPrenom( this.getPrenom().toLowerCase() );
			this.ctrl.supprimerOccurence();
			this.ctrl.validerPrenom ( this.getPrenom() );
			
			this.panelSchema.removeAll();
			
			if ( this.ctrl.validerPrenom( this.getPrenom() ) )
			{
				this.panelSchema.setLayout( new FlowLayout(FlowLayout.CENTER, 0, 0) );
				
				ArrayList<String> tabValide = this.ctrl.getTabValide();
				
				for ( String s : tabValide )
				{
					JLabel lbl = new JLabel( new ImageIcon(new ImageIcon(this.ctrl.getImage(s)).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
				
					this.panelSchema.add(lbl);
				}
				
				this.lblPrenom.setText( "Le prénom " + this.getPrenom() + " est atomique !" );
			}
			else
			{
				this.lblPrenom.setText( "Le prénom " + this.getPrenom() + " n'est pas atomique !" );
			}
			
				ArrayList<String> tabValide = this.ctrl.getTabValide();
				
				for ( String s : tabValide )
				{
					JLabel lbl = new JLabel( new ImageIcon(new ImageIcon(this.ctrl.getImage(s)).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
				
					this.panelSchema.add(lbl);
				}
		}
	}


	public String getPrenom()
	{
		return this.txtPrenom.getText().toLowerCase();
	}
}
