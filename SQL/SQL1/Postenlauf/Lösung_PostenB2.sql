--
-- *************************************
-- L�sung zu Arbeitsblatt 4.1, Posten 2
-- *************************************
--
--
-- ==============
-- Tabellen-Drops
-- ==============
--
DROP TABLE Student;
DROP TABLE Klasse;

--
--
-- ======================
-- Erzeugung der Tabellen
-- ======================
--
CREATE
  TABLE Klasse
  (
    KlassenID      CHAR(4)   CONSTRAINT Klasse_PK PRIMARY KEY,
    Eintrittsdatum DATE      NOT NULL
  ) ;

CREATE
  TABLE Student
  (
    StudentenID CHAR(4)       CONSTRAINT Student_PK PRIMARY KEY,
    Name        VARCHAR2(20)  NOT NULL,
    Vorname     VARCHAR2(20)  NOT NULL,
    Geschlecht  CHAR(1)       NOT NULL,
    Absenzen    NUMBER (4),
    KlassenID   CHAR (4)      NOT NULL CONSTRAINT Student_Klasse_FK REFERENCES Klasse
  ) ;

--
-- ======================
-- Nachtr�glicher Constraint
-- ======================
--
ALTER TABLE Student ADD CONSTRAINT Chk_Geschlecht CHECK (Geschlecht IN ('m','w'));