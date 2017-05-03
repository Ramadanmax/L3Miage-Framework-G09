package Module_Securite;

import java.io.Serializable;

/**
 * La classe Sécurité met à disposition des méthodes pour les classes Crypteur et Decrypteur. 
 * 
 * @version 1.0
 * @date 25/04/2017
 * @author Yannick Falco && Maxime Vanbossel
 *
 */
public class Securite implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** 
	 * La méthode tabNbPremier récupère une chaine de caractères et renvoie un tableau d'entier correspondant
	 * aux n premiers nombres entiers. n étant le nombre de caractères dans la chaine de caractères récupérée.
	 * 
	 * @param message
	 * 	  			 Message de n caractère permettant de créer le tableau des n nombres premiers
	 * @return tabNbPremier
	 */
	/*@
	 * require message != "";
	 * ensure tabNbPremier != "";
	 @*/
	public int[] tabNbPremier(String message){
		int[] tabNbPremier = null;
		int b = message.length();
		tabNbPremier = new int[b]; //Création du tableau
		tabNbPremier[0]=2; // le premier nombre premier est 2
		int lg = 1; // nombre de nombres premiers trouvés.
		int i=3; // premier nombre qui va être testé.
		for (int k=0; k<b; k++){
			for(int j=0;j<lg;j++){
				if((i%tabNbPremier[j])==0){ // si le nombre testé est multiple d'un nombre premier.
					j=0; // réinitialisation du compteur
					i = i+2; // pour un nouveau nombre (on exclut les pairs).
				}
				else    
				{
					if (b!=lg){
						while(tabNbPremier[j]>Math.sqrt(i)) // si le nombre premier testeur est supérieur au carré du nombre testé, alors il est premier.
						{
						tabNbPremier[lg] = i; // enregistrement du nb premier dans le tableau.	
						lg++; // incrémentation du nombre de premier.
						j=0; // réinitialisation du compteur
						i=i+2; // pour un nouveau nombre.
						}
					}
				}
			}
		}
		return tabNbPremier;
	}
	
	/**
	 * La méthode stringToChar transforme une chaîne de caractères en un tableau de caractères
	 * 
	 * @param msgString
	 * 				    Message de n caractère utilisé pour créer un tableau de taille n-1
	 * @return caractere
	 */
	/*@
	 * ensure caractere != "";
	 @*/
	public char[] stringToChar(String msgString){
		int a = msgString.length();
		char[] caractere = new char[a];
		for(int i =0; i<a; i++){
			caractere[i] = msgString.charAt(i);
		}
		return caractere;
	}
	
	/**
	 * La méthode charToString transforme un tableau de caractères en une chaîne de caractères
	 * 
	 * @param caractere
	 * 				   Tableau de taille n utilisé pour créer une chaîne de caractère de taille n+1
	 * @return str
	 */
	/*@
	 * require caractere != "";
	 * ensure str != "";
	 @*/
	public String charToString(char[] caractere){
		String str = new String(caractere);
		return str;
	}
}
