package Oppgåve1;

public class Main {

	public static void main(String[] args) {
		System.out.println(Rekursjon.summer(100));
		System.out.println();
		
		Rekursjon.ledd(10);
		System.out.println();
		
		Rekursjon towers = new Rekursjon(4);
		towers.solve();
		//n = 26, 26 ringer tok 1 minutt + 15 sekund, altså 75 sekund, totalt 67 108 863 flyttinger.
		//n = 27, 27 ringer tok 2 minutt + 35 sekund, altså 155 sekund, totalt 134 217 727 flyttinger.
		//n = 28, 28 ringer tok 5 minutt, altså 300 sekund, totalt 268 435 455 flyttinger.
	}
}
