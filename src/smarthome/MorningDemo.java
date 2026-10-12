package smarthome;

import myphone.MyPhone;

public class MorningDemo {
    public static void main(String[] args) {
        // All four devices belong to the same home
        SmartHome home = new SmartHome("Morning home");
        Light bedroomLight = new Light("Bedroom light", 25);
        Light kitchenLight = new Light("Kitchen light", 40);
        Thermostat thermostat = new Thermostat("Hallway thermostat", 19.5);
        MotionSensor sensor = new MotionSensor("Hallway sensor");

        home.addDevice(bedroomLight);
        home.addDevice(kitchenLight);
        home.addDevice(thermostat);
        home.addDevice(sensor);

        // Install the app on MyPhone; it uses the existing home
        SmartHomeApp app = new SmartHomeApp(home);
        MyPhone phone = new MyPhone("Samsung", "Galaxy S24", 256, 80);
        phone.installApp(app);

        System.out.println("=== EARLY MORNING ===");
        phone.startApp("SmartHome");

        // Plan two devices for different times through the app.
        app.scheduleDevice("Hallway thermostat", "06:30");
        app.scheduleDevice("Bedroom light", "07:00");

        System.out.println("\n=== MORNING ROUTINE ===");
        home.showDevices(); // Shows both scheduled times.

        // Common actions and two type-specific actions through the app.
        app.turnOnDevice("Hallway thermostat");
        app.turnOnDevice("Bedroom light");
        app.turnOnDevice("Kitchen light");
        app.changeTemperature("Hallway thermostat", 21.5);
        app.changeBrightness("Bedroom light", 70);

        // Simulate motion detected by the hallway sensor
        sensor.turnOn();
        sensor.setMotionDetected(true);

        System.out.println("\n=== AFTER MORNING ACTIONS ===");
        home.showDevices();

        System.out.println("\n=== LEAVING HOME ===");
        app.turnOffAll();
        sensor.setMotionDetected(false);

        System.out.println("\n=== FINAL HOME STATUS ===");
        home.showDevices();
    }
}