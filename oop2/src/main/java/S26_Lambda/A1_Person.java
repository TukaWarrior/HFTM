package S26_Lambda;

public class A1_Person {
    private String vorname;
    private String nachname;
    private int alter;

    public A1_Person(){
    }

    public A1_Person(String vorname, String nachname, int alter){
        this.vorname = vorname;
        this.nachname = nachname;
        this.alter = alter;
    }

    public void setVorname(String vorname){
        this.vorname = vorname;
    }

    public String getVorname(){
        return this.vorname;
    }

    public void setNachname(String nachname){
         this.nachname = nachname;
    }

    public String getNachname(){
        return this.nachname;
    }

    public void setAlter(int alter){
         this.alter = alter;
    }

    public int getAlter(){
        return this.alter;
    }

    @Override
    public toString (){
        System.out.println(this.vorname, " ", this.nachname, " ", this.alter);
    }

}
