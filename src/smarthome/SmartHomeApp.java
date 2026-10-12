package smarthome;

import myphone.App;

// the app is a phone app that controls an existing SmartHome object
public class SmartHomeApp extends App {
    private SmartHome home;

    public SmartHomeApp(SmartHome home) {
        super("SmartHome", "1.0");
        this.home = home;
    }

    // MyPhone can call run() through the general App type
    @Override
    public void run() {
        super.run();
        home.showDevices();
    }
    // use the homes common methods to turn a selected device on or off
    public void turnOnDevice(String deviceName) {
        home.turnOnDevice(deviceName);
    }

    public void turnOffDevice(String deviceName) {
        home.turnOffDevice(deviceName);
    }

    // change brightness only when the selected device is a light
    public void changeBrightness(String deviceName, int brightness) {
        SmartDevice device = home.findDevice(deviceName);

        if (device instanceof Light) {
            Light light = (Light) device;
            light.setBrightness(brightness);
        } else {
            System.out.println("Light not found: " + deviceName);
        }
    }

    // change temperature only when the selected device is a thermostat
    public void changeTemperature(String deviceName, double temperature) {
        SmartDevice device = home.findDevice(deviceName);

        if (device instanceof Thermostat) {
            Thermostat thermostat = (Thermostat) device;
            thermostat.setTemperature(temperature);
        } else {
            System.out.println("Thermostat not found: " + deviceName);
        }
    }

    // use the scheduling ability only on devices that support it
    public void scheduleDevice(String deviceName, String time) {
        SmartDevice device = home.findDevice(deviceName);

        if (device instanceof Schedulable) {
            Schedulable schedulable = (Schedulable) device;
            schedulable.setScheduledTime(time);
        } else {
            System.out.println("Device cannot be scheduled: " + deviceName);
        }
    }
    // Turn off all registered devices through the app
    public void turnOffAll() {
        home.turnOffAll();
    }
}