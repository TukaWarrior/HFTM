SELECT Bezeichner, MAX(Datum)
FROM ANLASS
GROUP BY Bezeichner;

SELECT Bezeichner,Ort, Datum
FROM ANLASS
WHERE (Bezeichner, Datum) IN 
(SELECT Bezeichner, MAX(Datum)
FROM Anlass
GROUP BY Bezeichner);

-- Welche Person ist als erstes in den Verein eingetreten?
SELECT NAME, VORNAME
FROM PERSON
WHERE EINTRITT <= ALL(SELECT EINTRITT FROM PERSON WHERE EINTRITT IS NOT NULL)
AND EINTRITT IS NOT NULL;

-- Geben Sie die Personen aus, die bereits an einem Anlass teilgenommen haben.
SELECT NAME, VORNAME
FROM PERSON
WHERE PERSID = ALL (SELECT PERSID FROM TEILNEHMER);

