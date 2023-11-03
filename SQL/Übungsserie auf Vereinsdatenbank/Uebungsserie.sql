-- https://www.youtube.com/watch?v=zfgDdLvSHeA&list=PLIeHnQJo3DGMBHWq0JSjjpW8O1Hzzr73D

-- SELERCT
SELECT PersID, Name, Vorname, Strasse_Nr, PLZ, Ort
FROM Person;

-- WHERE, AND, LIKE
SELECT PersID, Name, Vorname, Strasse_Nr, PLZ, Ort
FROM Person
WHERE PLZ ='2540' AND Vorname LIKE'M%';

-- IN, BETWEEN
SELECT PersID, Name, Vorname, Strasse_Nr, PLZ, Ort
FROM Person
WHERE PersID BETWEEN '1' AND '3' 
OR PersID IN('8', '9', '10');

-- NOT, ORDER BY
SELECT PersID, Name, Vorname, Strasse_Nr, PLZ, Ort
FROM Person
WHERE ORT NOT IN('Grenchen', 'Solothurn')
ORDER BY PLZ ASC, Strasse_Nr ASC;

-- COUNT, DISTINCT
SELECT COUNT(DISTINCT(PersID)) AS "Anzahl Sponsorenkontakte"
FROM Sponsorenkontakt;

-- INNER JOIN
SELECT DISTINCT(P.Vorname), P.Name, S.PersID
FROM Person P
RIGHT JOIN Sponsorenkontakt S
ON S.PersID = P.PersID;

-- LEFT JOIN
SELECT P.Vorname, P.Name, S.PersID
FROM Person P
LEFT JOIN Sponsorenkontakt S
ON S.PersID = P.PersID;
 
-- RIGHT JOIN
SELECT P.Vorname, P.Name, S.PersID
FROM Person P
RIGHT JOIN Sponsorenkontakt S
ON S.PersID = P.PersID;

SELECT p.name, p.VORNAME FROM person p
JOIN SPONSORENKONTAKT sk on sk.PERSID = p.PERSID
GROUP BY P.NAME, P.VORNAME;


-- Personen die nie eine Funktionsbesetzung hatten
SELECT P.PersID, P.Name, P.Vorname, F.Antritt, F.Ruecktritt
FROM Person p
LEFT JOIN FUNKTIONSBESETZUNG F
ON P.PersID = F.PersID
WHERE F.Antritt IS NULL;

SELECT P.PERSID, P.NAME, P.VORNAME
FROM PERSON P
WHERE P.PERSID NOT IN(SELECT FB.PERSID FROM FUNKTIONSBESETZUNG FB);

-- Personen mit aktueller Funktionsbesetzung mit Funktionsbezeichnung
SELECT P.PersID, P.Name, P.Vorname, F.Bezeichner
FROM Person P
INNER JOIN Funktionsbesetzung FB
ON P.PersID = FB.PersID
INNER JOIN Funktion F
ON F.FunkID = FB.FunkID
WHERE FB.Ruecktritt IS NULL;


-- Erstellen Sie eine Liste aller Vereinsmitglieder (PersonenID, Name und Vorname), absteigend geordnet nach Name und Vorname. 
-- Zur Erinnerung: Eine Person ist genau dann Vereinsmitglied, wenn sie einen Status hat, dessen Beitragswert nicht leer (NULL) ist.
-- Lösen Sie die Aufgabe einmal mithilfe eines Joins und einmal mithilfe eines Subqueries ohne Join.

SELECT P.PersID, P.Name, P.Vorname, P.StatID, S.Beitrag
FROM Person P
INNER JOIN Status S ON S.StatID = P.StatID
WHERE S.Beitrag IS NOT NULL
ORDER BY P.Name DESC, P.Vorname DESC;


SELECT P.PersID, P.Name, P.Vorname, P.StatID
FROM Person p
WHERE P.StatID IN (SELECT S.StatID FROM Status S WHERE S.BEITRAG IS NOT NULL)
ORDER BY P.Name DESC, P.Vorname DESC;