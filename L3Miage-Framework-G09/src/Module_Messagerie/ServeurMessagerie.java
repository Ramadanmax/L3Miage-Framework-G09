package Module_Messagerie;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.SocketPermission;
import java.net.UnknownHostException;
import java.rmi.Naming;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Classe qui met en place le RMI de la messagerie coté serveur il enregistre le
 * chat Room dans le Naming
 * 
 * @author matheyt
 *
 */
public class ServeurMessagerie {

	private SalonDiscussion salonDiscussion;

	/**
	 * constructeur simple de la classe
	 */
	public ServeurMessagerie() {
		try {
			System.setProperty("java.security.policy","file:./security.policy");

			
			salonDiscussion = new SalonDiscussion("chatTest");
			LocateRegistry.createRegistry(1099);
			String url = "rmi://" + InetAddress.getLocalHost().getHostAddress() + "/ChatRoom";
			System.out.println("Enregistrement de l'objet avec l'url : " + url);
			Naming.rebind(url, salonDiscussion);

			System.out.println("Serveur lancee");
		} catch (RemoteException e) {
			e.printStackTrace();

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * construteur de la classe qui prend le nom du serveur sur lequel il sera
	 * lancé, pour l'enregistrer
	 * 
	 * @param nomServeur
	 *            Le nom du Serveur.
	 */
	public ServeurMessagerie(String nomServeur) {
		try {
			LocateRegistry.createRegistry(1099);
			salonDiscussion = new SalonDiscussion(nomServeur);
			String url = "rmi://" + nomServeur + "/chatRoom";
			System.out.println("Enregistrement de l'objet avec l'url : " + url);
			Naming.rebind(url, salonDiscussion);
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
	 * @return chatRoom La ChatRoom du Serveur courant.
	 */
	public SalonDiscussion getSalonDiscussion() {
		return this.salonDiscussion;
	}
}
