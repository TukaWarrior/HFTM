package ch.hftm.RecursivesVieleck;

import javafx.scene.canvas.GraphicsContext;

public class TurtleAlgorithm {

	public void drawWithTurtle(GraphicsContext gc) {
		// Turtle-Objekt erzeugen
		Turtle turtle = new Turtle(gc,250, 250, 0.05);
		
		vieleck(turtle, 1, 8, 50);

		// Display turtles path
		turtle.startJourney();
	}

	// RekursivesVieleck
	public void vieleck(Turtle t, int n, int eckenzahl, double seitenlaenge) {
		if (n <= eckenzahl){
			t.forward(seitenlaenge);
			t.left(360.0/eckenzahl);
			vieleck(t, n+1, eckenzahl, seitenlaenge);
		}
	}
}