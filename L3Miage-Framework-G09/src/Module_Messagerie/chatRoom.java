package Module_Messagerie;

import java.rmi.Remote;
import java.util.List;

import module_outil.Contact;


public interface chatRoom extends Remote {
	
	public void envoyerMessage (Message message);
	
	public List<Message> getMessages ();
	
	public List<Contact> getcontacts ();
	
	public void ajouterContact (Contact contact);
	
	public void supprimerContact (Contact contact);
	
	public Contact getcontact (Contact contact);
	

}
