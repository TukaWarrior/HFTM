-- Aufgabe 1: group by, having
-- a)
SELECT SponID, SUM(Betrag) AS "Spendentotal/Sponsor"
FROM Spende
WHERE Betrag > 500
GROUP BY SponID
HAVING SUM(Betrag) > 1000
ORDER BY SponID;

-- Aufgabe 1: group by, having
-- b)
SELECT StatID, COUNT(*) AS "Anzahl Personen"
FROM Person
GROUP BY StatID
HAVING COUNT(*) > 2
ORDER BY StatID;

-- Aufgabe 1: group by, having
-- c)
SELECT SponID, AVG(Betrag) AS "mittlere Spendenhöhe"
FROM Spende
GROUP BY SponID
ORDER BY "mittlere Spendenhöhe" DESC;

-- Aufgabe 2: join
-- a)
SELECT Name, Vorname, Bezeichner, Antritt
FROM person p
JOIN Funktionsbesetzung fi ON p.PersID = fi.PersID
JOIN Funktion f ON fi.FunkID = f.FunkID
WHERE Ruecktritt IS NULL
OR Ruecktritt > SYSDATE
ORDER BY Name, Vorname;


-- Aufgabe 2: join
-- b)
SELECT Sponsor.SponID, Name, 
SUM(Betrag) AS "Spendentotal/Sponsor"
FROM Spende
JOIN Sponsor ON Spende.SponID = Sponsor.SponID
GROUP BY Sponsor.sponID, Name
ORDER BY Sponsor.sponID;

-- Aufgabe 2: join
-- c)
SELECT Name, Vorname, Bezeichner, 
COUNT(*) AS "Anzahl Funktionsübernahmen"
FROM Person p
JOIN Funktionsbesetzung fi ON p.PersID = fi.PersID
JOIN Funktion f ON fi.FunkID = f.FunkID
GROUP BY p.PersID, f.FunkID, Name, Vorname, Bezeichner
HAVING COUNT(*) > 1
ORDER BY p.PersID, f.FunkID;

-- Aufgabe 2: join
-- d)
SELECT Sponsor.SponID, Name, 
SUM(Betrag) AS "Spendentotal"
FROM Spende
JOIN Sponsor ON Spende.SponID = Sponsor.SponID
WHERE Datum >= TO_DATE('01.01.2015','DD.MM.YYYY')
GROUP BY Sponsor.SponID, name
ORDER BY SUM(Betrag) DESC;