package myphone;

public class Headset {
    private boolean connected;

    public Headset() {
        this.connected = false;
    }

    public void connect() {
        connected = true;
        System.out.println("Headset connected.");
    }

    public void disconnect() {
        connected = false;
        System.out.println("Headset disconnected.");
    }

    public boolean isConnected() {
        return connected;
    }
}
