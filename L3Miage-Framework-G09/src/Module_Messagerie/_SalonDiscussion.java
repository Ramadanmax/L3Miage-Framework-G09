package Module_Messagerie;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import Structure_Contact.Contact;

/**
 * Interface d'une ChatRoom.
 * 
 * @author matheyt
 *
 */
public interface _SalonDiscussion extends Remote {

	/**
	 * Methode d'envoie d'un Message.
	 * 
	 * @param message
	 *            Le Message a emvoyer.
	 * @throws RemoteException
	 */
	public void envoyerMessage(MessageTexte message) throws RemoteException;

	/**
	 * Getter de la liste de MessageTexte.
	 * 
	 * @return Une liste de MessageTexte.
	 * @throws RemoteException
	 */
	public List<MessageTexte> getMessages() throws RemoteException;

	/**
	 * Getter de la liste de Contact.
	 * 
	 * @return Une liste de Contact.
	 * @throws RemoteException
	 */
	public List<Contact> getcontacts() throws RemoteException;

	/**
	 * Methode d'ajout d'un Contact a la liste de Contact.
	 * 
	 * @param contact
	 *            Le Contact a ajouter.
	 * @throws RemoteException
	 */
	public void ajouterContact(Contact contact) throws RemoteException;

	/**
	 * Methode de suppression d'un Contact dans la liste de Contact.
	 * 
	 * @param contact
	 *            Le Contact a supprimer.
	 * @throws RemoteException
	 */
	public void supprimerContact(Contact contact) throws RemoteException;

}