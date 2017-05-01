package Module_Evenement;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

import Structure_Contact.Adresse;
import Structure_Contact.Contact;

/**
 * La classe Event permet aux utilisateurs de ce Framework de créer/supprimer et
 * modifier un Evenement. La modification d'un Evenement consiste en l'ajout ou
 * la suppression de contacts liés à cet Event.
 * 
 * @version 1.0
 * @date 13/04/2017
 * @author Maxime RAMADANOSKI
 * 
 */
public class Evenement {
	/**
	 * Le nom de l'événement. Ce nom peut être amené à changer.
	 * 
	 * @see Evenement#getNom()
	 * @see Evenement#setNom(String)
	 */
	private String nom;

	/**
	 * Le lieu de l'événement. Ce lieu peut être amené à changer.
	 * 
	 * @see Evenement#getLieu()
	 * @see Evenement#setLieu(String)
	 */
	private Adresse lieu;

	/**
	 * La date de l'événement. Son format int de base est le suivant : AAAAMMJJ
	 * Cette date peut être amenée à changer.
	 * 
	 * @see Evenement#getDate()
	 * @see Evenement#setDate(Date)
	 */
	private int date;

	/**
	 * La liste des contacts participants à l'événement. Cette liste est amenée
	 * à changer.
	 * 
	 * @see Evenement#getContacts()
	 * @see Event#setContacts(List<Contact>)
	 */
	private List<Contact> contacts;
	
	public boolean estPasse;

	/**
	 * Le constructeur principal Event établit un événement selon le nom, le
	 * lieu la date et la liste de contacts participants fournis.
	 * 
	 * @param nom
	 * @param lieu
	 * @param date
	 * @param contacts
	 */
	public Evenement(String nom, Adresse lieu, int date, List<Contact> contacts) {
		this.nom = nom;
		this.lieu = lieu;
		this.date = date;
		this.contacts = contacts;
		estPasse = false;
	}

	/**
	 * Le constructeur secondaire Event permet de créer un événement selon son
	 * nom, son lieu et sa date. Il peut être évident qu'un Event crée ne
	 * détienne pas encore de contacts participants.
	 * 
	 * @param nom
	 *            Le nom du nouvel evenement.
	 * @param lieu
	 *            Le lieu du nouvel evenement.
	 * @param i
	 *            La date du nouveau evenement.
	 */
	public Evenement(String nom, Adresse lieu, int date) {
		this.nom = nom;
		this.lieu = lieu;
		this.date = date;
		this.contacts = new ArrayList<Contact>();
	}
	
	public boolean aEuLieu(File eventXML){
		// analyse du document
		DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();

		// récupération de la structure objet du document
		Document document = docBuilder.parse(eventXML);
		
		
		
		for (int i = 0; i < document.getElementsByTagName("evenement").getLength(); i++) {
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date dateEvt = SimpleDateFormat.parse(document.getElementsByTagName("nom").item(i).getTextContent());
			Date maintenant = Date();
			
			if (nom.equals(document.getElementsByTagName("nom").item(i).getTextContent())) {
				if(dateEvt.after(maintenant)){
					estPasse = true;
				}
			}

		}
		return estPasse;
	}
	
	/**
	 * Retourne le nom de l'événement.
	 * 
	 * @return le nom de l'événement.
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Met à jour le nom de l'événement.
	 * 
	 * @param nom
	 *            Le nouveau nom de l'événement.
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Retourne le lieu de l'événement.
	 * 
	 * @return le lieu de l'événement.
	 */
	public Adresse getLieu() {
		return lieu;
	}

	/**
	 * Met à jour le lieu de l'événement.
	 * 
	 * @param lieu
	 *            Le nouveau lieu de l'événement.
	 */
	public void setLieu(Adresse lieu) {
		this.lieu = lieu;
	}

	/**
	 * Retourne la date de l'événement.
	 * 
	 * @return la date de l'événement.
	 */
	public int getDate() {
		return date;
	}

	/**
	 * Met à jour la date de l'événement.
	 * 
	 * @param date
	 *            La nouvelle date de l'événement
	 */
	public void setDate(int date) {
		this.date = date;
	}

	/**
	 * Retourne la liste de contacts participants à l'événement.
	 * 
	 * @return la liste de contacts participants à l'événement.
	 */
	public List<Contact> getContacts() {
		return contacts;
	}

	/**
	 * Met à jour la liste de contacts participants à l'événement.
	 * 
	 * @param contacts
	 *            La nouvelle liste de contacts participant à l'événement
	 */
	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	/**
	 * Ajoute un contact à la liste des contacts participants à l'événement.
	 * 
	 * @param c
	 *            Le nouveau contact à ajouter à l'événement.
	 */
	public void ajouterContact(Contact c) {
		contacts.add(c);
	}

	/**
	 * Supprime un contact de la liste des contacts participants à l'événement.
	 * 
	 * @param c
	 *            Le contact à supprimer de la liste des contacts participants à
	 *            l'événement.
	 * 
	 */
	public void supprimerContact(Contact c) {
		contacts.remove(c);
	}
}
