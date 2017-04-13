package Structure_Contact;

import java.util.ArrayList;
import java.util.List;

import FrameworkExceptions.FrameworkException;
import Module_Annuaire.Annuaire;
import Module_Event.Agenda;
import Module_Messagerie.ChatRoom;

/**
 * Classe Contact, structure d'une personne.
 * 
 * @author virgil
 *
 */
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

		if (!mail.matches(
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
			throw new FrameworkException("Adresse mail \"" + mail + "\" invalide.");
		}

		this.mail = mail;
	}

	/**
	 * Getter du nom d'un Contact.
	 * 
	 * @return this.nom Le nom du Contact courant.
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Getter de l'adresse d'un Contact.
	 * 
	 * @return this.adresse L'adresse du Contact courant.
	 */
	public Adresse getAdresse() {
		return adresse;
	}

	/**
	 * Getter du mail d'un Contact.
	 * 
	 * @return this.mail Le mail du Contact courant.
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * Getter des ChatRooms d'un Contact.
	 * 
	 * @return this.chatRooms La liste de ChatRoom du Contact courant.
	 */
	public List<ChatRoom> getChatRooms() {
		return chatRooms;
	}

	/**
	 * Getter de l'Annuaire d'un Contact.
	 * 
	 * @return this.annuaire L'Annuaire du Contact courant.
	 */
	public Annuaire getAnnuaire() {
		return annuaire;
	}

	/**
	 * Getter de l'Agenda d'un Contact.
	 * 
	 * @return this.agenda L'Agenda du Contact courant.
	 */
	public Agenda getAgenda() {
		return agenda;
	}

	/**
	 * Setter de l'adresse d'un Contact.
	 * 
	 * @param adresse
	 *            L'Adresse du Contact courant.
	 */
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	/**
	 * Setter du nom d'un Contact.
	 * 
	 * @param nom
	 *            Le nom du Contact courant.
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Setter du mail d'un Contact.
	 * 
	 * @param mail
	 *            Le mail du Contact courant.
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * Methode toString d'un Contact.
	 */
	public String toString() {
		return this.nom + " - " + this.mail + " - " + this.adresse;
	}
}
