package Module_Messagerie;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import Module_Annuaire.Annuaire;
import Structure_Contact.Adresse;
import Structure_Contact.Contact;

/**
 * @author matheyt
 * 
 *         class ChatRoomImpl heritan de UnicastRemoteObject pour l'utilisation
 *         avec un RMI elle donne les outils nÃ©cÃ©ssaire Ã  la gestion d'une
 *         chatRoom
 */
public class SalonDiscussion extends UnicastRemoteObject implements _SalonDiscussion {

	private static final long serialVersionUID = 1L;
	private String nomSalonDiscussion;
	private String xmlFile;
	private List<MessageTexte> messages;
	private Annuaire contacts;

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
		this.contacts = new Annuaire();
		this.xmlFile=this.nomSalonDiscussion+".xml";

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
	 * fonction renvoyant la liste de tous les messages enregistÃ© dans
	 * l'attribu message de la classe
	 * 
	 * @return messages La liste messages.
	 */
	@Override
	public List<MessageTexte> getMessages() throws RemoteException {
		return messages;
	}

	/**
	 * fonction renvoyant la liste de tous les contacts enregistÃ© dans
	 * l'attribu contacts de la classe reprÃ©sentant toutes les personne
	 * participant Ã  la chat room
	 * 
	 * @return contacts La liste contacts.
	 */
	@Override
	public List<Contact> getcontacts() throws RemoteException {
		return this.contacts.getContacts();
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
		contacts.ajouterContact(contact);
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
		contacts.supprimerContact(contact);
	}

	public void setAnnuaire(Annuaire ann)
	{
		this.contacts=ann;
	}
	
