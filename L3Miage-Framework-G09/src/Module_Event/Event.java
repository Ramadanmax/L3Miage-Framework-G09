package Module_Event;
import java.util.Date;
import java.util.List;
import Module_Outil.Contact;

/**
 * La classe Event permet aux utilisateurs de ce Framework de créer/supprimer et modifier un Evenement.
 * La modification d'un Evenement consiste en l'ajout ou la suppression de contacts liés à cet Event.
 * 
 * @version 1.0
 * @date 13/04/2017
 * @author Maxime RAMADANOSKI
 * 
 */
public class Event{
/**
 * Le nom de l'événement.
 * Ce nom peut être amené à changer.
 * 
 * @see Event#getNom()
 * @see Event#setNom(String)
 */
	private String nom;
	
/**
	 * Le lieu de l'événement.
	 * Ce lieu peut être amené à changer.
	 * 
	 * @see Event#getLieu()
	 * @see Event#setLieu(String)
*/	
	private String lieu;
/**
	 * La date de l'événement.
	 * Cette date peut être amenée à changer.
	 * 
	 * @see Event#getDate()
	 * @see Event#setDate(Date)
*/	
	private Date date;
/**
	 * La liste des contacts participants à l'événement.
	 * Cette liste est amenée à changer.
	 * 
	 * @see Event#getContacts()
	 * @see Event#setContacts(List<Contact>)
*/	
	private List<Contact> contacts;

/**
 * Le constructeur principal Event établit un événement selon le nom, le lieu la date et la liste de contacts participants fournis.
 *  
 * @param nom
 * @param lieu
 * @param date
 * @param contacts
 */

	public Event(String nom, String lieu, Date date, List<Contact> contacts){
		this.nom=nom;
		this.lieu=lieu;
		this.date=date;
		this.contacts=contacts;
	}
/**
 * Le constructeur secondaire Event permet de créer un événement selon son nom, son lieu et sa date.
 * Il peut être évident qu'un Event crée ne détienne pas encore de contacts participants.
 * @param nom
 * @param lieu
 * @param date
 */
	public Event(String nom, String lieu, Date date){
		this.nom=nom;
		this.lieu=lieu;
		this.date=date;
	}
/**
 * Retourne le nom de l'événement.
 * @return le nom de l'événement.
 */
	private String getNom() {
		return nom;
	}
/**
 * Met à jour le nom de l'événement.
 * 
 * @param nom
 * 			Le nouveau nom de l'événement.
 */
	private void setNom(String nom) {
		this.nom = nom;
	}
/**
 * Retourne le lieu de l'événement.
 * @return le lieu de l'événement.
 */
	private String getLieu() {
		return lieu;
	}
/**
 * Met à jour le lieu de l'événement.
 * @param lieu
 * 			Le nouveau lieu de l'événement.
 */
	private void setLieu(String lieu) {
		this.lieu = lieu;
	}
/**
 * Retourne la date de l'événement.
 * @return la date de l'événement.
 */
	private Date getDate() {
		return date;
	}
/**
 * Met à jour la date de l'événement.
 * @param date
 * 			La nouvelle date de l'événement
 */
	private void setDate(Date date) {
		this.date = date;
	}
/**
 * Retourne la liste de contacts participants à l'événement.
 * @return la liste de contacts participants à l'événement.
 */
	private List<Contact> getContacts() {
		return contacts;
	}
/**
 * Met à jour la liste de contacts participants à l'événement.
 * @param contacts
 * 				La nouvelle liste de contacts participant à l'événement
 */
	private void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
/**
 * Ajoute un contact à la liste des contacts participants à l'événement.
 * @param c
 * 			Le nouveau contact à ajouter à l'événement.
 */
	private void ajouterContact(Contact c){
		contacts.add(c);
	}
/**
 * Supprime un contact de la liste des contacts participants à l'événement.
 * @param c
 * 			Le contact à supprimer de la liste des contacts participants à l'événement.
 */
	private void supprimerContact(Contact c){
		contacts.remove(c);
	}
}
