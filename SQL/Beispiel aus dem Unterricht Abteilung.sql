-- @"C:\pfad\beispiel.sql"
PROMPT Tabelle Abteilung wird gelöscht, erstellt und mit Beispiel-Daten befüllt
DROP TABLE abteilung;

CREATE TABLE abteilung (
  id            NUMBER(6) PRIMARY KEY,
  bezeichner    VARCHAR2(30) NOT NULL,
  ort           VARCHAR2(30),
  top_abteilung NUMBER(6)
);

ALTER TABLE abteilung
  ADD CONSTRAINT top_abteilung_fk
  FOREIGN KEY (top_abteilung)  REFERENCES abteilung(id);

INSERT INTO abteilung(id,bezeichner)
  VALUES (1, 'IT');

INSERT INTO abteilung(id,bezeichner,top_abteilung)
  VALUES (2, 'Dev', 1);
  
SELECT * FROM abteilung;