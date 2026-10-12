package myphone;

public class MyPhoneDemo {
    public static void main(String[] args) {
        // 1. Create a phone.
        MyPhone phone = new MyPhone(
                "Samsung", "Galaxy S24", 256, 70
        );

        // 2. Create and install two apps.
        App weatherApp = new App("Weather", "1.0");
        App musicApp = new App("Music", "2.1");

        phone.installApp(weatherApp);
        phone.installApp(musicApp);

        // 3. Run the apps.
        weatherApp.run();
        musicApp.run(true);

        // 4. Connect the phone's headset.
        phone.connectHeadset();

        // 5. Use and charge the phone.
        phone.use(25);
        phone.charge(10);
        phone.chargePhone();

        // 6. Display the final status.
        System.out.println();
        phone.displayInfo();

        System.out.println();
        phone.listApps();
    }
}
