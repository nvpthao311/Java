package org.example;


public class Main {
    public static void main(String[] args) {
        Store store = new Store();
        store.getNotificationService().subcribe(Event.NEW_ITEM,new EmailMsgListener("1111111111"));
        store.getNotificationService().subcribe( Event.NEW_ITEM,new EmailMsgListener("22222222222222"));
        store.getNotificationService().subcribe(Event.SALE,new EmailMsgListener("3333333333333333"));

        store.newItemPromotion();
    }
}