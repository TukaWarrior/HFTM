-- Formulieren Sie die folgenden Abfragen an die Vereinsdatenbank:

-- Erstellen Sie eine Liste der Anlässe (AnlassID, Bezeichner, Ort, Datum) mit einem zusätzlichen Vermerk
-- bezüglich Kosten:
-- "ohne", falls für diesen Anlass keine Kosten vermerkt sind
-- "gedeckt", falls die Kosten durch Spenden gedeckt sind
-- "Defizit", falls keine oder nicht genügend Spenden eingegangen sind
--    ANLAID BEZEICHNER           ORT                  DATUM       KOSTEN
-- --------- -------------------- -------------------- ----------- -------
--         1 GV                   Solothurn            31-MAR-2013 Defizit
--         2 Vorstandssitzung     Grenchen             17-JAN-2014 ohne
--         3 GV                   Bettlach             30-MAR-2013 Defizit
--         4 Klaushock            Bettlach             06-DEC-2014 gedeckt
--         5 Vorstandssitzung     Grenchen             21-JAN-2015 ohne
--         6 Turnier              Biel                 28-FEB-2014 gedeckt
--         7 GV                   Grenchenberg         29-MAR-2015 gedeckt
--         8 Vorstandssitzung     Grenchen             19-JAN-2015 ohne

SELECT ANLAID, BEZEICHNER, ORT, DATUM, 'ohne' 
FROM Anlass
WHERE KOSTEN IS NULL

UNION

SELECT ANLAID, BEZEICHNER, ORT, DATUM, 'gedeckt' AS KOSTEN
FROM Anlass A
WHERE KOSTEN <= COALESCE((SELECT SUM(BETRAG) FROM SPENDE WHERE ANLAID = A.ANLAID), 0)

UNION

SELECT ANLAID, BEZEICHNER, ORT, DATUM, 'Defizit' AS KOSTEN
FROM Anlass A
WHERE KOSTEN > COALESCE((SELECT SUM(BETRAG) FROM SPENDE WHERE ANLAID = A.ANLAID), 0)

ORDER BY ANLAID;

-- Erstellen Sie eine Liste aller Funktionen (Bezeichner), versehen mit der Bemerkung "besetzt" bzw.
-- "vakant", entsprechend dem Zustand per Ende 2028.
-- BEZEICHNER           BEMERKU
-- -------------------- -------
-- Beisitz              besetzt
-- Kasse                besetzt
-- PR                   vakant
-- Präsidium            besetzt
-- Vizepräsidium        besetzt

SELECT BEZEICHNER, 'vakant' 
FROM FUNKTION F
WHERE DATE '2028-01-01' > COALESCE((SELECT RUECKTRITT FROM FUNKTIONSBESETZUNG WHERE FUNKID = F.FUNKID), DATE '2028-01-01')
ORDER BY FUNKID;




SELECT * FROM FUNKTIONSBESETZUNG;