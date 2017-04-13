package Module_Messagerie;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import module_outil.Contact;

public class ChatRoomImpl extends UnicastRemoteObject implements chatRoom{
	


	private List<Message> messages;
	private List<Contact> contacts;
	
	
	protected ChatRoomImpl() throws RemoteException {
		super();
		messages = new ArrayList<Message>();
		contacts = new ArrayList<Contact>();
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public void envoyerMessage(Message message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Message> getMessages() {
		return messages;
	}

	@Override
	public List<Contact> getcontacts() {
		return contacts;
	}

	@Override
	public void ajouterContact(Contact contact) {
		contacts.add(contact);
	}

	@Override
	public void supprimerContact(Contact contact) {

		
	}

	@Override
	public Contact getcontact(Contact contact) {
		// TODO Auto-generated method stub
		return null;
	}


}
