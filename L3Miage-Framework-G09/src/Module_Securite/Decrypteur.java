package Module_Securite;

import java.io.Serializable;

/**
 * La classe Decrypteur décrypte une chaine de caractères ayant été précédemment
 * crypté via l'utilisation de la classe Crypteur.
 * 
 * @version 1.0
 * @date 25/04/2017
 * @author Yannick Falco && Maxime Vanbossel
 *
 */
public class Decrypteur extends Securite implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String msgDecrypte;

	/**
	 * Le constructeur de la classe Decrypteur récupère une chaine de caractères
	 * (cryptée) et utilise la méthode decryptage pour décrypter cette chaine.
	 * 
	 * @param msgCrypte
	 */
	public Decrypteur(String msgCrypte) {
		msgDecrypte = decryptage(msgCrypte);
	}

	//
	/**
	 * La méthode getMsgDecrypte retourne le message décrypté
	 * 
	 * @return msgDecrypte
	 */
	public String getMsgDecrypte() {
		return msgDecrypte;
	}

	/**
	 * La méthode décryptage utilise les méthodes tabNbPremier, stringToChar,
	 * tabInt, tabDecrypte et charToString pour décrypter une chaine de
	 * caractères précédemment cryptée.
	 * 
	 * @param message
	 * @return charToString(decrypte)
	 */
	public String decryptage(String message) {
		int[] nbpremier = tabNbPremier(message);
		char[] caractere = stringToChar(message);
		int[] tabint = tabInt(nbpremier, caractere);
		char[] decrypte = tabDecrypte(tabint);
		return charToString(decrypte);
	}

	/**
	 * La méthode tabInt crée la clé de décryptage avec le tableau de caractères
	 * cryptés (grâce à l'utilisation des nombres premiers)
	 * 
	 * @param tabNbPremier
	 * @param tabCrypte
	 * @return tabInt
	 */
	public int[] tabInt(int[] tabNbPremier, char[] tabCrypte) {
		int a = tabCrypte.length;
		int[] tabInt = new int[a];
		for (int i = 0; i < a; i++) {
			tabInt[i] = ((int) tabCrypte[i] - 32);
			if (tabInt[i] + 1000000 > 1000032) {
				tabInt[i] = tabInt[i] % 1000000;
			} else {
				tabInt[i] = tabInt[i] + 1000000;
			}
			tabInt[i] = ((((tabInt[i]) + 32) - tabNbPremier[i]) % 1000032);
			if (tabInt[i] < 32) {
				tabInt[i] = tabInt[i] + 32;
			} else {
				tabInt[i] = tabInt[i];
			}
		}
		return tabInt;
	}

	/*
	 * Transformation d'un tableau d'entier (équivalent Ascii de chaque
	 * caractère) en un tableau de caractère après décryptage (grâce à
	 * l'utilisation des nombres premiers)
	 */
	/**
	 * La méthode tabDecrypte transforme un tableau d'entiers (équivalent Ascii
	 * de chaque caractère) en un tableau de caractères après décryptage (grâce
	 * à l'utilisation des nombres premiers)
	 * 
	 * @param tabInt
	 * @return tabDecrypte
	 */
	public char[] tabDecrypte(int[] tabInt) {
		int a = tabInt.length;
		char[] tabDecrypte = new char[a];
		for (int i = 0; i < a; i++) {
			tabDecrypte[i] = (char) tabInt[i];
		}
		return tabDecrypte;
	}
}
