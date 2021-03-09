package Oppgåve1;

public class Rekursjon {
	private int totalDisks;
	private int antall;

	public static int summer(int n) {
		int resultat = 0;
		if (n <= 1) {
			resultat += n;
		} else {
			resultat += n + summer(n - 1);
		}
		return resultat;
	}

	public static int ledd(int n) {
		int resultat = 0;
		if (n < 1) {
			System.out.println(resultat += 2);
		} else if (n == 1) {
			System.out.println(resultat += 5 + ledd(n - 1));
		} else {
			System.out.println(resultat += ((5 * (n - 1)) - (6 * (n - 2)) + 2) + ledd(n - 1));
		}
		return resultat;
	}

	/**
	 * Sets up the puzzle with the specified number of disks.
	 *
	 * @param disks the number of disks
	 */
	public Rekursjon(int disks) {
		this.totalDisks = disks;
		this.antall = 1;
	}

	/**
	 * Performs the initial call to moveTower to solve the puzzle. Moves the disks
	 * from tower 1 to tower 3 using tower 2.
	 */
	public void solve() {
		moveTower(totalDisks, 1, 3, 2);
	}

	private void moveTower(int numDisks, int start, int end, int temp) {
		if (numDisks == 1) {
			antall();
		} else {
			moveTower(numDisks - 1, start, temp, end);
			antall();
			moveTower(numDisks - 1, temp, end, start);
		}
	}

	/**
	 * Prints instructions to move one disk from the specified start tower to the
	 * specified end tower.
	 *
	 * @param start the starting tower
	 * @param end the ending tower
	 */
	private void antall() {
		System.out.println(antall++);
	}
}
