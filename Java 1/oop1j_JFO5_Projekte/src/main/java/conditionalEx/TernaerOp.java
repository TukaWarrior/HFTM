package conditionalEx;

public class TernaerOp {

    public static void main(String[] args) {

        int x = 4, y = 9;
        // if (y / x < 3) {
        // x += y;
        // } else {
        // x *= y;
        // }
        // System.out.println("Nach der Anweisung ist x = " + x);

        // Verwende den ternären Operator, um die gleiche Logik noch einmal zu
        // implementieren.
        x = ((y / x) < 3) ? (x += y) : (x *= y);
        System.out.println("nach der Anweisung ist x = " + x);
    }
}