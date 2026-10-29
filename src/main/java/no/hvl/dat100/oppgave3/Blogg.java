package no.hvl.dat100.oppgave3;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.*;

public class Blogg {

	Innlegg[] innleggtabell;
	int nesteledig;

	public Blogg() {
		
		innleggtabell = new Innlegg[20];
		nesteledig = 0;

	}

	public Blogg(int lengde) {
		
		innleggtabell = new Innlegg[lengde];
		nesteledig = 0;

	}

	public int getAntall() {
		
		int antall = 0;
		for (int i = 0; i < innleggtabell.length; i++) {
			if (innleggtabell[i] != null) {
				antall++;
			}
		}

		return antall;

	}
	
	public Innlegg[] getSamling() {
		
		return innleggtabell;

	}
	
	public int finnInnlegg(Innlegg innlegg) {

		for (int i = 0; i < innleggtabell.length; i++) {
			if (innleggtabell[i] != null && innleggtabell[i].erLik(innlegg)) {
				return i;
			}
		}

		return -1;
	}

	public boolean finnes(Innlegg innlegg) {
		
		for (Innlegg i : innleggtabell) {
			if (i != null && i.erLik(innlegg)) {
				return true;
			}
		}

		return false;

	}

	public boolean ledigPlass() {
		
		for (Innlegg i : innleggtabell) {
			if (i == null) {
				return true;
			}
		}

		return false;

	}
	
	public boolean leggTil(Innlegg innlegg) {

		if (finnes(innlegg)) {
			return false;
		} else if (ledigPlass()) {
			innleggtabell[nesteledig] = innlegg;
			nesteledig++;
			return true;
		} else {
			return false;
		}

	}
	
	public String toString() {
		
		String str = getAntall() + "\n";
		for (Innlegg i : innleggtabell) {
			if (i != null) {
				str += i.toString();
			}
		}

		return str;

	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		
		Innlegg[] nyInnleggtabell = new Innlegg[innleggtabell.length * 2];
		int neste = 0;
		for (Innlegg i : innleggtabell) {
			if (i != null) {
				nyInnleggtabell[neste] = i;
				neste++;
			}
		}

		innleggtabell = nyInnleggtabell;
		nesteledig = getAntall();

	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {

		if (leggTil(innlegg)) {
			return true;
		} else if (ledigPlass()) {
			return false;
		} else {
			utvid();
			return leggTil(innlegg);
		}
		
	}
	
	public boolean slett(Innlegg innlegg) {
		
		if (finnes(innlegg)) {
			int index = finnInnlegg(innlegg);
			innleggtabell[index] = null;
			return true;
		} else {
			return false;
		}
		
	}
	
	public int[] search(String keyword) {
		
		throw new UnsupportedOperationException(TODO.method());

	}
}