package Oppgåve2;

public class Dobbelkjedetliste<T extends Comparable<T>> {
	private Dobbelnode<T> foerste;
	private Dobbelnode<T> siste;
	private int antall;

	public Dobbelkjedetliste(T minVerdi, T maksVerdi) {
		Dobbelnode<T> Node1 = new Dobbelnode<T>(minVerdi);
		this.foerste = Node1;

		Dobbelnode<T> Node2 = new Dobbelnode<T>();
		Node2.setElement(maksVerdi);
		Node1.setNeste(Node2);
		Node2.setForrige(Node1);
		this.siste = Node2;

		this.antall = 0;
	}

	public void leggTil(T ny) {
		Dobbelnode<T> t;

		if (ny.compareTo(foerste.getElement()) <= 0 || ny.compareTo(siste.getElement()) >= 0) {
			System.out.println("Ulovlig verdi!");
		} else {
			antall++;

			t = foerste.getNeste();
			foerste = t.getForrige();

			while (ny.compareTo(t.getElement()) >= 0) {
				t = t.getNeste();
			}

			if (ny.compareTo(t.getElement()) < 0) {
				Dobbelnode<T> nyNode = new Dobbelnode<T>(ny);
				nyNode.setNeste(t);
				nyNode.setForrige(t.getForrige());
				t.getForrige().setNeste(nyNode);
				t.setForrige(nyNode);
			}
		}
	}

	public T fjern(T x) {
		T resultat = null;
		Dobbelnode<T> t;
		boolean funnet = false;

		if (x.compareTo(foerste.getElement()) <= 0 || x.compareTo(siste.getElement()) >= 0) {
			System.out.println("Ulovlig verdi!");
		} else {

			t = foerste.getNeste();
			foerste = t.getForrige();

			while (x.compareTo(t.getElement()) > 0) {
				t = t.getNeste();
			}

			if (x.compareTo(t.getElement()) == 0) {
				funnet = true;
			}

			if (funnet) {
				antall--;

				t.getNeste().setForrige(t.getForrige());
				t.getForrige().setNeste(t.getNeste());
				resultat = t.getElement();
			}
		}

		return resultat;
	}

	public boolean fins(T x) {
		boolean funnet = false;
		Dobbelnode<T> t;

		if (x.compareTo(foerste.getElement()) <= 0 || x.compareTo(siste.getElement()) >= 0) {
			System.out.println("Ulovlig verdi!");
		} else {

			t = foerste.getNeste();
			foerste = t.getForrige();

			while (x.compareTo(t.getElement()) > 0) {
				t = t.getNeste();
			}

			if (x.compareTo(t.getElement()) == 0) {
				funnet = true;
			}
		}

		return funnet;
	}

	public void visListe() {
		Dobbelnode<T> t = foerste;

		while (t != null) {
			System.out.println(t.getElement() + " ");
			t = t.getNeste();
		}
	}
}
