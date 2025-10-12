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
	//private JLabel        lblImage;
	
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
		//this.lblImage      = new JLabel    (    );
		
		/* ----------------------------- */
		/* Positionnement des composants */
		/* ----------------------------- */
		
		panelPrenom.add(txtPrenom);
		panelPhrase.add(lblPrenom);
		//panelSchema.add(lblImage);

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
				// this.ctrl.comparerPrenom( this.getPrenom() );
				ArrayList<String> tabValide = this.ctrl.getTabValide();
				
				
				/*ImageIcon icon = new ImageIcon(this.ctrl.getImage( ));
				Image img = icon.getImage();
				Image resizedImg = img.getScaledInstance(600, 423, Image.SCALE_SMOOTH);
				ImageIcon resizedIcon = new ImageIcon(resizedImg);
				lblImage.setIcon(resizedIcon);*/

				this.panelSchema.removeAll();
				
				this.panelSchema.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
				
				
				for ( String s : tabValide )
				{
					JLabel lbl = new JLabel( new ImageIcon(new ImageIcon(this.ctrl.getImage(s)).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
					//JLabel lbl = new JLabel( new ImageIcon(new ImageIcon(this.ctrl.getImage(s)).getImage().getScaledInstance(600, 423, Image.SCALE_SMOOTH)));
					
					lbl.setBorder(null);
					lbl.setOpaque(false);
					lbl.setBackground(Color.BLACK);
					lbl.setText(null);
					lbl.setHorizontalAlignment(JLabel.LEFT);
					lbl.setVerticalAlignment(JLabel.TOP);
					
					this.panelSchema.add(lbl);
				}

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
