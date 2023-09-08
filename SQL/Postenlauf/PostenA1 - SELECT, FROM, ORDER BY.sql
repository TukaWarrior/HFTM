-- Aufgabe a)
-- Zeigen Sie alle Informationen der Tabelle DEPT.
SELECT * FROM dept;
-- Aufgabe b)
-- Listen Sie alle Abteilungsnummern und -namen (Tabelle DEPT) auf, sortiert nach Abteilungsnamen. 
SELECT deptno, dname FROM dept
ORDER BY deptno ASC;
-- Aufgabe c)
-- Zeigen Sie das Jahressalär aller Beschäftigten an, sortiert nach Gehaltshöhe, Vielverdiener zuerst. Beim Namen sollen dabei nur die ersten drei Zeichen ausgegeben werden.
SELECT SUBSTR(ename, 1, 3) AS kuerzel,
sal * 12 AS jahresgehalt
FROM emp
ORDER BY sal DESC;