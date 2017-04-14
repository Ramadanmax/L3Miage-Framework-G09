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

		// Ajout de Contacts dans l'Annuaire de c1
		c1.getAnnuaire().ajouterContact(c2);
		c1.getAnnuaire().ajouterContact(c3);
		
		// TEST DES EXCEPTIONS
		// Creation d'un Contact avec un mail invalide
		// Contact c4 = new Contact("Exception1", adresseC1, "adresseMailSansArobase.fr");
		// Contact c5 = new Contact("Exception2", adresseC1, "adresseMailSansPointFR@test");
		// Contact c6 = new Contact("Exception3", adresseC1, "adresseMailSansRienEntreArobaseEtPointFRFR@.fr");
		// Contact c7 = new Contact("Exception4", adresseC1, "@adresseMailRienAvantArobase.fr");

		// Affichage d'un contact
		System.out.println(c1);

		// Affichage de l'Annuaire de c1
		System.out.print("\n");
		System.out.println(c1.getAnnuaire());
	}

}
