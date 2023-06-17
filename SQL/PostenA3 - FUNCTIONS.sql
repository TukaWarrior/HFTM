-- Aufgabe a)
-- Geben Sie die Namen und das Anstellungsdatum aller Beschäftigten der Abteilung 20 im angegebenen Format aus. Die Ausgabe ist aufsteigend nach dem Namen zu ordnen.
SELECT ENAME as Name,
TO_CHAR(TO_DATE(HIREDATE, 'DD.MM.YYYY'), 'Month, Day YYYY') AS Anstellungsdatum
FROM EMP
WHERE DEPTNO = 20
ORDER BY ENAME ASC;
-- Aufgabe b)
-- Geben Sie von jedem Mitarbeiter den Namen, sein Gehalt sowie ein Gehaltsüberprüfungsdatum aus, aufsteigend sortiert nach dem Gehaltsprüfungsdatum. Das Gehalt eines Mitarbeiters wird ein halbes Jahr nach seiner Einstellung überprüft.
SELECT ENAME AS Name,
TO_CHAR(SAL, '999,999.9') AS Gehalt,
TO_CHAR(TO_DATE(HIREDATE, 'DD.MM.YYYY'), 'IW - YYYY') AS Anstellungsdatum
FROM EMP
ORDER BY HIREDATE ASC;
-- Aufgabe c)
-- Geben Sie für den Mitarbeiter Smith für die Monate Mai, Juni und Juli 2005 an, wann sein Lohn überwiesen wird. Die Lohnauszahlungen der Firma erfolgen jeweils zweitletzten Tag des Monats.
SELECT ENAME AS Name,
    TO_CHAR(LAST_DAY(DATE '2005-05-01') -1, 'Day DD.') AS Mai,
    TO_CHAR(LAST_DAY(DATE '2005-06-01') -1, 'Day DD.') AS Mai,
    TO_CHAR(LAST_DAY(DATE '2005-07-01') -1, 'Day DD.') AS Mai
FROM EMP 
WHERE ename = 'SMITH';
-- Aufgabe d)
-- Geben Sie für den Mitarbeiter Smith für die Monate Mai, Juni und Juli 2005 an, wann sein Lohn überwiesen wird. Die Lohnauszahlungen der Firma erfolgen jeweils zweitletzten Tag des Monats.
SELECT ename as NAME,
ROUND(MONTHS_BETWEEN(DATE '2016-01-21', hiredate),2) AS "Monate beschaeftigt"
FROM EMP;
-- SELECT * FROM emp;

