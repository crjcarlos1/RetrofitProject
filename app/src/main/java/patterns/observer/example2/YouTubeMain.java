package patterns.observer.example2;

import patterns.observer.example2.models.Channel;

public class YouTubeMain {
    public static void main(String... args) {

        Channel myChannel = new Channel();
        Subscriber subscriber1 = new Subscriber("Carlos");
        Subscriber subscriber2 = new Subscriber("María");
        Subscriber subscriber3 = new Subscriber("Jorge");
        Subscriber subscriber4 = new Subscriber("Nancy");
        Subscriber subscriber5 = new Subscriber("Katya");

        myChannel.subscribe(subscriber1);
        myChannel.subscribe(subscriber2);
        myChannel.subscribe(subscriber3);
        myChannel.subscribe(subscriber4);
        myChannel.subscribe(subscriber5);

        subscriber1.subscribeChannel(myChannel);
        subscriber2.subscribeChannel(myChannel);
        subscriber3.subscribeChannel(myChannel);
        subscriber4.subscribeChannel(myChannel);
        subscriber5.subscribeChannel(myChannel);

        myChannel.upload("Video nuevo");

    }
}
