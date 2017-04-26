package GUI;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class CreationContributionProduit {

	private JFrame frame;
	private JTextField textField_Unite;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreationContributionProduit window = new CreationContributionProduit();
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
	public CreationContributionProduit() {
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
		
		JLabel lbl_ContributionProduit = new JLabel("Contribution d'un produit");
		lbl_ContributionProduit.setBounds(96, 50, 167, 14);
		frame.getContentPane().add(lbl_ContributionProduit);JLabel lbl_Nom = new JLabel("Nom");
		lbl_Nom.setFont(new Font("Dialog", Font.BOLD, 14));
		lbl_Nom.setBounds(41, 94, 35, 14);
		frame.getContentPane().add(lbl_Nom);
		
		JLabel lbl_Qantite = new JLabel("Quantite");
		lbl_Qantite.setFont(new Font("Dialog", Font.BOLD, 14));
		lbl_Qantite.setBounds(12, 119, 73, 14);
		frame.getContentPane().add(lbl_Qantite);
		
		JLabel lbl_ValeurFinanciere = new JLabel("Valeur financière");
		lbl_ValeurFinanciere.setFont(new Font("Dialog", Font.BOLD, 14));
		lbl_ValeurFinanciere.setBounds(12, 145, 136, 14);
		frame.getContentPane().add(lbl_ValeurFinanciere);
		
		JTextField textField_Nom = new JTextField();
		textField_Nom.setBounds(83, 93, 213, 18);
		frame.getContentPane().add(textField_Nom);
		textField_Nom.setColumns(10);
		
		JTextField textField_Quantite = new JTextField();
		textField_Quantite.setColumns(10);
		textField_Quantite.setBounds(83, 118, 90, 18);
		frame.getContentPane().add(textField_Quantite);
		
		JTextField textField_Lieu = new JTextField();
		textField_Lieu.setColumns(10);
		textField_Lieu.setBounds(146, 144, 150, 18);
		frame.getContentPane().add(textField_Lieu);
		
		JLabel lbl_Unite = new JLabel("Unite");
		lbl_Unite.setFont(new Font("Dialog", Font.BOLD, 14));
		lbl_Unite.setBounds(191, 119, 46, 14);
		frame.getContentPane().add(lbl_Unite);
		
		textField_Unite = new JTextField();
		textField_Unite.setColumns(10);
		textField_Unite.setBounds(231, 118, 65, 18);
		frame.getContentPane().add(textField_Unite);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setBounds(121, 172, 175, 100);
		frame.getContentPane().add(scrollPane);
		
		JTextArea textArea_Description = new JTextArea();
		scrollPane.setViewportView(textArea_Description);
		textArea_Description.setBorder(UIManager.getBorder("TextField.border"));
		textArea_Description.setLineWrap(true);
		
		JLabel lbl_Description = new JLabel("Description");
		lbl_Description.setFont(new Font("Dialog", Font.BOLD, 14));
		lbl_Description.setBounds(26, 171, 88, 14);
		frame.getContentPane().add(lbl_Description);

		JButton btn_Valider = new JButton("Valider");
		btn_Valider.setBounds(12, 323, 125, 35);
		frame.getContentPane().add(btn_Valider);
	}

}
