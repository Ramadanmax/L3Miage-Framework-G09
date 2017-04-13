package Module_Outil;

import java.util.regex.*;

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
	public Adresse(int numRue, String nomRue, String ville, String codePostal, String pays) {
		this.numRue = numRue;
		this.nomRue = nomRue;
		this.ville = ville;
		
		// Controle de validation du code postal
		Pattern pattern = Pattern.compile("[0-9]{5}");
        Matcher matcher = pattern.matcher(this.codePostal);
        if(!matcher.find()) {
            throw new FrameworkException("Code postal \"" + this.codePostal + "\" invalide.");
        }
        
		this.codePostal = codePostal;
		this.pays = pays;
	}
}
