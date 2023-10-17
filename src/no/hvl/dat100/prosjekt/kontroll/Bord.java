package no.hvl.dat100.prosjekt.kontroll;

import no.hvl.dat100.prosjekt.modell.KortSamling;
import no.hvl.dat100.prosjekt.modell.KortUtils;
import no.hvl.dat100.prosjekt.TODO;
import no.hvl.dat100.prosjekt.modell.Kort;

/**
 * Klasse som implementerer bordet som spilles på. 
 * 
 * Klassen har objektvariablene bunkeTil og bunkeFra som skal brukes til å representere 
 * kortene som er i de to bunker på border. 
 */
public class Bord {

	private KortSamling bunkeFra;
	private KortSamling bunkeTil;
	
	/**
	 * Metoden oppretter to bunker, til- og fra-bunken
	 * Alle kortene legges til fra-bunken. 
	 */
	public Bord() {
		
		// TODO - START
		
		bunkeFra = new KortSamling();
		bunkeTil = new KortSamling();
		
		bunkeFra.leggTilAlle();
		// TODO - END
	}
	// Jeg oppretter to nye 'KortSamling'-objekter, èn for 'bunkeFra' og èn for 'bunkeTil'. 
	// Dette representerer de to bunker med kort på bordet. Så legger jeg til alle kortene i
	// 'bunkeFra', ved å kalle på 'leggTilAlle'-metoden. 
	
	/**
	 * Gir peker/referanse til til-bunken.
	 * 
	 * @return referanse/peker til til-bunken.
	 */
	public KortSamling getBunkeTil() {
		
		return bunkeTil;
		
	}

	/**
	 * Gir peker/referanse til fra-bunken.
	 * 
	 * @return referanse/peker til fra-bunken.
	 */
	public KortSamling getBunkeFra() {
		
		return bunkeFra;
		
	}
	
	/**
	 * Sjekker om til-bunken er tom.
	 * 
	 * @return true om til-bunken er tom, false ellers.
	 */
	public boolean bunketilTom() {
		
		// TODO - START
				
		return bunkeTil.erTom(); 

		// TODO - END
	}
	// Her kaller jeg metoden 'erTom()' på 'bunkeTil'-objektet. Dersom 'bunkeTil' er
	// tom, vil 'erTom()' returnere true. Hvis det fortsatt er kort igjen, returnerer
	// den false. 

	/**
	 * Sjekker om fra-bunken er tom.
	 * 
	 * @return true om fra-bunken er tom, false ellers.
	 */
	public boolean bunkefraTom() {
		
		// TODO - START
		
		return bunkeFra.erTom(); 
	
		// TODO - END
		
	}
	// Denne metoden er veldig lik den forrige. Den gjør samme operasjon som 'bunkeTilTom', 
	// men på 'bunkeFra'-objektet istedet. 
	
	/**
	 * Gir antall kort i fra-bunken.
	 * 
	 * @return antall kort i fra-bunken.
	 */
	public int antallBunkeFra() {
		
		// TODO - START
		
		return bunkeFra.getAntalKort(); 

		// TODO - END
	}
	// Her returneres antallet kort i 'bunkeFra'-objektet, ved å kalle inn metoden 'getAntalKort()'. 

	/**
	 * Gir antall kort i til-bunken.
	 * 
	 * @return antall kort i til-bunken.
	 */
	public int antallBunkeTil() {
		
		// TODO - START
		
		return bunkeTil.getAntalKort(); 

		// TODO - END
	}
	// Her returneres antallet kort i 'bunkeTil'-objektet, ved å kalle inn metoden 'getAntalKort()'. 
	
	/**
	 * Tar øverste kortet fra fra-bunken og legger dettte til til-bunken (med
	 * billedsiden opp, men det trenger ikke gruppen tenke på).
	 */
	public void vendOversteFraBunke() {
		
		// TODO - START
		
		if (!bunkeFra.erTom()) {
			bunkeTil.leggTil(bunkeFra.taSiste());
		}
		// TODO - END
		
	}
	// Her blir det utført en sjekk ved hjelp av metoden 'erTom' på 'bunkeFra'-objektet. 
	// Hvis 'bunkeFra' ikke er tom, vil koden i if-løkken bli utført. Hvis bunken er tom, 
	// vil ingenting skje. I if-løkken utføres det to operasjoner. Vi kaller på metoden
	// 'taSiste' for 'bunkeFra', som returnerer det øverste kortet fra 'bunkeFra', men 
	// fjerner det også fra bunken. Så, tar vi kortet som ble hentet fra 'bunkeFra' og 
	// legger det til 'bunkeTil' ved hjelp av metoden 'leggTil'. 
		
