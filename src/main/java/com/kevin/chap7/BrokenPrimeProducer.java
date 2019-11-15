package com.kevin.chap7;

import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;

public class BrokenPrimeProducer extends Thread {

    private final BlockingQueue<BigInteger> queue;
    private volatile boolean cancelled;

    public BrokenPrimeProducer(BlockingQueue<BigInteger> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            BigInteger p = BigInteger.ONE;
            while (!cancelled) {
                p = p.nextProbablePrime();
                queue.put(p);
            }
        } catch (InterruptedException e) {
            // do nothing
        }
    }

    public void cancel() {
        cancelled = true;
    }
}
