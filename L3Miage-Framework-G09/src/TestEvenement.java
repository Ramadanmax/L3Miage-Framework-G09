import java.util.ArrayList;

import Module_Evenement.Evenement;
import Structure_Contact.Adresse;
import Structure_Contact.Contact;
//
public class TestEvenement {

	public static void main(String[] args) {
		Contact c1 = new Contact("Jean Michel Serieu", new Adresse(2,"avenue Bosh","Solérieu","26580","France"), "JMSerieu@gmail.com");
		Contact c2 = new Contact("Yves Patae", new Adresse(2,"avenue Bosh","Solérieu","26580","France"), "YvePate@laposte.net");
		
		Evenement foireTroll = new Evenement("La foire aux Troll de Paris", "13, rue des champignons, Paris, 69000, France", 20170421, "Une belle foire au troll");
		System.out.println(foireTroll.getNom() + " se situera " + foireTroll.getLieu().toString() + " le " + foireTroll.getDate());
		
		Evenement foireJambon = new Evenement("La foire aux Troll de Paris", "13, rue des champignons, Paris, 69000, France", 20170421, "Une belle foire au jambon");
		System.out.println(foireTroll.getNom() + " se situera " + foireTroll.getLieu().toString() + " le " + foireTroll.getDate());
	}

}
