package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlVerifierIdentiteTest {
	private Village village;
	private Chef abraracourcix;
	private ControlVerifierIdentite controlVerifierIdentite;
	
	@BeforeEach
	public void initialiserSituation() {
		village = new Village("le village des irréductibles", 10, 5);
		controlVerifierIdentite = new ControlVerifierIdentite(village);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
	}

	@Test
	void testControlVerifierIdentite() {
		assertNotNull(controlVerifierIdentite, "Constructeur ne renvoie pas null");
	}

	@Test
	void testVerifierIdentite() {
		Gaulois gaulois = new Gaulois ("Gaulois", 5);
		village.ajouterHabitant(gaulois);
		assertTrue(controlVerifierIdentite.verifierIdentite("Gaulois"));
		assertFalse(controlVerifierIdentite.verifierIdentite("Existe pas"));
	}

}
