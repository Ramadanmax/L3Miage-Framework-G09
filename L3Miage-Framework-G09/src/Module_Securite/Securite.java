package Module_Securite;

public class Securite {
	
	/** 
	 * 
	 * @param message
	 * @return
	 */
	//Renvoi les n nombre premier, n étant la longueur du message
	public int[] tabNbPremier(String message){
		int[] tabNbPremier = null;
		int b = message.length();
		tabNbPremier = new int[b]; //Création du tableau
		tabNbPremier[0]=2; // le premier nombre premier est 2
		int lg = 1; // nombre de nombre premier trouvé.
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
		//for(int v=0; v<tabNbPremier.length;v++){
		//	System.out.println(tabNbPremier[v]);
		//}
		return tabNbPremier;
	}
	
	/*
	 * Transformation d'une chaîne de caractères en tableau de caractères
	 */
	public char[] stringToChar(String msgString){
		int a = msgString.length();
		char[] caractere = new char[a];
		for(int i =0; i<a; i++){
			caractere[i] = msgString.charAt(i);
		}
		return caractere;
	}
	
	/*
	 * Transformation d'un tableau de caractères en chaîne de caractères
	 */
	public String charToString(char[] caractere){
		String str = new String(caractere);
		return str;
	}
}
