package pattern.behavioral.observer;

public class ObserverPatternDemo {
    public static void main(String[] args) {

        // create an event source - reads from stdin
        final EventSource eventSource = new EventSource();

        // create first observer
        final EventObserver channel1 = new EventObserver("ChannelOne");

        // create second observer
        final EventObserver channelX = new EventObserver("ChannelX");

        // subscribe the observer to the event source
        eventSource.addObserver(channelX);

        // subscribe the observer to the event source
        eventSource.addObserver(channel1);


        // starts the event thread
        Thread thread = new Thread(eventSource);
        thread.start();
    }
}
