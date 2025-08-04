package com.dev.reactive.sec4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;
public class MonoOverloadedMethods {
    private static final Logger log = LoggerFactory.getLogger(MonoOverloadedMethods.class);
    public static void main(String[] args) {
        var mono = Mono.just(1).map(i->i+2);
       // mono.subscribe(i->log.info("recieved:{}",i));

        mono.subscribe(i->log.info("recieved:{}",i),err->log.info("Error"),()-> log.info("Completed"));


    }
}
