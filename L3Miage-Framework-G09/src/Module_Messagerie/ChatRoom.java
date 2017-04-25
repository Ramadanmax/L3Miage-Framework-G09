package Module_Messagerie;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import Structure_Contact.Contact;


public interface ChatRoom extends Remote {
	
	public void envoyerMessage (MessageTexte message) throws RemoteException;
	
	public List<MessageTexte> getMessages () throws RemoteException;
	
	public List<Contact> getcontacts () throws RemoteException;
	
	public void ajouterContact (Contact contact) throws RemoteException;
	
	public void supprimerContact (Contact contact) throws RemoteException;
	


}