package com.vedha.collections.reactive;

import reactor.core.publisher.Flux;

public class FluxDemo {

    public static Flux<?> producer(int cases) {

        // Flux means publisher produces one or more values.
        return switch (cases) {

            case 1 -> Flux.just("Vedha", "vijay", "Master").log();
            case 2 -> Flux.error(() -> new RuntimeException("Something Went Wrong!!")).log();
            default -> Flux.empty().log();
        };
    }

    public static Flux<String> produceString() {

        return Flux.just("Vedha", "Master", "Vijay");
    }

    public static void main(String[] args) throws InterruptedException {

//        producer(0).subscribe(new CustomSubscriber());
//
//        System.out.println("-----------------------------");
//        producer(1).subscribe(new CustomSubscriber());
//
//        System.out.println("-----------------------------");
//        producer(2).subscribe(new CustomSubscriber());

        // Multiple Sub methods.
        produceString().map(String::toUpperCase).subscribe(System.out::println);

        System.out.println("-----------------------------");
        produceString().map(s -> {

            if ("Master".equalsIgnoreCase(s)) {
                throw new RuntimeException("is not an actor: ".concat(s));
            }
            return s.toUpperCase();
        }).subscribe(System.out::println, System.err::println);

        System.out.println("-----------------------------");
        produceString().map(String::toUpperCase)
                .subscribe(System.out::println, System.err::println, () -> System.out.println("Completed!!"));

        System.out.println("-----------------------------");
        produceString().map(String::toUpperCase)
                .subscribe(System.out::println, System.err::println, () -> System.out.println("Completed!!"), subscription -> subscription.request(2));
    }
}
