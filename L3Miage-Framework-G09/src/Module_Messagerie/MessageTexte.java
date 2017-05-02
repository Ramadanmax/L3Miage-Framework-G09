package Module_Messagerie;

import java.util.Date;

import Structure_Contact.Contact;

/**
 * Classe représentant un messge dans le systeme, caractérisé par un contenu,
 * une date, une expéditeur et un destinataire
 * 
 * @author matheyt
 */
public class MessageTexte extends $Message {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String contenu;

	/**
	 * Constructeur de la classe
	 * 
	 * @param exp
	 *            L'expediteur du Message courant.
	 * @param dest
	 *            Le destinataire du Message courant.
	 * @param msg
	 *            Le contenu du Message courant.
	 */
	public MessageTexte(Contact exp, Contact dest, String msg) {
		this.contenu = msg;
		this.destinataire = dest;
		this.expediteur = exp;
		this.date= new Date().toString();
	}

	/**
	 * fonction renvoyant le contenu du message
	 * 
	 * @return Contenu Le contenu du Message courant.
	 */
	public String getcontenu() {
		return this.contenu;
	}

	/**
	 * fonction modifiant le contenu du message
	 * 
	 * @param contenu
	 *            Le nouveau contenu du Message courant.
	 */
	public void setContenue(String contenu) {
		this.contenu = contenu;
	}

	/**
	 * revoi une string de message sous un format simple expediteur : XXXX
	 * destinataire : XXXX Date : XXXX XXXXX
	 */
	public String toString() {
		return "expediteur : " + this.getExpediteur().getNom() + "\n" + "destinateur : "
				+ this.getDestinataire().getNom() + "\n" + "A :"
				+ /* new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format( */this.getDate()/* ) */ + "\n"
				+ this.getcontenu()+"\n";
	}
}
