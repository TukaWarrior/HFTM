package myPrison;

public class PrisonManager {
    public static void main(String[] args){

        Prisoner p1 = new Prisoner("Arnold");
        Prisoner p1 = new Prisoner("B");
        Prisoner p2 = new Prisoner("Bert");
        Prisoner p3 = new Prisoner("Carl");

        Jail j1 = new Jail(4);
        j1.addToJail(p1);
        j1.addToJail(p2);
        j1.addToJail(p3);

        p1.showPrisonerID();
        p1.showPrisonerName();
        j1.showOccupancy();
    }
}
