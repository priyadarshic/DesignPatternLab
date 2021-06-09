package pattern.creational.factory;

public class EmailNotification implements INotification{
    @Override
    public void notifyUser() {
        System.out.println("Sending an Email Notification");
    }
}
