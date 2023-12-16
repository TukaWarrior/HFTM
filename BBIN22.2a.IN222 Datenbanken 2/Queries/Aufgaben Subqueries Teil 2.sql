-- Aufgabe a
-- Formulieren Sie die folgenden Abfragen an die Vereinsdatenbank:
-- Zu welchen Anlässen sind keine Teilnehmer registriert?
--    ANLAID     ORGID BEZEICHNER           ORT                  DATUM          KOSTEN
-- --------- --------- -------------------- -------------------- ----------- ---------
--         4         7 Klaushock            Bettlach             06-DEC-2014       150
--         6        10 Turnier              Biel                 28-FEB-2014      1020

SELECT A.AnlaID, A.OrgID, A.Bezeichner, A.Ort, A.Datum, A.Kosten
FROM Anlass A
WHERE AnlaID NOT IN (SELECT AnlaID FROM Teilnehmer);

-- Aufgabe b
-- Wird per Ende 2028 eine Vereinsfunktion nicht besetzt sein? Bestimmen Sie den Funktionsbezeichner sowie das Datum, ab welchem die Funktion nicht mehr besetzt ist.
-- VAKANZ               AB
-- -------------------- -----------
-- PR                   30.11.2028
SELECT F.Bezeichner AS VAKANZ, 


SELECT f.bezeichner AS vakanz, MAX(fi.ruecktritt) AS ab
FROM funktion f
LEFT JOIN funktionsbesetzung fi ON f.funkid = fi.funkid
WHERE f.funkid NOT IN 
      ( SELECT funkid 
        FROM funktionsbesetzung
        WHERE TO_DATE('31.12.2028','DD.MM.YYYY')
              BETWEEN antritt AND
                  NVL(ruecktritt, TO_DATE('01.01.2029','DD.MM.YYYY'))
        )
GROUP BY f.funkid, f.bezeichner;
