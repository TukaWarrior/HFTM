
-- Fragt nach den Namen und Berufen der Ärzte.
SELECT m.Name, m.Vorname, b.Bezeichnung AS Beruf
FROM Mitarbeiter m
JOIN Arzt a ON m.Mitarrbeiter_ID = a.Mitarrbeiter_ID
JOIN Beruf b ON a.Beruf_ID = b.Beruf_ID;

-- Fragt den Termin für einen bestimmten Patienten.
SELECT t.Termin_ID, t.Datum, t.Zeit, a.Arzt_ID, a.Name AS Arzt_Name, a.Vorname AS Arzt_Vorname
FROM Termin t
JOIN Arzt a ON t.Arzt_ID = a.Arzt_ID
WHERE t.Patienten_ID = 1;

-- Fragt nach den Patienten die von einem bestimmten Arzt behandelt werden.
SELECT p.Name, p.Vorname, a.Arzt_ID
FROM Patient p
JOIN Arzt a ON p.Arzt_ID = a.Arzt_ID
WHERE a.Arzt_ID = 1;

-- Fragt nach einer bestimmten Krankenakte eines bestimmten Patienten.
SELECT Inhalt
FROM Krankenakte
WHERE Patienten_ID = 2;
