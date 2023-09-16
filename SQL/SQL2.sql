SELECT e.ename Angestellter, m.ename Vorgesetzter
FROM emp e
JOIN emp m ON e.mgr = m.empno;