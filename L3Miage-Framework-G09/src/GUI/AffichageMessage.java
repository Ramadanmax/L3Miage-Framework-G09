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

public class AffichageMessage {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AffichageMessage window = new AffichageMessage();
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
	public AffichageMessage() {
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
		
		JLabel lbl_AfficherMessage = new JLabel("Afficher un message");
		lbl_AfficherMessage.setBounds(117, 51, 130, 14);
		frame.getContentPane().add(lbl_AfficherMessage);
		
		JLabel lbl_Expediteur = new JLabel("Expediteur");
		lbl_Expediteur.setFont(new Font("Dialog", Font.BOLD, 14));
		lbl_Expediteur.setBounds(41, 94, 88, 14);
		frame.getContentPane().add(lbl_Expediteur);
		
		JTextField textField_ValeurFinanciere = new JTextField();
		textField_ValeurFinanciere.setEditable(false);
		textField_ValeurFinanciere.setColumns(10);
		textField_ValeurFinanciere.setBounds(133, 93, 150, 18);
		frame.getContentPane().add(textField_ValeurFinanciere);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setBounds(20, 170, 300, 100);
		frame.getContentPane().add(scrollPane);
		
		JTextArea textArea_Message = new JTextArea();
		textArea_Message.setEditable(false);
		scrollPane.setViewportView(textArea_Message);
		textArea_Message.setBorder(UIManager.getBorder("TextField.border"));
		textArea_Message.setLineWrap(true);
		
		JLabel lbl_Destinataire = new JLabel("Destinataire");
		lbl_Destinataire.setFont(new Font("Dialog", Font.BOLD, 14));
		lbl_Destinataire.setBounds(41, 120, 88, 14);
		frame.getContentPane().add(lbl_Destinataire);
		
		JTextField textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(133, 119, 150, 18);
		frame.getContentPane().add(textField);
		
		JLabel lbl_Message = new JLabel("Message");
		lbl_Message.setFont(new Font("Dialog", Font.BOLD, 14));
		lbl_Message.setBounds(20, 146, 88, 14);
		frame.getContentPane().add(lbl_Message);

		JButton btn_Repondre = new JButton("Repondre");
		btn_Repondre.setBounds(26, 281, 100, 30);
		frame.getContentPane().add(btn_Repondre);
		
		JButton btn_Supprimer = new JButton("Supprimer");
		btn_Supprimer.setBounds(196, 281, 100, 30);
		frame.getContentPane().add(btn_Supprimer);
	}

}
