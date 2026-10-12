package smarthome;

public class Thermostat extends SmartDevice {
    private double temperature;

    public Thermostat(String name, double temperature) {
        super(name);
        setTemperature(temperature);
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        if (temperature >= -45 && temperature <= 45) {
            this.temperature = temperature;
        } else {
            System.out.println("Temperature must be between 5 and 35 degrees.");
        }
    }

    @Override
    public String getStatus() {
        return "Thermostat: " + getName()
                + " | On: " + isOn()
                + " | Temperature: " + temperature + " C";
    }
}