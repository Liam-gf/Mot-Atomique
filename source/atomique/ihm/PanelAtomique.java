package atomique.ihm;

import atomique.Controleur;

import java.awt.event.*;
import java.util.ArrayList;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelAtomique extends JPanel implements ActionListener
{
	private Controleur   ctrl;

	private JTextField    txtPrenom;
	private JLabel        lblPrenom;
	private JLabel        lblImage;
	
	public PanelAtomique( Controleur ctrl )
	{
		this.ctrl = ctrl;

		this.setLayout( new GridLayout( 3, 1 ) );

		/* ----------------------------- */
		/* Création des composants       */
		/* ----------------------------- */
		
		JPanel panelPrenom = new JPanel();
		JPanel panelPhrase = new JPanel();
		JPanel panelSchema = new JPanel();

		this.txtPrenom     = new JTextField( 30 );
		this.lblPrenom     = new JLabel    ( "" );
		this.lblImage      = new JLabel    (    );
		
		/* ----------------------------- */
		/* Positionnement des composants */
		/* ----------------------------- */
		
		panelPrenom.add(txtPrenom);
		panelPhrase.add(lblPrenom);
		panelSchema.add(lblImage);

		this.add( panelPrenom );
		this.add( panelPhrase );
		this.add( panelSchema );

		/* ------------------------------ */
		/* Activation des composants      */
		/* ------------------------------ */
		
		this.txtPrenom.addActionListener( this );
	}


	public void actionPerformed( ActionEvent e )
	{
		if ( e.getSource() == this.txtPrenom )
		{
			if ( this.ctrl.verifierPrenom( this.getPrenom().toLowerCase() ) )
			{
				this.lblPrenom.setText( "Le prénom " + this.getPrenom() + " est atomique !" );
				this.ctrl.comparerPrenom( this.getPrenom() );
			}
			else
			{
				this.lblPrenom.setText( "Le prénom " + this.getPrenom() + " n'est pas atomique !" );
			}
		}
	}


	public String getPrenom()
	{
		return this.txtPrenom.getText();
	}
}
