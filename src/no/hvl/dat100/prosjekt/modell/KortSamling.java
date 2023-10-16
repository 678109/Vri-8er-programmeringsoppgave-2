package no.hvl.dat100.prosjekt.modell;

import no.hvl.dat100.prosjekt.TODO;
import no.hvl.dat100.prosjekt.kontroll.dommer.Regler;

/**
 * Struktur for å lagre ei samling kort. Kan lagre hele kortstokken. Det finnes
 * en konstant i klassen Regler som angir antall kort i hver av de 4 fargene. Når
 * programmet er ferdig settes denne til 13, men under utvikling / testing kan
 * det være praktisk å ha denne mindre,.
 *
 */
public class KortSamling {

	private final int MAKS_KORT = 4 * Regler.MAKS_KORT_FARGE;

	private Kort[] samling;
	private int antall;

	/**
	 * Oppretter en tom Kortsamling med plass til MAKS_KORT (hele kortstokken).
	 */
	public KortSamling() {

		samling = new Kort[MAKS_KORT];
		antall = 0;
	} 
	// Denne konstruktøren oppretter en ny array av typen 'Kort', med en størrelse definert av kosntanten 'MAKS_KORT'. Arrayen lagres i variablen 'samling'. 
	// antallet settes lik 0 ved start, for å holde styr på hvor mange kort som er lagt til i samlingen. Altså hvor mange plasser i arrayen som er okkupert. 

	/**
	 * Returnerer en tabell med kortene i samlinga. Tabellen trenger ikke være
	 * full. Kortene ligger sammenhengende fra starten av tabellen. Kan få
	 * tilgang til antallet ved å bruke metoden getAntallKort(). Metoden er
	 * først og fremst ment å brukes i testklasser. Om man trenger
	 * kortene utenfor, anbefales metoden getAlleKort().
	 *
	 * @return tabell av kort.
	 *
	 */
	public Kort[] getSamling() {		

		return samling;
	} 

	/**
	 * Antall kort i samlingen.
	 *
	 * @return antall kort i samlinga.
	 */
	public int getAntalKort() {

		return antall;					
	} 
	// 'int' indikerer at metoden vil returnere en verdi av typen 'int'. 
	// 'return antall' returnerer verdien av variablen 'antall', altså hvor mange kort som er med i samlingen. 

	/**
	 * Sjekker om samlinga er tom.
	 *
	 * @return true om samlinga er tom, false ellers.
	 */
	public boolean erTom() {

		return antall == 0;				
	} 
	// 'boolean' indikerer at metoden vil returnere en verdi av typen 'boolean'. 
	// Så metoden sjekker om samlingen av kort er tom, og returnerer en sann eller usann verdi. 

	/**
	 * Legg et kort til samlinga.
	 *
	 * @param kort
	 *            er kortet som skal leggast til.
	 */
	public void leggTil(Kort kort) {

		if (antall < MAKS_KORT) {
			samling[antall] = kort;		
			antall++;
		}
	} 
	// 'void' betyr at metoden ikke returnerer noen verdi. Her brukes if-betingelsen, som kontrollerer om 
	// antallet kort i samlingen er mindre enn den maksimale tillatte mengden kort 'MAKS_KORT'. 
	// Dersom betingelsen er oppfylt, legges det til 'kort' i arrayen 'samling' på neste ledige posisjon. 
	// Etter at et kort er lagt til i samlingen, øker vi variabelen 'antall' med 1 (antall++). 

	/**
	 * Legger alle korta (hele kortstokken) til samlinga. Korta vil være sortert
	 * slik at de normalt må stokkes før bruk.
	 */
	public void leggTilAlle() {

		for (Kortfarge farge : Kortfarge.values()) {
			for (int a = 1; a <= Regler.MAKS_KORT_FARGE; a++) {
				leggTil(new Kort(farge, a));
			}
		}
	} 
	// Her brukes det en for-løkke som itererer gjennom alle mulige verdier i typen 'Kortfarge'. 
	// Den begynner med verdien 1, og øker med 1 for hver iterasjon, helt til vi når verdien av MAKS_KORT_FARGE. 
	// For hver kombinasjon av 'farge' og 'a' (kortnummer), opprettes et nytt 'Kort' og legges til i samlingen
	// ved hjelp av den definerte 'leggTil'-metoden. 

	/**
	 * Fjerner alle korta fra samlinga slik at den blir tom.
	 */
	public void fjernAlle() {

		for(int a = 0; a < antall; a++) {
			samling[a] = null;
		}
		antall = 0;
	}
	// Denne metoden benytter en for-løkke som itererer fra 0 til verdien av 'samling' ved indeksen 'a' til 'null'. 
	// Dette fjerner referansen til 'Kort' i den posisjonen, slik at kortet ikke lengre er en del av samlingen. 
	// Etter at alle kortene er fjernet fra samlingen, blir variablen 'antall' satt til 0. 

	/**
	 * Ser på siste kortet i samlinga.
	 *
	 * @return siste kortet i samlinga, men det blir ikke fjernet. Dersom samalinga er tom, returneres
	 *         null.
	 */
	public Kort seSiste() {

		if (antall > 0) {
			return samling[antall - 1];
		}
		else {
			return null;
		}
	}
	// Her brukes betingelseskontrollen if-else. Den sjekker om det er noen kort i samlingen (hvis antall > 0). 
	// Hvis det stemmer, vil koden innenfor 'if' bli kjørt. Hvis ikke, vil koden i 'else' kjøres. 
	// Hvis det er kort i samlingen, (antall > 0), vil det siste kortet i samlingen returneres. 
	// Indeksen til det siste kortet i arrayen 'samling' vil være 'antall - 1'. 
	// Hvis det ikke er noen kort i samlingen, vil metoden returnere 'null', noe som indikerer at det ikke er
	// kort i samlingen. 

