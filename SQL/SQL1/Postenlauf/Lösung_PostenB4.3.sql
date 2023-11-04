L�sungsvorschlag zu Aufgabe 4
------------------------------

Zwischen den Relationen Klasse und Student ergibt sich ein "Zirkelschluss":
Jeder Student referenziert bereits �ber einen Foreign-Key-Constraint (fk-Constraint) eine Klasse � aber
jetzt referenziert auch jede Klasse �ber einen fk-Constraint einen Studenten.

Daraus ergeben sich folgende Probleme

F�r Aufgabe 1:
F�rs Kreieren der Tabellen inklusive fk-Constraint setzt jede der beiden betroffenen Tabellen die andere voraus.
L�sung: Eine der beiden Tabellen wird vorerst ohne fk-Constraint kreiert, dann wird die zweite Tabelle inklusive
fk-Constraint kreiert und zum Schluss die erste Tabelle abge�ndert (ALTER TABLE ... ADD) und der fk-
Constraint nachtr�glich hinzugef�gt.

F�r Aufgabe 2:
In die beiden betroffenen Tabellen kann kein einziges Tupel eingef�gt werden, denn das Einf�gen eines Tupels
in eine der beiden betroffenen Tabellen setzt jeweilen die Existenz des referenzierten ("zugeh�rigen") Tupels in
der anderen Tabelle voraus.
L�sung: Um diese gegenseitige Blockade aufzuheben, muss vor�bergehend einer der beiden fk-Constraints
ausser Kraft gesetzt werden (ALTER TABLE ... DISABLE CONSTRAINT...) und sp�ter m�glichst rasch wieder
aktiviert werden (ALTER TABLE ... ENABLE CONSTRAINT...).