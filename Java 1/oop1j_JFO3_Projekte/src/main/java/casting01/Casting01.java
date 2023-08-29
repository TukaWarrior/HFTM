package casting01;

public class Casting01 {
	public static void main(String[] args) {

		// Deklariere und initialisieren einen byte mit einem Wert von 128
		// und beobachte was die IDE macht
		// Byte value1 = 128; Nicht möglich.

		// Deklariere und initialisiere einen short mit einem Wert von 128
		// und gib die Variable als byte aus (mit cast)
		Short value2 = 128;
		System.out.println(value2);

		// Deklariere und initialisieren einen byte mit dem Wert 127
		// Inkrementiere die Variable und gib sie aus
		// Inkrementiere sie erneut und gib sie aus
		Byte value3 = 127;
		System.out.println(value3);
		value3++;
		System.out.println(value3);
		value3++;
		System.out.println(value3);
	}
}