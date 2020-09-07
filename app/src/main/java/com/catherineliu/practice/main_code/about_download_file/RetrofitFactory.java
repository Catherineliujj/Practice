package com.catherineliu.practice.main_code.about_download_file;

import com.catherineliu.practice.about_utils.MyLog;
import com.catherineliu.practice.about_utils.StrUtils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 项目：Practice
 * 文件描述：
 * 作者：ljj
 * 创建时间：2020/9/4
 */
public class RetrofitFactory {

    private static final int TIME_OUT_SECOND = 15;
    private static OkHttpClient.Builder mBuilder;

    private static Retrofit getDownloadRetrofit(DownloadListener downloadListener){
        Interceptor headInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request originRequest = chain.request();
                Request.Builder requestBuilder = originRequest.newBuilder()
                        .addHeader("Accept-Encoding", "gzip")
                        .method(originRequest.method(), originRequest.body());
                Request request = requestBuilder.build();
                return chain.proceed(request);
            }
        };

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                if (!StrUtils.isEmpty(message)){
                    MyLog.d("message", message);
                }
            }
        });
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        if (null == mBuilder){
            mBuilder = new OkHttpClient.Builder()
                    .connectTimeout(TIME_OUT_SECOND, TimeUnit.SECONDS)
                    .readTimeout(TIME_OUT_SECOND, TimeUnit.SECONDS)
                    .writeTimeout(TIME_OUT_SECOND, TimeUnit.SECONDS)
                    .addInterceptor(headInterceptor)
                    .addInterceptor(loggingInterceptor)
                    .addInterceptor(new DownloadInterceptor(downloadListener));
        }

        return new Retrofit.Builder()
                .baseUrl("https://fir.vip/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(mBuilder.build())
                .build();
    }

    /**
     * 取消网络请求
     */
    public static void cancel(Disposable disposable){
        if (null != disposable && !disposable.isDisposed()){
            disposable.dispose();
        }
    }

    /**
     * 下载文件请求
     */
    public static void downloadFile(String url, long startPos, DownloadListener downloadListener, Observer<ResponseBody> observer) {
        getDownloadRetrofit(downloadListener).create(BaseApi.class).downloadFile("bytes=" + startPos + "-", url)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

    }



}
