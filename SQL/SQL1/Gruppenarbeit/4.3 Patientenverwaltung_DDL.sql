CREATE TABLE Mitarbeiter (
  Mitarrbeiter_ID NUMBER(8) PRIMARY KEY,
  Name VARCHAR2(20) NOT NULL,
  Vorname VARCHAR2(20) NOT NULL,
  Beruf_ID NUMBER(8) NOT NULL,
  CONSTRAINT fk_beruf_to_mitarbeiter FOREIGN KEY (Beruf_ID) REFERENCES Beruf (Beruf_ID)
);

CREATE TABLE Beruf (
  Beruf_ID NUMBER(8) PRIMARY KEY,
  Bezeichnung VARCHAR2(100) NOT NULL
);

CREATE TABLE Patient (
  Patienten_ID NUMBER(8) PRIMARY KEY,
  Name VARCHAR2(20) NOT NULL,
  Vorname VARCHAR2(20) NOT NULL,
  KrankenkasseNummer VARCHAR2(20) NOT NULL,
  Arzt_ID NUMBER(8) NOT NULL,
  CONSTRAINT fk_arzt_to_patient FOREIGN KEY (Arzt_ID) REFERENCES Arzt (Arzt_ID)
);

CREATE TABLE Arzt (
  Arzt_ID NUMBER(8) PRIMARY KEY,
  Mitarrbeiter_ID NUMBER(8) NOT NULL,
  Beruf_ID NUMBER(8) NOT NULL,
  CONSTRAINT fk_mitarbeiter_to_arzt FOREIGN KEY (Mitarrbeiter_ID) REFERENCES Mitarbeiter (Mitarrbeiter_ID),
  CONSTRAINT fk_beruf_to_arzt FOREIGN KEY (Beruf_ID) REFERENCES Beruf (Beruf_ID)
);

CREATE TABLE Termin (
  Termin_ID NUMBER(8) PRIMARY KEY,
  Datum DATE NOT NULL,
  Zeit TIME NOT NULL,
  Arzt_ID NUMBER(8) NOT NULL,
  Patienten_ID NUMBER(8) NOT NULL,
  CONSTRAINT fk_arzt_to_termin FOREIGN KEY (Arzt_ID) REFERENCES Arzt (Arzt_ID),
  CONSTRAINT fk_patient_to_termin FOREIGN KEY (Patienten_ID) REFERENCES Patient (Patienten_ID)
);

CREATE TABLE Krankenakte (
  Krankenakte_ID NUMBER(8) PRIMARY KEY,
  Patienten_ID NUMBER(8) NOT NULL,
  Inhalt CLOB,
  CONSTRAINT fk_patient_to_krankenakte FOREIGN KEY (Patienten_ID) REFERENCES Patient (Patienten_ID)
);