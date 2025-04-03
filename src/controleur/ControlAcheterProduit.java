package controleur;

import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}
	
	public boolean verifierIdentite(String nom) {
		return controlVerifierIdentite.verifierIdentite(nom);
	}
	
	public String[] rechercherNomVendeursProduit(String produit) {
		Gaulois[] vendeursProduit = village.rechercherVendeursProduit(produit);
		if (vendeursProduit == null) {
			return new String[0];
		}
		String[] nomVendeursProduit = new String[vendeursProduit.length];
		for (int i = 0; i < vendeursProduit.length; i++) {
			nomVendeursProduit[i] = vendeursProduit[i].getNom();
		}
		return nomVendeursProduit;
	}
	
	public int acheterProduit(String nomVendeur, int quantite) {
		Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		if(etal != null) {
			return etal.acheterProduit(quantite);
		}
		return -1;
	}
}
