import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import Module_Messagerie.ClientMessagerie;
import Module_Messagerie.MessageTexte;

public class testClientCSalonDiscussion {
//
	public static void main(String[] args) throws Exception {
		
		Registry reg = LocateRegistry.getRegistry("192.168.137.2", 5555);
		ClientMessagerie client = new ClientMessagerie("192.168.137.2","testSalon",reg);
		MessageTexte message = new MessageTexte(client.getSalonDiscussion().getcontacts().get(0), client.getSalonDiscussion().getcontacts().get(1), "lut");
		client.getSalonDiscussion().envoyerMessage(message);
		System.out.println(client.getSalonDiscussion().getMessages());
	}
}
