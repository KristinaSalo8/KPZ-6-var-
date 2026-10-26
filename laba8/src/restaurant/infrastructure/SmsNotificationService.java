package restaurant.infrastructure;

import restaurant.application.NotificationService;
public class SmsNotificationService implements NotificationService {
    @Override
    public void send(String phone, String message) {
        System.out.println("[SMS] " + message + " надіслано на номер " + phone);
    }
}
