package smarthome;

import java.util.ArrayList;

public class SmartHome {
    private String name;
    private ArrayList<SmartDevice> devices;

    public SmartHome(String name) {
        this.name = name;
        this.devices = new ArrayList<>();
    }

    //register device in the home
    public void addDevice(SmartDevice device) {
        if (device != null) {
            devices.add(device);
        }
    }

    // show the current status of every reg. device
    public void showDevices() {
        System.out.println("Devices in " + name + ":");

        if (devices.isEmpty()) {
            System.out.println("No devices registered.");
            return;
        }

        for (SmartDevice device : devices) {
            System.out.println(device.getStatus());
        }
    }

    // find a registered device by name, null if doesnt exist
    public SmartDevice findDevice(String deviceName) {
        for (SmartDevice device : devices) {
            if (device.getName().equalsIgnoreCase(deviceName)) {
                return device;
            }
        }
        return null;
    }

    // turn on only the device selected by name
    public void turnOnDevice(String deviceName) {
        SmartDevice device = findDevice(deviceName);

        if (device != null) {
            device.turnOn();
        } else {
            System.out.println("Device not found: " + deviceName);
        }
    }

    // turn off only the device selected by name
    public void turnOffDevice(String deviceName) {
        SmartDevice device = findDevice(deviceName);

        if (device != null) {
            device.turnOff();
        } else {
            System.out.println("Device not found: " + deviceName);
        }
    }

    //turn off every registered device
    public void turnOffAll() {
        for (SmartDevice device : devices) {
            device.turnOff();
        }
    }
}