-- Aufgabe a)
-- Zeigen Sie alle Beschäftigten, die ein Gehalt zwischen 1000 und 2000 erhalten.
SELECT ENAME, DEPTNO, SAL
FROM EMP
WHERE SAL >  1000 AND SAL < 2000;
-- Aufgabe b)
-- Geben Sie die Namen und den Beruf aller Analytiker (ANALYST) in Abteilung 20 aus.
SELECT ENAME, JOB
FROM EMP
WHERE JOB = 'ANALYST' AND DEPTNO = '20';
-- Aufgabe c)
-- Listen Sie die Namen aller Beschäftigten auf, deren Name den Buchstaben 'C' enthält.
SELECT ENAME
FROM EMP
WHERE ENAME LIKE '%C%';
-- Aufgabe d)
-- Geben Sie Name, Job und Gehalt aller Manager aus, welche mehr als $ 2800.- monatlich verdienen.
SELECT ENAME, JOB, SAL
FROM EMP
WHERE JOB = 'MANAGER' AND SAL > 2800;
-- Aufgabe e)
-- Geben Sie Name, Job und Abteilungsnummer aller Manager aus, welche nicht zur Abteilung 30 gehören.
SELECT ENAME, JOB, DEPTNO
FROM EMP
WHERE JOB = 'MANAGER' AND DEPTNO != 30;
-- Aufgabe f)
-- Geben Sie die Namen (in aufsteigender Reihenfolge) sowie die Kommission (leere Spalte) aller Mitarbeiter aus, welche keine Kommission kriegen.
SELECT ENAME, COMM
FROM EMP
WHERE COMM IS NULL
ORDER BY ENAME ASC;
-- Aufgabe g)
-- Geben Sie die Namen sowie die Kommission aller Mitarbeiter aus, bei welchen eine Kommissionsangabe existiert, geordnet nach der Höhe der Kommission.
SELECT ENAME, COMM
FROM EMP
WHERE COMM IS NOT NULL
ORDER BY COMM DESC;
-- Aufgabe h)
-- Geben Sie die Namen aller Mitarbeiter aus, deren Name als dritten Buchstaben ein 'R' besitzt.
SELECT ENAME
FROM EMP
WHERE ENAME LIKE '__R%';