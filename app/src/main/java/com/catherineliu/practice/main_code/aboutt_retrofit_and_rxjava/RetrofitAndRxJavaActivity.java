package com.catherineliu.practice.main_code.aboutt_retrofit_and_rxjava;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import com.catherineliu.practice.R;
import com.catherineliu.practice.about_base.BaseActivity;
import com.catherineliu.practice.about_utils.MyLog;
import com.catherineliu.practice.about_utils.ToastUtil;
import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.OnClick;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * 项目：Practice
 * 文件描述：Retrofit + RxJava界面
 * 作者：ljj
 * 创建时间：2020/4/22
 */
public class RetrofitAndRxJavaActivity extends BaseActivity {

    @BindView(R.id.include_top_tv_title)
    TextView includeTopTvTitle;
    @BindView(R.id.tv_show_info)
    TextView tvShowInfo;

    @Override
    protected int getLayoutView() {
        return R.layout.activity_retrofit_and_rxjava;
    }

    @Override
    protected void initViewUI() {
        includeTopTvTitle.setText(getResources().getString(R.string.retrofit_and_rxjava_title));

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

    StringBuilder stringBuilder = new StringBuilder();
    private void executeRequest() {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())  // 新的配置
//                .baseUrl("http://59.110.231.50:9082")
                .baseUrl("http://6leefun.tpddns.cn:5052")
                .build();

        InfoService infosApi = retrofit.create(InfoService.class);

        infosApi.getInfosPostStrReturnObservable("{   \"ctn\": \"Login\",   \"mtn\": \"loginIn\",   \"version\": \"V2_0_1\",   \"api_key\": \"20180903\",   \"data\": [     {       \"machineCode\": \"ffffffff-c089-641b-0000-000053aa4819\",       \"modelName\": \"MI 6\",       \"password\": \"e5e94876560ab8220f43cbd52854e80a\",       \"sno\": \"15260602893\"     }   ],   \"timestamp\": \"1593483537\",   \"sign\": \"DF21CFD25909DBD99BF708B65FC19A0F\" }")
                .flatMap(new Func1<String, Observable<DataInfos>>() {
                    @Override
                    public Observable<DataInfos> call(String s) {
                        stringBuilder.append(s).append("\n");
                        MyLog.i("dataInfos", "dataInfos--s==" + s);
                        return infosApi.resetPassword("{\"ctn\":\"Login\",\"mtn\":\"resetPassword\",\"version\":\"V2_0_1\",\"timestamp\":1561449363,\"api_key\":\"20180903\",\"data\":[{\"mobile\":\"18150960007\",\"newPassword\":\"e5e94876560ab8220f43cbd52854e80b\",\"code\":\"858559\"}],\"sign\":\"A3B98ED7B2E323D99079F4CA350B27F2\"}");
                    }
                })
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .doOnNext(new Action1<DataInfos>() {
                    @Override
                    public void call(DataInfos dataInfos) {
                        String json = new Gson().toJson(dataInfos);
//                        tvShowInfo.setText(json);
                        MyLog.i("dataInfos", "dataInfos==" + json);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DataInfos>() {
                    @Override
                    public void onCompleted() {
                        ToastUtil.show("完成！！");
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(DataInfos dataInfos) {
                        Message msg = new Message();
                        Bundle data = new Bundle();
                        Gson gson = new Gson();
                        String json = gson.toJson(dataInfos);
                        stringBuilder.append(json).append("\n");
                        data.putString("value", json);
                        msg.setData(data);
                        handler.sendMessage(msg);
//                        tvShowInfo.setText(stringBuilder.toString());
                        MyLog.i("dataInfos", json + "==json--dataInfos==" + stringBuilder.toString());
                    }
                });


        /*infosApi.getInfosPostReturnObservable("oc3b349701a36b457339e53ead5159750efc1f2a89")  // 获取Observable对象
                .subscribeOn(Schedulers.newThread())  // 请求在新的线程中执行
                .observeOn(Schedulers.io())  // 请求完成后在io线程中执行
                .doOnNext(new Action1<DataInfos>() {
                    @Override
                    public void call(DataInfos dataInfos) {
                        String json = new Gson().toJson(dataInfos);
                        tvShowInfo.setText(json);
                        MyLog.i("dataInfos", "dataInfos==" + json);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())  // 最后在主线程中执行
                .subscribe(new Subscriber<DataInfos>() {
                    @Override
                    public void onCompleted() {
                        ToastUtil.show("完成工作！！");
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(DataInfos dataInfos) {

                    }
                });*/


//        Call<DataInfos> call = infosApi.getInfosGet("oc3b349701a36b457339e53ead5159750efc1f2a89");
//
//        /*Response<DataInfos> dataInfos = */
///*        try {
//            MyLog.i("call", "call开始执行");
//            call.execute();  // 同步请求
//            MyLog.i("call", "call执行结束");
//        } catch (IOException e) {
//            e.printStackTrace();
//            ToastUtil.show(e.toString());
//            MyLog.i("call", "call执行异常");
//        }*/
//
//        // 异步请求
//        call.enqueue(new Callback<DataInfos>() {
//            @Override
//            public void onResponse(Call<DataInfos> call, Response<DataInfos> response) {
//                //成功返回数据后在这里处理，使用response.body();获取得到的结果
//                DataInfos infosBean = response.body();
//                Message msg = new Message();
//                Bundle data = new Bundle();
//                Gson gson = new Gson();
//                String json = gson.toJson(infosBean);
//                data.putString("value", json);
//                msg.setData(data);
//                handler.sendMessage(msg);
//
///*                try {
//                    String errorMsg = response.errorBody().string();
//                    ToastUtil.show(errorMsg);
//                    MyLog.i("call", "errorBody" + errorMsg);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }*/
//            }
//
//            @Override
//            public void onFailure(Call<DataInfos> call, Throwable t) {
//                // 请求失败在这里处理
//                ToastUtil.show(t.toString() + "==请求失败: " + t.getMessage());
//            }
//        });
//        call.cancel();
    }

}
