-- Aufgabe 1: Unterabfragen die eine Liste von Werten liefern
-- a) 
-- Zu welchen Anlässen sind keine Teilnehmer registriert?
SELECT * 
FROM anlass
WHERE anlaid NOT IN
      ( SELECT anlaid 
        FROM teilnehmer );

-- b)
-- Wird per Ende 2028 eine Vereinsfunktion nicht besetzt sein? Bestimmen Sie den Funktionsbezeichner sowie das Datum, ab welchem die Funktion nicht mehr besetzt ist.
SELECT f.bezeichner vakanz, MAX(fi.ruecktritt) AS ab
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
 
-- c)
-- Welche aktiven Vereinsmitglieder (inklusive Junioren) gehören nicht zum Vorstand (d.h. besetzen also keine Vereinsfunktion)? (PersonenID, Name, Vorname und Ort)
-- Bemerkungen:
-- Vereinsmitglieder erkennt man daran, dass sie einen Status haben mit einem Beitrag, welcher nicht leer ist.
-- Ein aktives Vereinsmitglied ist ein Vereinsmitglied, dessen Status nicht passiv ist.
SELECT persid, name, vorname, ort
FROM person
WHERE statid IN
      ( SELECT statid
        FROM status
        WHERE beitrag IS NOT NULL
          AND bezeichner <> 'Passiv')
  AND persid <> ALL
      ( SELECT persid
        FROM funktionsbesetzung
        WHERE RUECKTRITT IS NULL
           OR ruecktritt > SYSDATE);

-- Aufgabe 2: Unterabfragen die mit der Hauptabfrage korrelieren
-- a)
-- Ermitteln Sie jene Einzelspenden (SponsorID, SpendenID, Bezeichner,Datum und Betrag), welche im Vergleich mit den übrigen Spenden desselben Sponsors überdurchschnittlich hoch sind.
SELECT sponid,spenid,bezeichner, datum, betrag
FROM spende s1
WHERE betrag >
      ( SELECT AVG(betrag)
        FROM spende s2
        WHERE s1.sponid = s2.sponid );