package com.catherineliu.practice.main_code.about_download_file;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * 项目：Practice
 * 文件描述：Retrofit下载用的Service
 * 作者：ljj
 * 创建时间：2020/9/4
 */
public interface BaseApi {
    /**
     * 下载文件
     */
    @Streaming
    @GET
    Observable<ResponseBody> downloadFile(@Header("Range") String range, @Url String url);

}
