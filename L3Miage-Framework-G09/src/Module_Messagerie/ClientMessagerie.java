package Module_Messagerie;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Classe qui permet de mettre en place le RMI du cote client en regardant dans
 * le Naming si il trouve la class ChatRoom et L'enregistre dans une variable.
 * 
 * @author matheyt
 */
public class ClientMessagerie {

	private _SalonDiscussion salonDiscussion;

	/**
	 * contructeur de la classe
	 * 
	 * @param nomServeur
	 *            Le nom du Serveur.
	 */
	public ClientMessagerie(String nomServeur) {
		try {
			Registry reg = LocateRegistry.getRegistry(nomServeur, 1099);
			Remote remote = reg.lookup("rmi://" + nomServeur + "/ChatRoom");
			System.out.println("serveur ok");
			if (remote instanceof _SalonDiscussion) {
				this.salonDiscussion = (_SalonDiscussion) remote;
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Getter de la ChatRoom.
	 * 
	 * @return chatRoom
	 */
	public _SalonDiscussion getSalonDiscussion() {
		return this.salonDiscussion;
	}

}
