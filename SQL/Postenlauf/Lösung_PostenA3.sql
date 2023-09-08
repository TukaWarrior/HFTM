--
-- *************************************
-- L�sung zu Arbeitsblatt 3.1, Posten 3
-- *************************************
--

--
-- ==============
-- Teilaufgabe a)
-- ==============
--
SELECT ename Name,
       TO_CHAR(hiredate,'Month, Day YYYY')
         AS anstellungsdatum
FROM emp
WHERE deptno = 20
ORDER BY ename;

--
-- ==============
-- Teilaufgabe b)
-- ==============
--
SELECT ename Name,
       TO_CHAR(sal,'999G990D0')
         AS gehalt,
       TO_CHAR(ADD_MONTHS(hiredate,6),
               'IW - YYYY')
         AS kw_pruef
FROM emp
ORDER BY ADD_MONTHS(hiredate,6);

--
-- ==============
-- Teilaufgabe c)
-- ==============
--
SELECT ename name,
TO_CHAR(LAST_DAY(TO_DATE('01.05.2005','DD.MM.YYYY'))-1,'Day DD.')AS "Mai",
	TO_CHAR(
		LAST_DAY(
           TO_DATE('01.06.2005','DD.MM.YYYY'))-1,
		'Day DD.')
    AS "Juni",
	TO_CHAR(
        LAST_DAY(
          TO_DATE('01.07.2005','DD.MM.YYYY'))-1,
'Day DD.')
    AS "Juli"
FROM emp
WHERE empno = 7369;

--
-- ==============
-- Teilaufgabe d)
-- ==============
--
SELECT ename name,
       TO_CHAR(
         MONTHS_BETWEEN(
           CURRENT_DATE,hiredate),
           '999999999999999D99')
             AS "Monate beschaeftigt"
FROM emp
ORDER BY "Monate beschaeftigt" DESC;

--
-- ==============
-- Teilaufgabe e)
-- ==============
--
SELECT TRUNC(
           CURRENT_DATE - TO_DATE('01.01.2000','DD.MM.YYYY'))
       AS "vergangene Tage"
FROM dual;

--
-- ==============
-- Teilaufgabe f)
-- ==============
--
SELECT ename || ' ' || job AS "Mitarbeiter", mgr AS "Vorgesetzter"
FROM emp
ORDER BY COALESCE(mgr,0);