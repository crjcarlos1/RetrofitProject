package patterns.observer.example2.models;

import java.util.ArrayList;
import java.util.List;

import patterns.observer.example2.Subscriber;

public class Channel {

    private List<Subscriber> subscribers = new ArrayList<>();
    private String title;

    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void unSubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void upload(String title) {
        this.title = title;
        notifySubscribers();
    }

    public void notifySubscribers() {
        for (Subscriber subscriber : subscribers) {
            subscriber.update();
        }
    }

}
