package Module_ListeTaches;

import java.util.Date;

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
