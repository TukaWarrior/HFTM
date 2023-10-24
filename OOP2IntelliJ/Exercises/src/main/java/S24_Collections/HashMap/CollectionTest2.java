package S24_Collections.HashMap;

import java.util.HashMap;
public class CollectionTest2 {
    public static void main(String[] args) {

        HashMap<Integer, String> fussballer = new HashMap<>();

//        Initialisiere eine HashMap fussballer in welcher die Rückennummer der Spieler als Key fungiert. Als Wert soll der Name des Fussballspielers gepflegt werden können.
        fussballer.put(1, "Messi");
        fussballer.put(2, "Ronaldo");
        fussballer.put(3, "Neymar");
        fussballer.put(4, "Lewandowski");

//         Gib die Anzahl an Elemente in fussballer auf der Konsole aus.
        System.out.println("Anzahl Fusballer " + fussballer.size());

//        Füge einen weiteren Spieler in der Liste hinzu, der eine bereits verwendete Rückennummer hat und gib die Anzahl an Spieler erneut auf die Konsole aus
        fussballer.put(4, "Mbappe");

        System.out.println("Anzahl Fusballer " + fussballer.size());

//        Suche über die Rückennummer eines Spielers nach eine Spielernamen und gib diesen auf die Konsole aus.
        String namen = fussballer.get(4);
        System.out.println(namen);
    }
}
