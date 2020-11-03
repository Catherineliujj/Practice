package com.catherineliu.practice.main_code.aboutt_retrofit_and_rxjava;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import com.catherineliu.practice.R;
import com.catherineliu.practice.about_base.BaseActivity;
import com.catherineliu.practice.about_utils.ToastUtil;
import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 项目：Practice
 * 文件描述：Retrofit + RxJava界面
 * 作者：ljj
 * 创建时间：2020/4/22
 */
public class RetrofitActivity extends BaseActivity {

    @BindView(R.id.include_top_tv_title)
    TextView includeTopTvTitle;
    @BindView(R.id.tv_show_info)
    TextView tvShowInfo;

    @Override
    protected int getLayoutView() {
        return R.layout.activity_retrofit;
    }

    @Override
    protected void initViewUI() {
        includeTopTvTitle.setText(getResources().getString(R.string.retrofit_title));

    }

    @Override
    protected void initData() {

    }


    @OnClick(R.id.btn_start)
    public void onViewClicked() {
        tvShowInfo.setText("");
        // 开启一个子线程，进行网络操作，等待有返回结果，使用handler通知UI
        new Thread(new Runnable() {
            @Override
            public void run() {
                executeRequest();
            }
        }).start();
    }

    @SuppressLint("HandlerLeak")
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Bundle data = msg.getData();
            String val = data.getString("value");
            tvShowInfo.setText(val);
        }
    };

    private void executeRequest() {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://59.110.231.50:9082")
                .build();

        InfoService infosApi = retrofit.create(InfoService.class);
//        Call<DataInfos> call = infosApi.getInfosGet("oc3b349701a36b457339e53ead5159750efc1f2a89");
        Call<DataInfos> call = infosApi.getInfosPost("oc3b349701a36b457339e53ead5159750efc1f2a89");

        /*Response<DataInfos> dataInfos = */
/*        try {
            MyLog.i("call", "call开始执行");
            call.execute();  // 同步请求
            MyLog.i("call", "call执行结束");
        } catch (IOException e) {
            e.printStackTrace();
            ToastUtil.show(e.toString());
            MyLog.i("call", "call执行异常");
        }*/

        // 异步请求
        call.enqueue(new Callback<DataInfos>() {
            @Override
            public void onResponse(Call<DataInfos> call, Response<DataInfos> response) {
                //成功返回数据后在这里处理，使用response.body();获取得到的结果
                DataInfos infosBean = response.body();
                Message msg = new Message();
                Bundle data = new Bundle();
                Gson gson = new Gson();
                String json = gson.toJson(infosBean);
                data.putString("value", json);
                msg.setData(data);
                handler.sendMessage(msg);

/*                try {
                    String errorMsg = response.errorBody().string();
                    ToastUtil.show(errorMsg);
                    MyLog.i("call", "errorBody" + errorMsg);
                } catch (IOException e) {
                    e.printStackTrace();
                }*/
            }

            @Override
            public void onFailure(Call<DataInfos> call, Throwable t) {
                // 请求失败在这里处理
                ToastUtil.show(t.toString() + "==请求失败: " + t.getMessage());
            }
        });
//        call.cancel();
    }

}
