import Module_Evenement.Evenement;

public class TestEvenement {

	public static void main(String[] args) {
		Evenement foireTroll = new Evenement("La foire aux Troll de Paris", "13, rue des champignons, Paris, 69000, France", 20170421, "Une belle foire au troll");
		System.out.println(foireTroll.getNom() + " se situera " + foireTroll.getLieu().toString() + " le " + foireTroll.getDate());
		
		Evenement foireJambon = new Evenement("La foire aux Troll de Paris", "13, rue des champignons, Paris, 69000, France", 20170421, "Une belle foire au jambon");
		System.out.println(foireJambon.getNom() + " se situera " + foireJambon.getLieu().toString() + " le " + foireJambon.getDate());
	}

}
