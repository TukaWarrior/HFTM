--
-- *************************************
-- L�sung zu Arbeitsblatt 4.1, Posten 1
-- *************************************
--
--
-- ==============
-- Tabellen-Drops
-- ==============
--
DROP TABLE Studienrichtung;
DROP TABLE Modul;

--
--
-- ======================
-- Erzeugung der Tabellen
-- ======================
--
CREATE
  TABLE Studienrichtung
  (
    RichtungsID  CHAR(2) NOT NULL,
    Bezeichnung  VARCHAR2(30) NOT NULL
  ) ;
  
CREATE
  TABLE Modul
  (
    ModulID         NUMBER(4) NOT NULL,
    Modulname       VARCHAR2(30) NOT NULL,
    Wochenlektionen NUMBER(4),
    Semester        NUMBER(4)
  ) ;