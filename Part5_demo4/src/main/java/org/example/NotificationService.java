package org.example;

import java.util.*;

public class NotificationService {
    private final Map<Event, List<EvenListener>> customers;

    public NotificationService(){
        customers = new HashMap<>();
        Arrays.stream(Event.values()).forEach(event ->
                customers.put(event, new ArrayList<>())
        );
    }

    public void notify (Event eventType, EmailMsgListener listener ){
        customers.get(eventType).forEach(evenListener ->
                listener.update(eventType));
    }

    public void subcribe (Event eventType, EmailMsgListener listener){
        customers.get(eventType).add(listener);
    }

    public void unsubcribe (Event eventType, EmailMsgListener listener){
        customers.get(eventType).remove(listener);
    }

}
