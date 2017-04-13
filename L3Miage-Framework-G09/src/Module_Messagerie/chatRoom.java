package Module_Messagerie;

import java.rmi.Remote;
import java.util.List;

import javax.xml.ws.handler.MessageContext;

import Module_Annuaire.Contact;

public interface chatRoom extends Remote {
	
	public void envoyerMessage (Message message);
	
	public List<Message> getMessages ();
	
	public List<Contact> getcontacts ();
	
	public void ajouterContact (Contact contatc);
	

}
