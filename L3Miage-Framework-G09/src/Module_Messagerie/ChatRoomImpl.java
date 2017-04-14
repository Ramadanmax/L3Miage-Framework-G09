package Module_Messagerie;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import Structure_Contact.Contact;

/**
 * @author matheyt
 * class ChatRoomImpl heritan de UnicastRemoteObject pour l'utilisation avec un RMI
 * elle donne les outils nécéssaire à la gestion d'une chatRoom
 */
public class ChatRoomImpl /*extends UnicastRemoteObject*/ implements ChatRoom 
{

	/**
	 * 
	 */
//	private static final long serialVersionUID = 1L;
	private List<MessageTexte> messages;
	private List<Contact> contacts;

	/**
	 * contructeur de la classe
	 * @throws RemoteException
	 * 
	 */
	public ChatRoomImpl() throws RemoteException {
		super();
		messages = new ArrayList<MessageTexte>();
		contacts = new ArrayList<Contact>();
	}

	/**
	 * fonction permettant d'enregistrer un message dans la liste de message existant
	 * @param un message de Type Message 
	 */
	@Override
	public void envoyerMessage(MessageTexte message) {
		messages.add(message);

	}

	/**
	 * fonction renvoyant la liste de tous les messages enregisté dans l'attribu message de la classe
	 */
	@Override
	public List<MessageTexte> getMessages() {
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
	 * fonction renvoyant un String contenant les messages dans un format simpliste
	 * 
	 * @return les Messges de la chat Room
	 */
	public String AfficherMessages() {
		String chaine ="";
		for (int i =0; i< this.getMessages().size(); i++)
		{
			chaine += this.getMessages().get(i).toString()+"\n"
					+ "######################################################\n";
					
		}
		return chaine;
	}
	
	/** 
	 * fonction renvoyant un String contenant les contacts de la chat Room
	 * 
	 * @return les contacts de la chat Room
	 */
	public String AfficherContacts()
	{
		String chaine = "";
		for(int i = 0; i< this.getcontacts().size();i++)
		{
			chaine += this.getcontacts().get(i).toString()+"\n"
					+ "######################################################\n";
		}
		return chaine;
	}

}
