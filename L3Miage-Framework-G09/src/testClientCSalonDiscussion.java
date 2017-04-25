import Module_Messagerie.ClientMessagerie;
import Module_Messagerie.MessageTexte;

public class testClientCSalonDiscussion {

	public static void main(String[] args) throws Exception {
		
		ClientMessagerie client = new ClientMessagerie("130.190.61.46");
		MessageTexte message = new MessageTexte(client.getSalonDiscussion().getcontacts().get(0), client.getSalonDiscussion().getcontacts().get(1), "lut");
		client.getSalonDiscussion().envoyerMessage(message);
		System.out.println(client.getSalonDiscussion().getMessages());
	}

}
