-- Aufgabe 1: group by, having
-- a) 
-- Ermitteln Sie das Spendentotal derjenigen Sponsoren, welche gesamthaft mehr als 1000 Fr. gespendet haben. Stellen Sie dabei sicher, dass nur Einzelspenden berücksichtigt werden, deren Betrag höher als 500 Fr. ist.
SELECT sponid, SUM(betrag) AS "Spendentotal/Sponsor"
FROM spende
WHERE betrag > 500
GROUP BY sponid
HAVING SUM(betrag) > 1000
ORDER BY sponid;
 
-- b)
-- Von welchem Mitgliederstatus hat der Verein mindestens drei Personen?
SELECT statid, COUNT(*) AS "Anzahl Personen"
FROM person
GROUP BY statid
HAVING COUNT(*) > 2
ORDER BY statid;
 
-- c)
-- Berechnen Sie die durchschnittliche Spendenhöhe der Einzelspenden pro Sponsor und sortieren Sie die Ausgabe absteigend sortiert nach der Höhe der Spende.
SELECT sponid, AVG(betrag) AS "mittlere Spendenhöhe"
FROM spende
GROUP BY sponid
ORDER BY 2 DESC;

-- Aufgabe 2: join
-- a)
-- Der Vereinsvorstand besteht aus allen Mitgliedern, welche zurzeit eine Funktion ausüben. Erstellen Sie eine Liste des aktuellen Vorstands mit Name, Vorname, Funktionsbezeichner und Antrittsdatum. (Beachte allenfalls auch Personen, deren Rücktritt sich erst in der Zukunft befindet.)
SELECT name, vorname, bezeichner, antritt
FROM person p
JOIN funktionsbesetzung fi ON p.persid = fi.persid
JOIN funktion f ON fi.funkid = f.funkid
WHERE ruecktritt IS NULL
OR ruecktritt > SYSDATE
ORDER BY name, vorname;

-- b)
-- Ermitteln Sie das Spendentotal der Einzelspenden nach Sponsoren aufgeschlüsselt (SponsorID, Sponsorname, Spendentotal).
SELECT sponsor.sponid, name, SUM(betrag) AS "Spendentotal/Sponsor"
FROM spende
JOIN sponsor ON spende.sponid = sponsor.sponid
GROUP BY sponsor.sponid, name
ORDER BY sponsor.sponid;

-- c)
-- Gibt es Personen, welche dieselbe Vereinsfunktion bereits mehr als einmal übernommen haben? (Name, Vorname, Funktionsbezeichner und Anzahl der Funktionsübernahmen)
SELECT name, vorname, bezeichner, COUNT(*) AS "Anzahl Funktionsübernahmen"
FROM person p
JOIN funktionsbesetzung fi ON p.persid = fi.persid
JOIN funktion f ON fi.funkid = f.funkid
GROUP BY p.persid, f.funkid, name, vorname, bezeichner
HAVING COUNT(*) > 1
ORDER BY p.persid, f.funkid;

-- d)
-- Welche Sponsoren haben seit anfangs 2015 bereits gespendet und wieviel? Sortieren Sie nach dem Spendenbetrag, die höchsten zuerst.
SELECT sponsor.sponid, name, SUM(betrag) AS "Spendentotal"
FROM spende
JOIN sponsor ON spende.sponid = sponsor.sponid
WHERE datum >= TO_DATE('01.01.2015','DD.MM.YYYY')
GROUP BY sponsor.sponid, name
ORDER BY SUM(betrag) DESC;