package com.vedha.collections.reactive;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class CustomSubscriber implements Subscriber<Object> {

    @Override
    public void onSubscribe(Subscription s) {

        System.out.println("Entering onSubscribe(Subscription)");
        s.request(Long.MAX_VALUE); // asking value from publisher at a time.
    }

    @Override
    public void onNext(Object o) {

        System.out.println("Value: " + o);
    }

    @Override
    public void onError(Throwable t) {

        System.err.println("Error: " + t.getMessage());
    }

    @Override
    public void onComplete() {

        System.out.println("Leaving onComplete()");
    }
}
