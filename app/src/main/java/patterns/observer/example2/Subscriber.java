package patterns.observer.example2;

import patterns.observer.example2.models.Channel;

public class Subscriber {
    private String name;
    private Channel channel = new Channel();

    public Subscriber(String name) {
        this.name = name;
    }

    public void update() {
        System.out.println("Hey " + name + " video actualizado :)");
    }

    public void subscribeChannel(Channel channel) {
        this.channel = channel;
    }

}
