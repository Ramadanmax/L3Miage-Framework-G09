import java.util.ArrayList;

import Module_Event.Event;
import Structure_Contact.Adresse;
import Structure_Contact.Contact;
//
public class TestEvent {

	public static void main(String[] args) {
		Contact c1 = new Contact("Jean Michel Serieu", new Adresse(2,"avenue Bosh","Solérieu","26580","France"), "JMSerieu@gmail.com");
		Contact c2 = new Contact("Yves Patae", new Adresse(2,"avenue Bosh","Solérieu","26580","France"), "YvePate@laposte.net");
		
		Event foireTroll = new Event("La foire aux Troll de Paris", new Adresse(13, "rue des champignons", "Paris", "69000", "France"), 20170421);
		System.out.println(foireTroll.getNom() + " se situera " + foireTroll.getLieu().toString() + " le " + foireTroll.getDate());
		
		foireTroll.ajouterContact(c1);
		foireTroll.ajouterContact(c2);
		System.out.println(foireTroll.getContacts());
		ArrayList<Contact> contacts = new ArrayList<Contact>();
		contacts.add(c1);
		contacts.add(c2);
		Event foireJambon = new Event("La foire aux Troll de Paris", new Adresse(13, "rue des champignons", "Paris", "69000", "France"), 20170421, contacts);
		System.out.println(foireJambon.getContacts());
		
		foireJambon.supprimerContact(c1);
		System.out.println(foireJambon.getContacts());
	}

}
