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

import Structure_createur.String;
import Structure_createur.createur;

/**
 * La classe Event permet aux utilisateurs de ce Framework de créer/supprimer et
 * modifier un Evenement. La modification d'un Evenement consiste en l'ajout ou
 * la suppression de createur liés à cet Event.
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
	private String lieu;

	/**
	 * La date de l'événement. Son format int de base est le suivant : AAAAMMJJ
	 * Cette date peut être amenée à changer.
	 * 
	 * @see Evenement#getDate()
	 * @see Evenement#setDate(Date)
	 */
	private int date;

	/**
	 * La liste des createur participants à l'événement. Cette liste est amenée
	 * à changer.
	 * 
	 * @see Evenement#getcreateur()
	 * @see Event#setcreateur(String)
	 */
	private String createur;
	
	public boolean estPasse;

	/**
	 * Le constructeur principal Event établit un événement selon le nom, le
	 * lieu la date et la liste de createur participants fournis.
	 * 
	 * @param nom
	 * @param lieu
	 * @param date
	 * @param createur
	 */
	public Evenement(String nom, String lieu, int date, String createur) {
		this.nom = nom;
		this.lieu = lieu;
		this.date = date;
		this.createur = createur;
		estPasse = false;
	}

	/**
	 * Le constructeur secondaire Event permet de créer un événement selon son
	 * nom, son lieu et sa date. Il peut être évident qu'un Event crée ne
	 * détienne pas encore de createur participants.
	 * 
	 * @param nom
	 *            Le nom du nouvel evenement.
	 * @param lieu
	 *            Le lieu du nouvel evenement.
	 * @param i
	 *            La date du nouveau evenement.
	 */
	public Evenement(String nom, String lieu, int date) {
		this.nom = nom;
		this.lieu = lieu;
		this.date = date;
		this.createur = "";
	}
	
	public boolean aEuLieu(File eventXML){
		// analyse du document
		DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();

		// récupération de la structure objet du document
		Document document = docBuilder.parse(eventXML);
		
		
		
		for (int i = 0; i < document.getElementsByTagName("evenement").getLength(); i++) {
			
			int test = Integer.parseInt(document.getElementsByTagName("date").item(i).getTextContent());
			Date dateEvt = new Date(25,12,1995);

			Date maintenant = new Date();
			
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
	public String getLieu() {
		return lieu;
	}

	/**
	 * Met à jour le lieu de l'événement.
	 * 
	 * @param lieu
	 *            Le nouveau lieu de l'événement.
	 */
	public void setLieu(String lieu) {
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
	 * Retourne la liste de createur participants à l'événement.
	 * 
	 * @return la liste de createur participants à l'événement.
	 */
	public String getcreateur() {
		return createur;
	}

	/**
	 * Met à jour la liste de createur participants à l'événement.
	 * 
	 * @param createur
	 *            La nouvelle liste de createur participant à l'événement
	 */
	public void setcreateur(String createur) {
		this.createur = createur;
	}

	/**
	 * Ajoute un createur à la liste des createur participants à l'événement.
	 * 
	 * @param c
	 *            Le nouveau createur à ajouter à l'événement.
	 */
	public void ajoutercreateur(createur c) {
		createur.add(c);
	}

	/**
	 * Supprime un createur de la liste des createur participants à l'événement.
	 * 
	 * @param c
	 *            Le createur à supprimer de la liste des createur participants à
	 *            l'événement.
	 * 
	 */
	public void supprimercreateur(createur c) {
		createur.remove(c);
	}
}
