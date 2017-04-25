package Module_Annuaire;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import FrameworkExceptions.FrameworkException;
import Structure_Contact.Contact;

/**
 * Classe Annuaire, structure de l'Annuaire d'un Contact.
 * 
 * @author virgil
 *
 */
public class Annuaire implements Serializable {


	private static final long serialVersionUID = -5041169557858836282L;
	private List<Contact> contacts;

	/**
	 * Constructeur d'un Annuaire.
	 */
	public Annuaire() {
		this.contacts = new ArrayList<Contact>();
	}

	/**
	 * Ajout d'un Contact dans l'Annuaire courant.
	 * 
	 * @param c
	 *            Le Contact a ajouter.
	 */
	public void ajouterContact(Contact c) {
		this.contacts.add(c);
	}

	/**
	 * Getter des Contacts d'un Annuaire.
	 * 
	 * @return Les Contacts de l'Annuaire courant.
	 */
	public List<Contact> getContacts() {
		return this.contacts;
	}

	/**
	 * Suppression d'un Contact dans l'Annuaire courant.
	 * 
	 * @param c
	 *            Le Contact a supprimer.
	 * @throws FrameworkException
	 */
	public void supprimerContact(Contact c) throws FrameworkException {
		if (!this.contacts.contains(c)) {
			// Le Contact n'existe pas.
			throw new FrameworkException("Le Contact que vous essayez de supprimer n'existe pas dans cette Annuaire.");
		}
		// Le Contact existe.
		this.contacts.remove(this.contacts.indexOf(c));
	}

	/**
	 * Methode toString d'un Annuaire.
	 */
	public String toString() {
		String chaine = "Annuaire :\n==========\n";
		for (Contact contact : contacts) {
			chaine += contacts.indexOf(contact) + " : " + contact.toString() + "\n";
		}

		return chaine;
	}
}
