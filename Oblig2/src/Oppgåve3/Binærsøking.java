package Oppgåve3;

public class Binærsøking<T extends Comparable<T>> {
	// Oppgåve a
	public int binaersok(T[] tab, int start, int slutt, T element) {
		int FINNES_IKKE = -1;

		if (start > slutt) {
			return FINNES_IKKE;
		}

		int midten = (start + slutt) / 2;
		int resultat = element.compareTo(tab[midten]);

		if (resultat == 0) {
			return midten;
		}

		if (resultat > 0) {
			return binaersok(tab, midten + 1, slutt, element);
		} else {
			return binaersok(tab, start, midten - 1, element);
		}
	}
}

/*
 * Oppgåve b
 * 
 * T[] tab = {2, 4, 5, 7, 8, 10, 12, 15, 18, 21, 23, 27, 29, 30, 31};
 * binaersøk(tab, 0, 14, 8);
 * 
 * midten = (0 + 14) / 2 = 7 Sjekkar basis først(om 8 == tab[midten]) 
 * Sjekker om 8 er Større enn tab[midten] == (false)
 * 
 * binaersok(tab, start, midten - 1, 8) 
 * Metoden vil no bli "kjørt på nytt" i denne halverte tabellen:
 * 
 * T[] tab = {2, 4, 5, 7, 8, 10, 12} 
 * 
 * Metoden blir kjørt om og om igjen til tab[midten] == 8(element)
 * 
 */

/* Oppgåve c
 *
 * T[] tab = {2, 4, 5, 7, 8, 10, 12, 15, 18, 21, 23, 27, 29, 30, 31};
 * binaersøk(tab, 0, 14, 16);
 * 
 * midten = (0 + 14) / 2 = 7 Sjekkar basis først(om 16 == tab[midten])
 * Sjekker om 16 er Større enn tab[midten] == (True)
 *
 */

