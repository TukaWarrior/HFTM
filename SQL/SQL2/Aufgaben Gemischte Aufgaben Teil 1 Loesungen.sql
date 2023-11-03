-- Aufgaben Gemischte Aufgaben Teil 1 (Group, Join, Subqueries)
-- a) 
-- Welche Personen waren zum Zeitpunkt der letzten GV (Anlass-ID 7) einer Funktion zugeordnet.
-- – Version 1 (mit Join und über Anlass-ID)
SELECT p.name, p.vorname, f.bezeichner funktion
FROM anlass a
JOIN funktionsbesetzung fb ON a.datum BETWEEN fb.antritt AND fb.RUECKTRITT
  OR (fb.antritt <= a.datum AND fb.ruecktritt is null)
JOIN person p ON fb.persid = p.persid
JOIN funktion f ON fb.funkid = f.funkid
WHERE a.anlaid = 7;

-- Version 2 (Mit zwei Subqueries für letzte GV)
SELECT p.name, p.vorname, f.bezeichner funktion
FROM funktionsbesetzung fb
JOIN person p ON fb.persid = p.persid
JOIN funktion f ON fb.funkid = f.funkid
WHERE (SELECT max(datum) from anlass WHERE bezeichner='GV')
        between fb.antritt and fb.ruecktritt
OR (fb.ruecktritt is null and
      fb.antritt <= (SELECT max(datum) from anlass WHERE bezeichner='GV'));

-- b)
-- Ermitteln Sie - unter Angabe von Durchführungsdatum, Anlassbezeichnung, Durchführungsort und Organisator - die drei zuletzt durchgeführten Anlässe.
-- Ordnen Sie die Ausgabe chronologisch nach dem Durchführungsdatum.
SELECT TO_CHAR(a.datum,'DD-MON-YYYY') AS datum, bezeichner AS anlass,
       a.ort, name || ' ' || vorname AS organisator
FROM anlass a
JOIN person p ON a.orgid = p.persid
WHERE 3 > ( SELECT COUNT(*)
            FROM anlass
            WHERE datum > a.datum)
ORDER BY a.datum;

-- Oder WHERE-Klause mit FETCH FIRST:^
SELECT TO_CHAR(a.datum,'DD-MON-YYYY') AS datum, bezeichner AS anlass,
       a.ort, name || ' ' || vorname AS organisator
FROM anlass a
JOIN person p ON a.orgid = p.persid
WHERE a.anlaid IN (
          SELECT anlaid
          FROM anlass
          ORDER BY datum desc
          FETCH FIRST 3 ROWS ONLY)
ORDER BY a.datum;