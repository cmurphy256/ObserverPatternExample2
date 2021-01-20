import java.util.Observable;
import java.util.Observer;

public class WeatherAppScreen implements Observer{

    private double currentTemperature;
    private double previousTemperature;
    private Observable observerable;

    public WeatherAppScreen(){

    }

    public WeatherAppScreen(Observable obs){
        this.observerable = obs;
    }

    public void display(){
        System.out.println("--------------------------------------------------------");
        System.out.println("The current temperature is : "+ this.currentTemperature + "\u00B0 F");
        System.out.println("The previous temperature is : "+ this.previousTemperature + "\u00B0 F");
        System.out.println("--------------------------------------------------------");
    }

    @Override
    public void update(Observable o, Object arg) {
        if( o instanceof WeatherBaseStation){
            this.previousTemperature = this.currentTemperature;
            this.currentTemperature = ((WeatherBaseStation) o).getTemperature();
            display();
        }
    }

    public void subscribe(){
        this.observerable.addObserver(this);
    }

    public void unsubscribe(){
        this.observerable.deleteObserver(this);
    }

    public Observable getObserverable() {
        return observerable;
    }

    public void setObserverable(Observable observerable) {
        this.observerable = observerable;
    }
}
