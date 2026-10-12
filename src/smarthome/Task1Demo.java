package smarthome;

public class Task1Demo {
    public static void main(String[] args) {
        // Create two different devices with different starting values.
        Light livingRoomLight = new Light("Living room", 30);
        Thermostat hallwayThermostat = new Thermostat("Hallway", 19.5);

        // Treat both devices as SmartDevice objects.
        SmartDevice[] devices = {livingRoomLight, hallwayThermostat};

        System.out.println("Initial status:");
        for (SmartDevice device : devices) {
            System.out.println(device.getStatus());
        }

        // Turn on both devices and change their type-specific settings.
        livingRoomLight.turnOn();
        hallwayThermostat.turnOn();
        livingRoomLight.setBrightness(75);
        hallwayThermostat.setTemperature(22.0);

        System.out.println("\nStatus after changes:");
        for (SmartDevice device : devices) {
            System.out.println(device.getStatus());
        }
    }
}