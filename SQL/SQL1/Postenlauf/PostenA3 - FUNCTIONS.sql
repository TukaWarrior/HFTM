-- Aufgabe a)
-- Geben Sie die Namen und das Anstellungsdatum aller Beschäftigten der Abteilung 20 im angegebenen Format aus. Die Ausgabe ist aufsteigend nach dem Namen zu ordnen.
SELECT ename name,
TO_CHAR(hiredate,'Month, Day YYYY') AS anstellungsdatum
FROM emp
WHERE deptno = 20
ORDER BY ename ASC;
-- Aufgabe b)
-- Geben Sie von jedem Mitarbeiter den Namen, sein Gehalt sowie ein Gehaltsüberprüfungsdatum aus, aufsteigend sortiert nach dem Gehaltsprüfungsdatum. Das Gehalt eines Mitarbeiters wird ein halbes Jahr nach seiner Einstellung überprüft.
SELECT ename AS name,
TO_CHAR(sal, '999G990D0') AS gehalt,
TO_CHAR(ADD_MONTHS(hiredate, 6), 'IW - YYYY') AS anstellungsdatum
FROM emp
ORDER BY ADD_MONTHS(hiredate,6) ASC;
-- Aufgabe c)
-- Geben Sie für den Mitarbeiter Smith für die Monate Mai, Juni und Juli 2005 an, wann sein Lohn überwiesen wird. Die Lohnauszahlungen der Firma erfolgen jeweils zweitletzten Tag des Monats.
SELECT ename AS name,
    TO_CHAR(LAST_DAY(TO_DATE('2005.05.01','YYYY.MM.DD'))-1,'Day DD.') AS "Mai",
    TO_CHAR(LAST_DAY(TO_DATE('2005.06.01','YYYY.MM.DD'))-1,'Day DD.') AS "Juli",
    TO_CHAR(LAST_DAY(TO_DATE('2005.07.01','YYYY.MM.DD'))-1,'Day DD.') AS "Juli"
FROM emp 
WHERE empno = 7369;
-- Aufgabe d)
-- Geben Sie für jeden Mitarbeiter an, wie viele Monate er bereits in der Firma tätig ist. Ausgabe sollte vom aktuellen Tagesdatum aus berechnet werden. Sortieren Sie die Ausgabe absteigend nach der Beschäftigungsdauer.
SELECT ename as name,
TO_CHAR(MONTHS_BETWEEN(CURRENT_DATE,hiredate),'999999999999999D99') AS "Monate beschaeftigt"
FROM emp
ORDER BY "Monate beschaeftigt" DESC;
-- Aufgabe e)
-- Geben Sie an, wie viele ganze Tage seit dem 01.01.2000 bereits vergangen sind.
SELECT TRUNC(CURRENT_DATE - TO_DATE('01.01.2000','DD.MM.YYYY')) AS "Vergangene Tage"
FROM DUAL;
-- Aufgabe f)
-- Zeigen Sie den Namen zusammengezogen mit dem Job und der Nummer des Managers an. Die Sortierung soll dabei aufsteigend nach der Managernummer sein, und Mitarbeiter ohne Manager sollten als erstes aufgeführt sein.
SELECT ename || ' ' || job AS "Mitarbeiter", mgr AS "Vorgesetzter"
FROM emp
ORDER BY COALESCE(mgr,0);