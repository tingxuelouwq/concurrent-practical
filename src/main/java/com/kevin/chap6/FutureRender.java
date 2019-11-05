package com.kevin.chap6;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @类名: FutureRender<br />
 * @包名：com.kevin.chap6<br/>
 * @作者：kevin<br/>
 * @时间：2019/11/5 10:42<br/>
 * @版本：1.0<br/>
 * @描述：<br/>
 */
public abstract class FutureRender {

    private final ExecutorService executor = Executors.newCachedThreadPool();

    void renderPage(CharSequence source) {
        final List<ImageInfo> imageInfos = scanForImageInfo(source);
        Callable<List<ImageData>> task = () -> {
            List<ImageData> result = new ArrayList<>();
            for (ImageInfo imageInfo : imageInfos) {
                result.add(imageInfo.downloadImage());
            }
            return result;
        };
        Future<List<ImageData>> future = executor.submit(task);

        renderText(source);
        try {
            List<ImageData> imageData = future.get();
            for (ImageData data : imageData) {
                renderImage(data);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            future.cancel(true);
        } catch (ExecutionException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    interface ImageData {}

    interface ImageInfo {
        ImageData downloadImage();
    }

    abstract void renderText(CharSequence s);

    abstract List<ImageInfo> scanForImageInfo(CharSequence s);

    abstract void renderImage(ImageData i);

}
