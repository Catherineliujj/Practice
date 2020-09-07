package com.catherineliu.practice.main_code.about_download_file;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;

import com.catherineliu.practice.about_utils.FileUtils;
import com.catherineliu.practice.about_utils.MyLog;
import com.catherineliu.practice.about_utils.StrUtils;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import io.reactivex.disposables.Disposable;
import okhttp3.ResponseBody;
import io.reactivex.Observer;

/**
 * 项目：Practice
 * 文件描述：
 * 作者：ljj
 * 创建时间：2020/9/4
 */
public class RxNet {
    public static boolean enableLog = true;

    public static void download(final String url, final String filePath, final DownloadCallback callback){
        if (StrUtils.isEmpty(url) || StrUtils.isEmpty(filePath)) {
            if (null != callback){
                callback.onError("Url or path empty");
            }
            return;
        }

        File oldFile = new File(filePath);
        if (oldFile.exists()){
            oldFile.delete();
//            if (null != callback){
//                callback.onFinish(oldFile);
//            }
//            return;
        }

        DownloadListener listener = new DownloadListener() {
            @Override
            public void onStart(ResponseBody responseBody) {
                saveFile(responseBody, url, filePath, callback);
            }
        };

        RetrofitFactory.downloadFile(url, FileUtils.getTempFile(url, filePath).length(), listener, new Observer<ResponseBody>() {
            @Override
            public void onSubscribe(Disposable d) {
                if (null != callback) {
                    callback.onStart(d);
                }
            }

            @Override
            public void onNext(ResponseBody responseBody) {

            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                MyLog.d("onError ", e.getMessage());
                if (null != callback) {
                    callback.onError(e.getMessage());
                }

            }

            @Override
            public void onComplete() {
                MyLog.d("onComplete", "download onComplete ");
            }

        });
    }

    private static void saveFile(ResponseBody responseBody, String url, String filePath, DownloadCallback callback) {
        boolean downloadSuccss = true;
        final File tempFile = FileUtils.getTempFile(url, filePath);
        try {
            writeFileToDisk(responseBody, tempFile.getAbsolutePath(), callback);
        } catch (Exception e) {
            e.printStackTrace();
            downloadSuccss = false;
        }

        if (downloadSuccss) {
            final boolean renameSuccess = tempFile.renameTo(new File(filePath));
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    if (null != callback && renameSuccess) {
                        callback.onFinish(new File(filePath));
                    }
                }
            });
        }
    }

    @SuppressLint("DefaultLocale")
    private static void writeFileToDisk(ResponseBody responseBody, String filePath, final DownloadCallback callback) throws IOException {
        long totalByte = responseBody.contentLength();
        long downloadByte = 0;
        File file = new File(filePath);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }

        byte[] buffer = new byte[1024 * 4];
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rwd");
        long tempFileLen = file.length();
        randomAccessFile.seek(tempFileLen);
        while (true) {
            int len = responseBody.byteStream().read(buffer);
            if (len == -1) {
                break;
            }
            randomAccessFile.write(buffer, 0, len);
            downloadByte += len;
            callbackProgress(tempFileLen + totalByte, tempFileLen + downloadByte, callback);
        }
        randomAccessFile.close();
    }

    private static void callbackProgress(final long totalByte, final long downloadByte, final DownloadCallback callback) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @SuppressLint("DefaultLocale")
            @Override
            public void run() {
                if (null != callback) {
                    callback.onProgress(totalByte, downloadByte, (int) ((downloadByte * 100) / totalByte));
                }
            }
        });
    }
}
