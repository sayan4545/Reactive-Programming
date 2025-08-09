package com.dev.reactive.common;

import com.github.javafaker.Faker;
import org.reactivestreams.Subscriber;
import reactor.core.publisher.Mono;

public class Utils {

    private static Faker faker = Faker.instance();

    public static <T> Subscriber<T> subscriber(){
        return new DefaultSubscriber<>("");
    }

    public static Faker faker(){
        return faker;
    }

    public static <T> Subscriber<T> subscriber(String name){
        return new DefaultSubscriber<>(name);
    }

    public static void sleepInSeconds(){
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        var mono = Mono.just(1);
        mono.subscribe(subscriber());
        mono.subscribe(subscriber("Sayan"));
        mono.subscribe(subscriber("Chatterjee"));
    }
}
