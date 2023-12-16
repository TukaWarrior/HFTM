-- Aufgaben Gemischte Aufgaben Teil 1 (Group, Join, Subqueries)
-- a) 
-- Erstellen Sie eine Liste der Anlässe (AnlassID, Bezeichner, Ort, Datum) mit einem zusätzlichen Vermerk
-- bezüglich Kosten:
-- "ohne", falls für diesen Anlass keine Kosten vermerkt sind
-- "gedeckt", falls die Kosten durch Spenden gedeckt sind
-- "Defizit", falls keine oder nicht genügend Spenden eingegangen sind
SELECT anlaid, bezeichner, ort, datum, 'ohne' AS kosten
FROM anlass
WHERE kosten IS NULL
  UNION
SELECT anlaid, bezeichner, ort, datum, 'gedeckt'
FROM anlass a
WHERE kosten <=
 (SELECT COALESCE(SUM(betrag),0)
  FROM spende s
  WHERE s.anlaid = a.anlaid )
  UNION
SELECT anlaid, bezeichner, ort, datum, 'Defizit'
FROM anlass a
WHERE kosten >
 (SELECT COALESCE(SUM(betrag),0)
  FROM spende s
  WHERE s.anlaid = a.anlaid )
ORDER BY 1;

-- b)
-- Erstellen Sie eine Liste aller Funktionen (Bezeichner), versehen mit der Bemerkung "besetzt" bzw.
-- "vakant", entsprechend dem Zustand per Ende 2028.
SELECT f.bezeichner, 'besetzt' bemerkung
FROM funktion f
WHERE funkid IN (
    SELECT funkid
    FROM Funktionsbesetzung fb
    WHERE (fb.ruecktritt IS NULL OR fb.ruecktritt > to_date('31.12.2028','DD.MM.YYYY'))
    AND fb.antritt < to_date('31.12.2028','DD.MM.YYYY')
)
  UNION ALL
SELECT f.bezeichner, 'vakant' bemerkung
FROM funktion f
WHERE funkid NOT IN (
    SELECT funkid
    FROM Funktionsbesetzung fb
    WHERE (fb.ruecktritt IS NULL OR fb.ruecktritt > to_date('31.12.2028','DD.MM.YYYY'))
    AND fb.antritt < to_date('31.12.2028','DD.MM.YYYY')
);