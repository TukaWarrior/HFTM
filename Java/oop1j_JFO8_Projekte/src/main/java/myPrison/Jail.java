package myPrison;

public class Jail {

    // Fields
    private int _jailCapacity;
    private int _jailOccupancy;
    private Prisoner[] _jailInmates;

    public Jail(int capacity){
        this._jailCapacity = capacity;
        this._jailOccupancy = 0;
        this._jailInmates = new Prisoner[capacity];
    }

    // Getters
    public int getOccupancy(){
        return _jailOccupancy;
    }

    public Prisoner[] getInmates(){
        return _jailInmates;
    }

    // Methods
    public void addToJail(Prisoner prisoner){
        if (_jailOccupancy < _jailCapacity){
            _jailInmates[prisoner.getPrisonerID()-1] = prisoner;
            _jailOccupancy++;
        }else{
            System.out.println("Jail is full");
        }
    }

    public void showOccupancy(){
        System.out.println("Occupancy of: "+ _jailOccupancy + " of "+ _jailCapacity);
    }
}
