package weatherStation;
/*
All potential observers need to implement the Observer
interface. This interface just has one method, update(),
that gets called when the Subject’s state changes.
 */
public interface Observer {

    public void update(float temp, float humidity, float pressure);
}
