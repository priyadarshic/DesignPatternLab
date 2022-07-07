/*
 * Copyright (c) 2021.
 * All Intellectual Property Rights to this File/Digital Product belong to the @Author
 * @PriyadarshiChaudhuri. Contact priyadarshi.c@gmail.com for enquiries.
 * This File maybe used for Non-commercial purpose only with Credits and link to GitHub repository.
 */

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
            System.out.println( observerName + " :=> Received Response: " + resp );
        }
    }
}