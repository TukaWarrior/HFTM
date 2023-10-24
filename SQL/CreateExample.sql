CREATE TABLE department(
        id              NUMBER(6) PRIMARY KEY,
        Name            VARCHAR2(50) NOT NULL,
        top_department  NUMBER(6)
);

-- ALTER TABLE department ADD

-- INSERT INTO department(id, name) VALUES (1, 'IT');
-- INSERT INTO department(id, name) VALUES (2, '');docker run -d --name oradb -p 1521:1521 ghcr.io/hftm-inf/oracle-db:21-db2
