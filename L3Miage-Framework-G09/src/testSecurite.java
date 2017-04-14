import Module_Securite.Crypteur;
import Module_Securite.Decrypteur;

public class testSecurite {

	public static void main(String[] args) {
		Crypteur crypte = new Crypteur("VirgilBiceps");
		System.out.println(crypte.getMsgCrypte());
		Decrypteur decrypte = new Decrypteur(crypte.getMsgCrypte());
		System.out.println(decrypte.getMsgDecrypte());
	}

}
