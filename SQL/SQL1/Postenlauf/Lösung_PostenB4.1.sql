--
-- *************************************
-- Lösung zu Arbeitsblatt 4.1, Posten 4 Teil 1
-- *************************************
--
--
-- ==============
-- Tabellen-Drops
-- ==============
--
DROP TABLE Modul;
DROP TABLE Student;
DROP TABLE Klasse;
DROP TABLE studienrichtung;

--
--
-- ======================
-- Erzeugung der Tabellen
-- ======================
--
CREATE
  TABLE Studienrichtung
  (
    RichtungsID  CHAR(2)      CONSTRAINT Studienrichtung_PK PRIMARY KEY,
    Bezeichnung  VARCHAR2(30) NOT NULL
  ) ;

CREATE
  TABLE Klasse
  (
    KlassenID      CHAR(4)   CONSTRAINT Klasse_PK PRIMARY KEY,
    Eintrittsdatum DATE      NOT NULL,
    RichtungsID    CHAR(2)   NOT NULL CONSTRAINT Klasse_Studienrichtung_FK
	                         REFERENCES Studienrichtung
  ) ;

CREATE
  TABLE Student
  (
    StudentenID CHAR(4)       CONSTRAINT Student_PK PRIMARY KEY,
    Name        VARCHAR2(20)  NOT NULL,
    Vorname     VARCHAR2(20)  NOT NULL,
    Geschlecht  CHAR(1)       NOT NULL CONSTRAINT Chk_Geschlecht
	                          CHECK (Geschlecht IN ('m','w')),
    Absenzen    NUMBER (4),
    KlassenID   CHAR (4)      NOT NULL CONSTRAINT Student_Klasse_FK REFERENCES Klasse
  ) ;

CREATE
  TABLE Modul
  (
    ModulID         NUMBER(4)    CONSTRAINT Modul_PK PRIMARY KEY,
    Modulname       VARCHAR2(30) NOT NULL CONSTRAINT unique_modulname UNIQUE,
    Wochenlektionen NUMBER(4)    CONSTRAINT Chk_Wochenlektionen
								 CHECK (Wochenlektionen BETWEEN 2 AND 8),
    Semester        NUMBER(4)    CONSTRAINT Chk_semester CHECK (Semester BETWEEN 1 AND 6),
    RichtungsID     CHAR(2)      NOT NULL CONSTRAINT Modul_Studienrichtung_FK
	                             REFERENCES Studienrichtung ON DELETE CASCADE
  ) ;