	/**
	 * Tek ut siste kort fra samlinga.
	 *
	 * @return siste kortet i samlinga. Dersom samalinga er tom, returneres
	 *         null.
	 */
	public Kort taSiste() {

		if (antall > 0) {
			Kort sisteKort = samling[antall - 1];
			samling[antall - 1] = null;
			antall--;
			return sisteKort;
		} else {
			return null;
		}
	}
	// Her brukes betingelseskontrollen if-else, som sjekker om det er noen kort i samlingen (antall > 0).
	// Hvis det er kort i samlingen, kjøres koden i 'if', hvis ikke kjøres koden i 'else'. 
	// Dersom det er kort i samlingen, hentes referansen til det siste kortet i samlingen og lagrer
	// den i en likal variabel kalt 'sisteKort'. Deretter, fjernes referansen til det siste kortet fra samlingen
	// ved å sette verdien av den aktuelle posisjonen i arrayen til 'null'. Dette betyr at kortet er fjernet 
	// fra samlingen, men vi har fortsatt en referanse til det i den lokale variabelen 'sisteKort'. 
	// Så reduseres verdien 'antall' med 1, siden vi fjernet et kort. Til slutt, returneres referansen til det
	// kortet vi nettopp fjernet fra samlingen. Dersom det ikke er noen kort i samlingen, returneres 'null'. 

	/**
	 * Undersøker om et kort finst i samlinga.
	 *
	 * @param kort
	 *
	 * @return true om kortet finst i samlinga, false ellers.
	 */
	public boolean har(Kort kort) {

		for (int v = 0; v < antall; v++) {
			if (samling[v].equals(kort)) {
				return true;
			}
		}
		return false;
	}
	// Her benyttes det en for-løkke, som går gjennom hver posisjon i samlingen, opp til verdien av 'antall'. 
	// Betingelseskontrollen sammenligner hvert kort i samlingen med det gitte kortet som er sendt inn som parameter. 
	// Den bruker metoden 'equals', for å sammenligne to kortobjekter basert på deres farge og nummer. 
	// Hvis koden finner et kort i samlingen som samsvarer med det gitte kortet, vil den returnere 'true' umiddelbart, 
	// noe som indikerer at samlingen inneholder det gitte kortet. 
	// Etter at for-løkken har kjørt, og hvis ingen av kortene i samlingen samsvarer med det gitte kortet, vil 
	// metoden returnere 'false'. 

	/**
	 * Fjernar et kort frå samlinga. Dersom kortet ikke finnest i samlinga,
	 * skjer ingenting med samilingen
	 *
	 * @param kort
	 *            kortet som skal fjernast. Dersom kortet ikke finnes, skjer
	 *            ingenting.
	 * @return true om kortet blev fjernet fra samlinga, false ellers.
	 */

	public boolean fjern(Kort kort) {

		for (int i = 0; i < antall; i++) {
			if (samling[i].equals(kort)) {
				for (int j = i; j < antall - 1; j++) {
					samling[j] = samling[j + 1];
				}
				samling[antall - 1] = null;
				antall--;
				return true;
			}
		}
		return false;
	}
	// Denne metoden har en ytre for-løkke som itererer gjennom samlingen opp til verdien av 'antall'. 
	// Innenfor er det en betingelseskontroll som sammenligner hvert kort i samlingen med det gitte
	// kortet. Hvis et kort i samlingen matcher det gitte kortet, kjøres det ei indre for-løkke. 
	// Denne for-løkken, som starter fra indeksen hvor det matchende kortet ble funnet ('i'). 
	// Den har som mål å "forskyve" alle kortene etter det matchende kortet èn plass til venstre
	// i arrayen. Så forskyves det neste kortet i samlingen til den nåværende posisjonen. 
	// Etter at alle kortene er forskjøvetm settes den siste plassen i samlingen til 'null'. 
	// Så reduseres 'antall' med 1, fordi vi nettopp har fjernet et kort fra samlingen. 
	// Returnerer 'true' for å indikere at kortet ble funnet og fjernet fra samlingen. 
	// Returnerer false hvis for-løkken fullføres uten at et matchende kort ble funnet. 

	/**
	 * Gir kortene som en tabell av samme lengde som antall kort i samlingen
	 *
	 * @return tabell av kort som er i samlingen, der kort skal ha samme rekkefølge
	 *         som i kortsamlinga.
	 */
	public Kort[] getAllekort() {

		Kort[] alleKort = new Kort[antall];
		for (int i = 0; i < antall; i++) {
			alleKort[i] = samling[i];
		}
		return alleKort;
	}
}
// Dette oppretter en ny array av 'Kort'-objekter med størrelsen av 'antall', som er antallet
// faktiske kort i samlingen. Denne nye arrayen vil inneholde de samme kortene som er i samlingen, men vil
// ha størrelsen tilsvarende antall faktiske kort. Så er det en for-løkke som itererer gjennom alle
// plassene i 'samling' opp til 'antall'. Hvert kort blir kopiert fra 'samling', over til den nye 
// 'alleKort'-arrayen. Til slutt returnerer metoden 'alleKort'-arrayen, som nå inneholder alle kortene fra
// samlingen. 
