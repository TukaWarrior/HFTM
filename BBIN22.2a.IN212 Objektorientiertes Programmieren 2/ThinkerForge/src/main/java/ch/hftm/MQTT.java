package ch.hftm;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class MQTT {

    public static void main(String[] args) throws MqttException {

        String broker = "tcp://test.mosquitto.org:1883";
        String clientId = "" + Math.random();
        MqttClient client = new MqttClient(broker, clientId, new MemoryPersistence());
        client.connect();


        //send hello to topic hftm with QoS 0 and no retain
        String text = "1";
        MqttMessage mm = new MqttMessage(text.getBytes());
        client.publish("hftm/thinkerforge/rotarypoti", mm);




//        //receive part in a class implementing MqttCallback
//        client.setCallback(this);
//        client.subscribe("hftm/dice");
//        @Override
//        public void messageArrived(String topic, MqttMessage mm)
//        {
//            System.out.println(topic + ":" + mm.toString());
//        }

    }
}
