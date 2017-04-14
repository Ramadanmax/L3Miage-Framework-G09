import java.util.Date;

import Module_Task.Task;
import Module_Task.TaskList;
import Structure_Contact.Adresse;
import Structure_Contact.Contact;

public class testTaskList {

	public static void main(String[] args) {

		// Creation d'une Adresse
		Adresse adresseC1 = new Adresse(20, "rue des coteaux", "Marsanne", "26740", "France");

		// Creation d'un Contact
		Contact c1 = new Contact("Virgil Bontempi", adresseC1, "virgilbontempi@hotmail.fr");

		// Creation de Tasks
		Task t1 = new Task("Nourrir le chat", new Date());
		Task t2 = new Task("Prendre une douche", new Date());
		Task t3 = new Task("Sortir les poubelles", new Date());
		Task t4 = new Task("Reviser (optionnel ?)", new Date());
		Task t5 = new Task("Aller a la muscu !!!", new Date());
		
		// Creation d'une TaskList
		TaskList taskList = new TaskList();
		taskList.ajouterTask(t1);
		taskList.ajouterTask(t2);
		taskList.ajouterTask(t3);
		taskList.ajouterTask(t4);
		taskList.ajouterTask(t5);
		
		// Affectation de la TaskList a un Contact
		c1.setTaskList(taskList);

		// Changement du booleen fait d'une Task
		c1.getTaskList().getTask(t2).setFait(true);
		
		// TEST DES EXCEPTIONS
		//Task t6 = new Task("Task inexistante", new Date());
		// Suppression d'une Task innexistante
		// c1.getTaskList().supprimerTas(t6);
		//c1.getTaskList().getTask(t6);
		// Recherche d'une Task inexistante
		
		// Affichage d'un Contact et de sa TaskList
		System.out.println(c1);
		System.out.print("\n");
		System.out.println(c1.getTaskList().toString());
	}

}
