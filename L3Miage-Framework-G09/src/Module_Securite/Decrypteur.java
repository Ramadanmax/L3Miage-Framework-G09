package Module_Securite;

public class Decrypteur extends Securite{
	
	private String msgDecrypte;
	
	public Decrypteur(String msgCrypte){
		msgDecrypte = decryptage(msgCrypte);
	}
	
	public String getMsgDecrypte(){
		return msgDecrypte;
	}
	
	public String decryptage (String message){
		int[] nbpremier = tabNbPremier(message);
		char[] caractere = stringToChar(message);
		int[] tabint = tabInt(nbpremier,caractere);
		char[] decrypte = tabDecrypte(tabint);
		return charToString(decrypte);
	}
	
	/*
	 * Création de la clé de décryptage avec le tableau de caractère crypté 
	 * (grâce à l'utilisation des nombres premiers)
	 */
	public int[] tabInt(int[] tabNbPremier, char[] tabCrypte){
		int a = tabCrypte.length;
		int[] tabInt = new int[a];
		for(int i=0; i<a; i++){
			tabInt[i] = ( (int) tabCrypte[i]- 32);
			if ( tabInt[i] + 1000000 > 1000032){
				tabInt[i] =  tabInt[i] % 1000000;
			}
			else{
				tabInt[i] =  tabInt[i] + 1000000;
			}
			tabInt[i] = ((((tabInt[i]) + 32) - tabNbPremier[i]) % 1000032);
			if (tabInt[i] < 32){
				tabInt[i] = tabInt[i] + 32;
			}
			else{
				tabInt[i] = tabInt[i];
			}
		}
		//for(int v=0; v<tabInt.length;v++){
		//	System.out.println(tabInt[v]);
		//}
		return tabInt;
	}
	
	/*
	 * Transformation d'un tableau d'entier (équivalent Ascii de chaque caractère) en un tableau de caractère
	 * après décryptage (grâce à l'utilisation des nombres premiers)
	 */
	public char[] tabDecrypte(int[] tabInt){
		int a = tabInt.length;
		char[] tabDecrypte = new char[a];
		for(int i=0; i<a; i++){
			tabDecrypte[i] = (char) tabInt[i];			 
		}
		//for(int v=0; v<tabDecrypte.length;v++){
		//	System.out.println(tabDecrypte[v]);
		//}
		return tabDecrypte;
	}

}
