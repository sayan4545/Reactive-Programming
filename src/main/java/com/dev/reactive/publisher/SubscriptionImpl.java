package com.dev.reactive.publisher;

import com.dev.reactive.subscriber.SubscriberImpl;
import com.github.javafaker.Faker;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SubscriptionImpl implements Subscription {
    private static final Logger log = LoggerFactory.getLogger(SubscriberImpl.class);
    private final Subscriber<? super String> subscriber;
    private boolean isCancelled;
    private final Faker faker;
    private static final int MAX  = 10;
    private int count = 0;
    public SubscriptionImpl(Subscriber<? super String> subscriber){
        this.subscriber=subscriber;
        this.faker = Faker.instance();
    }

    @Override
    public void request(long requested) {
        if(isCancelled) return;
        log.info("requested items {}",requested);
        for(int i=0;i<requested && count<MAX;i++){
            //log.info("email id is {}",faker.internet().emailAddress());
            this.subscriber.onNext(this.faker.internet().emailAddress());
            count++;
        }
        if(count==MAX){
            log.info("No more data to request");
            this.subscriber.onComplete();
            isCancelled = true;
        }
    }

    @Override
    public void cancel() {
        log.info("subscription cancelled");
        isCancelled = true;
    }
}
