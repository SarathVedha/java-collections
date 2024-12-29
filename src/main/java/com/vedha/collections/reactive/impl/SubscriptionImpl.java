package com.vedha.collections.reactive.impl;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.List;

public class SubscriptionImpl<T> implements Subscription {

    private final Subscriber<? super T> subscriber;

    private final List<T> tList;

    private boolean isCanceled = false;

    public SubscriptionImpl(Subscriber<? super T> subscriber, List<T> tList) {

        this.subscriber = subscriber;
        this.tList = tList;
    }

    @Override
    public void request(long n) {

        System.out.println("Subscriber requesting: " + n + ", Data");

        if (isCanceled) {return;}

        try {

            for (int i = 0; i < n; i++) {

                if (tList.size() > i) {

                    subscriber.onNext(tList.get(i));
                } else {

                    break;
                }
            }

            subscriber.onComplete();
        } catch (Exception e) {

            subscriber.onError(e);
        }
    }

    @Override
    public void cancel() {

        isCanceled = true;
        System.out.println("Subscription Canceled!!");
    }
}
