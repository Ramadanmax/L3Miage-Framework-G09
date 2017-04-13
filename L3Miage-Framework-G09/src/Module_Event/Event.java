package Module_Event;
import java.util.Date;
import java.util.List;
import Module_Outil.Contact;

/*
 * La classe Event permet aux utilisateurs de ce Framework de créer/supprimer et modifier un Evenement.
 * La modification d'un Evenement consiste en l'ajout ou la suppression de contacts liés à cet Event.
 * 
 * @version 1.0
 * @date 13/04/2017
 * @author Maxime RAMADANOSKI
 */
public class Event{
	//
	private String nom,lieu;
	private Date date;
	private List<Contact> contacts;

	public Event(String nom, String lieu, Date date, List<Contact> contacts){
		this.nom=nom;
		this.lieu=lieu;
		this.date=date;
		this.contacts=contacts;
	}
	public Event(String nom, String lieu, Date date){
		this.nom=nom;
		this.lieu=lieu;
		this.date=date;
	}
	private String getNom() {
		return nom;
	}
	private void setNom(String nom) {
		this.nom = nom;
	}
	private String getLieu() {
		return lieu;
	}
	private void setLieu(String lieu) {
		this.lieu = lieu;
	}
	private Date getDate() {
		return date;
	}
	private void setDate(Date date) {
		this.date = date;
	}
	private List<Contact> getContacts() {
		return contacts;
	}
	private void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
	private void ajouterContact(Contact c){
		contacts.add(c);
	}
	private void supprimerContact(Contact c){
		contacts.remove(c);
	}
}
