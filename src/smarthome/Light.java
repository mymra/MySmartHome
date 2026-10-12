package smarthome;

public class Light extends SmartDevice {
    private int brightness;

    public Light(String name, int brightness) {
        super(name);
        setBrightness(brightness);
    }

    public int getBrightness() {
        return brightness;
    }

    public void setBrightness(int brightness) {
        if (brightness >= 0 && brightness <= 100) {
            this.brightness = brightness;
        } else {
            System.out.println("Brightness must be between 0 and 100.");
        }
    }

    @Override
    public String getStatus() {
        return "Light: " + getName()
                + " | On: " + isOn()
                + " | Brightness: " + brightness + "%";
    }
}