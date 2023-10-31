INSERT INTO vereinuser.persone (persid, name, vorname, strassen_nr, plz, ort, bezahlt, bemerkung, eintritt, austritt, statid, mentoriid)
VALUES (1, 'Niiranen', 'Ulla', 'Seestrasse 1', 2502, 'Biel', '1', null, To_DATE('11-11-2017','DD-MM-YYYY'), TO_DATE('31-12-2011', 'DD-MM-YYYY'), null);

INSERT INTO vereinuser.status(statid, bezeichner, beitrag)
VALUES (3, 'Ehemalig', null);

INSERT INTO vereinuser.funktion (funkid, bezeichener)
VALUES (1, 'Praesidium');

INSERT INTO vereinuser.funktionsbesetzung (antritt, ruecktritt, funkid, persid)
VALUES (TO_DATE('11-11-2007', 'DD-MM-YYYY'), TO_DATE('31-03-2010', 'DD-MM-YYYY', 1, 1));