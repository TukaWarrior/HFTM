package ch.hftm.SymmetrischerBaum;

import ch.hftm.RecursivesVieleck.Turtle;
import javafx.scene.canvas.GraphicsContext;

public class SymmetrischerBaum {

	public void drawWithTurtle(GraphicsContext gc) {
		// Turtle-Objekt erzeugen
		Turtle turtle = new Turtle(gc,250, 250, 0.05);
		turtle.left(90);
	
		symBaum(turtle, 5 ,100, 0.5, 45);

		// Display turtles path
		turtle.startJourney();
	}

	// SymmetrischerBaum
	public void symBaum(Turtle t, int n, double seitenlaenge, double k, double alpha) {
 
        if (n != 0){
 
            // Baumstamm
            t.forward(seitenlaenge);
 
            // 2x Rekursion weil 2 Äste pro Stamm
            t.left(alpha);
            symBaum(t, n-1, seitenlaenge*k, k, alpha);
            t.right(alpha * 2);
            symBaum(t, n-1, seitenlaenge*k, k, alpha);
			t.left(alpha);

			// Zurück zum Stammbeginn
			t.forward(-seitenlaenge);
        }
    }
}