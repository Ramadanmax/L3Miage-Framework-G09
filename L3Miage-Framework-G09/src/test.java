import Module_Outil.Adresse;
import Module_Outil.Contact;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Adresse adresseC1 = new Adresse(20, "rue des coteaux", "Marsanne", "26740", "France");
		Contact c1 = new Contact("Virgil Bontempi", adresseC1, "virgilbontempi@hotmail.fr");
	}

}
