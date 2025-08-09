package com.dev.reactive.sec4;

import com.dev.reactive.common.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

public class MonoFromRunnable {

    private static final Logger log = LoggerFactory.getLogger(MonoFromSupplier.class);

    public static void main(String[] args) {
        getProdName(1).subscribe(Utils.subscriber());
        getProdName(3).subscribe(Utils.subscriber());
    }
    private static Mono<String> getProdName(int prodId){
        if(prodId == 1) return Mono.fromSupplier(()-> Utils.faker().commerce().productName());
        //return Mono.empty();
        return Mono.fromRunnable(()-> notifyBusiness(prodId));

    }

    private static void notifyBusiness(int prodId){
        log.info("product with id {} is missing",prodId);
    }


}
