--
-- *************************************
-- L�sung zu Arbeitsblatt 4.1, Posten 3
-- *************************************
--
--

-- ================================
-- Einf�gen des Klassen-Datensatzes
-- ================================
--
INSERT INTO klasse
       (klassenid,eintrittsdatum)
VALUES ('I047',DATE '2004-04-22');
--
-- ==================================
-- Einf�gen des Studenten-Datensatzes
-- ==================================
--
INSERT INTO student
       (studentenid,klassenid,name,vorname,geschlecht,absenzen)
VALUES ('XX07','I047','Huber','Fritz','m',3);


COMMIT;

-- ================================
-- neue Elektronikklasse definieren
-- ================================
--
INSERT INTO klasse
       (klassenid,eintrittsdatum)
VALUES ('PX05',DATE '2004-05-28');
--
-- ========================
-- Fritz Huber modifizieren
-- ========================
--
UPDATE student
SET klassenid = 'PX05'
WHERE studentenID = 'XX07';

COMMIT;

-- ========================
-- Klasse entfernen
-- ========================
--
DELETE FROM klasse
WHERE klassenid = 'I047';
--
--

ROLLBACK;
--
--
-- ============
-- Testabfragen
-- ============
--
SELECT * FROM klasse;
--
SELECT * FROM student;