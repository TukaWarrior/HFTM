package ch.hftm;

import com.tinkerforge.IPConnection;
import com.tinkerforge.BrickletRGBLEDButton;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Copy {

    private static final String HOST = "localhost";
    private static final int PORT = 4223;

    private static final String UID = "25jp";

    public static void main(String[] args) throws Exception{

        Random rand = new Random();
        int upperbound = 255;


        IPConnection ipcon = new IPConnection(); // Create IP connection
        BrickletRGBLEDButton rlb = new BrickletRGBLEDButton(UID, ipcon); // Create device object

        ipcon.connect(HOST, PORT); // Connect to brickd
        // Don't use device before ipcon is connected


            // Set light blue color
//        while (true) {
//            System.out.println("|||");
//            rlb.setColor(rand.nextInt(upperbound), rand.nextInt(upperbound), rand.nextInt(upperbound));
//            TimeUnit.MILLISECONDS.sleep(100);
//        }

        int state = rlb.getButtonState();
        if (state == BrickletRGBLEDButton.BUTTON_STATE_PRESSED) {
            //            rlb.setColor(rand.nextInt(upperbound), rand.nextInt(upperbound), rand.nextInt(upperbound));

        }
//        System.out.println("Press key to exit");System.in.read();
//        ipcon.disconnect();
    }
}