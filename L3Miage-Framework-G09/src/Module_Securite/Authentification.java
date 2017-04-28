package Module_Securite;

import java.io.File;
import java.io.Serializable;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import FrameworkExceptions.FrameworkException;

/**
 * La classe Authentification récupère un login, un mot de passe et un fichier
 * XML. Le fichier XML énumère l'ensemble des utilisateurs, suivant un XMLSchema
 * bien définit.
 * 
 * @version 1.0
 * @date 25/04/2017
 * @author Yannick Falco && Maxime Vanbossel
 *
 */
public class Authentification implements Serializable{

	private String identifiant;
	private String motDePasse;
	private File cheminXML;
	private boolean valide;

	/**
	 * Le constructeur Authentification de cette classe réalise une
	 * authentification à partir du login, du mot de passe et du fichier XML
	 * fournit.
	 * 
	 * @param identifiant
	 * @param pwd
	 * @param cheminXML
	 */
	public Authentification(String identifiant, String pwd) {
		valide = false;
		this.identifiant = identifiant;
		this.motDePasse = pwd;
	}
	public Authentification(String identifiant, String pwd, File cheminXML) {
		valide = false;
		this.identifiant = identifiant;
		this.motDePasse = pwd;
		this.cheminXML = cheminXML;
	}

	/**
	 * La méthode reconnaissance vérifie si la combinaison login/Mot de passe
	 * existe dans le fichier XML. Dans le cas où celle-ci existe, la variable
	 * valide, initialisée à false, prend la valeur true. Dans le cas contraire,
	 * cette méthode renvoie une FrameworkException.
	 * 
	 * @return valide
	 * @throws FrameworkException
	 */
	public boolean reconnaissance() throws FrameworkException {
		try {

			// analyse du document
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();

			// récupération de la structure objet du document
			Document document = docBuilder.parse(cheminXML);

			for (int i = 0; i < document.getElementsByTagName("login").getLength(); i++) {
				if (identifiant.equals(document.getElementsByTagName("login").item(i).getTextContent())
						&& motDePasse.equals(document.getElementsByTagName("pwd").item(i).getTextContent())) {
					valide = true;
				}

			}
			if (!valide) {
				throw new FrameworkException("Les identifiants fournis sont invalides.");
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return valide;
	}

	/**
	 * La méthode getIdentifiant retourne le identifiant
	 * 
	 * @return identifiant
	 */
	public String getIdentifiant() {
		return identifiant;
	}

	/**
	 * La méthode setIdentifiant met à jour le identifiant
	 * 
	 * @param identifiant
	 *            identifiant a changer
	 */
	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	/**
	 * La méthode setMotDePasse met à jour le mot de passe
	 * 
	 * @param motDePasse
	 *            the pwd to set
	 */
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	/**
	 * La méthode getCheminXML retourne le fichier XML
	 * 
	 * @return cheminXML
	 */
	public File getCheminXML() {
		return cheminXML;
	}

	/**
	 * La méthode setCheminXML met à jour le fichier XML
	 * 
	 * @param cheminXML
	 *            the xMLName to set
	 */
	public void setCheminXML(File cheminXML) {
		this.cheminXML = cheminXML;
	}
	/**
	 * La méthode getValide retourne l'état de connexion. S'il est vrai, l'utilisateur est connecté, sinon il ne l'est pas.
	 * @return valide
	 */
	public boolean getValide(){
		return valide;
	}
}