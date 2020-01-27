package patterns.observer.example3;

import patterns.observer.example3.models.Channel;
import patterns.observer.example3.models.Subscriber;

public class Youtube {

    public static void main(String... args) {
        /*creamos canal*/
        Channel channel = new Channel("UAM");

        /*creamos subscriptores*/
        Subscriber subscriber0 = new Subscriber("Subscriber 1");
        Subscriber subscriber1 = new Subscriber("Subscriber 2");
        Subscriber subscriber2 = new Subscriber("Subscriber 3");
        Subscriber subscriber3 = new Subscriber("Subscriber 4");
        Subscriber subscriber4 = new Subscriber("Subscriber 5");

        /*nos subscribimos al canal*/
        channel.addSubsCriber(subscriber0);
        channel.addSubsCriber(subscriber1);
        channel.addSubsCriber(subscriber2);
        channel.addSubsCriber(subscriber3);
        channel.addSubsCriber(subscriber4);

        System.out.println("al dia siguiente se va sub 3");
        channel.removeSubscriber(subscriber2);

        System.out.println("Pasan 4 dias despues y subimos nuevo video");

        channel.addNewVideo("How to programmin in java");
    }
}
