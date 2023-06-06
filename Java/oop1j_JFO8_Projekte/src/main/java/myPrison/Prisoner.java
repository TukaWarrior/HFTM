package myPrison;

// import java.sql.Date;

public class Prisoner {

    // Fields
    private int _prisonerID;
    private String _prisonerName;

    private static int nextID = 1;
    
    // Constructors
    public Prisoner(String name) {
        this._prisonerID = nextID;
        this._prisonerName = name;
        nextID++;
    }

    // Getters
    public int getPrisonerID() {
        return _prisonerID;
    }

    public String getPrisonerName(){
            return _prisonerName;
    }

    public void showPrisonerID(){
        System.out.println("Prisoner ID: " + _prisonerID);
    }

    public void showPrisonerName(){
        System.out.println("Prisoner ID: " + _prisonerName);
    }
}
