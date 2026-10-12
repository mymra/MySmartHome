package myphone;

import java.util.ArrayList;

public class MyPhone {
    private String brand;
    private String model;
    private int storageCapacity;
    private int batteryLevel;

    private ArrayList<App> apps;
    private Headset headset;

    public MyPhone(String brand, String model,
                   int storageCapacity, int batteryLevel) {
        this.brand = brand;
        this.model = model;
        this.storageCapacity = storageCapacity;

        // Use the setter so the first battery value is also checked.
        setBatteryLevel(batteryLevel);

        apps = new ArrayList<>();
        headset = new Headset();
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getStorageCapacity() {
        return storageCapacity;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(int batteryLevel) {
        if (batteryLevel >= 0 && batteryLevel <= 100) {
            this.batteryLevel = batteryLevel;
        } else {
            System.out.println("Battery level must be between 0 and 100.");
        }
    }

    public void charge(int amount) {
        if (amount <= 0) {
            System.out.println("Charge amount must be positive.");
            return;
        }

        batteryLevel = batteryLevel + amount;

        if (batteryLevel > 100) {
            batteryLevel = 100;
        }
    }

    public void use(int amount) {
        if (amount <= 0) {
            System.out.println("Usage amount must be positive.");
            return;
        }

        batteryLevel = batteryLevel - amount;

        if (batteryLevel < 0) {
            batteryLevel = 0;
        }
    }

    // A simple standard charge of 20 percent.
    public void chargePhone() {
        charge(20);
    }

    public void installApp(App app) {
        if (app != null) {
            apps.add(app);
        }
    }

    // start an installed app by name without knowing its specific type
    public void startApp(String appName) {
        for (App app : apps) {
            if (app.getAppName().equalsIgnoreCase(appName)) {
                app.run();
                return;
            }
        }

        System.out.println("App not installed: " + appName);
    }

    public void listApps() {
        System.out.println("Installed apps:");

        if (apps.isEmpty()) {
            System.out.println("No apps installed.");
            return;
        }

        for (App app : apps) {
            System.out.println(
                    app.getAppName() + " (version "
                            + app.getVersion() + ")"
            );
        }
    }

    public void connectHeadset() {
        headset.connect();
    }

    public void displayInfo() {
        System.out.println("Phone information:");
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Storage: " + storageCapacity + " GB");
        System.out.println("Battery: " + batteryLevel + "%");
        System.out.println("Headset connected: " + headset.isConnected());
    }
}
