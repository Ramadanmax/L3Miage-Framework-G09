package Module_Securite;

public class Crypteur extends Securite{
	
	private String msgCrypte;
	
	public Crypteur(String msgVierge){
		msgCrypte = cryptage(msgVierge);
	}
	
	public String getMsgCrypte(){
		return msgCrypte;
	}
	
	public String cryptage (String message){
		int[] nbpremier = tabNbPremier(message);
		int[] ascii = tabAscii(message);
		char[] crypte = tabCrypte(ascii,nbpremier);
		return charToString(crypte);
	}
	
	//Transformation d'une chaîne de caractère en tableau d'entier (équivalent Ascii de chaque caractère)
	public int[] tabAscii(String message){
		int a = message.length();
		int[] tabAscii = new int[a];
		for(int i=0; i<a; i++){
			tabAscii[i] = (int) message.charAt(i);			 
		}
		//for(int v=0; v<tabAscii.length;v++){
		//	System.out.println(tabAscii[v]);
		//}
		return tabAscii;
	}
	
	/*
	 * Transformation d'un tableau d'entier (équivalent Ascii de chaque caractère) en un tableau de caractère
	 * après cryptage (grâce à l'utilisation des nombres premiers)
	 */
	public char[] tabCrypte(int[] tabAscii, int[] tabNbPremier){
		int a = tabAscii.length;
		char[] tabCrypte = new char[a];
		for(int i=0; i<a; i++){
			tabCrypte[i] = (char) (((tabAscii[i] + tabNbPremier[i] - 32) % 1000000) + 32);			 
		}
		//for(int v=0; v<tabCrypte.length;v++){
		//	System.out.println(tabCrypte[v]);
		//}
		return tabCrypte;
	}
	
}
