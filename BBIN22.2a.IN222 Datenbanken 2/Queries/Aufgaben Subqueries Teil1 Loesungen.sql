-- Aufgabe 1: Mit Unterabfragen die genau einen Wert liefern
-- a) 
-- Gib Sie alle Personen aus, die am gleichen Ort mit der gleichen PLZ wohnen wie die Person 2.
SELECT name, vorname, plz, ort
FROM person
WHERE (ort, plz) = (SELECT ort, plz FROM person WHERE persid =2);

-- b)
-- Welcher Sponsor (Name, Adresse) hat bis heute am meisten spendiert und wieviel?
-- Beachte:
-- 1. Setze auf die Spalte SPENDENTOTAL auf der Tabelle SPONSOR, um die Komplexität des Queries möglichst gering zu halten.
-- 2. Schreibe das Query so, damit auch mehrere Sponsoren aufgeführt würden, falls mehrere gleich viel gespendet haben. (Setze also auf ein Subquery anstelle von FETCH FIRST)
SELECT name, strasse_nr, plz, ort, spendentotal
FROM sponsor
WHERE spendentotal =( SELECT MAX(spendentotal) FROM sponsor );
 
-- c)
-- Von welchem Sponsor (Name) stammt die grösste Einzelspende (Datum und Betrag)?
-- Beachte: Schreibe das Query so, damit auch mehrere Spenden aufgeführt würden, falls mehrere gleich viel gespendet haben. (Setze also auf ein Subquery anstelle von FETCH FIRST)
SELECT name, TO_CHAR(datum, 'DD.MM.YY') datum, betrag
FROM sponsor
JOIN spende ON sponsor.sponid = spende.sponid
WHERE betrag >= ( SELECT MAX(betrag) FROM spende );

-- Aufgabe 2 - Knacknüsse Fortgeschrittene: Mit Unterabfragen die eine Tabelle liefern
-- a)
-- Welcher Anlass hat am meisten registrierte Teilnehmer und wie viele?
-- (Verschachtelte Subqueries oder verschachtelte Aggregatsfunktionen notwendig, um es mit dem bisher gelernten erledigen zu können. Später werden wir den Befehl ALL kennen lernen, um dieses Problem mit einem Subquery zu lösen.)
SELECT anlaid, COUNT(*) AS teilnehmerzahl
FROM teilnehmer
GROUP BY anlaid
HAVING COUNT(*) =
  (SELECT MAX(teilnehmerzahl)
   FROM (SELECT COUNT(*) AS teilnehmerzahl
         FROM teilnehmer
         GROUP BY anlaid));

SELECT t.anlaid, COUNT(*) teilnehmerzahl
FROM teilnehmer t
GROUP BY t.anlaid
HAVING COUNT(*) =
  (SELECT MAX(COUNT(*)) maxteil
   FROM teilnehmer t2
   GROUP BY t2.anlaid);

-- b)
-- Wie a), aber mit Bezeichner, Ort und Datum des Anlasses anstelle der AnlassID.
SELECT bezeichner, ort, TO_CHAR(datum, 'DD.MM.YY') datum,
       COUNT(*) AS teilnehmerzahl
FROM anlass a
JOIN teilnehmer t ON a.anlaid = t.anlaid
GROUP BY a.anlaid, bezeichner, ort, datum
HAVING COUNT(*) =
  (SELECT MAX(teilnehmerzahl)
   FROM (SELECT COUNT(*) AS teilnehmerzahl
         FROM teilnehmer
         GROUP BY anlaid));