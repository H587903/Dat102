package Oppgåve4;

public class Sortering {

	public static <T extends Comparable<T>> void innSettSort(T[] tab) {
		for (int i = 0; i < tab.length; i++) {
			T element = tab[i];
			int pos = i;

			while (pos > 0 && element.compareTo(tab[pos - 1]) < 0) {
				tab[pos] = tab[pos - 1];
				pos--;
			}
			tab[pos] = element;
		}
	}

	public static <T extends Comparable<T>> void utvalgSort(T[] tab) {
		int minst;
		T temp;

		for (int i = 0; i < tab.length - 1; i++) {
			minst = i;
			for (int j = i + 1; j < tab.length; j++) {
				if (tab[j].compareTo(tab[minst]) < 0) {
					minst = j;
				}
			}
			temp = tab[minst];
			tab[minst] = tab[i];
			tab[i] = temp;
		}
	}

	public static <T extends Comparable<T>> void bobleSort(T[] tab) {
		T temp;

		for (int i = tab.length - 1; i >= 0; i--) {
			for (int j = 0; j <= i - 1; j++) {
				if (tab[j].compareTo(tab[j + 1]) > 0) {
					temp = tab[j];
					tab[j] = tab[j + 1];
					tab[j + 1] = temp;
				}
			}
		}
	}
	
	public static <T extends Comparable<T>> void kvikkSort(T[] tab, int min, int max) {
		if (min < max) {
			T temp, pivot;
			int midten = (min + max) / 2;
			pivot = tab[midten];

			temp = tab[midten];
			tab[midten] = tab[min];
			tab[min] = temp;

			int venstre = min + 1;
			int hogre = max;
			while (venstre < hogre) {
				while (venstre < hogre && tab[venstre].compareTo(pivot) <= 0) {
					venstre++;
				}
				while (tab[hogre].compareTo(pivot) > 0) {
					hogre--;
				}

				if (venstre < hogre) {
					temp = tab[venstre];
					tab[venstre] = tab[hogre];
					tab[hogre] = temp;
				}
			}
			temp = tab[min];
			tab[min] = tab[hogre];
			tab[hogre] = temp;
			kvikkSort(tab, min, hogre - 1);
			kvikkSort(tab, hogre + 1, max);
		}
	}
	
	public static <T extends Comparable<T>> void fletteSort(T[] tab, int forste, int siste) {
		if (forste < siste) {
			int midten = (forste + siste) / 2;
			fletteSort(tab, forste, midten);
			fletteSort(tab, midten + 1, siste);
			
			int size = siste - forste + 1;
			T[] hjelp = (T[]) (new Comparable[size]);

			int forsteV = forste;
			int sisteV = midten;
			int forsteH = midten + 1;
			int sisteH = siste;

			int p = 0;

			while (forsteV <= sisteV && forsteH <= sisteH) {
				if (tab[forsteV].compareTo(tab[forsteH]) <= 0) {
					hjelp[p] = tab[forsteV];
					forsteV++;
				} else {
					hjelp[p] = tab[forsteH];
					forsteH++;
				}
				p++;
			}

			while (forsteV <= sisteV) {
				hjelp[p] = tab[forsteV];
				forsteV++;
				p++;
			}

			while (forsteH <= sisteH) {
				hjelp[p] = tab[forsteH];
				forsteH++;
				p++;
			}

			p = 0;
			for (int i = forste; i <= siste; i++) {
				tab[i] = hjelp[p];
				p++;
			}
		}
	}
	
	public static <T extends Comparable<T>> void kvikkSortNy(T[] data) {
		kvikkSortNy(data, 0, data.length -1);
		innSettSort(data);
	} 
	
	public static <T extends Comparable<T>> void kvikkSortNy(T[] tab, int min, int max) {
		final int MIN = 500; //beste funnet, gir stabilt lave retur tider
		if(max - min + 1 > MIN) {
			T temp, pivot;
			int midten = (min + max) / 2;
			pivot = tab[midten];

			temp = tab[midten];
			tab[midten] = tab[min];
			tab[min] = temp;

			int venstre = min + 1;
			int hogre = max;
			while (venstre < hogre) {
				while (venstre < hogre && tab[venstre].compareTo(pivot) <= 0) {
					venstre++;
				}
				while (tab[hogre].compareTo(pivot) > 0) {
					hogre--;
				}

				if (venstre < hogre) {
					temp = tab[venstre];
					tab[venstre] = tab[hogre];
					tab[hogre] = temp;
				}
			}
			temp = tab[min];
			tab[min] = tab[hogre];
			tab[hogre] = temp;
			kvikkSortNy(tab, min, hogre - 1);
			kvikkSortNy(tab, hogre + 1, max);
		}
	}

	public static void main(String[] args) {
		Integer[] tab = new Integer[12000];
		for(int i = 0; i < 12000; i++) {
			tab[i] = i-i+1;
		}
		
//		Integer[] tab = { 7, 3, 1, 9, 2, 4 };
		
		long start = System.currentTimeMillis();
		
//		innSettSort(tab);
//		utvalgSort(tab);
//		bobleSort(tab);
		kvikkSort(tab, 0, tab.length - 1);
//		fletteSort(tab, 0, tab.length - 1);
//		kvikkSortNy(tab, 0, tab.length - 1);

		for (Integer e : tab) {
			System.out.println(e);
		}
		
		long finish = System.currentTimeMillis();
		long timeElapsed = finish - start;
		
		System.out.println();
		
		System.out.println(timeElapsed + "ms");

	}
}
/*
 * Oppgåve 4c
 * 
 * som regel funker det å kjøre kvikksorteringa med 12000 like element,
 * med ei gjennomssnittstid på 130ms.
 * 
 * når kvikksorteringa feiler får vi feilen: stackoverflowerror.
 * grunnen til erroren kan vere fordi programmet meiner det er ein dårlig rekursjon,
 * som vil kjøre uendelig lenge.
 * 
 * fleire antall like element, gir større sjanse får å få feilen.
 */
