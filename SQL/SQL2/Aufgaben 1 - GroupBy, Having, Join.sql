-- Aufgabe 1: group by, having
-- a)
SELECT SUM(beitrag)
FROM spende
WHERE DATE >= '2015-01-01';

-- Aufgabe 1: group by, having
-- b)
SELECT SUM(beitrag)
FROM spende
GROUP BY spendenid, SUM(beitrag) as "Spendentotal";

-- Aufgabe 1: group by, having
-- c)
SELECT SUM(beitrag) as total
FROM spende
WHERE date >= '2015-01-01' 
GROUP BY Spionid
HAVING SUM(Beitrag) > 1000;

-- Aufgabe 2 Join
-- a)
SELECT p.vorname, p.name, s.bezeichner as "status bezeichner", s.beitrag
FROM person p
JOIN status s OM p.statid = s.statid
ORDER BY p.name, p.vorname;

-- Aufgabe 2 Join
-- b)
SELECT a.bezeichner, a.ort, p.name, p.vorname
FROM anlass a
JOIN anlas a ON p 

-- Stuff
SELECT substr('bla bla', 1, 2) as "Mein Alias" FROM dual;

SELECT TO_CHAR(austritt, 'DD.MM.YYYY') austritt
FROM person
WHERE coalesce(austritt, current_date+1) < DATE '2023-01-01';


SELECT p.vorname, p.name, f.persid = p.persid
FROM person p
JOIN funktionsbezeichnung fb ON fb.persid = p.persid
JOIN funktion ON fb.funkid = f
WHERE fb.antritt < vurrent_date
AND coalesce(fb.ruecktritt, current_dat1e) > current_date;

-- AND coalesce(fb ruecktrittm current_date+1) > current_date;

--Unfinished;  
SELECT avg(statid_count)
FROM statid,co unt(statid), 
SELECT statid, count, count (countid)



-- c)

SELECT sp.name, s datum, s.betrag
FROM spende s
JOIN sponsor sp ON s.spoid = s.spomids
WHERE s.betrag = (SELECT MAX (betrag) FROM spenden;)

-- or

SELECT sp.name, s datum, s.betrag
FROM spende s
JOIN sponsor sp ON s.spoid = s.spomids
ORDER BY s.betrag DESC
FETCH FIRST 1 ROWS ONLY;