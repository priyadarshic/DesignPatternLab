package pattern.behavioral.observer;


import java.util.Observable;
import java.util.Observer;

public class EventObserver implements Observer {
    private String resp;
    private String observerName;

    EventObserver(String observerName){
        this.observerName = observerName;
    }

    public void update(Observable obj, Object arg) {
        if (arg instanceof String) {
            resp = (String) arg;
            System.out.println( observerName + " Received Response: " + resp );
        }
    }
}