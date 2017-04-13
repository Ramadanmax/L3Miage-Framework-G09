package Module_Annuaire;

import java.util.ArrayList;
import java.util.List;

import Structure_Contact.Contact;

public class Annuaire {
	
	private List<Contact> contacts;
	
	/**
	 * Constructeur d'un Annuaire.
	 */
	public Annuaire() {
		this.contacts = new ArrayList<Contact>();
	}
	
	/**
	 * Ajout d'un Contact dans l'Annuaire.
	 * 
	 * @param c
	 */
	public void ajouterContact(Contact c) {
		this.contacts.add(c);
	}
	
	/**
	 * Recuperation des contacts de l'Annuaire.
	 * 
	 * @return
	 */
	public List<Contact> getContacts() {
		return this.contacts;
	}
	
	/**
	 * Suppression d'un Contact dans l'Annuaire.
	 * 
	 * @param c
	 */
	public void supprimerContact(Contact c) {
		this.contacts.remove(this.contacts.indexOf(c));
	}
}
