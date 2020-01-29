package weatherStation;
/*
Concrete observers can be any class that implements the Observer interface. Each
observer registers with a concrete subject to receive updates.
 */
//This display implements Observer
//so it can get changes from the
//WeatherData object.
public class CurrentConditionsDisplay implements Observer, DisplayElement {

    private float temperature;
    private float humidity;
    private Subject weatherData;

   /* Observer classes should be able to register themselves.
      That's why we need to create the Subject instance
      and use registerObserver() method.*/

    public CurrentConditionsDisplay(Subject weatherData){
        this.weatherData=weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Current Conditions : "+temperature+" F degrees and "+humidity+" % humidity");

    }

    //This method is called from WeatherData class(when WeatherData class has changes)

    //When update() is called, we
    //save the temp and humidity
    //and call display().
    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature=temp;
        this.humidity=humidity;
        display();
    }
}
