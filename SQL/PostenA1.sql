-- Aufgabe a)
-- Zeigen Sie alle Informationen der Tabelle DEPT.
SELECT * FROM DEPT;
-- Aufgabe b)
-- Listen Sie alle Abteilungsnummern und -namen (Tabelle DEPT) auf, sortiert nach Abteilungsnamen. 
SELECT DEPTNO, DNAME FROM DEPT
ORDER BY DEPTNO ASC;
-- Aufgabe c)
-- Zeigen Sie das Jahressalär aller Beschäftigten an, sortiert nach Gehaltshöhe, Vielverdiener zuerst. Beim Namen sollen dabei nur die ersten drei Zeichen ausgegeben werden.
SELECT SUBSTR(ENAME, 1, 3) as KUERZEL,
SAL * 12 as JAHRESGEHALT
FROM EMP
ORDER BY SAL DESC;