import Structure_Contact.Adresse;
import Structure_Contact.Contact;

public class testAnnuaire {

	public static void main(String[] args) {

		// Creation des adresses
		Adresse adresseC1 = new Adresse(20, "rue des coteaux", "Marsanne", "26740", "France");
		Adresse adresseC2 = new Adresse(14, "chemin des tourterelles", "Marsanne", "26740", "France");
		Adresse adresseC3 = new Adresse(20, "chemin a gauche apres le rond point", "Bourg Les Valence", "26001",
				"France");

		// Creation des contacts
		Contact c1 = new Contact("Virgil Bontempi", adresseC1, "virgilbontempi@hotmail.fr");
		Contact c2 = new Contact("Maxime Vanbossel", adresseC2, "maximevanbossel@hotmail.fr");
		Contact c3 = new Contact("Charlotte Jondet", adresseC3, "charlottejondet@hotmail.fr");

		// Affichage d'un contact
		System.out.println(c1);

		// Ajout de Contacts dans l'Annuaire de c1
		c1.getAnnuaire().ajouterContact(c2);
		c1.getAnnuaire().ajouterContact(c3);

		// Affichage de l'Annuaire de c1
		System.out.print("\n");
		System.out.println(c1.getAnnuaire());
	}

}
