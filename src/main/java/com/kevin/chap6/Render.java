package com.kevin.chap6;

import java.util.List;
import java.util.concurrent.*;

/**
 * @类名: Render<br />
 * @包名：com.kevin.chap6<br/>
 * @作者：kevin<br/>
 * @时间：2019/11/5 20:05<br/>
 * @版本：1.0<br/>
 * @描述：<br/>
 */
public abstract class Render {
    private final ExecutorService executor;

    Render(ExecutorService executor) {
        this.executor = executor;
    }

    void renderPage(CharSequence source) {
        final List<ImageInfo> info = scanForImageInfo(source);
        CompletionService<ImageData> completionService =
                new ExecutorCompletionService<>(executor);
        for (final ImageInfo imageInfo : info) {
            completionService.submit(() -> imageInfo.downloadImage());
        }

        renderText(source);
        try {
            for (int i = 0, n = info.size(); i < n; i++) {
                Future<ImageData> future = completionService.take();
                ImageData imageData = future.get();
                renderImage(imageData);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    interface ImageData {
    }

    interface ImageInfo {
        ImageData downloadImage();
    }

    abstract void renderText(CharSequence s);

    abstract List<ImageInfo> scanForImageInfo(CharSequence s);

    abstract void renderImage(ImageData i);
}
