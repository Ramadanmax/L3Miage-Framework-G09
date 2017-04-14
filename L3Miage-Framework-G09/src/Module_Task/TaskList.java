package Module_Task;

import java.util.ArrayList;
import java.util.List;

import FrameworkExceptions.FrameworkException;

/**
 * Classe TaskList, structure de la TaskList d'un Contact.
 * 
 * @author virgil
 *
 */
public class TaskList {

	private List<Task> tasks;

	/**
	 * Constructeur d'une TaskList.
	 */
	public TaskList() {
		this.tasks = new ArrayList<Task>();
	}

	/**
	 * Ajout d'une Task dans la TaskList courante.
	 * 
	 * @param t
	 *            La Task a ajouter.
	 */
	public void ajouterTask(Task t) {
		this.tasks.add(t);
	}

	/**
	 * Suppression d'une Task dans la TaskList courante.
	 * 
	 * @param t
	 *            La Task a supprimer.
	 * @throws FrameworkException
	 */
	public void supprimerTas(Task t) throws FrameworkException {
		if (!this.tasks.contains(t)) {
			// La Task n'existe pas.
			throw new FrameworkException("La Task que vous essayez de supprimer n'existe pas dans cette TaskList.");
		}
		// La Task existe.
		this.tasks.remove(this.tasks.indexOf(t));
	}

	/**
	 * Getter des Tasks d'une TaskList.
	 * 
	 * @return Les Tasks de la TaskList courante.
	 */
	public List<Task> getTasks() {
		return tasks;
	}

	/**
	 * Getter d'une Task d'une TaskList.
	 * 
	 * @param task
	 *            La Task recherchee.
	 * @return La Task recherchee.
	 * @throws FrameworkException
	 */
	public Task getTask(Task task) throws FrameworkException {
		if (!this.tasks.contains(task)) {
			// La Task n'existe pas.
			throw new FrameworkException("La Task que vous cherchez n'existe pas dans cette TaskList.");
		}
		// La Task existe.
		return this.tasks.get(this.tasks.indexOf(task));
	}

	/**
	 * Methode toString d'une TaskList.
	 */
	public String toString() {
		String chaine = "TaskList :\n==========\n";
		for (Task task : tasks) {
			chaine += tasks.indexOf(task) + " : " + task.toString() + "\n";
		}

		return chaine;
	}
}
