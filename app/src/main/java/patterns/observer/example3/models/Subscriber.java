package patterns.observer.example3.models;

import patterns.observer.example3.interfaces.SubscriberObserver;

/*
        El subscriptor recibe las notificaciones
 */
public class Subscriber implements SubscriberObserver {

    private String name;

    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void newNotification(String notification) {
        System.out.println("Hey " + name + " " + notification);
    }

}
