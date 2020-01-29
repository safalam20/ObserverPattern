package weatherStation;

import java.util.ArrayList;
import java.util.List;

/*
A concrete subject always implements the Subject
interface. In addition to the register and remove
methods, the concrete subject implements a notifyObservers()
method that is used to update all the current observers whenever state changes.
 */
public class WeatherData implements Subject {
    //We’ve added an ArrayList to hold the Observers, and we
    //create it in the constructor.
    private List<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {
        this.observers=new ArrayList<>();
    }
    //We notify the Observers when
    //we get updated measurements
    //from the Weather Station.
    public void measurementsChanged(){
        notifyObservers();
    }

    public void setMeasurements(float temperature,float humidity, float pressure){
        this.temperature=temperature;
        this.humidity=humidity;
        this.pressure=pressure;
        measurementsChanged();
    }


    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    //this is where we tell all the observers about the state.
    //Because they are all Observers, we know they all implement update(), so
    //we know how to notify them.
    @Override
    public void notifyObservers() {
        for (Observer ob : observers){
            ob.update(temperature,humidity,pressure);
        }
    }
}
