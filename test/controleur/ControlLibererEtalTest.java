package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlLibererEtalTest {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlLibererEtal controlLibererEtal;
	
	@BeforeEach
	public void initialiserSituation() {
		village = new Village("le village des irréductibles", 10, 5);
		Chef abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
	}

	@Test
	void testControlLibererEtal() {
		assertNotNull(controlTrouverEtalVendeur, "Constructeur non vide");
		assertNotNull(controlLibererEtal, "Constructeur non vide");
	}

	@Test
	void testIsVendeur() {
		Gaulois vendeur = new Gaulois ("Vendeur", 5);
		
		assertFalse(controlLibererEtal.isVendeur("Vendeur"));
		
		village.ajouterHabitant(vendeur);
		village.installerVendeur(vendeur, "produit", 10);
		assertTrue(controlLibererEtal.isVendeur("Vendeur"));
	}

	@Test
	void testLibererEtal() {
		Gaulois vendeur = new Gaulois("Vendeur", 5);
		
		village.ajouterHabitant(vendeur);
		village.installerVendeur(vendeur, "produit", 10);
		
		String[] test = controlLibererEtal.libererEtal("Vendeur");
		assertEquals(test[0], "Vendeur");
		
	}
}
