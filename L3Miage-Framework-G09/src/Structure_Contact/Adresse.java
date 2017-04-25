package Structure_Contact;

import java.io.Serializable;

/**
 * Classe Adresse, structure de l'Adresse d'un Contact.
 * 
 * @author virgil
 *
 */
public class Adresse implements Serializable {

	private static final long serialVersionUID = 8176741803008839719L;
	public int numRue;
	public String nomRue;
	public String ville;
	public String codePostal;
	public String pays;

	/**
	 * Constructeur d'une Adresse.
	 * 
	 * @param numRue
	 *            Le numero de rue d'une Adresse.
	 * @param nomRue
	 *            Le nom de rue d'une Adresse.
	 * @param ville
	 *            La ville d'une Adresse.
	 * @param codePostal
	 *            Le code postal de la ville d'une Adresse.
	 * @param pays
	 *            Le pays d'une Adresse.
	 */
	public Adresse(int numRue, String nomRue, String ville, String codePostal, String pays) {
		this.numRue = numRue;
		this.nomRue = nomRue;
		this.ville = ville.toUpperCase();
		this.pays = pays.toUpperCase();
		this.codePostal = codePostal;
	}

	/**
	 * Getter du numero de rue d'une Adresse.
	 * 
	 * @return Le numero de rue de l'Adresse courante.
	 */
	public int getNumRue() {
		return numRue;
	}

	/**
	 * Getter du nom de rue d'une Adresse.
	 * 
	 * @return Le nom de rue de l'Adresse courante.
	 */
	public String getNomRue() {
		return nomRue;
	}

	/**
	 * Getter de la ville d'une Adresse.
	 * 
	 * @return La ville de l'Adresse courante.
	 */
	public String getVille() {
		return ville;
	}

	/**
	 * Getter du code postal de la ville d'une Adresse.
	 * 
	 * @return Le code postal de la ville de l'Adresse courante.
	 */
	public String getCodePostal() {
		return codePostal;
	}

	/**
	 * Getter du pays d'une Adresse.
	 * 
	 * @return Le pays de l'Adresse courante.
	 */
	public String getPays() {
		return pays;
	}

	/**
	 * Setter du numero de rue d'une Adresse.
	 * 
	 * @param numRue
	 *            Le numero de rue d'une Adresse.
	 */
	public void setNumRue(int numRue) {
		this.numRue = numRue;
	}

	/**
	 * Setter du nom de rue d'une Adresse.
	 * 
	 * @param nomRue
	 *            Le nom de rue d'une Adresse.
	 */
	public void setNomRue(String nomRue) {
		this.nomRue = nomRue;
	}

	/**
	 * Setter de la ville d'une Adresse.
	 * 
	 * @param ville
	 *            La ville d'une Adresse.
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

	/**
	 * Setter du code postal d'une Adresse.
	 * 
	 * @param codePostal
	 *            Le code postal de la ville d'une Adresse.
	 */
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	/**
	 * @param pays
	 *            Le pays d'une Adresse.
	 */
	public void setPays(String pays) {
		this.pays = pays;
	}

	/**
	 * Methode toString d'une Adresse.
	 */
	public String toString() {
		return this.numRue + " " + this.nomRue + ", " + this.codePostal + " " + this.ville + ", " + this.pays;
	}
}
