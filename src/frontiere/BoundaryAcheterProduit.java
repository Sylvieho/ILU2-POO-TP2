package frontiere;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		if (!controlAcheterProduit.verifierIdentite(nomAcheteur)) {
			System.out.println("Je suis désolé " + nomAcheteur
					+ " mais il faut être un habitant de notre village pour commercer ici.");
			return;
		}
		
		String produitVoulu = Clavier.entrerChaine("Quel produit voulez-vous acheter ?");
		
		String[] vendeursProduit = controlAcheterProduit.rechercherNomVendeursProduit(produitVoulu);
		if (vendeursProduit == null) {
			System.out.println("Désolé, personne ne vend ce produit au marché");
			return;
		}
		
		System.out.println("Chez quel commercant voulez-vous acheter des " + produitVoulu + " ?");
		for (int i = 0; i < vendeursProduit.length; i++) {
			System.out.println((i + 1) + " - " + vendeursProduit[i]);
		}
		
		int numVendeur = Clavier.entrerEntier("");
		while (numVendeur > vendeursProduit.length || numVendeur < 1) {
			System.out.println("Veuillez saisir un des nombres proposés :");
			numVendeur = Clavier.entrerEntier("");
		}

		String nomVendeur = vendeursProduit[numVendeur - 1];
		
		System.out.println(nomAcheteur + " se déplace jusqu'à  l'étal du vendeur " + nomVendeur);
		
		System.out.println("Bonjour " + nomAcheteur);
		
		int quantiteVoulue = Clavier.entrerEntier("Combien de " + produitVoulu + " voulez-vous acheter ?");
		while (quantiteVoulue < 1) {
			System.out.println("Veuillez saisir une quantité supérieur à 0");
		}

		int quantiteDisponible = controlAcheterProduit.acheterProduit(nomVendeur, quantiteVoulue);
		
		if (quantiteDisponible == 0) {
			System.out.println(nomAcheteur + " veut acheter " + quantiteVoulue + " " + produitVoulu
					+ ", malheureusement il n'y en a plus !");
		} else if (quantiteDisponible < quantiteVoulue) {
			System.out.println(nomAcheteur + " veut acheter " + quantiteVoulue + " " + produitVoulu
					+ ", malheureusement " + nomVendeur + " n'en a plus que " + quantiteDisponible + ". " 
					+ nomAcheteur
					+ " achète tout le stock de " + nomVendeur + ".");
		} else {
			System.out
			.println(nomAcheteur + " achète " + quantiteVoulue + " " + produitVoulu 
					+ " à " + nomVendeur + ".");
		}
	}
}
