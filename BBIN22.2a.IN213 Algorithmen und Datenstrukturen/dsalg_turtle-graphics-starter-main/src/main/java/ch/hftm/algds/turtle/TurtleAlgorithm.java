package ch.hftm.algds.turtle;

import javafx.scene.canvas.GraphicsContext;

public class TurtleAlgorithm {

	static final double FULL_CIRCLE = 360.0;

	public void drawWithTurtle(GraphicsContext gc) {
		// Turtle-Objekt erzeugen
		Turtle turtle = new Turtle(gc,250, 250, 0.01);

		// Time when execution started
		long startTime = System.nanoTime();
		
		// Call Aufgabe
		// aufgabe1(turtle);
		// aufgabe2(turtle);
		aufgabe3(turtle);
		// eigeneAufgabe1(turtle);

		// Display turtles path
		turtle.startJourney();

		// Meassure execution time 
		long elapsedTime = System.nanoTime() - startTime;
		System.out.println("Total execution time: " + elapsedTime/1000000 + " ms");
	}


	
	// Aufgabe 1
	private static void aufgabe1(Turtle turtle) {
		int a1_sideLength = 50;
		int a1_maxLoops = 10;
	
		for (int currentLoop = 1; currentLoop <= a1_maxLoops; currentLoop++) {		// Every iteration contains a full shape. Repeats the loop for maxLoops times. 
			for (int index = 1; index <= currentLoop+2 ; index++) {					// Every iteration contains a line and a turn. Put together, they form a individual shape. Repeats for the currentLoop + 2 (because it starts with a triangle) ammount of times. 
				turtle.forward(a1_sideLength);
				turtle.left(FULL_CIRCLE/(currentLoop+2));
			}
		}
	}

	// Aufgabe 2
	private static void aufgabe2(Turtle turtle) {
		int a2_initialSideLength = 10;			// Sets the size of a side as the base value.
		int a2_maxLoops = 15;					// Sets the ammount of shapes to draw
		int a2_AnglesPerShape = 4;				// Sets the ammount of sides/angles per shape. (MinRequired = 3)

		for (int index = 1; index <= a2_maxLoops; index++) {								// Every iteration contains a full shape. Repeates for maxLoops times.
			for (int currentSide = 1; currentSide <= a2_AnglesPerShape; currentSide++) {	// Every iteration contains a side of a single shape. Repeats for a2_AnglesPerShape times. 
				turtle.forward(a2_initialSideLength*index);
				turtle.left(FULL_CIRCLE/a2_AnglesPerShape);
			}
		}
	}

	// Aufgabe 3
	private static void aufgabe3(Turtle turtle) {
		int a3_ShapeSideLength = 50;
		int a3_maxLoops = 24;
		int a3_AnglesPerShape = 4;	

		for (int index = 1; index <= a3_maxLoops; index++) {
			for (int currentIteration = 1; currentIteration <= a3_AnglesPerShape; currentIteration++) {
				turtle.forward(a3_ShapeSideLength);
				turtle.left(FULL_CIRCLE/a3_AnglesPerShape);
			}
			turtle.left((FULL_CIRCLE/a3_maxLoops));
		}
	}

	// Eigene Aufgabe 1
	private static void eigeneAufgabe1(Turtle turtle){
		turtle.drawFilledRectangle(100,50,50,50);
	}
}