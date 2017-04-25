package Module_Messagerie;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Classe qui permet de mettre en place le RMI du cote client en regardant dans le Naming si il trouve la class ChatRoom
 *  et L'enregistre dans une variable.
 * @author matheyt
 */
public class ClientMessagerie {

	private ChatRoom chatRoom;

	/**
	 * contructeur de la classe
	 * @param nomServeur
	 */
	public ClientMessagerie(String nomServeur) {

		try {
			Remote r = Naming.lookup("rmi://" + nomServeur + "/ChatRoom");
			System.out.println(r);
			if (r instanceof ChatRoom) {
				this.chatRoom = (ChatRoom) r;
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}

	}
	
	public ChatRoom getChatRoom(){
		return this.chatRoom;
	}

}
