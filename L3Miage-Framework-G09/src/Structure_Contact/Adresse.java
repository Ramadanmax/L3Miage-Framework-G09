package Structure_Contact;

import FrameworkExceptions.FrameworkException;

/**
 * Classe Adresse, structure de l'Adresse d'un Contact.
 * 
 * @author virgil
 *
 */
public class Adresse {

	public int numRue;
	public String nomRue;
	public String ville;
	public String codePostal;
	public String pays;

	/**
	 * Constructeur d'une Adresse.
	 * 
	 * @param numRue
	 * @param nomRue
	 * @param ville
	 * @param codePostal
	 * @param pays
	 */
	public Adresse(int numRue, String nomRue, String ville, String codePostal, String pays) {
		this.numRue = numRue;
		this.nomRue = nomRue;
		this.ville = ville.toUpperCase();
		this.pays = pays.toUpperCase();
		this.codePostal = codePostal;
	}

	/**
	 * Methode toString d'une Adresse.
	 */
	public String toString() {
		return this.numRue + " " + this.nomRue + ", " + this.codePostal + " " + this.ville + ", " + this.pays;
	}
}
