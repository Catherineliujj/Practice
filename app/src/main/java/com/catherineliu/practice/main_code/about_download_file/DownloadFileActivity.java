package com.catherineliu.practice.main_code.about_download_file;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.catherineliu.practice.R;
import com.catherineliu.practice.about_base.BaseActivity;
import com.catherineliu.practice.about_utils.FileUtils;
import com.catherineliu.practice.about_utils.MyLog;
import com.catherineliu.practice.about_utils.NoDoubleClickUtils;

import java.io.File;
import java.math.BigDecimal;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.disposables.Disposable;

public class DownloadFileActivity extends BaseActivity {


    @BindView(R.id.include_top_tv_title)
    TextView includeTopTvTitle;
    @BindView(R.id.progressbar_download)
    ProgressBar progressbarDownload;
    @BindView(R.id.tv_message)
    TextView tvMessage;
    @BindView(R.id.tv_current_progress)
    TextView tvCurrentProgress;
    @BindView(R.id.tv_total_progress)
    TextView tvTotalProgress;

    //    private String downloadUrl = "https://github.com/Greedddd/Axure/archive/master.zip";
    private String downloadUrl = "https://fir.vip/file-download?id=28617";
    private long downloadedSoFar;
    private long totalSize;
    private Disposable mDownloadTask;

    @Override
    protected int getLayoutView() {
        return R.layout.activity_download_file;
    }

    @Override
    protected void initViewUI() {
        includeTopTvTitle.setText("下载");
    }

    @Override
    protected void initData() {

    }

    private void downloadFiles() {
        String path = getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath() + File.separator + "PracticeDownload.apk";
        RxNet.download(downloadUrl, path, new DownloadCallback() {
            @Override
            public void onStart(Disposable d) {
                mDownloadTask = d;
                MyLog.d("onStart", "开始下载：" + d);
            }

            @Override
            public void onProgress(long totalByte, long currentByte, int progress) {
                MyLog.d("onProgress", "下载进度：" + progress);
                progressbarDownload.setProgress(progress);
                tvMessage.setText(progress + "%\n");
                tvCurrentProgress.setText(byteFormat(currentByte) + "");
                tvTotalProgress.setText(" / " + byteFormat(totalByte));
            }

            @Override
            public void onFinish(File file) {
                MyLog.d("onFinish", "下载完成：" + file.getAbsolutePath());
            }

            @Override
            public void onError(String msg) {
                MyLog.d("onError", "下载出错：" + msg);
            }
        });
    }

    private String byteFormat(long bytes) {
        BigDecimal fileSize = new BigDecimal(bytes);
        BigDecimal megabyte = new BigDecimal(1024 * 1024);
        float returnValue = fileSize.divide(megabyte, 2, BigDecimal.ROUND_UP).floatValue();
        if (returnValue > 1) {
            return (returnValue + "MB");
        }
        BigDecimal kilobyte = new BigDecimal(1024);
        returnValue = fileSize.divide(kilobyte, 2, BigDecimal.ROUND_UP).floatValue();
        return (returnValue + "KB");
    }

    @OnClick({R.id.tv_start, R.id.tv_stop})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_start:
                if (NoDoubleClickUtils.isDoubleClickNoToast()) {
                    downloadFiles();
                }
                break;
            case R.id.tv_stop:
                if (NoDoubleClickUtils.isDoubleClickNoToast()) {
                    RetrofitFactory.cancel(mDownloadTask);
                    String filePath = getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath() + File.separator + "PracticeDownload.apk";
                    final File tempFile = FileUtils.getTempFile(downloadUrl, filePath);
                    tempFile.delete();

                    progressbarDownload.setProgress(0);
                    tvMessage.setText(0 + "%\n");
                    tvCurrentProgress.setText("0MB");
                }
                break;
        }
    }
}
