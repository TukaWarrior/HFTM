--
-- *************************************
-- Lösung zu Arbeitsblatt 3.1, Posten 2
-- *************************************
--

--
-- ==============
-- Teilaufgabe a)
-- ==============
--
SELECT ename, deptno, sal 
FROM emp
WHERE sal BETWEEN 1000 AND 2000;

--
-- ==============
-- Teilaufgabe b)
-- ==============
--
SELECT ename, job
FROM emp
WHERE job = 'ANALYST'
  AND deptno = 20;
  
--
-- ==============
-- Teilaufgabe c)
-- ==============
--
SELECT ename
FROM emp
WHERE UPPER(ename) LIKE '%C%';

-- ==============
-- Teilaufgabe d)
-- ==============
--
SELECT ename, job, sal 
FROM emp
WHERE job = 'MANAGER'
  AND sal > 2800;

--
-- ==============
-- Teilaufgabe e)
-- ==============
--
SELECT ename, job, deptno
FROM emp
WHERE job = 'MANAGER'
  AND NOT (deptno = 30);

-- oder:

SELECT ename, job, deptno
FROM emp
WHERE job = 'MANAGER'
  AND deptno != 30;

--
-- ==============
-- Teilaufgabe f)
-- ==============
--
SELECT ename, comm
FROM emp
WHERE comm IS NULL
ORDER BY ename;

--
-- ==============
-- Teilaufgabe g)
-- ==============
--
SELECT ename, comm
FROM emp
WHERE comm IS NOT NULL
ORDER BY comm DESC;

--
-- ==============
-- Teilaufgabe h)
-- ==============
--
SELECT ename
FROM emp
WHERE ename LIKE '__R%';
  

