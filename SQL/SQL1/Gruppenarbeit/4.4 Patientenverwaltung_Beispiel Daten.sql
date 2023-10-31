
-- Beispieldaten für Mitarbeiter
INSERT INTO Mitarbeiter (Mitarbeiter_ID, Name, Vorname)
VALUES
    (1, 'Müller', 'Anna'),
    (2, 'Schmidt', 'Peter'),
    (3, 'Wagner', 'Maria');


-- Beispieldaten für Beruf
INSERT INTO Beruf (Beruf_ID, Bezeichnung)
VALUES
    (1, 'Arzt'),
    (2, 'Krankenschwester');


-- Beispieldaten für Patienten
INSERT INTO Patienten (Patienten_ID, Name, Vorname, KrankenkasseNummer, Arzt_ID)
VALUES
    (1, 'Schulz', 'Michael','7938.5634.1234.4' 1),
    (2, 'Becker', 'Laura','7938.1111.1224.4' 2),
    (3, 'Keller', 'Lukas','6666.4444.3333.4' 1);


-- Beispieldaten für Arzt
INSERT INTO Arzt (Arzt_ID, Mitarbeiter_ID)
VALUES
    (1, 1),
    (2, 3);

-- Beispieldaten für Termin
INSERT INTO Termin (Termin_ID, Datum, Zeit, Arzt_ID, Patienten_ID)
VALUES
    (1, '2023-08-21', '09:00', 1, 1),
    (2, '2023-08-21', '10:30', 1, 3),
    (3, '2023-08-22', '14:00', 2, 2);

-- Beispieldaten für Krankenakte
INSERT INTO Krankenakte (Krankenakte_ID, Patienten_ID, Inhalt)
VALUES
    (1, 1, 'Grippe, verschriebenes Medikament: Paracetamol'),
    (2, 2, 'Allergische Reaktion, verschriebenes Medikament: Loratadin'),
    (3, 1, 'Folgeuntersuchung nach Herzoperation');
