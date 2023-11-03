package JSONP.Aufgabe01;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import jakarta.json.JsonReader;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.json.bind.JsonbConfig;

public class App {

    public static void main(String[] args) throws IOException {

        // JsonB-Kontext erzeugen
        JsonbConfig config = new JsonbConfig().withFormatting(true);
        Jsonb jsonb = JsonbBuilder.create(config);

        // Deserialisieren aus JSON Datei // Json aus Datei Lesen
        JsonReader jsonReader = Json.createReader(new FileReader("./src/main/java/JSONP/Aufgabe01/lieferscheinA.json"));
        JsonObject lieferscheinJson = jsonReader.readObject();

        // Auf Werte Zugreifen
        var nummer = lieferscheinJson.getInt("nummer");
        var kunde = lieferscheinJson.getJsonObject("kunde").getString("name");
        System.out.println("Lieferschein-Nummer: " + nummer);
        System.out.println("Kunde: " + kunde);

        // Neues Json erstellen
        JsonObjectBuilder lieferscheinB = Json.createObjectBuilder().add("name", kunde);
        JsonObject neuJson = Json.createObjectBuilder().add("besteller", lieferscheinB).add("nummer", nummer).build();
        System.out.println(neuJson);

        // Serialisieren in JSON String
        String jsonString = neuJson.toString();

        // Serialisieren in JSON Datei
        try (FileWriter fw = new FileWriter("./src/main/java/JSONP/Aufgabe01/lieferscheinB.json")) {
            jsonb.toJson(jsonString , fw);
        }
    }
}