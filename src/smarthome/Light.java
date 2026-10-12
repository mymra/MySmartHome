package smarthome;

// a light is a smart device and also supports scheduling
public class Light extends SmartDevice implements Schedulable {
    private int brightness;

    // a scheduled time is stored as text; it doesnt activate a real timer
    private String scheduledTime;

    public Light(String name, int brightness) {
        super(name);
        setBrightness(brightness);
    }

    public int getBrightness() {
        return brightness;
    }
    // accept brightness values from 0 to 100%
    public void setBrightness(int brightness) {
        if (brightness >= 0 && brightness <= 100) {
            this.brightness = brightness;
        } else {
            System.out.println("Brightness must be between 0 and 100.");
        }
    }

    // include both the shared state and the lights own info
    @Override
    public String getStatus() {
        return "Light: " + getName()
                + " | On: " + isOn()
                + " | Brightness: " + brightness + "%"
                + " | Scheduled: " + (scheduledTime == null ? "none" : scheduledTime);
    }

    // save the planned time in this particular light object
    @Override
    public void setScheduledTime(String time) {
        this.scheduledTime = time;
    }

    @Override
    public String getScheduledTime() {
        return scheduledTime;
    }
}