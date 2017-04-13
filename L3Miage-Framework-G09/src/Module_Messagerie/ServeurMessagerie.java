package Module_Messagerie;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class ServeurMessagerie {

	private ChatRoomImpl chatRoom;

	public ServeurMessagerie() {
		try {
			LocateRegistry.createRegistry(1099);
			chatRoom = new ChatRoomImpl();
			String url = "rmi://" + InetAddress.getLocalHost().getHostAddress() + "/chatRoom";
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
	
	public ChatRoomImpl getChatroom()
	{
		return this.chatRoom;
	}
}
