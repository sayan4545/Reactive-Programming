package com.dev.reactive.sec4;

import com.dev.reactive.common.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.util.List;

public class MonoFromSupplier {
    private static final Logger log = LoggerFactory.getLogger(MonoFromSupplier.class);

    public static void main(String[] args) {
        var list = List.of(1,2,3);
        Mono.fromSupplier(()-> sum(list))
                .subscribe(Utils.subscriber());

        Mono.fromCallable(()->sum(list))
                .subscribe(Utils.subscriber());
    }

    private static int sum(List<Integer> list){
        log.info("finding the sum of {} ",list);
        return list.stream().mapToInt(a->a).sum();
    }

}
