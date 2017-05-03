package Module_Messagerie;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;


/**
 * Classe qui met en place le RMI de la messagerie cotÃ© serveur il enregistre
 * le chat Room dans le un registre passer en parametttre du constructeur
 * 
 * @author matheyt
 *
 */
public class ServeurMessagerie {

	private SalonDiscussion salonDiscussion;
	private Registry reg;

	/**
	 * construteur de la classe qui prend le nom du salon de discution pour
	 * l'enregistrer, ainsi qu'un registre pour l'enregistrement
	 * 
	 * @param nomSalon
	 *            Le nom du Serveur.
	 */
	public ServeurMessagerie(String nomSalon, Registry reg) {
		try {
			System.setProperty("java.security.policy", "file:./security.policy");

			salonDiscussion = new SalonDiscussion(nomSalon);
			this.reg = reg;
			String url = "rmi://" + InetAddress.getLocalHost().getHostAddress() + "/"
					+ salonDiscussion.getNomSalonDiscussion();
			System.out.println("Enregistrement de l'objet avec l'url : " + url);
			this.reg.rebind(url, salonDiscussion);

			System.out.println("Serveur lancee");
		} catch (RemoteException e) {
			e.printStackTrace();

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	/**
	 * fonction qui ferme proprement le RMI en détachant les référence du Salon assossié
	 */
	public void fermetureServeurMessagerie()
	{
		try {
			this.reg.unbind("rmi://" + InetAddress.getLocalHost().getHostAddress() + "/"
						+ salonDiscussion.getNomSalonDiscussion());
		} catch (AccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
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
