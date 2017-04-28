package Module_Messagerie;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
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
	 * contructeur de la classe qui va chercher l'objet salon de discution
	 * enregistrer dans le registre passer en parametre
	 * 
	 * @param nomServeur
	 * 				le nomdu Serveur (IP)
	 * @param reg
	 * 				le Registre d'enregistrement
	 */
	public ClientMessagerie(String nomServeur,String nomSalon, Registry reg) {
		try {
			System.setProperty("java.security.policy", "file:./security.policy");
			Remote remote = reg.lookup("rmi://" + nomServeur +"/"+ nomSalon);
			System.out.println("serveur ok");
			if (remote instanceof _SalonDiscussion) {
				this.salonDiscussion = (_SalonDiscussion) remote;
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		} /*
			 * catch (UnknownHostException e) { e.printStackTrace(); }
			 */
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
