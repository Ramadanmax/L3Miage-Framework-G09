package Module_ListeTaches;

import java.io.File;
import java.time.LocalDate;
import java.util.Date;

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
	private Date date;
	private boolean fait;
	
	private boolean dateValide;
	
	public boolean nomValide;
	
	public boolean lieuValide;

	/**
	 * Constructeur d'une Tache.
	 * 
	 * @param nom
	 *            Le nom d'une Tache.
	 * @param date
	 *            La date d'une Tache.
	 */
	/*@
	 * requires nom.length()>0;
	 * ensures nom.length()>0;
	 @*/
	public Tache(String nom, Date date) {
		this.nom = nom;
		this.date = date;
		this.fait = false;
		dateValide = false;
		nomValide = false;
	}

	public boolean aEuLieu(File eventXML){
		try{
			// analyse du document
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();

			// récupération de la structure objet du document
			Document document = docBuilder.parse(eventXML);
			
			
			
			for (int i = 0; i < document.getElementsByTagName("evenement").getLength(); i++) {
				
				int test = Integer.parseInt(document.getElementsByTagName("date").item(i).getTextContent());
				LocalDate date = LocalDate.now(); // Date d'aujourd'hui
				annee = test / 10000;
				mois = (test - (test - (test%10000)))/100;
				jour = test - ((test - (test%10000)) + mois*100);
				
				if (nom.equals(document.getElementsByTagName("nom").item(i).getTextContent())) {
					if(date.getDayOfMonth() < jour && date.getMonthValue() < mois && date.getYear() < annee ){
						estPassee = true;
					}
				}
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return estPassee;
	}
	
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
	public Date getDate() {
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

	public void setDate(Date date) {
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
