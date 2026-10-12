package smarthome;

// a thermostat is a smart device and also supports scheduling
public class Thermostat extends SmartDevice implements Schedulable {
    private double temperature;

    // store a planned time as text; this is not a real timer
    private String scheduledTime;

    public Thermostat(String name, double temperature) {
        super(name);
        setTemperature(temperature);
    }

    public double getTemperature() {
        return temperature;
    }
    // accept temperatures from -45 to 45 degrees
    public void setTemperature(double temperature) {
        if (temperature >= -45 && temperature <= 45) {
            this.temperature = temperature;
        } else {
            System.out.println("Temperature must be between -45 and 45 degrees.");
        }
    }

    //include the shared state, temperature and scheduled time
    @Override
    public String getStatus() {
        return "Thermostat: " + getName()
                + " | On: " + isOn()
                + " | Temperature: " + temperature + " C"
                + " | Scheduled: " + (scheduledTime == null ? "none" : scheduledTime);
    }
    // save the planned time in this particular thermostat object
    @Override
    public void setScheduledTime(String time) {
        this.scheduledTime = time;
    }

    @Override
    public String getScheduledTime() {
        return scheduledTime;
    }
}
