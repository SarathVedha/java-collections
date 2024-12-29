package com.vedha.collections.reactive.impl;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

import java.util.List;

public class PublisherImpl<T> implements Publisher<T> {

    private final List<T> tList;

    public PublisherImpl(List<T> tList) {
        this.tList = tList;
    }

    @Override
    public void subscribe(Subscriber<? super T> subscriber) {

        SubscriptionImpl<T> tSubscription = new SubscriptionImpl<>(subscriber, tList);
        subscriber.onSubscribe(tSubscription);
    }
}
