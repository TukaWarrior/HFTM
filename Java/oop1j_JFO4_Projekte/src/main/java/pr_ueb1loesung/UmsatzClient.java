package pr_ueb1loesung;

public class UmsatzClient {

	public static void main(String[] args) {
		Leser leser = new Leser();
		String message = leser.gesamtTotal();
		System.out.println(message);
	}

}
