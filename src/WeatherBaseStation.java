import java.util.Observable;

import static java.lang.Thread.sleep;

public class WeatherBaseStation extends Observable implements Runnable{

    private double temperature;
    private double humidity;

    public WeatherBaseStation() {

    }

    public void generateWeather(){
        setChanged();
        this.temperature = Math.random()*212;
        this.humidity = Math.random() * 100;
        notifyObservers();
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        setChanged();
        this.temperature = temperature;
        notifyObservers();
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        setChanged();
        this.humidity = humidity;
        notifyObservers();
    }

    @Override
    public void run() {
        while(true){
            generateWeather();
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
