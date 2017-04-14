

import java.rmi.RemoteException;

import Module_Messagerie.ChatRoomImpl;
import Module_Messagerie.MessageTexte;
import Structure_Contact.Adresse;
import Structure_Contact.Contact;

public class testChatRoom {

	public static void main(String[] args) throws RemoteException {
		Adresse adresseC1 = new Adresse(20, "rue des coteaux", "Marsanne", "26740", "France");
		Adresse adresseC2 = new Adresse(14, "chemin des tourterelles", "Marsanne", "26740", "France");
		Adresse adresseC3 = new Adresse(20, "chemin a gauche apres le rond point", "Bourg Les Valence", "26001",
				"France");

		// Creation des contacts
		Contact c1 = new Contact("Virgil Bontempi", adresseC1, "virgilbontempi@hotmail.fr");
		Contact c2 = new Contact("Maxime Vanbossel", adresseC2, "maximevanbossel@hotmail.fr");
		Contact c3 = new Contact("Charlotte Jondet", adresseC3, "charlottejondet@hotmail.fr");

		ChatRoomImpl Cr = new ChatRoomImpl();
		Cr.ajouterContact(c1);
		Cr.ajouterContact(c2);
		
		Cr.envoyerMessage(new MessageTexte(c1,c2,"Hello"));
		Cr.envoyerMessage(new MessageTexte(c2, c1, "lut"));
		

		System.out.println(Cr.AfficherMessages());
		
		

	}

}
