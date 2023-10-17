package no.hvl.dat100.prosjekt.kontroll;

import java.util.ArrayList;

import no.hvl.dat100.prosjekt.modell.KortSamling;
import no.hvl.dat100.prosjekt.TODO;
import no.hvl.dat100.prosjekt.kontroll.dommer.Regler;
import no.hvl.dat100.prosjekt.kontroll.spill.Handling;
import no.hvl.dat100.prosjekt.kontroll.spill.Spillere;
import no.hvl.dat100.prosjekt.modell.Kort;
import no.hvl.dat100.prosjekt.modell.KortUtils;

import no.hvl.dat100.prosjekt.kontroll.spill.HandlingsType;

/**
 * Klassen har objektvariaber som er referanser til de spillerne, nord og syd
 * (type ISpiller). Den har ogsÂ en bunke man deler/trekker fra og en bunke man
 * spiller til.
 *
 */
public class Spill {

	private ISpiller nord;
	private ISpiller syd;

	private Bord bord;

	// antall kort som skal deles ut til hver spiller ved start
	public final static int ANTALL_KORT_START = Regler.ANTALL_KORT_START;

	public Spill() {

		// TODO - START

		this.nord = new NordSpiller(Spillere.NORD);
		this.syd = new SydSpiller(Spillere.SYD);
		this.bord = new Bord();

		// TODO - END

	}
	// Jeg oppretter en ny spiller kalt 'Nord' av typen 'NordSpiller'. 
	// Jeg oppretter en ny spiller kalt 'Syd' av typen 'SydSpiller'. 
	// Så initialiserer jeg et nytt bord. 

	/**
	 * Gir referanse/peker til bord.
	 *
	 * @return referanse/peker bord objekt.
	 */
	public Bord getBord() {

		// TODO - START

		return bord;

		// TODO - END

	}
	// Her returnerer jeg objektet 'Bord'. 

	/**
	 * Gir referanse/peker til syd spilleren.
	 *
	 * @return referanse/peker til syd spiller.
	 */
	public ISpiller getSyd() {

		// TODO - START

		return syd;

		// TODO - END

	}
	// Her returnerer jeg spiller 'Syd'. 

	/**
	 * Gir referanse/peker til nord.
	 *
	 * @return referanse/peker til nord.
	 */
	public ISpiller getNord() {

		// TODO - START

		return nord;

		// TODO - END
	}
	// Her returnerer jeg spiller 'Nord'. 

	/**
	 * Metoden oppretter to spillere, nord og syd. Det opprettes to bunker, fra
	 * og til. Alle kortene legges til fra. Bunken fra stokkes. Deretter deles
	 * det ut kort fra fra-bunken til nord og syd i henhold til regler. Til
	 * slutt tas øverste kortet fra fra-bunken og legges til til-bunken.
	 *
	 * Nord har type RandomSpiller (som er forhåndefinert). Syd vil være spiller
	 * av en klasse laget av gruppen (implementeres i oppgave 3).
	 */
	public void start() {

		// TODO - START
		// FIKS expected 1, actual 0
		bord.getBunkeFra().leggTilAlle();
		bord.snuTilBunken();
		delutKort();
		bord.vendOversteFraBunke();

		// TODO - END
	}
	// Først legger jeg til alle kortene til 'bunkeFra'. Deretter, snur jeg 'bunkeTil'. 
	// Så deler jeg ut kortene til spillerne, og vender det øverste kortet fra 'bunkeFra'
	// til 'bunkeTil'. 

	/**
	 * Deler ut kort til nord og syd,.
	 *
	 */
	private void delutKort() {

		// TODO - START

		for (int i = 0; i < ANTALL_KORT_START; i++) {
			nord.leggTilKort(bord.taOversteFraBunke());
			syd.leggTilKort(bord.taOversteFraBunke());
		}

		// TODO - END
	}
	// Jeg bruker ei for-løkke til å dele ut antallet 'Kort', bestemt av 'ANTALL_KORT_START', 
	// til både spiller 'Nord' og 'Syd'. 

	/**
	 * Trekker et kort fra fra-bunken til spilleren gitt som parameter. Om
	 * fra-bunken er tom, må man "snu" til-bunken. Se info om metoden
	 * snuTilBunken().
	 *
	 * @param spiller
	 *            spilleren som trekker.
	 *
	 * @return kortet som trekkes.
	 */
	public Kort trekkFraBunke(ISpiller spiller) {

		// TODO - START
		// FIKS expected spar3, fikk ruter2
		Kort kort = bord.taOversteFraBunke();
		if (bord.bunkefraTom()) {
			bord.snuTilBunken();
		}
		spiller.trekker(kort);
		return kort;

		// TODO - END
	}
	// Jeg trekker det første kortet ved å kalle på metoden 'bord.taOversteFraBunke', og kortet
	// blir lagret i variabelen 'kort'. Deretter bruker jeg en if-setning til å snu 'bunkeTil'
	// hvis 'bunkeFra' går tom. Deretter informeres spillerobjektet at det har trukket det gitte
	// kortet, ved å kalle på metoden 'spiller.trekker(kort)'. 

