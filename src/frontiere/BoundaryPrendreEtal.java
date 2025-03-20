package frontiere;

import controleur.ControlPrendreEtal;
import villagegaulois.Village;
import personnages.Gaulois;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		boolean inThisVillage = controlPrendreEtal.verifierIdentite(nomVendeur);
		if(inThisVillage) {
			System.out.println("Bonjour " + nomVendeur + ", je vais regarder si je peux vous trouver un �tal.");
			boolean etalDisponible = controlPrendreEtal.resteEtals();
			if(etalDisponible) installerVendeur(nomVendeur);
			else System.out.println("Il n'y a plus d'�tal disponible.");
		} else {
			System.out.println("Je suis d�sol�e " + nomVendeur + " mais il faut �tre un habitant de notre village pour commercer ici.");
		}
	}

	private void installerVendeur(String nomVendeur) {
		System.out.println("C'est parfait, il me reste un �tal pour vous!");
		System.out.println("Il me faudrait quelques renseignements:");
		String produit = Clavier.entrerChaine("Quel produit souhaitez-vous vendre?");
		int nbProduit = Clavier.entrerEntier("Combien souhaitez-vous en vendre?");
		int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		System.out.println("Le vendeur " + nomVendeur + " s'est install� � l'�tal n�" + numeroEtal+1);
	}
}
