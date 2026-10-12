package smarthome;

public class Task3Demo {
    public static void main(String[] args) {
        SmartHome home = new SmartHome("Morning home");

        Light light = new Light("Bedroom light", 30);
        Thermostat thermostat = new Thermostat("Hallway thermostat", 19.5);
        MotionSensor sensor = new MotionSensor("Hallway sensor");

        home.addDevice(light);
        home.addDevice(thermostat);
        home.addDevice(sensor);

        // give the two schedulable devices different planned times
        light.setScheduledTime("07:00");
        thermostat.setScheduledTime("06:30");

        // simulate the sensor reporting movement
        sensor.turnOn();
        sensor.setMotionDetected(true);

        System.out.println("Initial overview with different scheduled times:");
        home.showDevices();

        // treat the light and thermostat through their shared ability
        Schedulable[] schedulableDevices = {light, thermostat};
        for (Schedulable device : schedulableDevices) {
            device.setScheduledTime("08:00");
            System.out.println("Scheduled time set to: " + device.getScheduledTime());
        }

        System.out.println("\nOverview after the common scheduling operation:");
        home.showDevices();
    }
}