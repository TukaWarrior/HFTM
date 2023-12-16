-- Aufgabe 1
-- Erstellen Sie eine Liste aller Vereinsmitglieder (PersonenID, Name und Vorname), absteigend geordnet nach Name und Vorname. 
-- Zur Erinnerung: Eine Person ist genau dann Vereinsmitglied, wenn sie einen Status hat, dessen Beitragswert nicht leer (NULL) ist.
-- Lösen Sie die Aufgabe einmal mithilfe eines Joins und einmal mithilfe eines Subqueries ohne Join.

-- Mit JOIN
SELECT P.PersID, P.Name, P.Vorname, P.StatID, S.Beitrag
FROM Person P
INNER JOIN Status S ON S.StatID = P.StatID
WHERE S.Beitrag IS NOT NULL
ORDER BY P.Name DESC, P.Vorname DESC;

-- Mit Subquery
SELECT P.PersID, P.Name, P.Vorname, P.StatID
FROM Person p
WHERE P.StatID IN (SELECT S.StatID FROM Status S WHERE S.BEITRAG IS NOT NULL)
ORDER BY P.Name DESC, P.Vorname DESC;


-- Aufgabe 2
-- Erstellen Sie eine chronologisch geordnete Liste aller Anlässe (Bezeichner, Ort, Datum), zusätzlich versehen mit der Anzahl registrierter Teilnehmer.

SELECT A.Bezeichner, A.Ort, A.Datum, COUNT(T.PersID) AS "Anzahl Teilnehmer"
FROM Anlass A
LEFT JOIN Teilnehmer T ON T.AnlaID = A.AnlaID
GROUP BY A.Bezeichner, A.Ort, A.Datum;


-- Aufgabe 3
-- Erstellen Sie eine Liste aller Vereinsanlässe (Anlassbezeichner, Durchführungsort, Durchführungsdatum), 
-- deren Kosten höher sind als die Summe der für diesen Anlass eingegangenen Spenden. 
-- Geben Sie diesen nicht gesponserten Kostenanteil ebenfalls an.

SELECT A.Bezeichner AS "Anlassbezeichner", A.Ort AS "Durchführungsort", A.Datum AS "Durchführungsdatum"
FROM Anlass A;

SELECT A.Bezeichner AS "Anlassbezeichner", A.Ort AS "Durchführungsort", A.Datum AS "Durchführungsdatum", COALESCE(A.Kosten,0)-COALESCE(SUM(S.Betrag),0) AS "ungedekte Kosten"
FROM Anlass A
LEFT JOIN Spende S ON A.AnlaID = S.AnlaID
GROUP BY A.Bezeichner, A.ORt, A.Datum, A.Kosten;

SELECT A.Bezeichner AS "Anlassbezeichner", A.Ort AS "Durchführungsort", A.Datum AS "Durchführungsdatum", COALESCE(A.Kosten,0)-COALESCE(SUM(S.Betrag),0) AS "ungedekte Kosten"
FROM Anlass A
LEFT JOIN Spende S ON A.AnlaID = S.AnlaID
GROUP BY A.Bezeichner, A.ORt, A.Datum, A.Kosten
HAVING COALESCE(A.Kosten,0)-COALESCE(SUM(S.Betrag),0) > 0;


-- Aufgabe 7 (KNACKNUSS)
-- Welche Anlässe haben überdurchschnittlich viele registrierte Teilnehmer und wieviele?
-- Dabei sollen die Anlässe ohne registrierte Teilnehmer für die Durchschnittsberechnung berücksichtigt werden. (Bezeichner, Ort, Datum, Teilnehmerzahl.)
-- Ordnen Sie die Ausgabe absteigend nach der Teilnehmerzahl.

SELECT A.Bezeichner, A.Datum, A.Ort, COUNT(T.PersID) AS "Teilnehmerzahl"
FROM Anlass A
LEFT JOIN Teilnehmer T ON A.AnlaID = T.AnlaID
GROUP BY A.Bezeichner, A.Datum, A.Ort;
-- Unfertig