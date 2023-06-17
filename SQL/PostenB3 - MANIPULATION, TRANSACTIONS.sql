-- Fritz Huber mit der StudentenID XX07 ist in seine Klasse mit der KlassenID I047 
-- am 22.4.04 eingetreten. Fritz hat bis jetzt drei Absenzen.
INSERT INTO Klasse (KlassenID, Eintrittsdatum)
VALUES ('I047', DATE '2004-04-22');

INSERT INTO Student (StudentenID, Name, Vorname, Geschlecht, Absenzen, KlassenID)
VALUES ('XX07', 'Huber', 'Fritz', 'm', 3, 'I047');

-- Fritz Huber wechselt seine Studienrichtung. 
-- Ab sofort gehört er zur Elektronikklasse PX05, welche ihr Studium am 28.5.04 startet. 

INSERT INTO Klasse (KlassenID, Eintrittsdatum)
VALUES ('PX05', DATE '2004-05-28');

UPDATE Student
SET KlassenID = 'PX05'
WHERE StudentenID = 'XX07';

DELETE FROM Klasse
WHERE KlassenID = 'I047';