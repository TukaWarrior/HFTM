-- Aufgabe 1: group by, having
-- a) 
-- Ermitteln Sie das Total sämtlicher Spenden, welche der Verein seit Anfangs 2015 erhalten hat.
SELECT sum(betrag) AS "Spendentotal"
FROM spende
WHERE datum >= TO_DATE('01.01.2015', 'DD.MM.YYYY');
 
-- b)
-- Ermitteln Sie das Spendentotal der Einzelspenden nach Sponsoren aufgeschlüsselt (SponsorID, Spendentotal).
SELECT sponid, SUM(betrag) AS "Spendentotal/Sponsor"
FROM spende
GROUP BY sponid
ORDER BY sponid;
 
-- c)
-- Ermitteln Sie das Spendentotal derjenigen Sponsoren, welche seit Anfangs 2015 gesamthaft mehr als 1000 Fr. gespendet haben.
SELECT sponid, SUM(betrag) AS "Spendentotal/Sponsor"
FROM spende
WHERE datum >= TO_DATE('01.01.2015', 'DD.MM.YYYY')
GROUP BY sponid
HAVING SUM(betrag) > 1000
ORDER BY sponid;

-- Aufgabe 2: join
-- a)
-- Erstellen Sie eine Liste aller Junioren und Aktiven mit Name, Vorname, Statusbezeichner und Mitgliederbeitrag, sortiert nach Name und Vorname.
SELECT name, vorname, bezeichner, beitrag
FROM person p
JOIN status s ON p.statid = s.statid
WHERE s.statid IN (1,2)
ORDER BY name, vorname;

-- b)
-- Welcher Anlass hat am 29.3.2015 stattgefunden und wer hat daran teilgenommen? (Anlassbezeichner, Ort, Name und Vorname der Teilnehmer)
SELECT bezeichner, a.ort, name, vorname
FROM anlass a
JOIN teilnehmer t ON a.anlaid = t.anlaid
JOIN person p ON t.persid = p.persid
WHERE datum = TO_DATE('29.03.2015','DD.MM.YYYY')
ORDER BY name, vorname;