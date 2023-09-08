--
-- *************************************
-- Lösung zu Arbeitsblatt 3.1, Posten 1
-- *************************************
--

-- ==============
-- Teilaufgabe a)
-- ==============
--
PROMPT Teilaufgabe a
PROMPT *********************
SELECT * 
FROM dept;

--
-- ==============
-- Teilaufgabe b)
-- ==============
--
PROMPT Teilaufgabe b
PROMPT *********************
SELECT deptno, dname 
FROM dept
ORDER BY dname;

--
-- ==============
-- Teilaufgabe c)
-- ==============
--
PROMPT Teilaufgabe c
PROMPT *********************
SELECT SUBSTR(ename,1,3) kuerzel, sal*12 AS jahresgehalt 
FROM emp
ORDER BY 2 DESC;
