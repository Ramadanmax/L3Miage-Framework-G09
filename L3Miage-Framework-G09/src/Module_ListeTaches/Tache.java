package Module_ListeTaches;

import java.io.File;
import java.time.LocalDate;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

/**
 * Classe Tache, structure de la Tache d'une Liste de Taches.
 * 
 * @author virgil
 *
 */
public class Tache {

	private String nom;
	private int date;
	private boolean fait;
	
	private boolean estPassee;
	
	public boolean nomValide;
	
	public boolean dateValide;
	
	private int jour,mois,annee;

	/**
	 * Constructeur d'une Tache.
	 * 
	 * @param nom
	 *            Le nom d'une Tache.
	 * @param int
	 *            La date d'une Tache.
	 */
	/*@
	 * requires nom.length()>0;
	 * ensures nom.length()>0;
	 @*/
	public Tache(String nom, int date) {
		this.nom = nom;
		this.date = date;
		this.fait = false;
		estPassee = false;
		nomValide = false;
		dateValide = false;
	}
	
	/**
	 * La méthode aEuLieu, qui prend en paramètre un fichier XML, renvoie True si la tâche à déjà eu lieu, False sinon.
	 * 
	 * @param eventXML
	 *                Le nom du fichier XML contenant l'événement à vérifier
	 * @return estPassee
	 */
	/*@
	 * requires (mois%2 == 0 && mois < 7 && jour < 31 && jour > 0) || (mois%2 == 1 && mois < 7 && jour < 32 && jour > 0) || (mois%2 == 0 && mois > 7 && jour < 32 && jour > 0) ||(mois%2 == 1 && mois > 6 && jour < 31 && jour > 0); 
	 * requires mois < 13 && mois > 0;
	 * requires annee.length() = 4;
	 @*/
	public boolean aEuLieu(File eventXML){
		try{
			int test = getDate();
			LocalDate date = LocalDate.now(); // Date d'aujourd'hui
			annee = test / 10000;
			mois = (test - (test - (test%10000)))/100;
			jour = test - ((test - (test%10000)) + mois*100);
			
			if(date.getDayOfMonth() < jour && date.getMonthValue() < mois && date.getYear() < annee ){
				estPassee = true;
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return estPassee;
	}
	
	/**
	 * La méthode dateEstValidee, qui prend en paramètre un fichier XML, renvoie True si la date est correcte, False sinon.
	 * 
	 * @param eventXML
	 *                Le nom du fichier XML contenant l'événement à vérifier
	 * @return dateValide
	 */
	/*@
	 * requires (mois%2 == 0 && mois < 7 && jour < 31 && jour > 0) || (mois%2 == 1 && mois < 7 && jour < 32 && jour > 0) || (mois%2 == 0 && mois > 7 && jour < 32 && jour > 0) ||(mois%2 == 1 && mois > 6 && jour < 31 && jour > 0); 
	 * requires mois < 13 && mois > 0;
	 * requires annee.length() = 4;
	 @*/
	public boolean dateEstValidee(File eventXML){
		try{
			// analyse du document
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();

			// récupération de la structure objet du document
			Document document = docBuilder.parse(eventXML);
			
			for (int i = 0; i < document.getElementsByTagName("evenement").getLength(); i++) {
				
				int test = Integer.parseInt(document.getElementsByTagName("date").item(i).getTextContent());
				annee = test / 10000;
				mois = (test - (test - (test%10000)))/100;
				jour = test - ((test - (test%10000)) + mois*100);
				
				if (getNom().equals(document.getElementsByTagName("nom").item(i).getTextContent())) {
					if(0 < jour && jour < 32 && 0 < mois && mois < 13 && 999 < annee && annee < 10000){
						dateValide = true;
					}
				}
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return dateValide;
	}
	
	/**
	 * La méthode nomEstValidee, qui prend en paramètre un fichier XML, renvoie True si le nom est correcte, False sinon.
	 * 
	 * @param eventXML
	 *                Le nom du fichier XML contenant l'événement à vérifier
	 * @return nomValide
	 */
	/*@
	 * requires nom.length() < 100; 
	 @*/
	public boolean nomEstValide(File eventXML){
		try{
			// analyse du document
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();

			// récupération de la structure objet du document
			Document document = docBuilder.parse(eventXML);
			
			for (int i = 0; i < document.getElementsByTagName("tache").getLength(); i++) {
				
				if (getNom().equals(document.getElementsByTagName("nom").item(i).getTextContent())) {
					if(nom.length() < 100){
						nomValide = true;
					}
				}
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return nomValide;
	}
	
	/**
	 * Getter du nom d'une Tache.
	 * 
	 * @return Le nom de la Tache courante.
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Getter de la date d'une Tache.
	 * 
	 * @return La date de la Tache courante.
	 */
	public int getDate() {
		return date;
	}

	/**
	 * Getter du booleen fait d'une Tache.
	 * 
	 * @return Le booleen fait de la Tache courante.
	 */
	public boolean getFait() {
		return fait;
	}

	/**
	 * Setter du nom d'une Tache.
	 * 
	 * @param nom
	 *            Le nom d'une Tache.
	 */
	/*@
	 * requires nom.length()>0;
	 * ensures nom.length()>0;
	 @*/
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Setter de la date d'une Tache.
	 * 
	 * @param date
	 *            La date d'une Tache.
	 */

	public void setDate(int date) {
		this.date = date;
	}

	/**
	 * Setter du booleen fait d'une Tache.
	 * 
	 * @param fait
	 *            Le booleen fait d'une Tache.
	 */
	public void setFait(boolean fait) {
		this.fait = fait;
	}

	/**
	 * Methode toString d'une Tache.
	 */
	public String toString() {
		String statut = "A Faire";

		if (this.fait) {
			statut = "Fait";
		}

		return this.nom + ", " + this.date + ", " + statut;
	}
}
