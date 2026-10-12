package myphone;

public class App {
    private String appName;
    private String version;

    public App(String appName, String version) {
        this.appName = appName;
        this.version = version;
    }

    public String getAppName() {
        return appName;
    }

    public String getVersion() {
        return version;
    }

    public void run() {
        System.out.println(appName + " is running.");
    }

    // This overloaded method can show extra information.
    public void run(boolean debugMode) {
        run();

        if (debugMode) {
            System.out.println("Debug information:");
            System.out.println("App: " + appName);
            System.out.println("Version: " + version);
        }
    }
}
