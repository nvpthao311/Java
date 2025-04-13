package org.example;

public class Store {
    private final NotificationService notificationService;

    public Store(){
        notificationService = new NotificationService();
    }

    public void newItemPromotion(){
//        notificationService.notify();
    }

    public NotificationService getService(){
        return  notificationService;
    }

    public NotificationService getNotificationService() {
        return notificationService;
    }
}
