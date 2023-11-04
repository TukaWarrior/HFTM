DROP TABLE Student;
DROP TABLE Klasse;

CREATE TABLE Klasse(
    KlassenID CHAR(4) NOT NULL PRIMARY KEY,
    Eintrittsdatum DATE NOT NULL
);

CREATE TABLE Student(
    StudentenID CHAR(4) NOT NULL PRIMARY KEY,
    Name VARCHAR2(20) NOT NULL,
    Vorname VARCHAR2(20) NOT NULL,
    Geschlecht CHAR(1) NOT NULL,
    Absenzen NUMBER(4) NULL,
    KlassenID CHAR(4) NOT NULL,
    FOREIGN KEY (KlassenID) REFERENCES Klasse(KlassenID)
    -- KlassenID CHAR(4) NOT NULL CONSTRAINT FK_Student_Klasse REFERENCES Klasse
    -- PRIMARY KEY (StudentenID)
);

ALTER TABLE Student ADD CONSTRAINT Chk_Geschlecht CHECK (Geschlecht IN ('m','w'));