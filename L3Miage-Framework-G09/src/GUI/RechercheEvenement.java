package GUI;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

public class RechercheEvenement {

	private JFrame frame;
	private JTextField textField_ChampRecherche;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RechercheEvenement window = new RechercheEvenement();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RechercheEvenement() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 350, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btn_Retour = new JButton("Retour");
		btn_Retour.setBounds(203, 323, 125, 35);
		frame.getContentPane().add(btn_Retour);
		
		JLabel lbl_MyEwine = new JLabel("My eWine");
		lbl_MyEwine.setFont(new Font("Dialog", Font.BOLD, 16));
		lbl_MyEwine.setBounds(133, 12, 80, 26);
		frame.getContentPane().add(lbl_MyEwine);
		
		JLabel lbl_RechercheDEvenement = new JLabel("Recherche d'événement");
		lbl_RechercheDEvenement.setBounds(96, 51, 147, 14);
		frame.getContentPane().add(lbl_RechercheDEvenement);
		
		JButton btn_Recherche = new JButton("Recherche");
		btn_Recherche.setBounds(230, 77, 98, 24);
		frame.getContentPane().add(btn_Recherche);
		
		textField_ChampRecherche = new JTextField();
		textField_ChampRecherche.setBounds(12, 77, 205, 24);
		frame.getContentPane().add(textField_ChampRecherche);
		textField_ChampRecherche.setColumns(10);
		
		JScrollPane scrollPane_ResultatRecherche = new JScrollPane();
		scrollPane_ResultatRecherche.setBounds(12, 110, 315, 150);
		frame.getContentPane().add(scrollPane_ResultatRecherche);
		
		JButton btn_Afficher = new JButton("Afficher");
		btn_Afficher.setBounds(22, 265, 125, 35);
		frame.getContentPane().add(btn_Afficher);
		
		JButton btn_Modifier = new JButton("Modifier");
		btn_Modifier.setBounds(192, 265, 125, 35);
		frame.getContentPane().add(btn_Modifier);
	}
}
