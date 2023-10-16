package no.hvl.dat100.prosjekt.kontroll;

import no.hvl.dat100.prosjekt.modell.KortSamling;
import no.hvl.dat100.prosjekt.modell.KortUtils;
import no.hvl.dat100.prosjekt.TODO;
import no.hvl.dat100.prosjekt.kontroll.spill.Spillere;
import no.hvl.dat100.prosjekt.modell.Kort;

/**
 * Abstrakt klasse som implementerer alle metodene i kontrakten (interfacet) ISpiller,
 * bortsett fra nesteHandling(). Dette er grunnen til at klassen er abstrakt.
 * For å lage "virkelige" spillere, må vi arve fra denne klassen og implementere
 * nesteHandling (fra ISpiller).
 * 
 * Klassen har objektvariablene hand (Hand), antalltrekk (heltall) og spiller
 * (Spillere). Den har to konstruktører. Se beskrivelse av disse.
 * 
 */
public abstract class Spiller implements ISpiller {

	// hand for spilleren (samling)
	private KortSamling hand; 
	
	// antall trekk spilleren har gjort fra fra-bunken
	private int antalltrekk; 
	
	// hvem spilleren er (Nord,Syd,Ingen) - se oppramsklassen Spillere
	private Spillere spiller;

	/**
	 * Standard konstruktør som oppretter en Spiller med en hånd uten kort,
	 * antalltrekk som 0 og setter spiller til Spillere.INGEN.
	 */
	public Spiller() {
		hand = new KortSamling();
        antalltrekk = 0;
        spiller = Spillere.INGEN;
	}
	// Jeg oppretter en ny tom 'KortSamling' for spillerens hånd. Så setter jeg antall
	// trekk lik 0, og setter spillerens identitet til 'INGEN'. 

	/**
	 * Konstruktør der vi kan sette hvilken spiller det er (NORD, SYD eller
	 * INGEN).
	 * 
	 * @param spiller
	 *            hvilken spiller det er.
	 */
	public Spiller(Spillere spiller) {
		
		hand = new KortSamling();
        antalltrekk = 0;
        this.spiller = spiller;
	}
	// Her oppretter jeg en ny tom 'KortSamling' for spillerens hånd. Deretter setter
	// jeg antall trekk lik 0, og setter spillerens identitet til den gitte parameteren. 

	public int getAntallKort() {
		
		return hand.getAntalKort();
	}
	// Returnerer antallet kort i spillerens hånd ved å kalle metoden 'getAntalKort'
	// fra objektet 'hand'. 

	public KortSamling getHand() {
		
		return hand;
	}
	// Her returnerer jeg spillerens hånd. 

	public int getAntallTrekk() {
		
		return antalltrekk;
	}
	// Her returnerer jeg verdien av 'antallTrekk'. 

	public Spillere hvem() {
		
		return spiller;
		
	}
	// Her returnerer jeg spillerens identitet. 

	public void setAntallTrekk(int t) {
		
		antalltrekk = t;	
		}
	// Her oppdaterer jeg 'antallTrekk' med gitt verdi 't'. 

	public boolean erFerdig() {
		
		return hand.erTom();
		
	}
	// Her sjekker jeg om spillerens hånd er tom, ved å returnere 'true' eller 'false'. 

	public void leggTilKort(Kort kort) {
		
		hand.leggTil(kort);
		
	}
	// Her legger jeg til 'Kort' i spillerens hånd. 

	public void fjernKort(Kort kort) {
		
		hand.fjern(kort);
		
	}
	// Her fjerner jeg 'Kort' fra spillerens hånd. 

	public void fjernAlleKort() {
		
		hand.fjernAlle();
	}
	// Her fjerner jeg alle 'Kort' fra spillerens hånd. 

	public void trekker(Kort kort) {
		
		leggTilKort(kort);
		antalltrekk ++;
	}

}
// Her legger jeg til 'Kort' i spillerens hånd, og øker 'antallTrekk' med 1. 