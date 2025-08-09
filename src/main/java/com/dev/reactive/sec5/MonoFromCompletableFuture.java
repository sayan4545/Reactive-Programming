package com.dev.reactive.sec5;

import com.dev.reactive.common.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

public class MonoFromCompletableFuture {
    private static final Logger log = LoggerFactory.getLogger(MonoFromCompletableFuture.class);

    private static CompletableFuture<String> getName(){
        return CompletableFuture.supplyAsync(()->{
            log.info("Generated first name ");
            return Utils.faker().name().firstName();
        });
    }

    public static void main(String[] args) {
        Mono.fromFuture(getName()).subscribe(Utils.subscriber());
        Utils.sleepInSeconds();
    }
}
