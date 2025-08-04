package com.dev.reactive;

import com.dev.reactive.publisher.PublisherImpl;
import com.dev.reactive.subscriber.SubscriberImpl;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {
        demo1();
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

        }
        private static void demo1() throws Exception{
            var publisher = new PublisherImpl();
            var subscriber = new SubscriberImpl();
            publisher.subscribe(subscriber);
            subscriber.getSubscription().request(3);
            Thread.sleep(3000);
            subscriber.getSubscription().request(4);
            Thread.sleep(3000);
            subscriber.getSubscription().request(5);
            subscriber.getSubscription().request(5);
            subscriber.getSubscription().request(5);
        }



}