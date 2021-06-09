package pattern.creational.factory;

public class FactoryPattern {
    public static void main(String[] args)
    {
        //EMAIL, SMS, PUSH parameters accepted
        NotificationFactory notificationFactory = new NotificationFactory();
        INotification notification = notificationFactory.createNotificationClass("Email");
        notification.notifyUser();
    }
}
