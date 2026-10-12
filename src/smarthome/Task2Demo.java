package smarthome;

public class Task2Demo {
    public static void main(String[] args) {
        SmartHome home = new SmartHome("My home");

        Light livingRoomLight = new Light("Living room light", 30);
        Light kitchenLight = new Light("Kitchen light", 50);
        Thermostat hallwayThermostat = new Thermostat("Hallway thermostat", 19.5);

        // register 3 devices after creating the home
        home.addDevice(livingRoomLight);
        home.addDevice(kitchenLight);
        home.addDevice(hallwayThermostat);

        System.out.println("Initial overview:");
        home.showDevices();

        // turn on several devices through SmartHome
        home.turnOnDevice("Living room light");
        home.turnOnDevice("Kitchen light");
        home.turnOnDevice("Hallway thermostat");

        System.out.println("\nAfter turning on three devices:");
        home.showDevices();

        // turn off one device; the other two should remain on
        home.turnOffDevice("Kitchen light");

        System.out.println("\nAfter turning off only the kitchen light:");
        home.showDevices();

        // turn off every registered device with one action
        home.turnOffAll();

        System.out.println("\nAfter turning off all devices:");
        home.showDevices();
    }
}