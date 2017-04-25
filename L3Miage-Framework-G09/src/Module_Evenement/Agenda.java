package Module_Evenement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * La classe Agenda permet d'initialiser une liste d'événements pour un
 * utilisateur. Dans cette classe, on peut aussi ajouter (@see
 * {@link Agenda#ajouterEvenement(Evenement)}) ou supprimer (@see
 * {@link Agenda#supprimerEvenement(Evenement)}) des événements à la liste des
 * événements d'un utilisateur (@see {@link Agenda#evenements})
 * 
 * @version 1.0
 * @date 13/04/2017
 * @author Maxime RAMADANOSKI
 */
public class Agenda implements Serializable {

	private static final long serialVersionUID = -4360089665096308659L;
	/**
	 * La liste d'événements constituant un agenda. Cette liste est sujette à
	 * modifications.
	 * 
	 * @see Agenda#ajouterEvenement(Evenement)
	 * @see Agenda#supprimerEvenement(Evenement)
	 * @see Agenda#setEvenements(List)
	 */
	private List<Evenement> evenements;

	/**
	 * Constructeur principal de l'Agenda.
	 */
	public Agenda() {
		this.evenements = new ArrayList<Evenement>();
	}

	/**
	 * Constructeur secondaire de l'Agenda.
	 * 
	 * @param evenements
	 */
	public Agenda(List<Evenement> evenements) {
		this.evenements = evenements;
	}

	/**
	 * Retourne la liste des événements existants.
	 * 
	 * @return events
	 */
	private List<Evenement> getEvenements() {
		return evenements;
	}

	/**
	 * Met à jour la liste des événements existants.
	 * 
	 * @param evenements
	 *            Les nouveaux événements.
	 */
	private void setEvenements(List<Evenement> evenements) {
		this.evenements = evenements;
	}

	/**
	 * Ajoute un événement à la liste des événements.
	 * 
	 * @param evenement
	 *            Le nouvel événement.
	 */

	private void ajouterEvenement(Evenement evenement) {
		evenements.add(evenement);
	}

	/**
	 * Supprime un événement de la liste des événements.
	 * 
	 * @param evenement
	 *            L'événement supprimé.
	 */
	private void supprimerEvenement(Evenement evenement) {
		evenements.remove(evenement);
	}

}
