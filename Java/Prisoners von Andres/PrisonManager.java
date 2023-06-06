package Prisoners;

public class PrisonManager
{
    public static void main(String[] args)
    {
        Prisoner p1 = new Prisoner("Adriana");
        Prisoner p2 = new Prisoner("Andres");
        Prisoner p3 = new Prisoner("Nicola");
        Prisoner p4 = new Prisoner("Richard");

        Jail HFTM = new Jail(8);
        HFTM.addInmateJail(p1);
        HFTM.addInmateJail(p2);
        HFTM.addInmateJail(p3);
        HFTM.addInmateJail(p4);

        // HFTM.showCurrentOccupancy(); // Belegung ausgeben
        // HFTM.removeInmateJail(p1); // Insasse entfernen
        // HFTM.showCurrentOccupancy(); // neue Belegung ausgeben
    }
}