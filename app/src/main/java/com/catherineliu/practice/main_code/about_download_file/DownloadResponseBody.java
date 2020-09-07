package com.catherineliu.practice.main_code.about_download_file;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;

/**
 * 项目：Practice
 * 文件描述：自定义DownloadResponBody
 * 作者：ljj
 * 创建时间：2020/9/4
 */
public class DownloadResponseBody extends ResponseBody {

    private final ResponseBody responseBody;
    private BufferedSource bufferedSource;

    public DownloadResponseBody(ResponseBody responseBody, DownloadListener downloadListener) {
        this.responseBody = responseBody;
        if (null != downloadListener){
            downloadListener.onStart(responseBody);
        }
    }

    @Override
    public MediaType contentType() {
        return responseBody.contentType();
    }

    @Override
    public long contentLength() {
        return responseBody.contentLength();
    }

    @Override
    public BufferedSource source() {
        if (bufferedSource == null){
            bufferedSource = Okio.buffer(getSource(responseBody.source()));
        }
        return bufferedSource;
    }

    private Source getSource(Source source) {
        return new ForwardingSource(source) {
            long downloadBytes = 0L;

            @Override
            public long read(Buffer buffer, long byteCount) throws IOException {
                long singleRead = super.read(buffer, byteCount);
                if (-1 != singleRead){
                    downloadBytes += singleRead;
                }
                return singleRead;
            }
        };

    }

}
