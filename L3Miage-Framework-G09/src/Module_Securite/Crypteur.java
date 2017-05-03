package Module_Securite;

import java.io.Serializable;

/**
 * La classe Crypteur crypte une chaine de caractères
 * 
 * @version 1.0
 * @date 25/04/2017
 * @author Yannick Falco && Maxime Vanbossel
 *
 */
public class Crypteur extends Securite implements Serializable{


	
	private static final long serialVersionUID = 1L;
	private String msgCrypte;

	/**
	 * Le constructeur de la classe Crypteur récupère une chaine de caractères
	 * et utilise la méthode cryptage pour crypter cette chaine.
	 * 
	 * @param msgVierge
	 * 				   Message à crypter
	 */
	public Crypteur(String msgVierge) {
		msgCrypte = cryptage(msgVierge);
	}

	/**
	 * La méthode getMsgCrypte retourne la chaine de caractères
	 * 
	 * @return msgCrypte
	 * 				   Message crypté
	 */
	public String getMsgCrypte() {
		return msgCrypte;
	}

	/**
	 * La méthode cryptage utilise les autres méthodes tabNbPremier, tabAscii,
	 * tabCrypte et charToString pour crypter la chaine de caractères récupérée.
	 * 
	 * @param message
	 * 				 Message qui va être crypté avec l'aide des méthodes de cryptage
	 * @return charToString(crypte)
	 */
	private String cryptage(String message) {
		int[] nbpremier = tabNbPremier(message);
		int[] ascii = tabAscii(message);
		char[] crypte = tabCrypte(ascii, nbpremier);
		return charToString(crypte);
	}

	/**
	 * La méthode tabAscii transforme une chaîne de caractères en un tableau
	 * d'entiers (équivalent Ascii de chaque caractère)
	 * 
	 * @param message
	 * 			     Message qui va être crypté en tableau d'entier
	 * @return tabAscii
	 */
	public int[] tabAscii(String message) {
		int a = message.length();
		int[] tabAscii = new int[a];
		for (int i = 0; i < a; i++) {
			tabAscii[i] = (int) message.charAt(i);
		}
		return tabAscii;
	}

	/**
	 * La méthode tabCrypte transforme un tableau d'entier (équivalent Ascii de
	 * chaque caractère) en un tableau de caractères après cryptage (grâce à
	 * l'utilisation des nombres premiers)
	 * 
	 * @param tabAscii
	 * 				  Tableau d'entier contenant la valeur correspondante d'un caractère en ascii
	 * @param tabNbPremier
	 * 					  Tableau d'entier qui contient la liste des n premiers nombres premiers
	 * @return tabCrypte
	 */
	public char[] tabCrypte(int[] tabAscii, int[] tabNbPremier) {
		int a = tabAscii.length;
		char[] tabCrypte = new char[a];
		for (int i = 0; i < a; i++) {
			tabCrypte[i] = (char) (((tabAscii[i] + tabNbPremier[i] - 32) % 1000000) + 32);
		}
		return tabCrypte;
	}
}
