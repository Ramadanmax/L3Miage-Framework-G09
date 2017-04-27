package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;

import Module_Securite.Authentification;
import Module_Securite.Crypteur;

import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPasswordField;

public class PageAuthentification {

	private JFrame frame;
	private JTextField textField_Identifiant;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PageAuthentification window = new PageAuthentification();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 350, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lbl_MyEwine = new JLabel("My eWine");
		lbl_MyEwine.setFont(new Font("Dialog", Font.BOLD, 16));
		lbl_MyEwine.setBounds(133, 12, 80, 26);
		frame.getContentPane().add(lbl_MyEwine);
		
		JLabel lbl_Identifiant = new JLabel("Identifiant");
		lbl_Identifiant.setBounds(43, 68, 82, 14);
		frame.getContentPane().add(lbl_Identifiant);
		
		JLabel lbl_MotDePasse = new JLabel("Mot de passe");
		lbl_MotDePasse.setBounds(43, 116, 82, 14);
		frame.getContentPane().add(lbl_MotDePasse);
		
		textField_Identifiant = new JTextField();
		textField_Identifiant.setBounds(153, 66, 114, 18);
		frame.getContentPane().add(textField_Identifiant);
		textField_Identifiant.setColumns(10);
		
		JButton btnConnexion = new JButton("Connexion");
		btnConnexion.setBounds(128, 167, 98, 24);
		frame.getContentPane().add(btnConnexion);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(153, 114, 114, 18);
		frame.getContentPane().add(passwordField);
	}
}
