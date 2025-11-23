
public class NotificationService {

    public void notifyUser(String userName, String message) {
        // For now just print; could be extended to email/SMS later
        System.out.println("Notification for " + userName + ": " + message);
    }
}
