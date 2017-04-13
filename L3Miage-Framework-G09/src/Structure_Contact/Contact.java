package Structure_Contact;
import java.util.ArrayList;
import java.util.List;

import FrameworkExceptions.FrameworkException;
import Module_Annuaire.Annuaire;
import Module_Event.Agenda;
import Module_Messagerie.ChatRoom;

public class Contact {

	private String nom;
	private Adresse adresse;
	private String mail;

	private List<ChatRoom> chatRooms;
	private Annuaire annuaire;
	private Agenda agenda;

	/**
	 * Constructeur d'un Contact.
	 * 
	 * @param nom
	 * @param adresse
	 * @param mail
	 */
	public Contact(String nom, Adresse adresse, String mail) {
		this.nom = nom;
		this.adresse = adresse;
		this.annuaire = new Annuaire();
		this.agenda = new Agenda();
		this.chatRooms = new ArrayList<ChatRoom>();

		if(!mail.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
			throw new FrameworkException("Adresse mail \"" + mail + "\" invalide.");
		}
		
		this.mail = mail;
	}

	/**
	 * Setter de l'adresse d'un Contact.
	 * 
	 * @param adresse
	 */
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	/**
	 * Setter du nom d'un Contact.
	 * 
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Setter du mail d'un Contact.
	 * 
	 * @param mail
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}
}
