package com.kevin.chap7;

import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;

public class PrimeProducer extends Thread {

    private final BlockingQueue<BigInteger> queue;

    public PrimeProducer(BlockingQueue<BigInteger> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            BigInteger p = BigInteger.ONE;
            while (!Thread.currentThread().isInterrupted()) {
                p = p.nextProbablePrime();
                queue.put(p);
            }
        } catch (InterruptedException consumed) {
            /* Allow thread to exit */
        }
    }

    public void cancel() {
        interrupt();
    }
}
