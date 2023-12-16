-- Aufgabe 1: group by, having
-- a) 
-- Gibt es Personen, welche dieselbe Vereinsfunktion bereits mehr als einmal übernommen haben?
SELECT persid, funkid, COUNT(*) AS "Anzahl Funktionsübernahmen"
FROM funktionsbesetzung
GROUP BY persid, funkid
HAVING COUNT(*) > 1
ORDER BY persid, funkid;
 
-- b)
-- Finden Sie heraus, wie viele Personen einen Mentor haben, ohne den Einsatz der SQL-Konstrukte: JOIN, WHERE und HAVING.
SELECT COUNT(mentorid) AS "Personen mit Mentor"
FROM person;


-- Aufgabe 2: join
-- a)
-- Erstellen Sie eine alphabetisch geordnete Liste aller Personen, welche je an einem Anlass teilgenommen haben. (PersonenID, Name und Vorname)
SELECT DISTINCT p.persid, name, vorname
FROM person p
JOIN teilnehmer t ON p.persid = t.persid
ORDER BY name, vorname;


-- b)
-- Wie a), aber zusätzlich angeben, an wie vielen Anlässen die jeweilige Person teilgenommen hat.
SELECT p.persid, name, vorname, COUNT(*) AS "Anzahl Anlässe"
FROM person p
JOIN teilnehmer t ON p.persid = t.persid
GROUP BY p.persid, name, vorname
ORDER BY name, vorname;

-- c)
-- Erstellen Sie eine alphabetisch geordnete Liste aller Personen und geben Sie für jede Person an, an wievielen Anlässen sie teilgenommen hat.
SELECT p.persid, name, vorname, COUNT(t.persid) AS "Anzahl Anlässe"
FROM person p
LEFT JOIN teilnehmer t ON p.persid = t.persid
GROUP BY p.persid, name, vorname
ORDER BY name, vorname;

-- d)
-- Erstellen Sie eine chronologisch geordnete Liste aller Vereinsanlässe (Anlassbezeichner, Durchführungsort, Durchführungsdatum, Kosten) zusätzlich versehen mit der Summe der für diesen Anlass eingegangenen Spenden - sofern vorhanden.
SELECT a.bezeichner, ort, TO_CHAR(a.datum,'DD.MM.YYYY') AS datum, kosten, SUM(betrag) AS spendensumme
FROM anlass a
LEFT JOIN spende s ON a.anlaid = s.anlaid
GROUP BY a.bezeichner, ort, a.datum, kosten
ORDER BY a.datum;

-- e)
-- Listen Sie alle Anlässe (Bezeichner und Datum) absteigend nach Datum auf und ergänzen Sie diese mit der Angabe des Namens des Organisators des Anlasses. Führen Sie am Ende der Liste alle Personen auf, welche noch an keinem Anlass als Organisator figurierten.
SELECT a.bezeichner, a.datum, p.name, p.vorname
FROM anlass a
RIGHT JOIN person p ON a.orgid = p.persid
ORDER BY NVL(a.datum, TO_DATE('01.01.1900','DD.MM.YYYY')) desc;