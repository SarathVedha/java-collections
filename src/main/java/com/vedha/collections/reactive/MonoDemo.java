package com.vedha.collections.reactive;

import reactor.core.publisher.Mono;

public class MonoDemo {

    // Mono means single data
    public static Mono<String> getData() {

        return Mono.just("Vedha").log();
    }

    public static void main(String[] args) {

        getData().map(String::toUpperCase).subscribe(System.out::println);

    }
}
