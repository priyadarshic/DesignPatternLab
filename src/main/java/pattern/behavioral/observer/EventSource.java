package pattern.behavioral.observer;

//This is a class.

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
}// End of the Eventsource class.