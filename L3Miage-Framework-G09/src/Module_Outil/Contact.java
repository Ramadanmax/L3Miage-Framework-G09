package Module_Outil;
import java.util.ArrayList;
import java.util.List;

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
		this.mail = mail;
		this.annuaire = new Annuaire();
		this.agenda = new Agenda();
		this.chatRooms = new ArrayList<ChatRoom>();
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
