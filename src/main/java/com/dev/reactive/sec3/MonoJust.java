package com.dev.reactive.sec3;

import com.dev.reactive.subscriber.SubscriberImpl;
import org.reactivestreams.Subscriber;
import reactor.core.publisher.Mono;

public class MonoJust {
    public static void main(String[] args) {
        Mono<String> mono = Mono.just("Sayan Chatterjee");
        var subscriber = new SubscriberImpl();
        mono.subscribe(subscriber);
        subscriber.getSubscription().request(10);


    }
}
