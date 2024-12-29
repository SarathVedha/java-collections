package com.vedha.collections.reactive.impl;

import java.util.Collections;
import java.util.List;

public class ReactorApp {

    public static void main(String[] args) {

        // Publisher is the interface of flux.
        // publisher publish the data or streams the date to its subscriber.
        PublisherImpl<String> publisher = new PublisherImpl<>(Collections.emptyList());
        SubscriberImpl<String> subscriber = new SubscriberImpl<>();
        publisher.subscribe(subscriber);
        subscriber.getSubscription().request(10);
        subscriber.getSubscription().cancel();
        subscriber.getSubscription().request(10);

    }
}
