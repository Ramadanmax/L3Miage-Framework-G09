package Module_Evenement;

import java.io.File;
import java.time.LocalDate;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
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
	 * Description de l'événement
	 * 
	 * @see Evenement#getDescription()
	 * @see Evenement#setDescription(Date)
	 */
	private String description;

	/**
	 * Le créateur de l'événement
	 * 
	 * @see Evenement#getCreateur()
	 * @see Event#setCreateur(String)
	 */
	private String createur;
	
	public boolean estPassee;
	
	public boolean dateValide;
	
	public boolean nomValide;
	
	public boolean lieuValide;
	
	private int jour,mois,annee;
	/**
	 * Le constructeur principal Event établit un événement selon le nom, le
	 * lieu la date, la description et le createur.
	 * 
	 * @param nom
	 * @param lieu
	 * @param date
	 * @param createur
	 * @param description
	 */
	public Evenement(String nom, String lieu, int date,String description, String createur) {
		this.nom = nom;
		this.lieu = lieu;
		this.date = date;
		this.description = description;
		this.createur = createur;
		estPassee = false;
		dateValide = false;
		nomValide = false;
		lieuValide = false;
	}

	/**
	 * Le constructeur secondaire Event permet de créer un événement selon son
	 * nom, son lieu, sa date et sa description.
	 * 
	 * @param nom
	 *            Le nom du nouvel evenement.
	 * @param lieu
	 *            Le lieu du nouvel evenement.
	 * @param i
	 *            La date du nouveau evenement.
	 * @param description
	 *            La description du nouveau evenement.
	 */
	public Evenement(String nom, String lieu, int date, String description) {
		this.nom = nom;
		this.lieu = lieu;
		this.date = date;
		this.description = description;
		this.createur = "";
		estPassee = false;
		dateValide = false;
		nomValide = false;
		lieuValide = false;
	}
	
	/**
	 * La méthode aEuLieu, qui prend en paramètre un fichier XML, renvoie True si l'événement à déjà eu lieu, False sinon.
	 * 
	 * @param eventXML
	 * @return estPassee
	 */
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
	
	/**
	 * La méthode dateEstValidee, qui prend en paramètre un fichier XML, renvoie True si la date est correcte, False sinon.
	 * 
	 * @param eventXML
	 * @return dateValide
	 */
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
	 * @return nomValide
	 */
	public boolean nomEstValide(File eventXML){
		try{
			// analyse du document
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();

			// récupération de la structure objet du document
			Document document = docBuilder.parse(eventXML);
			
			for (int i = 0; i < document.getElementsByTagName("evenement").getLength(); i++) {
				
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
	 * La méthode lieuEstValidee, qui prend en paramètre un fichier XML, renvoie True si le lieu est correcte, False sinon.
	 * 
	 * @param eventXML
	 * @return nomValide
	 */
	public boolean lieuEstValide(File eventXML){
		try{
			// analyse du document
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();

			// récupération de la structure objet du document
			Document document = docBuilder.parse(eventXML);
			
			for (int i = 0; i < document.getElementsByTagName("evenement").getLength(); i++) {
				
				if (getNom().equals(document.getElementsByTagName("nom").item(i).getTextContent())) {
					if(lieu.length() < 100){
						lieuValide = true;
					}
				}
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return lieuValide;
	}
	
	public void creationEvt(Evenement evt, File eventXML){

		 try {
		    DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		    DocumentBuilder builder = factory.newDocumentBuilder();
		    // creating input stream
		    Document doc = builder.parse(eventXML);
		    
		    //
		    //New Node evenement       
		    Node evenement = doc.createElement("evenement");        
		    Node result = doc.getElementsByTagName("evenements").item(0).appendChild(evenement);
		    //
		    //
		    //New Node nom       
		    Node nom = doc.createElement("nom");        
		    result.appendChild(nom);
		    nom.setTextContent(evt.getNom());
		    
		    //
		    //New Node lieu       
		    Node lieu = doc.createElement("lieu");        
		    result.appendChild(lieu);
		    lieu.setTextContent(evt.getLieu());
		    
		    //
		    //New Node date       
		    Node date = doc.createElement("date");        
		    result.appendChild(date);
		    date.setTextContent(evt.getDate() + "");
		    
		    //
		    //New Node description       
		    Node description = doc.createElement("description");        
		    result.appendChild(description);
		    description.setTextContent(evt.getDescription());
		    
		    //
		    //New Node createur       
		    Node createur = doc.createElement("createur");        
		    result.appendChild(createur);
		    createur.setTextContent(evt.createur);
		    
		    //
		    //New Node contributions       
		    Node contributions = doc.createElement("contributions");        
		    Node contrib = result.appendChild(contributions);
		    
		    //
		    //New Node contributions_bien       
		    Node contributions_bien = doc.createElement("contributions_bien");        
		    Node contribb = contrib.appendChild(contributions_bien);
		    
		    //
		    //New Node id_cbien       
		    Node id_cbien = doc.createElement("id_cbien");        
		    contribb.appendChild(id_cbien);
		    id_cbien.setTextContent("");
		    
		    //
		    //New Node id_contact       
		    Node id_contact = doc.createElement("id_contact");        
		    contribb.appendChild(id_contact);
		    id_contact.setTextContent("");
		    
		    //
		    //New Node nom_cbien       
		    Node nom_cbien = doc.createElement("nom_cbien");        
		    contribb.appendChild(nom_cbien);
		    nom_cbien.setTextContent("");
		    
		    //
		    //New Node unite       
		    Node unite = doc.createElement("unite");        
		    contribb.appendChild(unite);
		    unite.setTextContent("");
		    
		    //
		    //New Node valeur_cbien       
		    Node valeur_cbien = doc.createElement("valeur_cbien");        
		    contribb.appendChild(valeur_cbien);
		    valeur_cbien.setTextContent("");
		    
		    //
		    //New Node description_cbien       
		    Node description_cbien = doc.createElement("description_cbien");        
		    contribb.appendChild(description_cbien);
		    description_cbien.setTextContent("");

		    //
		    //New Node contribution_service       
		    Node contribution_service = doc.createElement("contribution_service");        
		    Node contribs = contrib.appendChild(contribution_service);
		    
		    //
		    //New Node id_cserv       
		    Node id_cserv = doc.createElement("id_cserv");        
		    contribs.appendChild(id_cserv);
		    id_cserv.setTextContent("");
		    
		    //
		    //New Node id_contact       
		    Node id_contacts = doc.createElement("id_contact");        
		    contribs.appendChild(id_contacts);
		    id_contacts.setTextContent("");
		    
		    //
		    //New Node nom_cserv       
		    Node nom_cserv = doc.createElement("nom_cserv");        
		    contribs.appendChild(nom_cserv);
		    nom_cserv.setTextContent("");
		    
		    //
		    //New Node valeur_cserv       
		    Node valeur_cserv = doc.createElement("valeur_cserv");        
		    contribs.appendChild(valeur_cserv);
		    valeur_cserv.setTextContent("");
		    
		    //
		    //New Node description_cserv       
		    Node description_cserv = doc.createElement("description_cserv");        
		    contribs.appendChild(description_cserv);
		    description_cserv.setTextContent("");
	      
		    // writing xml file
		    TransformerFactory transformerFactory = TransformerFactory.newInstance();
		    Transformer transformer = transformerFactory.newTransformer();
		    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		    transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		    transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
		    DOMSource source = new DOMSource(doc);
		     File outputFile = eventXML;
		    StreamResult resulta = new StreamResult(outputFile);
		    // creating output stream
		    transformer.transform(source, resulta);
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
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
	 * Retourne la descritpion de l'événement.
	 * 
	 * @return description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Met à jour la description de l'événement.
	 * 
	 * @param description
	 *            La nouvelle description de l'événement
	 */
	public void setDate(String description) {
		this.description = description;
	}
	
	/**
	 * Retourne la liste de createur participants à l'événement.
	 * 
	 * @return la liste de createur participants à l'événement.
	 */
	public String getCreateur() {
		return createur;
	}

	/**
	 * Met à jour la liste de createur participants à l'événement.
	 * 
	 * @param createur
	 *            La nouvelle liste de createur participant à l'événement
	 */
	public void setCreateur(String createur) {
		this.createur = createur;
	}
}