	/**
	 * Gir neste handling for en spiller (spilt et kort, trekker et kort, forbi)
	 *
	 * @param spiller
	 *            spiller som skal handle.
	 *
	 * @return handlingen som skal utføres av kontroll delen.
	 */
	public Handling nesteHandling(ISpiller spiller) {

		// TODO - START
		// Hint: se på hvilke metoder som er tilgjengelig på en spiller

		// Hvis spilleren har et gyldig kort å spille.

		// Sjekk om spilleren har mulighet til å spille et kort
	    for (Kort kort : spiller.getHand().getAllekort()) {
	        if (Regler.kanLeggeNed(kort, bord.seOversteBunkeTil())) {
	            return new Handling(HandlingsType.LEGGNED, kort);
	        }
	    }

	    // Hvis ikke, sjekk om spilleren kan trekke et kort
	    if (spiller.getAntallTrekk() < Regler.maksTrekk()) {
	        return new Handling(HandlingsType.TREKK, null);
	    }

	    // Hvis ingen av de over er mulig, gå FORBI
	    return new Handling(HandlingsType.FORBI, null);

		// TODO - END

	}
	// Jeg henter inn alle kortene på spillerens hånd med metodene 'getAllekort' og
	// 'getHand'. Jeg bruker ei if-setning til å sjekke om spilleren har kort som kan 
	// legges ned i henhold til øverste kort i 'bunkeTil' og spillets 'Regler'. 
	// Hvis det går, returnerer den en ny 'Handling' av type 'LEGGNED'. Hvis spilleren ikke 
	// har kort som kan legges ned, utføres ikke koden innenfor for-løkken. 
	// Vi hopper videre til if-setningen som sjekker om spilleren kan utføre handlingen 
	// 'TREKK'. Så lenge spilleren ikke overskrider 'maksTrekk' i 'Regler', kan spilleren 
	// trekke inn kort. Hvis ikke, hopper vi til handlingstypen 'FORBI', hvor spilleren melder
	// pass. 

	/**
	 * Metoden spiller et kort. Den sjekker at spiller har kortet. Dersom det er
	 * tilfelle, fjernes kortet fra spilleren og legges til til-bunken. Metoden
	 * nulltiller også antall ganger spilleren har trukket kort.
	 *
	 * @param spiller
	 *            den som spiller.
	 * @param kort
	 *            kort som spilles.
	 *
	 * @return true dersom spilleren har kortet, false ellers.
	 */
	public boolean leggnedKort(ISpiller spiller, Kort kort) {

		// TODO - START

		if (spiller.getHand().har(kort)) {
			spiller.fjernKort(kort);
			bord.leggNedBunkeTil(kort);
			spiller.setAntallTrekk(0);
			return true;
		}

		return false;

		// TODO - END
	}
	// Jeg bruker ei if-setning til å sjekke om spilleren faktisk har det angitte kortet
	// i hånden. Hvis spilleren har kortet, blir kortet fjernet fra spillerens hånd. 
	// Kortet som ble fjernet, legges deretter ned på 'bunkeTil'. 
	// Antallet ganger spilleren har trukket et kort blir nullstilt, for å holde styr på 
	// hvor mange ganger en spiller har trukket et kort i sin tur. 
	// Hvis if-setningen er oppfylt, returnerer koden i løkka 'true'. 
	// Hvis spilleren ikke hadde kortet i hånden i første omgang, kjøres ikke koden i if-løkka
	// og metoden returnerer 'false'. 

	/**
	 * Metode for å si forbi. Må nullstille antall ganger spilleren har trukket
	 * kort.
	 *
	 * @param spiller
	 *            spilleren som er i tur.
	 */
	public void forbiSpiller(ISpiller spiller) {

		// TODO - START

		spiller.setAntallTrekk(0);

		// TODO - END
	}
	// Her setter jeg antallet ganger spilleren har trukket et kort til 0, idet spilleren
	// melder pass. 

	/**
	 * Metode for å utføre en handling (trekke, spille, forbi). Dersom handling
	 * er kort, blir kortet også spilt.
	 *
	 * @param spiller
	 *            spiller som utfører handlingen.
	 * @param handling
	 *            handling som utføres.
	 *
	 * @return kort som trekkes, kort som spilles eller null ved forbi.
	 */
	public Kort utforHandling(ISpiller spiller, Handling handling) {

		// TODO - START
		Kort kort = null;

		switch (handling.getType()) {
			case TREKK:
				kort = trekkFraBunke(spiller);
				break;
			case LEGGNED:
				kort = handling.getKort();
				if (leggnedKort(spiller, kort)) {
					spiller.setAntallTrekk(0);
				}
				break;
			case FORBI:
				forbiSpiller(spiller);
				break;
		}

		return kort;
	// TODO - END
	}
	// Jeg begynner med å initialisere variabelen 'kort' lik 0. Så bruker jeg en switch-setning
	// til å sjekke hvilken type handling som er gitt som parameter. Handlingens type hentes ved
	// 'handling.getType'. 
	// Når handlingstypen er 'TREKK', blir casen 'TREKK'. Her kaller jeg metoden 'trekkFraBunke'
	// med spilleren som parameter, og lagrer verdien i variabelen 'kort'. 
	// Når handlingstypen er 'LEGGNED', blir casen 'LEGGNED. Først henter jeg kortet som skal 
	// legges ned fra objektet 'handling'. Deretter bruker jeg en if-setning til å kalle på metoden
	// 'leggNedKort'. Hvis dette er vellykket, og metoden returnerer 'true', setter vi antall ganger
	// spilleren har trukket et kort lik 0. 
	// Når handlingstypen er 'FORBI', blir casen 'FORBI'. I denne casen kaller vi på metoden
	// 'forbiSpiller' med spilleren som parameter. Spilleren melder pass. 
	// Etter å ha sjekket handlingstypen og utført den tilsvarende handligen, returnerer vi variabelen
	// 'kort'. Dette kan være det kortet spilleren spilte, eller 'null' hvis spilleren meldte pass. 

}