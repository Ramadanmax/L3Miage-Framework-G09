package Module_Messagerie;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import Structure_Contact.Contact;

/**
 * @author matheyt
 * 
 *         class ChatRoomImpl heritan de UnicastRemoteObject pour l'utilisation
 *         avec un RMI elle donne les outils nécéssaire à la gestion d'une
 *         chatRoom
 */
public class SalonDiscussion extends UnicastRemoteObject implements _SalonDiscussion {

	private static final long serialVersionUID = 1L;
	private String nomSalonDiscussion;
	private List<MessageTexte> messages;
	private List<Contact> contacts;

	/**
	 * Constructeur d'une ChatRoomImpl.
	 * 
	 * @param nom
	 *            Le nom de la ChatRoomImpl.
	 * @throws RemoteException
	 */
	public SalonDiscussion(String nom) throws RemoteException {
		super();
		this.nomSalonDiscussion = nom;
		this.messages = new ArrayList<MessageTexte>();
		this.contacts = new ArrayList<Contact>();

	}

	/**
	 * fonction permettant d'enregistrer un message dans la liste de message
	 * existant
	 * 
	 * @param message
	 *            Le message a envoyer.
	 */
	@Override
	public void envoyerMessage(MessageTexte message) throws RemoteException {
		messages.add(message);

	}

	/**
	 * fonction renvoyant la liste de tous les messages enregisté dans l'attribu
	 * message de la classe
	 * 
	 * @return messages La liste messages.
	 */
	@Override
	public List<MessageTexte> getMessages() throws RemoteException {
		return messages;
	}

	/**
	 * fonction renvoyant la liste de tous les contacts enregisté dans l'attribu
	 * contacts de la classe représentant toutes les personne participant à la
	 * chat room
	 * 
	 * @return contacts La liste contacts.
	 */
	@Override
	public List<Contact> getcontacts() throws RemoteException {
		return contacts;
	}

	/**
	 * renvoi le nom de la chatRoom
	 * 
	 * @return nomChatRoom Le nom de la ChatRoom
	 */
	public String getNomSalonDiscussion() throws RemoteException {
		return this.nomSalonDiscussion;
	}

	/**
	 * fonction ajoutant une perssone dans l'attribut contacts
	 * 
	 * @param contact
	 *            Le Contact a ajouter.
	 */
	@Override
	public void ajouterContact(Contact contact) throws RemoteException {
		contacts.add(contact);
	}

	/**
	 * fonction retirant un contact de la liste des contacts de l'attribut
	 * contacts
	 * 
	 * @param contact
	 *            Le Contact a supprimer.
	 */
	@Override
	public void supprimerContact(Contact contact) throws RemoteException {
		contacts.remove(contact);
	}

	/*
	 * public void save() { try { DataOutputStream dos = new DataOutputStream(
	 * new BufferedOutputStream(new FileOutputStream(this.getNomChatRoom())));
	 * 
	 * StringBuffer strBuff = new StringBuffer();
	 * strBuff.append(this.AfficherContacts()); strBuff.append("Messages : \n");
	 * strBuff.append(this.AfficherMessages());
	 * 
	 * dos.writeChars(strBuff.toString()); dos.close();
	 * 
	 * } catch (FileNotFoundException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } catch (IOException e) { // TODO Auto-generated
	 * catch block e.printStackTrace(); } }
	 * 
	 * public void load() { BufferedReader br; try { br = new BufferedReader(new
	 * FileReader(new File(this.getNomChatRoom())));
	 * 
	 * String line; StringBuffer ln; while (((line = br.readLine()) != null)) {
	 * if (line.startsWith(" Messages")){System.out.println(
	 * "Hellllllllllllloooooooooooooooooooooooooo");} ln = new
	 * StringBuffer(line); System.out.println(ln); }
	 * 
	 * while ( (line = br.readLine()) != null) { ln = new StringBuffer(line);
	 * 
	 * } br.close(); } catch (FileNotFoundException e) { // TODO Auto-generated
	 * catch block e.printStackTrace(); } catch (IOException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } }
	 * 
	 * /** fonction renvoyant un String contenant les messages dans un format
	 * simpliste
	 * 
	 * @return les Messges de la chat Room
	 */
	/*
	 * public String AfficherMessages() { String chaine = ""; for (int i = 0; i
	 * < this.getMessages().size(); i++) { chaine +=
	 * this.getMessages().get(i).toString() + "\n" +
	 * "######################################################\n";
	 * 
	 * } return chaine; }
	 * 
	 * /** fonction renvoyant un String contenant les contacts de la chat Room
	 * 
	 * @return les contacts de la chat Room
	 */
	/*
	 * public String AfficherContacts() { String chaine = ""; for (int i = 0; i
	 * < this.getcontacts().size(); i++) { chaine +=
	 * this.getcontacts().get(i).toString() + "\n"; } return chaine; }
	 */
}
