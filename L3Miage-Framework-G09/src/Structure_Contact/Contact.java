package Structure_Contact;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import FrameworkExceptions.FrameworkException;
import Module_Annuaire.Annuaire;
import Module_Evenement.Agenda;
import Module_ListeTaches.ListeTaches;
import Module_Messagerie._SalonDiscussion;

/**
 * Classe Contact, structure d'une personne.
 * 
 * @author virgil
 *
 */
public class Contact implements Serializable {

	private static final long serialVersionUID = 3597050801817464921L;
	private String nom;
	private Adresse adresse;
	private String mail;
	private String login;

	private List<_SalonDiscussion> salonDiscussion;
	private Annuaire annuaire;
	private Agenda agenda;
	private ListeTaches listeTaches;
	
	/**
	 * Constructeur d'un Contact.
	 * 
	 * @param nom
	 *            Le nom d'un Contact.
	 * @param adresse
	 *            L'Adresse d'un Contact.
	 * @param mail
	 *            Le mail d'un Contact.
	 * @throws FrameworkException
	 */
	public Contact(String nom, Adresse adresse, String mail, String login) throws FrameworkException {
		this.nom = nom;
		this.adresse = adresse;
		this.login=login;
		this.annuaire = new Annuaire();
		this.agenda = new Agenda();
		this.salonDiscussion = new ArrayList<_SalonDiscussion>();
		this.listeTaches = new ListeTaches();

		// Verification de la validite du mail
		if (!mail.matches(
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
			throw new FrameworkException("L'adresse mail \"" + mail + "\" saisie est invalide.");
		}

		this.mail = mail;
	}

	/**
	 * Getter du nom d'un Contact.
	 * 
	 * @return Le nom du Contact courant.
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Getter de l'adresse d'un Contact.
	 * 
	 * @return L'adresse du Contact courant.
	 */
	public Adresse getAdresse() {
		return adresse;
	}
	
	/**
	 * Getter du login d'un Contact.
	 * 
	 * @return Login du Contact courant.
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * Getter du mail d'un Contact.
	 * 
	 * @return Le mail du Contact courant.
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * Getter des ChatRooms d'un Contact.
	 * 
	 * @return La liste de ChatRoom du Contact courant.
	 */
	public List<_SalonDiscussion> getChatRooms() {
		return salonDiscussion;
	}

	/**
	 * Getter de l'Annuaire d'un Contact.
	 * 
	 * @return L'Annuaire du Contact courant.
	 */
	public Annuaire getAnnuaire() {
		return annuaire;
	}

	/**
	 * Getter de l'Agenda d'un Contact.
	 * 
	 * @return L'Agenda du Contact courant.
	 */
	public Agenda getAgenda() {
		return agenda;
	}

	/**
	 * Getter de la TaskList d'un Contact.
	 * 
	 * @return La TaskList du Contact courant.
	 */
	public ListeTaches getTaskList() {
		return listeTaches;
	}

	/**
	 * Setter de l'adresse d'un Contact.
	 * 
	 * @param adresse
	 *            L'Adresse d'un Contact.
	 */
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	/**
	 * Setter du nom d'un Contact.
	 * 
	 * @param nom
	 *            Le nom d'un Contact.
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Setter du mail d'un Contact.
	 * 
	 * @param mail
	 *            Le mail d'un Contact.
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * Setter de la TaskList d'un Contact.
	 * 
	 * @param taskList
	 *            La TaskList d'un Contact.
	 */
	public void setTaskList(ListeTaches taskList) {
		this.listeTaches = taskList;
	}

	/**
	 * Methode toString d'un Contact.
	 */
	public String toString() {
		return this.nom + " - " + this.mail + " - " + this.adresse + " - " + this.login;
	}
}
