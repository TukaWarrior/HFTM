DROP TABLE student;
DROP TABLE klasse;
DROP TABLE modul;
DROP TABLE studienrichtung;

CREATE TABLE student(
    studentenid CHAR(4) NOT NULL PRIMARY KEY,
    name VARCHAR2(20) NOT NULL,
    bezeichnung VARCHAR2(30) NOT NULL,
    vorname VARCHAR2(20) NOT NULL,
    geschlecht CHAR(1) NOT NULL CONSTRAINT chk_geschlecht CHECK (geschlecht IN ('m','w')),
    absenzen NUMBER(4) NULL,
    klassenid CHAR(4) NOT NULL
);

CREATE TABLE klasse(
    klassenid CHAR(4) NOT NULL PRIMARY KEY,
    eintrittsdatum DATE NOT NULL,
    richtungsid CHAR(2) NOT NULL
);

CREATE TABLE modul(
    modulid NUMBER(4) NOT NULL PRIMARY KEY,
    modulname VARCHAR2(30) NOT NULL CONSTRAINT chk_modulname UNIQUE,
    wochenlektionen NUMBER(4) NULL CONSTRAINT chk_wochenlektionen CHECK (wochenlektionen BETWEEN 2 AND 8),
    semester NUMBER(4) NULL,
    richtungsid CHAR(2) NOT NULL
);

CREATE TABLE studienrichtung(
    richtungsid CHAR(2) NOT NULL PRIMARY KEY,
    bezeichnung VARCHAR2(30) NOT NULL
);

ALTER TABLE student
ADD FOREIGN KEY (klassenid) REFERENCES klasse(klassenid);

ALTER TABLE klasse
ADD FOREIGN KEY (richtungsid) REFERENCES studienrichtung(richtungsid);

ALTER TABLE modul
ADD FOREIGN KEY (richtungsid) REFERENCES studienrichtung(richtungsid) ON DELETE CASCADE;