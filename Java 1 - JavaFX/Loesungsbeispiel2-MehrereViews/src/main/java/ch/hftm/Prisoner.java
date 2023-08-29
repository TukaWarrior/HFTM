package ch.hftm;
import javafx.beans.property.SimpleStringProperty;

public class Prisoner {
    private SimpleStringProperty lastname = new SimpleStringProperty();
    private SimpleStringProperty firstname = new SimpleStringProperty();

    public Prisoner(String lastname, String firstname) {
        this.setLastname(lastname);
        this.setFirstname(firstname);
    }

    public SimpleStringProperty lastnameProperty() {
        return this.lastname;
    }
    public String getLastname() {
        return lastname.get();
    }
    public void setLastname(String lastname) {
        this.lastname.set(lastname);
    }

    public SimpleStringProperty firstnameProperty() {
        return this.firstname;
    }
    public String getFirstname() {
        return firstname.get();
    }
    public void setFirstname(String firstname) {
        this.firstname.set(firstname);
    }
}