package Module_Messagerie;

import java.io.Serializable;

import Structure_Contact.Contact;

/**
 * Classe abstraite Message.
 * 
 * @author matheyt
 */
public abstract class $Message implements Serializable {

	private static final long serialVersionUID = 1L;
	protected String date;
	protected Contact expediteur;
	protected Contact destinataire;

	/**
	 * renvoi la date à laquelle le messge a était envoyé
	 * 
	 * @return date La date du Message courant.
	 */
	public String getDate() {
		return this.date;
	}

	/**
	 * renvoi l'objet Contact correspondant à l'expediteur
	 * 
	 * @return expediteur L'expediteur du Message courant.
	 */
	public Contact getExpediteur() {
		return this.expediteur;
	}

	/**
	 * renvoi l'objet Contact correspondant au destinataire
	 * 
	 * @return destinataire Le destinataire du Message courant.
	 * */
	public Contact getDestinataire() {
		return this.destinataire;
	}

	/**
	 * fonction modifiant l'expediteur du message
	 * 
	 * @param contact Le nouvel expediteur. 
	 */
	public void setExpediteur(Contact contact) {
		this.expediteur = contact;
	}

	/**
	 * fonction modifiant le destinataire du message
	 * 
	 * @param contact Le nouveau destinataire.
	 */
	public void setDestinataire(Contact contact) {
		this.destinataire = contact;
	}
	/**
	 * fonction modifiant la Date du message
	 * @param dt La nouvelle date
	 */
	public void setDate(String dt)
	{
		this.date=dt;
	}

}
