package com.example;

import jakarta.xml.bind.annotation.XmlElement;

import jakarta.xml.bind.annotation.XmlElement;

public class Person {
    private String vorname;
    private String nachname;

    public Person() {
        // Default no-argument constructor for JAXB
    }
    
    public Person(String nachname, String vorname){
        this.vorname = vorname;
        this.nachname = nachname;
    }

    @XmlElement
    public void setNachname(String nachname){
        this.nachname = nachname;
    }

    @XmlElement
    public void setVorname(String vorname){
        this.vorname = vorname;
    }

    @XmlElement
    public String getNachname(){
        return nachname;
    }
    @XmlElement
    public String getVorname(){
        return vorname;
    }
}
