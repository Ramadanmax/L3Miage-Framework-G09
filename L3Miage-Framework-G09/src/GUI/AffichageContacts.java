package GUI;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class AffichageContacts {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AffichageContacts window = new AffichageContacts();
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
	public AffichageContacts() {
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
		
		JLabel lbl_AffichageContacts = new JLabel("Affichage des contacts");
		lbl_AffichageContacts.setBounds(99, 50, 144, 14);
		frame.getContentPane().add(lbl_AffichageContacts);
		
		JLabel lbl_Filtrer = new JLabel("Filtrer");
		lbl_Filtrer.setFont(new Font("Dialog", Font.BOLD, 14));
		lbl_Filtrer.setBounds(12, 96, 61, 14);
		frame.getContentPane().add(lbl_Filtrer);
		
		JTextField textField_Filtrer = new JTextField();
		textField_Filtrer.setBounds(71, 95, 150, 18);
		frame.getContentPane().add(textField_Filtrer);
		textField_Filtrer.setColumns(10);
		
		JButton btn_Filtrer = new JButton("Filtrer");
		btn_Filtrer.setBounds(250, 95, 78, 18);
		frame.getContentPane().add(btn_Filtrer);
		
		JTable table_Contacts = new JTable();
		table_Contacts.setBorder(UIManager.getBorder("TextField.border"));
		table_Contacts.setBounds(12, 122, 316, 135);
		frame.getContentPane().add(table_Contacts);

		JButton btn_EcrireMessage = new JButton("Nouveau message");
		btn_EcrireMessage.setBounds(12, 281, 314, 30);
		frame.getContentPane().add(btn_EcrireMessage);
	}

}
