package no.hvl.dat100.prosjekt.modell;

import java.util.Arrays;
import java.util.Random;

import no.hvl.dat100.prosjekt.TODO;

public class KortUtils {

	/**
	 * Sorterer en samling. Rekkefølgen er bestemt av compareTo() i Kort-klassen.
	 * 
	 * @see Kort
	 * 
	 * @param samling
	 * 			samling av kort som skal sorteres. 
	 */
	
	public static void sorter(KortSamling samling) {
		
		// TODO - START

		Kort[] kortene = samling.getAllekort();
		Arrays.sort(kortene);

		samling.fjernAlle();
		for (Kort kort : kortene) {
			samling.leggTil(kort);
		}

		// TODO - END
	}

	/**
	 * Stokkar en kortsamling.
	 *
	 * @param samling
	 * 			samling av kort som skal stokkes.
	 */
	public static void stokk(KortSamling samling) {

		// TODO - START

		Random rand = new Random();
		Kort[] kortene = samling.getAllekort();

		for (int i = 0; i < kortene.length; i++) {
			int tilfeldigIndeks = rand.nextInt(kortene.length);

			Kort temp = kortene[i];
			kortene[i] = kortene[tilfeldigIndeks];
			kortene[tilfeldigIndeks] = temp;
		}

		samling.fjernAlle();
		for (Kort kort : kortene) {
			samling.leggTil(kort);
		}
	}
		// TODO - END
	}


