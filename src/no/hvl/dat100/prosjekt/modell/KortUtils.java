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

		Kort[] kortene = samling.getAllekort();
		Arrays.sort(kortene);

		samling.fjernAlle();
		for (Kort kort : kortene) {
			samling.leggTil(kort);
		}
	}
	// Her kaller jeg på metoden 'getAlleKort()' fra 'samling'-objektet for å få alle kortene fra samlingen. 
	// Resultatet lagres i en array kalt 'kortene'. Jeg bruker Java's innebygde 'Arrays-sort()-metode, for å 
	// sortere arrayen. Så fjerner jeg kortene fra 'samling' ved å kalle på 'fjernAlle()'-metoden, for å 
	// sørge for at kortene legges tilbake i samlingen i sortert rekkefølge. Så bruker jeg en for-løkke
	// som itererer gjennom hvert kort i den sorterte 'kortene'-arrayen. For hvert kort, kaller den 'leggTil()'-
	// metoden fra 'samling'-objektet for å legge hvert kort tilbake i samlingen, men nå i sortert rekkefølge. 

	/**
	 * Stokkar en kortsamling.
	 *
	 * @param samling
	 * 			samling av kort som skal stokkes.
	 */
	public static void stokk(KortSamling samling) {

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
}
// Først oppretter jeg en ny instans av 'Random'-klassen, som lar meg generere tilfeldige tall. Så kaller jeg
// 'getAlleKort()'-metoden fra 'samling'-objektet for å få alle kortene fra samlingen. Resultatet lagres i en
// array kalt 'kortene'. For å stokke kortene, bruker jeg en for-løkke som går gjennom hvert kort i 'kortene'-
// arrayen. En tilfeldig indeks 'tilfeldigIndeks' genereres fra intervallet (0, 'kortene.length'). Deretter
// bytter kortet ved indeksen 'i' med kortet ved den tilfeldige indeksen. For å gjøre dette byttet uten å 
// miste verdien til et av kortene, lagres kortet ved indeksen 'i' midlertidig i 'temp'. Så fjerner jeg alle
// kortene fra 'samling' ved å kalle 'fjernAlle()'-metoden. Til slutt, bruker jeg en for-løkke som itererer
// gjennom hvert kort i den stokkede 'kortene'-arrayen. For hvert kort, kaller den 'leggTil()-metoden fra
// 'samling'-objektet, for å legge hvert kort tilbake i samlingen. 