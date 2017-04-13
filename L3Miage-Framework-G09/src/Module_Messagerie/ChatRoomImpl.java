package Module_Messagerie;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import Module_Outil.Contact;

/**
 * @author matheyt
 * class ChatRoomImpl heritan de UnicastRemoteObject pour l'utilisation avec un RMI
 * elle donne les outils nécéssaire à la gestion d'une chatRoom
 */
public class ChatRoomImpl extends UnicastRemoteObject implements ChatRoom {

	private List<Message> messages;
	private List<Contact> contacts;

	/**
	 * contructeur de la classe
	 * @throws RemoteException
	 * 
	 */
	protected ChatRoomImpl() throws RemoteException {
		super();
		messages = new ArrayList<Message>();
		contacts = new ArrayList<Contact>();
	}

	/**
	 * fonction permettant d'enregistrer un message dans la liste de message existant
	 * @param un message de Type Message 
	 */
	@Override
	public void envoyerMessage(Message message) {
		messages.add(message);

	}

	/**
	 * fonction renvoyant la liste de tous les messages enregisté dans l'attribu message de la classe
	 */
	@Override
	public List<Message> getMessages() {
		return messages;
	}

	/**
	 * fonction renvoyant la liste de tous les contacts enregisté dans l'attribu contacts de la classe
	 * représentant toutes les personne participant à la chat room
	 */
	@Override
	public List<Contact> getcontacts() {
		return contacts;
	}

	/**
	 * fonction ajoutant une perssone dans l'attribut contacts
	 */
	@Override
	public void ajouterContact(Contact contact) {
		contacts.add(contact);
	}

	/**
	 * fonction retirant un contact de la liste des contacts de l'attribut contacts
	 */
	@Override
	public void supprimerContact(Contact contact) {
		contacts.remove(contact);

	}

	/**
	 * renvoie un contact spécifique se trouvant dans l'attributs contacts
	 */
	@Override
	public Contact getcontact(Contact contact) {
		return contacts.get(contacts.indexOf(contact));
	}

}
