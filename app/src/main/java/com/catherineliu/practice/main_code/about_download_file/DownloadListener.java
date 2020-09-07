package com.catherineliu.practice.main_code.about_download_file;

import okhttp3.ResponseBody;

/**
 * 项目：Practice
 * 文件描述：
 * 作者：ljj
 * 创建时间：2020/9/4
 */
public interface DownloadListener {
    void onStart(ResponseBody responseBody);
}
