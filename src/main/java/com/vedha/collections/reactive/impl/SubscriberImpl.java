package com.vedha.collections.reactive.impl;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class SubscriberImpl<T> implements Subscriber<T> {

    private Subscription subscription;

    @Override
    public void onSubscribe(Subscription subscription) {

        this.subscription = subscription;
        System.out.println("Subscription Successfully");
//        subscription.request(10);
    }

    @Override
    public void onNext(T t) {

        System.out.println("OnNext Called!!");
        System.out.println("Data Received: " + t);
    }

    @Override
    public void onError(Throwable t) {

        System.err.println("onError: " + t);
    }

    @Override
    public void onComplete() {

        System.out.println("onComplete Called");
    }

    public Subscription getSubscription() {
        return subscription;
    }
}
