package com.vedha.collections.reactive;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;

import java.util.List;

public class BackPressureDemo {

    public static Flux<String> getData() {

        return Flux.just("Vedha", "Vijay", "Master", "Theri", "Vikram", "Rabin", "Sha");
    }

    public static void main(String[] args) throws InterruptedException {

        getData().subscribe(new Subscriber());

        List.of(1, 2);
    }
}

class Subscriber extends BaseSubscriber<String> {

    private Subscription subscription;

    @Override
    protected void hookOnSubscribe(Subscription subscription) {

        this.subscription = subscription;
        System.out.println("Subscription successfully");
        subscription.request(3); // asking one by one or controlling.
    }

    @Override
    protected void hookOnNext(String value) {

        System.out.println("Data Received: " + value);
        if ("Rabin".equalsIgnoreCase(value)) {

            System.out.println("Canceled");
            subscription.cancel();
        }
        subscription.request(1); // Requesting value after processing the previous value.
    }

    @Override
    protected void hookOnComplete() {

        System.out.println("Completed!!");
    }
}
