package Module_Messagerie;

import java.text.SimpleDateFormat;

import Structure_Contact.Contact;

/**
 * @author matheyt
 * Classe représentant un messge dans le systeme, caractérisé par un contenu, une date, une expéditeur et un destinataire
 */
public class Message {

	private String contenu;
	private SimpleDateFormat date;
	private Contact expediteur;
	private Contact destinataire;

	/**
	 * Constructeur de la classe
	 * @param exp 
	 * @param dest
	 * @param msg
	 */
	public Message(Contact exp, Contact dest, String msg) {
		this.contenu = msg;
		this.destinataire = dest;
		this.expediteur = exp;
		this.date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * fonction renvoyant le contenu du message
	 * @return Contenu
	 */
	public String getcontenu(){
		return this.contenu;
	}
	
	/**
	 * renvoi la date à laquelle le messge a était envoyé
	 * @return date
	 */
	public SimpleDateFormat getDate(){
		return this.date;
	}
	
	/**
	 * renvoi l'objet Contact correspondant à l'expediteur
	 * @return expediteur
	 */
	public Contact getExpediteur(){
		return this.expediteur;
	}
	
	/**
	 * renvoi l'objet Contact correspondant au destinataire
	 * @return destinataire
	 */
	public Contact getDestinataire(){
		return this.destinataire;
	}
	
	/**
	 * fonction modifiant l'expediteur du message
	 * @param contact
	 */
	public void setExpediteur(Contact contact){
		this.expediteur = contact;
	}
	
	/**
	 * fonction modifiant le destinataire du message
	 * @param contact
	 */
	public void setDestinataire(Contact contact){
		this.destinataire = contact;
	}
	
	/**
	 * fonction modifiant le contenu du message
	 * @param contenu
	 */
	public void setContenue(String contenu){
		this.contenu = contenu;
	}
}
