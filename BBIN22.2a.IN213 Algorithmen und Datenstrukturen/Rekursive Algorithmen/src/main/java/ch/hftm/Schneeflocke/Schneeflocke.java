package ch.hftm.Schneeflocke;

import javafx.scene.canvas.GraphicsContext;

public class Schneeflocke {

	public void drawWithTurtle(GraphicsContext gc) {
		// Turtle-Objekt erzeugen
		Turtle turtle = new Turtle(gc,250, 250, 0.5);
		turtle.left(90);
		
		Schneeflocke(turtle, 2, 100, 0.33, 6);

		// Display turtles path
		turtle.startJourney();
	}

	// Schneeflocke
	public void Schneeflocke(Turtle t, int n, double seitenlaenge, double k, int anzahlStrahlen) {
		if (n !=0) {

			// t.forward(seitenlaenge);


			// Strahlen
			for (int i = 1; i <= anzahlStrahlen+1; i++) {
				// Schneeflocke(t, n-1, seitenlaenge*k, k, anzahlStrahlen);
				t.left(360/anzahlStrahlen);
				t.forward(seitenlaenge);
				Schneeflocke(t, n-1, seitenlaenge*k, k, anzahlStrahlen);
				t.forward(-seitenlaenge);
				t.setRandomColor();
				
			}
		}
	}
}