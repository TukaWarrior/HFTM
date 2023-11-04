-- Aufgabe a)
-- Zeigen Sie alle Beschäftigten, die ein Gehalt zwischen 1000 und 2000 erhalten.
SELECT ename, deptno, sal
FROM emp
WHERE sal >  1000 AND sal < 2000;
-- Aufgabe b)
-- Geben Sie die Namen und den Beruf aller Analytiker (ANALYST) in Abteilung 20 aus.
SELECT ename, job
FROM emp
WHERE job = 'ANALYST' AND deptno = '20';
-- Aufgabe c)
-- Listen Sie die Namen aller Beschäftigten auf, deren Name den Buchstaben 'C' enthält.
SELECT ename
FROM emp
WHERE ename LIKE '%C%';
-- Aufgabe d)
-- Geben Sie Name, Job und Gehalt aller Manager aus, welche mehr als $ 2800.- monatlich verdienen.
SELECT ename, job, sal
FROM emp
WHERE job = 'MANAGER' AND sal > 2800;
-- Aufgabe e)
-- Geben Sie Name, Job und Abteilungsnummer aller Manager aus, welche nicht zur Abteilung 30 gehören.
SELECT ename, job, deptno
FROM emp
WHERE job = 'MANAGER' AND deptno != 30;
-- Aufgabe f)
-- Geben Sie die Namen (in aufsteigender Reihenfolge) sowie die Kommission (leere Spalte) aller Mitarbeiter aus, welche keine Kommission kriegen.
SELECT ename, comm
FROM emp
WHERE comm IS NULL
ORDER BY ename ASC;
-- Aufgabe g)
-- Geben Sie die Namen sowie die Kommission aller Mitarbeiter aus, bei welchen eine Kommissionsangabe existiert, geordnet nach der Höhe der Kommission.
SELECT ename, comm
FROM EMP
WHERE comm IS NOT NULL
ORDER BY comm DESC;
-- Aufgabe h)
-- Geben Sie die Namen aller Mitarbeiter aus, deren Name als dritten Buchstaben ein 'R' besitzt.
SELECT ename
FROM emp
WHERE ename LIKE '__R%';