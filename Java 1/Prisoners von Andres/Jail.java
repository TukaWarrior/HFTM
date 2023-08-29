package Prisoners;

public class Jail
{
    // Instanzvariablen
    private int maxPrisonerCount;
    private Prisoner[] _jailInmates;
    private int currantOccupancy;

    // Konstruktor
    public Jail(int maxPrisonerCount)
    {
        this.maxPrisonerCount = maxPrisonerCount;
        this._jailInmates = new Prisoner[maxPrisonerCount];
        this.currantOccupancy = 0;
    }

    // Getter
    public int getCurrantOccupancy()
    {
        return currantOccupancy;
    }

    public Prisoner[] getCurrentPrisoners()
    {
        return _jailInmates;
    }

    // Methoden
    public void addInmateJail(Prisoner prisoner){
        if (currantOccupancy == this.maxPrisonerCount)
        {
            System.out.println("Full");
        }else{
            _jailInmates[prisoner.getid()-1] = prisoner;
            currantOccupancy++;
            System.out.println(prisoner.getName() + " erfolgreich eingebuchtet!");
        }
    }

    // public void removeInmateJail(Prisoner prisoner)
    // {
    //     for (int i = 0; i < _jailInmates.length; i++)
    //     {
    //         if (_jailInmates[i] != null && _jailInmates[i].equals(prisoner))
    //         {
    //             _jailInmates[i] = null;
    //             currantOccupancy--;
    //         }
    //     }
    // }

    // public void showCurrentOccupancy()
    // {
    //     System.out.println("---------------------------");
    //     System.out.println();
    //     System.out.println("Gefängniskapazität: " + this.maxPrisonerCount);
    //     System.out.println("Anzahl Insassen: " + getCurrantOccupancy());
    //     System.out.println();
    //     System.out.println("Aktuelle Insassen:");

    //     for (Prisoner prisoner : _jailInmates)
    //     {
    //         if (prisoner != null)
    //         {
    //             System.out.println("Name: " + prisoner.getName() + " (Sträflings-Nummer " + prisoner.getid() + ")");
    //         }
    //     }

    //     System.out.println("---------------------------");
    // }
}