	/**
	 * Tar øverste kortet fra fra-bunken.
	 * 
	 * @return peker/referanse til det kort som blev tatt fra fra-bunken
	 */
	
	public Kort taOversteFraBunke() {
		
		// TODO - START
		
		if (!bunkeFra.erTom()) {
			return bunkeFra.taSiste(); 
		}
		
		return null; 
		
		// TODO - END
	}
	// if-setningen sjekker om 'bunkeFra' ikke er tom. Hvis den ikke er tom, vil koden
	// kjøre. I tilfellet hvor den ikke er tom, brukes metoden 'taSiste' fra 
	// 'KortSamling'-klassen, for å hente og fjerne det øverste kortet fra 'bunkeFra'. 
	// Deretter returnerer den dette kortet. Hvis 'bunkeFra' er tom, kjøres ikke if-
	// setningen, og metoden vil returnere 'null' som indikerer at det ikke er noe kort. 
	
	/**
	 * Metode som leser øverste kortet i til-bunken. Kortet vil fremdeles være
	 * øverst i til-bunken etter at metoden er utført.
	 * 
	 * @return peker/referanse til øverste kortet i til-bunken.
	 */
	public Kort seOversteBunkeTil() {
		
		// TODO - START
		
		if (!bunkeTil.erTom()) {
			return bunkeTil.seSiste(); 
		}
		
		return null; 

		// TODO - END
	}
	// if-setningen sjekker om 'bunkeTil' ikke er tom. Hvis den inneholder kort, vil koden
	// kjøre. I det tilfellet, bruker vi metoden 'seSiste' fra 'KortSamling'-klassen for å 
	// lese det øverste kortet fra 'bunkeTil' uten å fjerne det. Metoden vil deretter 
	// returnere dette kortet. Hvis bunken er tom, returnerer metoden 'null'. 
	
	/**
	 * Når fra-bunken blir tom, tar man vare på kortet pÂ toppen av til-bunken.
	 * Deretter legges alle den andre kortene i til-bunken over i fra-bunken.
	 * Denne stokkes og kortet som man har tatt vare pÂ legges tilbake i
	 * til-bunken. Det vil nå være det eneste kortet i til-bunken.
	 */
	public void snuTilBunken() {

		// TODO - START
		
		if (!bunkeTil.erTom() && !bunkeFra.erTom()) {
			Kort toppKort = bunkeTil.taSiste();
			while (!bunkeTil.erTom()) {
				bunkeFra.leggTil(bunkeTil.taSiste());
			}
			KortUtils.stokk(bunkeFra);
			bunkeTil.leggTil(toppKort);
		}
		
		
		// TODO - END
	}
	// if-setningen sjekker om 'bunkeTil' og 'bunkeFra' ikke er tomme. Hvis begge bunkene
	// ikke er tomme, vil koden kjøre. Når den kjører, tas det øverste kortet fra 
	// 'bunkeTil' og lagrer det i variabelen 'toppKort'. Så lenge 'bunkeTil' ikke er tom, 
	// tar denne while-løkken det øverste kortet fra 'bunkeTil' og legger det i 'bunkeFra'. 
	// Deretter stokkes 'bunkeFra'. Til slutt legges det tidligere øverste kortet fra 
	// 'bunkeTil', som ble lagret i 'toppKort', tilbake på toppen av 'bunkeTil'. 
		
	/**
	 * Metode som legger et kort i til-bunken. 
	 * 
	 * @param k
	 * 			kort som skal legges ned. 
	 * 	
	 */
	public void leggNedBunkeTil(Kort k) {
		
		// TODO - START
		
		bunkeTil.leggTil(k);
		
		// TODO - END
				
	}
}
// Her kaller jeg inn metoden 'leggTil' på objektet 'bunkeTil', for å legge det gitte
// kortet 'k' til bunken. 