package pattern.creational.factory;

public class PushNotification implements INotification{
    @Override
    public void notifyUser() {
        System.out.println("Sending a Push Notification");
    }
}
