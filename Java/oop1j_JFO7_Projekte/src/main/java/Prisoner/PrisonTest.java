package Prisoner;

public class PrisonTest {
    public static void main(String[] args) {
        Cell cell1 = new Cell("Cell-1", false, "1234");

        Prisoner bubba = new Prisoner("Bubba", 2.08, 4, cell1);
        Prisoner twitch = new Prisoner("Twitch", 1.7, 1, cell1);

        bubba.display();
        cell1.openDoor("1111");
        bubba.display();
        cell1.openDoor("1234");
        bubba.display();

        twitch.display(true);
    }
}