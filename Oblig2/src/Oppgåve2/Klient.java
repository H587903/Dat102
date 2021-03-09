package Oppgåve2;

public class Klient {

	public static void main(String[] args) {
		int e1 = 1;
		int e2 = 2;
		int e3 = 3;
		int e4 = 4;
		int e5 = 5;
		int e6 = 6;
		int e7 = 7;
		
		Dobbelkjedetliste<Integer> list = new Dobbelkjedetliste<Integer>(-1, 100000);
		list.leggTil(e1);
		list.leggTil(e2);
		list.leggTil(e3);
		list.leggTil(e5);
		list.leggTil(e7);
		list.leggTil(e6);
		list.leggTil(e4);
		
		list.visListe();
		System.out.println();
		
		System.out.println(list.fins(e5));
		System.out.println(list.fins(e6));
		System.out.println(list.fins(e1));
		
		System.out.println();
		
		list.fjern(e1);
		list.fjern(e7);
		list.fjern(e4);
		
		list.visListe();
		System.out.println();
		
		System.out.println(list.fins(e5));
		System.out.println(list.fins(e6));
		System.out.println(list.fins(e1));
	}
}
