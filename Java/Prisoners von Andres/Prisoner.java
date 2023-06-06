package Prisoners;

public class Prisoner
{
    // Instanzvariablen
    private String name ;
    private int id ;

    // Statische Variablen
    private static int nextid = 1;

    // Konstruktor
    public Prisoner (String name)
    {
        this.name = name;
        this.id = nextid;
        nextid++;   
    }

    // Getter
    public int getid()
    {
        return id;
    } 

    public String getName()
    {
        return name;
    }
}
