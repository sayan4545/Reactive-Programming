package com.dev.reactive.sec4;

import reactor.core.publisher.Mono;

import static com.dev.reactive.common.Utils.subscriber;

public class MonoErrorHandling {

    public static void main(String[] args) {
        //getUserById(1).subscribe(subscriber());

        //getUserById(3).subscribe(subscriber());
        getUserById(3).subscribe(System.out::println);


    }

    private static <T> Mono<T> getUserById(int userId){
        return switch (userId){
            case 1-> Mono.just((T) "Sayan");
            case 2-> Mono.empty();
            default -> Mono.error(new RuntimeException("Invalid entry"));
        };
    }
}
