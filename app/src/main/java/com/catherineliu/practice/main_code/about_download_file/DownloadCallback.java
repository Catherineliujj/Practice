package com.catherineliu.practice.main_code.about_download_file;

import java.io.File;

import io.reactivex.disposables.Disposable;

/**
 * 项目：Practice
 * 文件描述：
 * 作者：ljj
 * 创建时间：2020/9/4
 */
public interface DownloadCallback {
    void onStart (Disposable d);
    void onProgress(long totalByte, long currentByte, int progress);
    void onFinish(File file);
    void onError(String msg);
}
