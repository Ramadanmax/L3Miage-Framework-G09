import java.rmi.RemoteException;
import Module_Messagerie.SalonDiscussion;

public class testSalonDiscussion {

	public static void main(String[] args) throws RemoteException {
		
		SalonDiscussion Cr = new SalonDiscussion("testSalon");

		System.out.println("1 :"+Cr.AfficherMessages());
		
		Cr.load();
		
		System.out.println("2 :"+Cr.AfficherMessages());

	}

}
