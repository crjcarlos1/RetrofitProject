package patterns.observer.example3.models;

import java.util.ArrayList;
import java.util.List;

import patterns.observer.example3.interfaces.ChannelObservable;

/*
        El canal manda notificaciones a todos los subscriptores
        El canal agrega video y notifica a cada subscriptor
        El canal elimina video y notifica a los subscriptores
 */

public class Channel implements ChannelObservable {

    private String name;

    private List<Subscriber> subscribers;

    public Channel(String name) {
        this.name = name;
        subscribers = new ArrayList<>();
    }

    public void addSubsCriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void removeSubscriber(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void addNewVideo(String newVideo) {
        notifySubscribers("hay nuevo video: " + newVideo);
    }

    @Override
    public void notifySubscribers(String notification) {
        for (Subscriber subscriber : subscribers) {
            subscriber.newNotification(notification);
        }
    }
}
