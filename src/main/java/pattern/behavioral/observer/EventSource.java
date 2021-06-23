/*
 * Copyright (c) 2021.
 * All Intellectual Property Rights to this File/Digital Product belong to the @Author
 * @PriyadarshiChaudhuri. Contact priyadarshi.c@gmail.com for enquiries.
 * This File maybe used for Non-commercial purpose only with Credits and link to GitHub repository.
 */

package pattern.behavioral.observer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Observable;

public class EventSource extends Observable implements Runnable {
    @Override
    public void run() {
        try {
            final InputStreamReader isr = new InputStreamReader(System.in);
            final BufferedReader br = new BufferedReader(isr);
            String response = "";
            while (!(response.equalsIgnoreCase("quit"))) {
                System.out.println("Enter Text >");
                response = br.readLine();

                setChanged();       //Marks this Observable object as having been changed;
                notifyObservers(response);

            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}// End of Eventsource class.