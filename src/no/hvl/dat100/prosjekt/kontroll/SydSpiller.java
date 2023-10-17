package no.hvl.dat100.prosjekt.kontroll;

import java.util.Random;

import no.hvl.dat100.prosjekt.TODO;
import no.hvl.dat100.prosjekt.kontroll.dommer.Regler;
import no.hvl.dat100.prosjekt.kontroll.spill.Handling;
import no.hvl.dat100.prosjekt.kontroll.spill.HandlingsType;
import no.hvl.dat100.prosjekt.kontroll.spill.Spillere;
import no.hvl.dat100.prosjekt.modell.Kort;
import no.hvl.dat100.prosjekt.modell.KortSamling;

/**
 * Klasse som for å representere en vriåtter syd-spiller. Strategien er å lete
 * gjennom kortene man har på hand og spille det første som er lovlig.
 *
 */
public class SydSpiller extends Spiller {

	/**
	 * Konstruktør.
	 * 
	 * @param spiller
	 *            posisjon for spilleren (nord eller syd).
	 */
	public SydSpiller(Spillere spiller) {
		super(spiller);
	}

	/**
	 * Metode for å implementere strategi. Strategien er å spille det første
	 * kortet som er lovlig (også en åtter selv om man har andre kort som også
	 * kan spilles). Dersom man ikke har lovlige kort å spille, trekker man om
	 * man ikke allerede har trukket maks antall ganger. I så fall sier man
	 * forbi.
	 * 
	 * @param topp
	 *            kort som ligg øverst på til-bunken.
	 */
	@Override
	public Handling nesteHandling(Kort topp) {
		// ArrayList for de kort vi har og kan spille
	    Kort[] hand = getHand().getAllekort();
	    KortSamling lovlige = new KortSamling();

	    // Gå igjennom kort å finn ut hvilke som kan spilles
	    for (Kort k : hand) {
	        // Sjekk om kortet 'k' kan legges ned på 'topp'
	        if (Regler.kanLeggeNed(k, topp)) {
	            // Legg til lovlige kort i samlingen
	            lovlige.leggTil(k);
	        }
	    }

	    Kort spill = null;
	    Kort[] spillFra = null;

	    // Hvis det finnes lovlige kort å spille
	    if (!lovlige.erTom()) {
	        spillFra = lovlige.getAllekort();
	    }

	    Handling handling = null;

	    // Hvis det er lovlige kort å spille
	    if (spillFra != null && spillFra.length > 0) {
	        // Velg det første lovlige kortet i samlingen for å spille
	        spill = spillFra[0];
	        // Lag en håndteringshandling for å legge ned dette kortet
	        handling = new Handling(HandlingsType.LEGGNED, spill);
	    } else if (getAntallTrekk() < Regler.maksTrekk()) {
	        // Hvis det ikke er lovlige kort å spille, men det er flere trekk igjen
	        // Lag en håndteringshandling for å trekke et nytt kort
	        handling = new Handling(HandlingsType.TREKK, null);
	    } else {
	        // Hvis det ikke er lovlige kort å spille og maks trekk er nådd
	        // Lag en håndteringshandling for å gå forbi
	        handling = new Handling(HandlingsType.FORBI, null);
	    }

	    return handling;
	}
}
