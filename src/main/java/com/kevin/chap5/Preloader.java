package com.kevin.chap5;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 类名: Preloader<br/>
 * 包名：com.kevin.chap5<br/>
 * 作者：kevin<br/>
 * 时间：2019/10/15 16:22<br/>
 * 版本：1.0<br/>
 * 描述：<br/>
 */
public class Preloader {
    private final FutureTask<ProductInfo> future = new FutureTask<>(new Callable<ProductInfo>() {
        @Override
        public ProductInfo call() throws DataLoadException {
            return loadProductInfo();
        }
    });

    private final Thread thread = new Thread(future);

    public void start() {
        thread.start();
    }

    public ProductInfo get() throws InterruptedException, DataLoadException {
        try {
            return future.get();
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause instanceof DataLoadException) {
                throw (DataLoadException) cause;
            } else {
                throw LaunderThrowable.launderThrowable(e);
            }
        }
    }

    private ProductInfo loadProductInfo() throws DataLoadException {
        return null;
    }

    interface ProductInfo {}

    class DataLoadException extends Exception {}

    static class LaunderThrowable {
        public static RuntimeException launderThrowable(Throwable t) {
            if (t instanceof RuntimeException)
                return (RuntimeException) t;
            else if (t instanceof Error)
                throw (Error) t;
            else
                throw new IllegalStateException("Not unchecked", t);
        }
    }
}
