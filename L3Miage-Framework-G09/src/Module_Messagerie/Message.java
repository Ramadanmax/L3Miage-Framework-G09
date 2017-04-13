package Module_Messagerie;

import java.text.SimpleDateFormat;
import Module_Outil.Contact;

public class Message {

	private String contenu;
	private SimpleDateFormat date;
	private Contact expediteur;
	private Contact destinataire;

	public Message(Contact exp, Contact dest, String msg) {
		this.contenu = msg;
		this.destinataire = dest;
		this.expediteur = exp;
		this.date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	}

	public String getcontenu(){
		return this.contenu;
	}
	
	public SimpleDateFormat getDate(){
		return this.date;
	}
	
	public Contact getExpediteur(){
		return this.expediteur;
	}
	
	public Contact getDestinataire(){
		return this.destinataire;
	}
	
	public void setExpediteur(Contact contact){
		this.expediteur = contact;
	}
	
	public void setDestinataire(Contact contact){
		this.destinataire = contact;
	}
	
	public void setContenue(String contenu){
		this.contenu = contenu;
	}
}
