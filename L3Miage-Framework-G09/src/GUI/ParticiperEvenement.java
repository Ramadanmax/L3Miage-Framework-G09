package GUI;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ParticiperEvenement {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ParticiperEvenement window = new ParticiperEvenement();
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
	public ParticiperEvenement() {
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
		
		JLabel lbl_ParticiperEvenement = new JLabel("Participer à ");
		lbl_ParticiperEvenement.setBounds(96, 51, 147, 14);
		frame.getContentPane().add(lbl_ParticiperEvenement);
		
		JLabel lbl_Instruction = new JLabel("Choisissez le type de votre participation");
		lbl_Instruction.setBounds(48, 77, 241, 35);
		frame.getContentPane().add(lbl_Instruction);

		JButton btn_Produit = new JButton("Produit");
		btn_Produit.setBounds(93, 124, 150, 50);
		frame.getContentPane().add(btn_Produit);
		
		JLabel lbl_Ou = new JLabel("Ou");
		lbl_Ou.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Ou.setBounds(48, 180, 241, 35);
		frame.getContentPane().add(lbl_Ou);
		
		JButton btn_Service = new JButton("Service");
		btn_Service.setBounds(93, 222, 150, 50);
		frame.getContentPane().add(btn_Service);
	}

}
