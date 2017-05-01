package Module_ListeTaches;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import FrameworkExceptions.FrameworkException;

/**
 * Classe Liste de Taches, structure de la Liste de Taches d'un Contact.
 * 
 * @author virgil
 *
 */
public class ListeTaches implements Serializable {

	private static final long serialVersionUID = -403307245786356963L;
	private List<Tache> taches;

	/**
	 * Constructeur d'une Liste de Taches.
	 */
	public ListeTaches() {
		this.taches = new ArrayList<Tache>();
	}

	/**
	 * Ajout d'une Tache dans la Liste de Taches courante.
	 * 
	 * @param t
	 *            La Tache a ajouter.
	 */
	/*@ 
	 *ensures taches.size() == \old(taches.size())+1;
	 @*/
	public void ajouterTache(Tache t) {
		this.taches.add(t);
	}

	/**
	 * Suppression d'une Tache dans la Liste de Taches courante.
	 * 
	 * @param tache
	 *            La Tache a supprimer.
	 * @throws FrameworkException
	 */
	/*@ 
	 *ensures taches.size() == \old(taches.size())-1;
	 @*/
	public void supprimerTache(Tache tache) throws FrameworkException {
		if (!this.taches.contains(tache)) {
			// La Tache n'existe pas.
			throw new FrameworkException("La Tache que vous essayez de supprimer n'existe pas dans cette Liste de Taches.");
		}
		// La Tache existe.
		this.taches.remove(this.taches.indexOf(tache));
	}

	/**
	 * Getter des Taches d'une Liste de Taches.
	 * 
	 * @return Les Taches de la Liste de Taches courante.
	 */
	public List<Tache> getTaches() {
		return taches;
	}

	/**
	 * Getter d'une Tache d'une Liste de Taches.
	 * 
	 * @param tache
	 *            La Tache recherchee.
	 * @return La Tache recherchee.
	 * @throws FrameworkException
	 */
	public Tache getTache(Tache tache) throws FrameworkException {
		if (!this.taches.contains(tache)) {
			// La Tache n'existe pas.
			throw new FrameworkException("La Tache que vous cherchez n'existe pas dans cette Liste de Taches.");
		}
		// La Tache existe.
		return this.taches.get(this.taches.indexOf(tache));
	}

	/**
	 * Methode toString d'une Liste de Taches.
	 */
	public String toString() {
		String chaine = "Liste de Taches :\n==========\n";
		for (Tache tache : taches) {
			chaine += taches.indexOf(tache) + " : " + tache.toString() + "\n";
		}

		return chaine;
	}
}
