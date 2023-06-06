import java.time.LocalTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Datumshandling {

    public static void main(String[] args) {

        // Erstelle ein Objekt mit der aktuellen Zeit
        // Speichert die Zeit in hh:mm:ss.ms
        LocalTime myTime = LocalTime.now();
        System.out.println("Current exact Time: " +myTime);
        
        // Gib das Datum mit Schweizerformat aus: Tag.Monat.Jahr
        LocalDate myDate = LocalDate.now();
        DateTimeFormatter myFormatDate = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String myDateFormatted = myDate.format(myFormatDate);
        System.out.println("Current Date: " +myDateFormatted);

        // Gib die Uhrzeit mit Schweizerformat aus: Stunde:Minute:Sekunde
        DateTimeFormatter myFormatTime = DateTimeFormatter.ofPattern("HH:mm:ss");
        String myTimeFormatted = myTime.format(myFormatTime);
        System.out.println("Current Time: " +myTimeFormatted);

        // Ermittle den Wochentag und gib ihn aus
        DateTimeFormatter myFormatWeekday = DateTimeFormatter.ofPattern("E");
        String myWeekdayFormatted = myDate.format(myFormatWeekday);
        System.out.println("Current Weekday: " +myWeekdayFormatted);
    }
}
