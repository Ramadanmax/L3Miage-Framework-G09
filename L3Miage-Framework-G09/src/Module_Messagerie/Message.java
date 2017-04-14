package Module_Messagerie;

import java.util.Date;

import Structure_Contact.Contact;

public abstract class Message {
	
	protected Date date;
	protected Contact expediteur;
	protected Contact destinataire;

	/**
	 * renvoi la date à laquelle le messge a était envoyé
	 * 
	 * @return date
	 */
	public Date getDate() {
		return this.date;
	}

	/**
	 * renvoi l'objet Contact correspondant à l'expediteur
	 * 
	 * @return expediteur
	 */
	public Contact getExpediteur() {
		return this.expediteur;
	}

	/**
	 * renvoi l'objet Contact correspondant au destinataire
	 * 
	 * @return destinataire
	 */
	public Contact getDestinataire() {
		return this.destinataire;
	}

	/**
	 * fonction modifiant l'expediteur du message
	 * 
	 * @param contact
	 */
	public void setExpediteur(Contact contact) {
		this.expediteur = contact;
	}

	/**
	 * fonction modifiant le destinataire du message
	 * 
	 * @param contact
	 */
	public void setDestinataire(Contact contact) {
		this.destinataire = contact;
	}

}
