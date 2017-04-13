package Module_Messagerie;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * Classe qui met en place le RMI de la messagerie coté serveur il enregistre le
 * chat Room dans le Naming
 * 
 * @author matheyt
 *
 */
public class ServeurMessagerie {

	private ChatRoomImpl chatRoom;

	/**
	 * constructeur simple de la classe
	 */
	public ServeurMessagerie() {
		try {
			LocateRegistry.createRegistry(1099);
			System.out.println("Mise en place du Security Manager ...");
			
			chatRoom = new ChatRoomImpl();
			String url = "rmi://" + InetAddress.getLocalHost().getHostAddress() + "/ChatRoom";
			System.out.println("Enregistrement de l'objet avec l'url : " + url);
			Naming.rebind(url, chatRoom);

			System.out.println("Serveur lancé");
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}


	/**
	 * construteur de la classe qui prend le nom du serveur sur lequel il sera
	 * lancé, pour l'enregistrer
	 * 
	 * @param nomServeur
	 */
	public ServeurMessagerie(String nomServeur) {
		try {
			LocateRegistry.createRegistry(1099);
			chatRoom = new ChatRoomImpl();
			String url = "rmi://" + nomServeur + "/chatRoom";
			System.out.println("Enregistrement de l'objet avec l'url : " + url);
			Naming.rebind(url, chatRoom);
			System.out.println("Serveur lancé");
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * fonction qui renvoi la chatRoom enregistrer en attribut
	 * 
	 * @return chatRoom
	 */
	public ChatRoomImpl getChatroom() {
		return this.chatRoom;
	}
}
