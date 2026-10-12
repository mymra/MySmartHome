package smarthome;

import myphone.MyPhone;

public class Task4Demo {
    public static void main(String[] args) {
        // Create one home and register its devices.
        SmartHome home = new SmartHome("My home");
        Light light = new Light("Living room light", 30);
        Thermostat thermostat = new Thermostat("Hallway thermostat", 19.5);
        MotionSensor sensor = new MotionSensor("Hallway sensor");

        home.addDevice(light);
        home.addDevice(thermostat);
        home.addDevice(sensor);

        // Give the app a reference to the existing home.
        SmartHomeApp app = new SmartHomeApp(home);
        MyPhone phone = new MyPhone("Samsung", "Galaxy S24", 256, 70);
        phone.installApp(app);

        // Start the installed app through the phone.
        phone.startApp("SmartHome");

        // Perform common and type-specific actions through the app.
        app.turnOnDevice("Living room light");
        app.changeBrightness("Living room light", 75);
        app.changeTemperature("Hallway thermostat", 22.0);
        app.scheduleDevice("Living room light", "07:00");

        System.out.println("\nHome status after changes through the app:");
        home.showDevices();

        // The app and the demo refer to the exact same device object.
        System.out.println("\nSame light object: "
                + (home.findDevice("Living room light") == light));
    }
}