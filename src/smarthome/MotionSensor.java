package smarthome;

// a motion sensor is a smart device, but doesnt support scheduling
public class MotionSensor extends SmartDevice {
    private boolean motionDetected;

    public MotionSensor(String name) {
        super(name);
        this.motionDetected = false;
    }

    // update whether the sensor has detected motion
    public void setMotionDetected(boolean motionDetected) {
        this.motionDetected = motionDetected;
    }

    public boolean isMotionDetected() {
        return motionDetected;
    }

    // show the shared state and the sensors own motion info
    @Override
    public String getStatus() {
        return "Motion sensor: " + getName()
                + " | On: " + isOn()
                + " | Motion detected: " + motionDetected;
    }
}