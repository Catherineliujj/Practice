package com.catherineliu.practice.main_code.about_download_file;

import android.app.DownloadManager;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.catherineliu.practice.R;
import com.catherineliu.practice.about_base.BaseActivity;
import com.catherineliu.practice.about_utils.MyLog;
import com.catherineliu.practice.about_utils.NoDoubleClickUtils;

import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DownloadFileActivity extends BaseActivity {


    @BindView(R.id.include_top_tv_title)
    TextView includeTopTvTitle;
    @BindView(R.id.progressbar_download)
    ProgressBar progressbarDownload;
    @BindView(R.id.tv_message)
    TextView tvMessage;

    private String downloadUrl = "https://github.com/Greedddd/Axure/archive/master.zip";
    private long downloadedSoFar;
    private long totalSize;
    @Override
    protected int getLayoutView() {
        return R.layout.activity_download_file;
    }

    @Override
    protected void initViewUI() {
        super.initViewUI();
        includeTopTvTitle.setText("下载");
    }

    @Override
    protected void initData() {
        super.initData();

    }

    private void downloadFiles() {
        // todo 1、封装下载请求
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(downloadUrl));
        /**
         * 设置在通知栏是否显示下载通知(下载进度)，有4个值可选:
         *  VISIBILITY_VISIBLE: 下载过程中可见, 下载完后自动消失 (默认)
         *  VISIBILITY_VISIBLE_NOTIFY_COMPLETED: 下载过程中和下载完成后均可见
         *  VISIBILITY_HIDDEN: 始终不显示通知
         *  VISIBILITY_VISIBLE_NOTIFY_ONLY_COMPLETION: 只有下载完后才显示
         */
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setTitle("Practice安装包下载中...");
        request.setDescription("I am a tool for practice everything.");

        /**
         * 设置允许使用的网络类型，可选值:
         *  NETWORK_MOBILE: 移动网络
         *  NETWORK_WIFI: WIFI网络
         *  NETWORK_BLUETOOTH: 蓝牙网络
         * 默认为所有网络都允许
         */
        // request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI);
        // 添加请求头
        // request.addRequestHeader("User-Agent", "Chrome Mozilla/5.0");

        // 设置下载文件的保存位置
        File saveFile = new File(Environment.getExternalStorageDirectory(), "practice.apk");
        request.setDestinationUri(Uri.fromFile(saveFile));

        // todo 2、获取下载管理器服务的实例，添加下载任务
        DownloadManager manager = (DownloadManager) DownloadFileActivity.this.getSystemService(Context.DOWNLOAD_SERVICE);
        // 将下载请求加入下载队列，返回一个下载ID
        long downloadId = manager.enqueue(request);

        // 如果中途想取消下载, 可以调用remove方法, 根据返回的下载ID取消下载, 取消下载后下载保存的文件将被删除
        // manager.remove(downloadId);

        // todo 3、查询下载状态
        DownloadManager.Query query = new DownloadManager.Query();
        query.setFilterById(downloadId);  // 根据id过滤结果
        // query.setFilterByStatus(DownloadManager.STATUS_SUCCESSFUL);  // 根据状态过滤结果

        Cursor cursor = manager.query(query);
        if (!cursor.moveToFirst()) {
            cursor.close();
            return;
        }

        long id = cursor.getLong(cursor.getColumnIndex(DownloadManager.COLUMN_ID));
        int status = cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_STATUS));
        String localFileUri = cursor.getString(cursor.getColumnIndex(DownloadManager.COLUMN_LOCAL_URI));
        downloadedSoFar = cursor.getLong(cursor.getColumnIndex(DownloadManager.COLUMN_BYTES_DOWNLOADED_SO_FAR));  // 已下载的字节大小
        totalSize = cursor.getLong(cursor.getColumnIndex(DownloadManager.COLUMN_TOTAL_SIZE_BYTES));  // 下载文件的总字节大小

        cursor.close();
        progressbarDownload.setProgress((int)(downloadedSoFar / totalSize));
        MyLog.i("download", "下载进度：" + downloadedSoFar + " / " + totalSize);
        timer.schedule(timerTask, 0, 500);
    }

    private Timer timer = new Timer();
    private TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            progressbarDownload.setProgress((int)(downloadedSoFar / totalSize));
            MyLog.i("download", "下载进度ing：" + downloadedSoFar + " / " + totalSize);
        }
    };



    @OnClick({R.id.tv_start})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_start:
                if (NoDoubleClickUtils.isDoubleClickNoToast()) {
                    downloadFiles();
                }
                break;
        }
    }
}
