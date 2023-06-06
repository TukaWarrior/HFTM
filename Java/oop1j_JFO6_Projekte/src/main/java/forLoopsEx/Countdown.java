package forLoopsEx;

public class Countdown {

	public static void main(String[] args) {

		System.out.println("Countdown zum Start: ");

		for (int i = 20; i >= 0; i -= 2) {
			System.out.print(i + " ");
		}
		System.out.println("Zündung!");
	}
}