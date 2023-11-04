--
-- *************************************
-- Lösung zu Arbeitsblatt 4.1, Posten 4 Teil 2
-- *************************************
--
--
-- =======================================
-- Einfügen der Studienrichtung-Datensätze
-- =======================================
--
INSERT INTO studienrichtung
       (richtungsid,bezeichnung)
VALUES ('IN','Informatik');

INSERT INTO studienrichtung
       (richtungsid,bezeichnung)
VALUES ('EL','Elektronik');
--
-- ================================
-- Einfügen des Klassen-Datensatzes
-- ================================
--
INSERT INTO klasse
       (klassenid,richtungsid,eintrittsdatum)
VALUES ('I047','IN', DATE '2004-04-22');
--
-- ==================================
-- Einfügen des Studenten-Datensatzes
-- ==================================
--
INSERT INTO student
       (studentenid,klassenid,name,vorname,geschlecht,absenzen)
VALUES ('XX07','I047','Huber','Fritz','m',3);
--
-- ===================
-- Einfügen der Module
-- ===================
--
INSERT INTO modul
       (modulid,richtungsid,modulname,wochenlektionen,semester)
VALUES ('1022','IN','Englisch 2',3,2);

INSERT INTO modul
       (modulid,richtungsid,modulname,wochenlektionen,semester)
VALUES ('5022','IN','Informatik Grundlagen 2',4,2);

INSERT INTO modul
       (modulid,richtungsid,modulname,wochenlektionen,semester)
VALUES ('2002','IN','Mathematik 2',4,2);

INSERT INTO modul
       (modulid,richtungsid,modulname,wochenlektionen,semester)
VALUES ('3021','IN','Projektorganisation',2,2);
-- ================================
-- neue Elektronikklasse definieren
-- ================================
--
INSERT INTO klasse
       (klassenid,richtungsid,eintrittsdatum)
VALUES ('PX05','EL',DATE '2004-05-28');
--
-- ========================
-- Fritz Huber modifizieren
-- ========================
--
UPDATE student
SET klassenid = 'PX05'
WHERE studentenID = 'XX07';
--
-- ===================
-- Module modifizieren
-- ===================
--
UPDATE modul
SET semester = 3
WHERE modulID = '2002';

DELETE FROM modul
WHERE modulID = '3021';
--
--
COMMIT;
--
--
-- ============
-- Testabfragen
-- ============
--
SELECT * FROM studienrichtung;
--
SELECT * FROM klasse;
--
SELECT * FROM student;
--
SELECT * FROM modul;
--