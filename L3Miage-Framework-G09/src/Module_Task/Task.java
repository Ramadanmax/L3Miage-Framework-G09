package Module_Task;

import java.util.Date;

/**
 * Classe Task, structure de la Task d'une TaskList.
 * 
 * @author virgil
 *
 */
public class Task {

	private String nom;
	private Date date;
	private boolean fait;

	/**
	 * Constructeur d'une Task.
	 * 
	 * @param nom
	 *            Le nom d'une Task.
	 * @param date
	 *            La date d'une Task.
	 */
	public Task(String nom, Date date) {
		this.nom = nom;
		this.date = date;
		this.fait = false;
	}

	/**
	 * Getter du nom d'une Task.
	 * 
	 * @return Le nom de la Task courante.
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Getter de la date d'une Task.
	 * 
	 * @return La date de la Task courante.
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Getter du booleen fait d'une Task.
	 * 
	 * @return Le booleen fait de la Task courante.
	 */
	public boolean getFait() {
		return fait;
	}

	/**
	 * Setter du nom d'une Task.
	 * 
	 * @param nom
	 *            Le nom d'une Task.
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Setter de la date d'une Task.
	 * 
	 * @param date
	 *            La date d'une Task.
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * Setter du booleen fait d'une Task.
	 * 
	 * @param fait
	 *            Le booleen fait d'une Task.
	 */
	public void setFait(boolean fait) {
		this.fait = fait;
	}

	/**
	 * Methode toString d'une Task.
	 */
	public String toString() {
		String statut = "A Faire";

		if (this.fait) {
			statut = "Fait";
		}
		
		return this.nom + ", " + this.date + ", " + statut;
	}
}
