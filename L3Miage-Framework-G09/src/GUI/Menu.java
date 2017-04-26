package GUI;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
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
	public Menu() {
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
		
		JLabel lbl_MyEwine = new JLabel("My eWine");
		lbl_MyEwine.setFont(new Font("Dialog", Font.BOLD, 16));
		lbl_MyEwine.setBounds(133, 12, 80, 26);
		frame.getContentPane().add(lbl_MyEwine);
		
		JButton btn_CreationDunEvenement = new JButton("Creation d'un Evenement");
		btn_CreationDunEvenement.setBounds(26, 58, 300, 50);
		frame.getContentPane().add(btn_CreationDunEvenement);
		
		JButton btn_RechercheDEvenement = new JButton("Recherche d'Evenement");
		btn_RechercheDEvenement.setBounds(26, 120, 300, 50);
		frame.getContentPane().add(btn_RechercheDEvenement);
		
		JButton btn_ListeDesContacts = new JButton("Liste des contacts");
		btn_ListeDesContacts.setBounds(26, 182, 300, 50);
		frame.getContentPane().add(btn_ListeDesContacts);
		
		JButton btn_ConsulterMesMessages = new JButton("Consulter mes messages");
		btn_ConsulterMesMessages.setBounds(26, 244, 300, 50);
		frame.getContentPane().add(btn_ConsulterMesMessages);
		
		JButton btn_Deconnexion = new JButton("Deconnexion");
		btn_Deconnexion.setBounds(201, 320, 125, 35);
		frame.getContentPane().add(btn_Deconnexion);
	}

}
