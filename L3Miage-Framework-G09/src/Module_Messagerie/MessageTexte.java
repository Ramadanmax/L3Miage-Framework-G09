package Module_Messagerie;

import java.text.SimpleDateFormat;
import java.util.Date;

import Structure_Contact.Contact;

/**
 * @author matheyt
 * Classe représentant un messge dans le systeme, caractérisé par un contenu, une date, une expéditeur et un destinataire
 */
public class MessageTexte extends Message {

	private String contenu;

	/**
	 * Constructeur de la classe
	 * @param exp 
	 * @param dest
	 * @param msg
	 */
	public MessageTexte(Contact exp, Contact dest, String msg) {
		this.contenu = msg;
		this.destinataire = dest;
		this.expediteur = exp;
		this.date = new Date();
	}

	/**
	 * fonction renvoyant le contenu du message
	 * @return Contenu
	 */
	public String getcontenu(){
		return this.contenu;
	}

	/**
	 * fonction modifiant le contenu du message
	 * @param contenu
	 */
	public void setContenue(String contenu){
		this.contenu = contenu;
	}
	
	/**
	 * revoi une string de message sous un format simple
	 * expediteur : XXXX
	 * destinataire : XXXX
	 * Date : XXXX
	 * XXXXX
	 * 
	 */
	public String toString()
	{
		return "expediteur : "+this.getExpediteur().getNom()+"\n"
			+ "destinateur : "+this.getDestinataire().getNom()+"\n"
			+ " A :"+/*new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(*/this.getDate()/*)*/+"\n"
			+ this.getcontenu();
	}
}
