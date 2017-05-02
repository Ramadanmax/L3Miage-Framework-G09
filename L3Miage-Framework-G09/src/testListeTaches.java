import java.util.Date;

import Module_ListeTaches.Tache;
import Module_ListeTaches.ListeTaches;
import Structure_Contact.Adresse;
import Structure_Contact.Contact;

public class testListeTaches {

	public static void main(String[] args) {

		// Creation d'une Adresse
		Adresse adresseC1 = new Adresse(20, "rue des coteaux", "Marsanne", "26740", "France");

		// Creation d'un Contact
		Contact c1 = new Contact("Virgil Bontempi", adresseC1, "virgilbontempi@hotmail.fr");

		// Creation de Tasks
		Tache t1 = new Tache("Nourrir le chat", 20160224);
		Tache t2 = new Tache("Prendre une douche", 20160225);
		Tache t3 = new Tache("Sortir les poubelles", 20160225);
		Tache t4 = new Tache("Reviser (optionnel ?)", 20160232);
		Tache t5 = new Tache("Aller a la muscu !!!", 20160612);
		
		// Creation d'une TaskList
		ListeTaches taskList = new ListeTaches();
		taskList.ajouterTache(t1);
		taskList.ajouterTache(t2);
		taskList.ajouterTache(t3);
		taskList.ajouterTache(t4);
		taskList.ajouterTache(t5);
		
		// Affectation de la TaskList a un Contact
		c1.setTaskList(taskList);

		// Changement du booleen fait d'une Task
		c1.getTaskList().getTache(t2).setFait(true);
		
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
