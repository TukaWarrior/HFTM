-- Aufgabe 1: Mit Unterabfragen die genau einen Wert liefern
-- a)
SELECT Name, Vorname, PLZ, ORT
FROM Person
WHERE (Ort, PLZ) = 
(SELECT Ort, PLZ FROM Person WHERE PersID =2);

-- Aufgabe 1: Mit Unterabfragen die genau einen Wert liefern
-- b)
SELECT Name, Strasse_NR, PLZ, Ort, Spendentotal
FROM Sponsor
WHERE Spendentotal = ( SELECT MAX(Spendentotal)
FROM Sponsor );

-- Aufgabe 1: Mit Unterabfragen die genau einen Wert liefern
-- c)
SELECT Name, Datum, Betrag
FROM Sponsor
JOIN Spende ON Sponsor.SponID = Spende.SponID
WHERE Betrag >= ( SELECT MAX(Betrag)
FROM Spende );


SELECT NAME, VORNAME, PLZ, ORT
FROM PERSON
WHERE (SELECT );

SELECT Name, Vorname, PLZ, ORT
FROM Person
WHERE PLZ = 
(SELECT PLZ FROM Person WHERE PersID =2);