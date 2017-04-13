package Module_Messagerie;

import java.rmi.Remote;
import java.util.List;

import Structure_Contact.Contact;


public interface ChatRoom extends Remote {
	
	public void envoyerMessage (Message message);
	
	public List<Message> getMessages ();
	
	public List<Contact> getcontacts ();
	
	public void ajouterContact (Contact contact);
	
	public void supprimerContact (Contact contact);
	
	

}