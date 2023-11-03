-- Aufgabe 1: Mit Unterabfragen die genau einen Wert liefern
-- a)

-- Gib Sie alle Personen aus, die am gleichen Ort mit der gleichen PLZ wohnen wie die Person 2.
-- NAME                 VORNAME         PLZ  ORT
-- -------------------- --------------- ---- --------------------
-- Wendel               Otto            4500 Solothurn
-- Cadola               Leo             4500 Solothurn

SELECT P.Name, P.Vorname, P.PLZ, P.ORT
FROM Person P
WHERE (P.Ort, P.PLZ) = 
(SELECT P.Ort, P.PLZ FROM Person P WHERE P.PersID ='2');


-- Aufgabe 1: Mit Unterabfragen die genau einen Wert liefern
-- b)

-- Welcher Sponsor (Name, Adresse) hat bis heute am meisten spendiert und wieviel?
-- Beachte:
-- 1. Setze auf die Spalte SPENDENTOTAL auf der Tabelle SPONSOR, um die Komplexität des Queries möglichst gering zu halten.
-- 2. Schreibe das Query so, damit auch mehrere Sponsoren aufgeführt würden, falls mehrere gleich viel gespendet haben. (Setze also auf ein Subquery anstelle von FETCH FIRST)
-- NAME                 STRASSE_NR           PLZ  ORT                  SPENDENTOTAL
-- -------------------- -------------------- ---- -------------------- ------------
-- Pauker Druck         Solothurnstr. 19     2544 Bettlach                     2750

SELECT Name, Strasse_NR, PLZ, Ort, Spendentotal
FROM Sponsor
WHERE Spendentotal = ( SELECT MAX(Spendentotal)
FROM Sponsor );


SELECT SPON.NAME, SPON.STRASSE_NR, SPON.PLZ, SPON.ORT, SPON.SPENDENTOTAL
FROM SPONSOR SPON
WHERE SPON.SPENDENTOTAL >= ALL (SELECT SPENDENTOTAL FROM SPONSOR);

-- Aufgabe 1: Mit Unterabfragen die genau einen Wert liefern
-- c)
-- Von welchem Sponsor (Name) stammt die grösste Einzelspende (Datum und Betrag)?
-- Beachte: Schreibe das Query so, damit auch mehrere Spenden aufgeführt würden, falls mehrere gleich viel gespendet haben. (Setze also auf ein Subquery anstelle von FETCH FIRST)
-- NAME                 DATUM        BETRAG
-- -------------------- -------- ----------
-- Pauker Druck         13.04.05        750


SELECT Spon.Name, Spen.Datum, Spen.Betrag
FROM Sponsor Spon
JOIN Spende Spen ON Spon.SponID = Spen.SponID
WHERE Spen.Betrag >= (SELECT MAX(Spen.Betrag) FROM Spende);

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