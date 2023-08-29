package input04;

import java.util.Scanner;

public class Input04 {
    public static void main(String[] args){
        Scanner sc = new Scanner(Input04.class.getResourceAsStream("input04text.txt"));      
        
        //Editiere die nächsten beiden Zeilen, um den Scanner vorzurücken
        sc.nextLine();
        System.out.println(sc.nextLine());
        
        //Enthält diese Zeile BlueBumper?
        System.out.println(sc.findInLine("BlueBumper"));
        sc.nextLine(); 
        
        //Speichere die nächsten beiden Zahlen als x-Position und y-Position
        //Gib sie aus
        int x = Integer.parseInt(sc.findInLine("90"));
        int y = Integer.parseInt(sc.findInLine("120"));
        
        // int x = sc.nextInt(); <- Teil vom Original Code
        // int y = sc.nextInt(); <- Teil vom Original Code
        System.out.println("X: " + x + ", Y: " +y );
        sc.close();
    }     
}
