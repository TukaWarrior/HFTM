package ch.hftm.RecursivesVieleck;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

public class TurtleApp extends Application {

	public static void main(String[] args) {
        launch();
	}

	@Override
	public void start(Stage primaryStage) {
		// Stage einrichten
		primaryStage.setTitle("Illustrationsbeispiel");
		Group root = new Group();

		// Zeichnungsumgebung einrichten
		Canvas canvas = new Canvas(500, 500);
		GraphicsContext gc = canvas.getGraphicsContext2D();

		// Applikation starten
		root.getChildren().add(canvas);
		primaryStage.setScene(new Scene(root));
		primaryStage.show();

		// Algorithmus starten
		new TurtleAlgorithm().drawWithTurtle(gc);
	}
}