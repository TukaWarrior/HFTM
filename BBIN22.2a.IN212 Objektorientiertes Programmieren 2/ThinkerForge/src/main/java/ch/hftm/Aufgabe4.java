package ch.hftm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Aufgabe4 {

    public static void main(String args[]) {

        System.out.println("Hello");

        try {
            // The REST Endpoint you provided, with the query parameters for color and state
            String url = "http://192.168.33.1/color/0?red=255&turn=on";

            // Create a URL object
            URL obj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

            // Optional default is GET
            connection.setRequestMethod("GET");

            // Add request header if necessary, for example, if your device requires authentication
            // connection.setRequestProperty("User-Agent", "Mozilla/5.0");

            int responseCode = connection.getResponseCode();
            System.out.println("\nSending 'GET' request to URL : " + url);
            System.out.println("Response Code : " + responseCode);

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Print the response
//            System.out.println(response.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }

}
}
