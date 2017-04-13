package Module_Messagerie;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public class ClientMessagerie {

	private ChatRoom chatRoom;

	public ClientMessagerie(String nomServeur) {

		try {
			Remote r = Naming.lookup("rmi://" + nomServeur + "/TestRMI");
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

}
