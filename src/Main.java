import static java.lang.Thread.sleep;

public class Main {

    public static void main(String[] args) {
        WeatherBaseStation station = new WeatherBaseStation();
        WeatherBaseStation station2 = new WeatherBaseStation();

        WeatherAppScreen app1 = new WeatherAppScreen(station);
        WeatherAppScreen app2 = new WeatherAppScreen(station);

        Thread t1 = new Thread(station);
        Thread t2 = new Thread(station2);
        t1.start();
        t2.start();

        app1.subscribe();
        app2.subscribe();

        try {
            sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        app2.unsubscribe();

        System.out.println();
        System.out.println("================================================================================================================");
        System.out.println();

        app2.setObserverable(station2);
        app2.subscribe();
    }
}
