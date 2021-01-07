package com.catherineliu.practice.main_code.about_okhttp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.catherineliu.practice.R;
import com.catherineliu.practice.about_base.BaseActivity;
import com.catherineliu.practice.about_utils.MyLog;
import com.catherineliu.practice.about_utils.NoDoubleClickUtils;

import java.io.IOException;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 项目：Practice
 * 文件描述：OkHttpActivity
 * 作者：ljj
 * 创建时间：2020/12/28
 */
public class OkHttpActivity extends BaseActivity {

    @BindView(R.id.include_top_tv_title)
    TextView includeTopTvTitle;
    @BindView(R.id.ed_input)
    EditText edInput;
    @BindView(R.id.tv_show_result)
    TextView tvShowResult;

    private String DEFAULT_RESULT = "Result: ";

    @Override
    protected int getLayoutView() {
        return R.layout.activity_okhttp;
    }

    @Override
    protected void initViewUI() {
        includeTopTvTitle.setText(getString(R.string.main_btn_jump_2_okhttp));
    }

    @Override
    protected void initData() {
        String url = "http://testsercviceapi.weecot.com:9086/v_1_0_1/PdaInfo/identifyEdition?token=2C17B76F-CBE5-F438-FA5C-5CB2BAD369E0&type=android&outsideSign=7c98aa3f96b211dd90181a8a7edc9df2";
        edInput.setText(url);
    }

    @OnClick({R.id.tv_request_get, R.id.tv_request_get_sync, R.id.tv_request_post})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_request_get:  // 同步get请求
                if (NoDoubleClickUtils.isDoubleClick()) {
                    tvShowResult.setText(DEFAULT_RESULT);
                    requestGet();
                }
                break;
            case R.id.tv_request_get_sync:  // 异步get请求
                if (NoDoubleClickUtils.isDoubleClick()) {
                    tvShowResult.setText(DEFAULT_RESULT);
                    requestGetSync();
                }
                break;
            case R.id.tv_request_post:  // 同步post请求
                if (NoDoubleClickUtils.isDoubleClick()) {
                    tvShowResult.setText(DEFAULT_RESULT);
                    requestPost();
                }
                break;
        }
    }

    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Bundle data = msg.getData();
            if (data != null) {
                String value = data.getString("value");
                tvShowResult.setText(value);
            }
        }
    };

    private void requestGet() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient okHttpClient = new OkHttpClient();  // 创建OkHttpClient对象
                    Request request = new Request.Builder()
                            .url(edInput.getText().toString().trim())  // 请求接口
                            .build();  // 创建Request 对象
                    Response response = okHttpClient.newCall(request).execute();  // 得到Response 对象
                    HttpUrl url = request.url();
                    MyLog.e("okhttp", url.toString());
                    if (response.isSuccessful()) {
                        MyLog.e("okhttp","response.code()=="+response.code());
                        MyLog.e("okhttp","response.message()=="+response.message());
                        String responseStr = response.body().string();  // response.body().string()只能调用一次，本质是输入流的读操作，必须有服务器的输出流的写操作时客户端的读操作才能得到数据
                        MyLog.e("okhttp","res=="+ responseStr);

                        //此时的代码执行在子线程，修改UI的操作请使用handler跳转到UI线程。
                        Message message = new Message();
                        Bundle bundle = new Bundle();
                        bundle.putString("value", responseStr);
                        message.setData(bundle);
                        handler.sendMessage(message);
//                        String finalResponse = responseStr;
//                        runOnUiThread(new Runnable() {
//                            @Override
//                            public void run() {
//                                tvShowResult.setText(finalResponse);
//                            }
//                        });
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void requestGetSync() {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(edInput.getText().toString())
                .build();
        okHttpClient.newCall(request).enqueue(callback);
    }

    private void requestPost() {
        OkHttpClient okHttpClient = new OkHttpClient();  // 创建OkHttpClient对象
        FormBody.Builder formBody = new FormBody.Builder();  // 创建表单请求体
        String[] split = edInput.getText().toString().trim().split("\\?");
        if (split.length == 2) {
            String[] keyAndValue = split[1].split("&");
            for (String s : keyAndValue) {
                String[] str = s.split("=");
                if (str.length == 2) {
                    formBody.add(str[0], str[1]);
                }
            }
        }
        Request request = new Request.Builder()
//                .url("http://testsercviceapi.weecot.com:9086/v_1_0_1/PdaInfo/identifyEdition")
                .url(split[0])
                .post(formBody.build())  // 传递请求体
                .build();
        okHttpClient.newCall(request).enqueue(callback);

    }

    private Callback callback = new Callback() {
        @Override
        public void onFailure(Call call, IOException e) {
            e.printStackTrace();
        }

        @Override
        public void onResponse(Call call, Response response) throws IOException {
            if (response.isSuccessful()) {
                MyLog.e("okhttp","response.code()=="+response.code());
                MyLog.e("okhttp","response.message()=="+response.message());
                String responseStr = response.body().string();  // response.body().string()只能调用一次，本质是输入流的读操作，必须有服务器的输出流的写操作时客户端的读操作才能得到数据
                MyLog.e("okhttp","res=="+ responseStr);

                //此时的代码执行在子线程，修改UI的操作请使用handler跳转到UI线程。
                Message message = new Message();
                Bundle bundle = new Bundle();
                bundle.putString("value", responseStr);
                message.setData(bundle);
                handler.sendMessage(message);
            }
        }
    };
}
