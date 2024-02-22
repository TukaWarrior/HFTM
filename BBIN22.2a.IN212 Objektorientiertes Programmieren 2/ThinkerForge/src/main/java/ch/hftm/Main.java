package ch.hftm;


import com.tinkerforge.BrickletSoundIntensity;
import com.tinkerforge.IPConnection;

public class Main {

    private static final String HOST = "localhost";
    private static final int PORT = 4223;

    // Change XYZ to the UID of your Sound Intensity Bricklet
    private static final String UID = "voF";

    public static void main(String[] args) throws Exception{
        System.out.println("Hello world!");

        IPConnection ipcon = new IPConnection(); // Create IP connection
        BrickletSoundIntensity si = new BrickletSoundIntensity(UID, ipcon);


        ipcon.connect(HOST, PORT); // Connect to brickd
        // Don't use device before ipcon is connected

        // Get current intensity

        while (true) {
            int intensity = si.getIntensity(); // Can throw com.tinkerforge.TimeoutException
            System.out.println("Intensity: " + intensity);

        }
//        System.out.println("Press key to exit"); System.in.read();

//        ipcon.disconnect();



    }
}