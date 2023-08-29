package ch.hftm;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    /*
     * Damit wir die gezeigtle Scene innerhalb des Haupt-BorderPanes zeigen können,
     * setzen wir eine statische Referenz auf das BorderPane
     */
    private static BorderPane borderPane;
    
    private static ObservableList<Prisoner> prisonerList = FXCollections.observableArrayList();
    
	public App() {
        prisonerList.add(new Prisoner("Bubba","John"));
		prisonerList.add(new Prisoner("Twitch","Fred"));
	}
    
    public static void main(String[] args) {
        launch();
    }
    
	public static ObservableList<Prisoner> getPrisonerList() {
        return prisonerList;
	}

    /*
     * Die start()-Methode auf einer Application-Klasse ist der grundsätzliche Einstieg in eine JavaFX-Applikation
     */
    @Override
    public void start(Stage stage) throws IOException {
        // BorderPane FXML laden
        FXMLLoader fxmlLoader = createFXMLLoader("MainView.fxml");
        App.borderPane = (BorderPane) loadFXML(fxmlLoader);

        // Prisoner View als Haupt-Inhalt in BorderPane laden
        App.showPrisonerView();


        // BorderPane in Scene starten
        Scene scene = new Scene(borderPane, 640, 480);
        stage.setTitle("Gefängisverwaltung");
        stage.setScene(scene);
        stage.show();
    }

    /*
     * Die beiden öffentlichen statischen Methoden erlauben den Wechsel des Inhalts des BorderPane's
     */
    public static void showEditView(Prisoner selectedPrisoner) {
        FXMLLoader fxmlLoader = createFXMLLoader("PrisonerEditView.fxml");
        // setRoot() ersetzt die Sichtbaren Elemente einer Szene, ohne dabei die ganze Szene neu aufbauen zu müssen
        App.borderPane.setCenter(loadFXML(fxmlLoader));

        // Über den Loader können wir den Controller identifizieren, um diesem den Prisoner mitzugeben
        // Dazu muss das Loading selber zwingend ausgeführt worden sein.
		PrisonerEditController controller = fxmlLoader.getController();
		controller.setPrisoner(selectedPrisoner);

    }
    public static void showPrisonerView() {
        FXMLLoader fxmlLoader = createFXMLLoader("PrisonerView.fxml");
        App.borderPane.setCenter(loadFXML(fxmlLoader));
    }

    /*
     * Diese Methode bereitet den Loader vor.
     * Wir benötigen diesen für das Identifizieren des Controllers sowie für das Laden des FXML's
     */
    private static FXMLLoader createFXMLLoader(String fxml)  {
        return new FXMLLoader(App.class.getResource("/" + fxml));
    }

    /*
     * Diese private Methode ist für das Laden des FXMLs verantwortlich.
     * Um den Zugriff zu vereinfachen wird bei einer allfälligen Lade-Fehler die Exception
     * nicht weitergeworfen, sondern der Fehler ausgegeben und das Programm geschlossen.
     */
    private static Parent loadFXML(FXMLLoader fxmlLoader)  {
        try {
            return fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
            return null;
        }
    }

}