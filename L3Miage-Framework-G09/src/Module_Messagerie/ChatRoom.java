package Module_Messagerie;

import java.rmi.Remote;
import java.util.List;

import Structure_Contact.Contact;


public interface ChatRoom extends Remote {
	
	public void envoyerMessage (MessageTexte message);
	
	public List<MessageTexte> getMessages ();
	
	public List<Contact> getcontacts ();
	
	public void ajouterContact (Contact contact);
	
	public void supprimerContact (Contact contact);
	
	

}