import Module_Messagerie.ClientMessagerie;
import Module_Messagerie.MessageTexte;

public class testClientChatRoom {

	public static void main(String[] args) throws Exception {
		
		ClientMessagerie clientChat = new ClientMessagerie("130.190.61.46");
		MessageTexte msg = new MessageTexte(clientChat.getChatRoom().getcontacts().get(0), clientChat.getChatRoom().getcontacts().get(1), "lut");
		clientChat.getChatRoom().envoyerMessage(msg);
		System.out.println(clientChat.getChatRoom().getMessages());
	}

}
