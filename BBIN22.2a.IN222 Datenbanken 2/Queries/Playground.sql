-- Aggregatsfunktionen
-- COUNT()
SELECT COUNT(SpenID) AS "Anzahl Spenden"
FROM Spende;

-- MAX()
SELECT MAX(Betrag) AS "Höchste Spende "
FROM Spende;

-- MIN()
SELECT MIN(Betrag) AS "Kleinste Spende "
FROM Spende;

-- SUM()
SELECT SUM(Betrag) AS "Total aller Spenden"
FROM Spende;

-- AVG()
SELECT AVG(Betrag) AS "Durchschnittliche Spende"
FROM Spende;


-- Operationen
-- JOIN
SELECT P.PersID, P.Name, P.Vorname
FROM Person P
INNER JOIN Sponsorenkontakt SK ON P.PersID = SK.PersID;

-- LEFT JOIN
SELECT P.PersID, P.Name, P.Vorname
FROM Person P
LEFT JOIN Sponsorenkontakt SK ON P.PersID = SK.PersID;

-- RIGHT JOIN
SELECT P.PersID, P.Name, P.Vorname
FROM Person P
RIGHT JOIN Sponsorenkontakt SK ON P.PersID = SK.PersID;

-- FULL OUTER JOIN
SELECT P.PersID, P.Name, P.Vorname
FROM Person P
FULL OUTER JOIN Sponsorenkontakt SK ON P.PersID = SK.PersID;

-- MINUS
SELECT PersID 
FROM Person
MINUS SELECT PersID FROM Person WHERE PersID = 3;

-- DISTINCT
SELECT DISTINCT(Ort)
FROM Anlass;

-- GROUP BY
SELECT COUNT(PersID), Ort
FROM Person
GROUP BY Ort;

-- HAVING
SELECT COUNT(PersID), Ort
FROM Person
GROUP BY Ort
HAVING COUNT(PersID) >= '3';

-- COALESCE
SELECT Bezeichner, Ort, COALESCE(Kosten, 0) AS "Kosten"
FROM Anlass;




































Erstellen Sie eine Liste der Anlässe (AnlassID, Bezeichner, Ort, Datum) mit einem zusätzlichen Vermerk
bezüglich Kosten:
"ohne", falls für diesen Anlass keine Kosten vermerkt sind
"gedeckt", falls die Kosten durch Spenden gedeckt sind
"Defizit", falls keine oder nicht genügend Spenden eingegangen sind
   ANLAID BEZEICHNER           ORT                  DATUM       KOSTEN
--------- -------------------- -------------------- ----------- -------
        1 GV                   Solothurn            31-MAR-2013 Defizit
        2 Vorstandssitzung     Grenchen             17-JAN-2014 ohne
        3 GV                   Bettlach             30-MAR-2013 Defizit
        4 Klaushock            Bettlach             06-DEC-2014 gedeckt
        5 Vorstandssitzung     Grenchen             21-JAN-2015 ohne
        6 Turnier              Biel                 28-FEB-2014 gedeckt
        7 GV                   Grenchenberg         29-MAR-2015 gedeckt
        8 Vorstandssitzung     Grenchen             19-JAN-2015 ohne

----> kommt an prüfung!
ca. 10 minuten / aufgabe an prüfung. 3 aufgaben kommen an prüfung
*/
SELECT ANLAID, BEZEICHNER, ORT, DATUM, 'gedeckt' KOSTEN
FROM ANLASS A
WHERE KOSTEN <= COALESCE((SELECT SUM(BETRAG) FROM SPENDE WHERE ANLAID = A.ANLAID), 0)
    UNION ALL
SELECT ANLAID, BEZEICHNER, ORT, DATUM, 'Defizit' KOSTEN
FROM ANLASS A
WHERE KOSTEN > COALESCE((SELECT SUM(BETRAG) FROM SPENDE WHERE ANLAID = A.ANLAID), 0)
    UNION ALL
SELECT ANLAID, BEZEICHNER, ORT, DATUM, 'ohne' KOSTEN
FROM ANLASS
WHERE KOSTEN IS NULL
ORDER BY ANLAID;