DROP TABLE Studienrichtung;
DROP TABLE Modul;

CREATE TABLE Studienrichtung(
    RichtungsID CHAR(2) NOT NULL,
    Bezeichnung VARCHAR2(30) NOT NULL
);

CREATE TABLE Modul(
    ModulID NUMBER(4) NOT NULL,
    Modulname VARCHAR2(30) NOT NULL,
    Wochenlektionen NUMBER(4) NULL,
    Semester NUMBER(4) NULL
);