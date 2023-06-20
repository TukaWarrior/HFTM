package ch.hftm;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    
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
     * Damit wir die gezeigtle Scene anpassen können, merken wir uns die Scene mit einer statischen Variable
     */
    private static Scene scene;

    /*
     * Die start()-Methode auf einer Application-Klasse ist der grundsätzliche Einstieg in eine JavaFX-Applikation
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = createFXMLLoader("PrimaryView.fxml");
        App.scene = new Scene(loadFXML(fxmlLoader), 640, 480);
        stage.setTitle("Gefängisverwaltung");
        // setScene() baut eine Szene grundsätzlich auf
        stage.setScene(scene);
        stage.show();
    }

    /*
     * Die beiden öffentlichen statischen Methoden erlauben den Wechsel der aktuellen Scene auf der "Haupt-Bühne"
     */
    public static void switchToEditView(Prisoner selectedPrisoner) {
        FXMLLoader fxmlLoader = createFXMLLoader("PrisonerEditView.fxml");
        // setRoot() ersetzt die Sichtbaren Elemente einer Szene, ohne dabei die ganze Szene neu aufbauen zu müssen
        App.scene.setRoot(loadFXML(fxmlLoader));

        // Über den Loader können wir den Controller identifizieren, um diesem den Prisoner mitzugeben
        // Dazu muss das Loading selber zwingend ausgeführt worden sein.
		PrisonerEditController controller = fxmlLoader.getController();
		controller.setPrisoner(selectedPrisoner);

    }
    public static void switchToMainView() {
        FXMLLoader fxmlLoader = createFXMLLoader("PrimaryView.fxml");
        App.scene.setRoot(loadFXML(fxmlLoader));
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