package JSONP.Aufgabe01_Loesung;

import java.io.FileNotFoundException;
import java.io.FileReader;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import jakarta.json.JsonReader;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.json.bind.JsonbConfig;

public class App {

    public static void main(String[] args) throws FileNotFoundException {
        
        // JsonB-Kontext erzeugen
        JsonbConfig config = new JsonbConfig().withFormatting(true);
        Jsonb jsonb = JsonbBuilder.create(config);

        // Json aus Datei Lesen
        JsonReader jsonReader = Json.createReader(new FileReader("./src/main/java/JSONP/Aufgabe01_Loesung/lieferschein.json"));
        JsonObject lieferscheinJson = jsonReader.readObject();
        System.out.println(jsonb.toJson(lieferscheinJson));

        // Auf Werte Zugreifen
        var nummer = lieferscheinJson.getInt("nummer");
        var kunde = lieferscheinJson.getJsonObject("kunde").getString("name");
        System.out.println("Lieferschein-Nummer: " + nummer);
        System.out.println("Kunde: " + kunde);

        // Neues Json erstellen
        JsonObjectBuilder kundeJson = Json.createObjectBuilder().add("name", kunde);
        JsonObject neuJson = Json.createObjectBuilder().add("besteller", kundeJson).add("nummer", nummer).build();
        System.out.println(neuJson);
    }
}