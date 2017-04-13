package Structure_Contact;

import FrameworkExceptions.FrameworkException;

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
	public Adresse(int numRue, String nomRue, String ville, String codePostal, String pays) throws FrameworkException {
		this.numRue = numRue;
		this.nomRue = nomRue;
		this.ville = ville;
		this.pays = pays;

		// Controle de validation du code postal
		if (codePostal.length() != 5) {
			throw new FrameworkException("Code postal \"" + codePostal + "\" invalide.");
		}
		
		this.codePostal = codePostal;
	}
}