	/**
	 * fonction sauvegardant l'etat de l'object dans un Xml portant sont nom
	 */
	public void save() {

		try {

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder p = dbFactory.newDocumentBuilder();
			Document doc = p.newDocument();

			Element Salon = (Element) doc.createElement("Salon");
			
			Element contacts = (Element) doc.createElement("contacts");

			for (int i = 0; i < this.getcontacts().size(); i++) {
				Contact contactCourant = this.getcontacts().get(i);

				Element contact = (Element) doc.createElement("contact");
				Element nom = (Element) doc.createElement("nom");
				Element mail = (Element) doc.createElement("mail");
				Element adresse = (Element) doc.createElement("adresse");
				Element numRue = (Element) doc.createElement("numRue");
				Element nomRue = (Element) doc.createElement("nomRue");
				Element CP = (Element) doc.createElement("CP");
				Element Ville = (Element) doc.createElement("ville");
				Element pays = (Element) doc.createElement("pays");
				Element login = (Element) doc.createElement("login");

				nom.setTextContent(contactCourant.getNom());
				mail.setTextContent(contactCourant.getMail());

				numRue.setTextContent(""+contactCourant.getAdresse().getNumRue());
				nomRue.setTextContent(contactCourant.getAdresse().getNomRue());
				CP.setTextContent(contactCourant.getAdresse().getCodePostal());
				Ville.setTextContent(contactCourant.getAdresse().getVille());
				pays.setTextContent(contactCourant.getAdresse().getPays());
				
				login.setTextContent(contactCourant.getLogin());

				adresse.appendChild(numRue);
				adresse.appendChild(nomRue);
				adresse.appendChild(Ville);
				adresse.appendChild(CP);
				adresse.appendChild(pays);

				contact.appendChild(nom);
				contact.appendChild(adresse);
				contact.appendChild(mail);
				contact.appendChild(login);

				contacts.appendChild(contact);
			}

			Element messages = (Element) doc.createElement("messages");

			for (int ind = 0; ind < this.messages.size(); ind++) {
				MessageTexte messageCourant = this.messages.get(ind);

				Element message = (Element) doc.createElement("message");
				Element expediteur = (Element) doc.createElement("expediteur");
				Element destinataire = (Element) doc.createElement("destinataire");
				Element contenu = (Element) doc.createElement("contenu");
				Element date = (Element) doc.createElement("date");

				expediteur.setTextContent(messageCourant.getExpediteur().getNom());
				destinataire.setTextContent(messageCourant.getDestinataire().getNom());
				date.setTextContent(messageCourant.getDate().toString());
				contenu.setTextContent(messageCourant.getcontenu());

				message.appendChild(expediteur);
				message.appendChild(destinataire);
				message.appendChild(date);
				message.appendChild(contenu);

				messages.appendChild(message);
			}

			
			Salon.appendChild(contacts);
			Salon.appendChild(messages);
			
			doc.appendChild(Salon);

			final TransformerFactory transformerFactory = TransformerFactory.newInstance();
			final Transformer transformer = transformerFactory.newTransformer();
			final DOMSource source = new DOMSource(doc);
			final StreamResult sortie = new StreamResult(this.xmlFile);

			transformer.setOutputProperty(OutputKeys.VERSION, "1.0");
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");

			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

			transformer.transform(source, sortie);

		} catch (ParserConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * fonction r�cup�rant les donn�es enregistrer dans un Xml du nom de ce Salon
	 */
	public void load() {

		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder p = dbFactory.newDocumentBuilder();
			Document doc = p.parse(xmlFile);
			
			for (int i = 0; i < doc.getElementsByTagName("contact").getLength(); i++) {
				NodeList elCourant = doc.getElementsByTagName("contact").item(i).getChildNodes();
				
				String nom = elCourant.item(1).getTextContent();
				NodeList nodeAdr = elCourant.item(3).getChildNodes();
				String email = elCourant.item(5).getTextContent();
				Adresse adr = new Adresse(Integer.parseInt(nodeAdr.item(1).getTextContent()), nodeAdr.item(3).getTextContent(),nodeAdr.item(5).getTextContent(), nodeAdr.item(7).getTextContent(),nodeAdr.item(9).getTextContent());
				String login = elCourant.item(7).getTextContent();
				contacts.ajouterContact(new Contact(nom, adr, email,login));

			}

			for (int i = 0; i < doc.getElementsByTagName("message").getLength(); i++) {
				NodeList elCourant = doc.getElementsByTagName("message").item(i).getChildNodes();

				Contact expediteur = null;
				Contact destinataire = null;

				for (int ind = 0; ind < this.getcontacts().size(); ind++) {
					if (this.getcontacts().get(ind).getNom() == elCourant.item(1).getTextContent()) {
						expediteur = this.getcontacts().get(ind);
					} else {
						expediteur = new Contact(elCourant.item(1).getTextContent(), null, "inconnu@incnnu.com", "inconnu");
					}

					if (this.getcontacts().get(ind).getNom() == elCourant.item(3).getTextContent()) {
						destinataire = this.getcontacts().get(ind);
					} else {
						destinataire = new Contact(elCourant.item(3).getTextContent(), null, "inconnu@incnnu.com", "inconnu");
					}
				}

				//Date date = new Date elCourant.item(5).getTextContent();
				String contenu = elCourant.item(7).getTextContent();

				MessageTexte msg = new MessageTexte(expediteur, destinataire, contenu);
				msg.setDate(elCourant.item(5).getTextContent());
				messages.add(msg);
			}

		} catch (SAXException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * fonction renvoyant un String contenant les messages dans un format
	 * simpliste
	 * 
	 * @return les Messges de la chat Room
	 * @throws RemoteException
	 * 
	 **/
	public String AfficherMessages() throws RemoteException {
		String chaine = "";
		for (int i = 0; i < this.getMessages().size(); i++) {
			chaine += this.getMessages().get(i).toString() + "\n"
					+ "######################################################\n";
		}
		return chaine;
	}

	/**
	 * fonction renvoyant un String contenant les contacts de la chat Room
	 * 
	 * @return les contacts de la chat Room
	 * @throws RemoteException
	 */

	public String AfficherContacts() throws RemoteException {
		String chaine = "";
		for (int i = 0; i < this.getcontacts().size(); i++) {
			chaine += this.getcontacts().get(i).toString() + "\n";
		}
		return chaine;
	}

}
