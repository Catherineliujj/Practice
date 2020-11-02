package com.catherineliu.practice.main_code.about_handler;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.catherineliu.practice.R;
import com.catherineliu.practice.about_base.BaseActivity;
import com.catherineliu.practice.about_utils.NoDoubleClickUtils;

import butterknife.BindView;
import butterknife.OnClick;

public class HandlerActivity extends BaseActivity {


    @BindView(R.id.handler_ed_input)
    EditText handlerEdInput;
    @BindView(R.id.handler_tv_message)
    TextView handlerTvMessage;

    private Handler mHandler;
    @Override
    protected int getLayoutView() {
        return R.layout.activity_handler;
    }

    @Override
    protected void initData() {
        super.initData();
        // 处理消息
        mHandler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                switch (msg.what){
                    case 1:
                        if (null == msg.obj){
                            handlerTvMessage.setText("收到一条空消息");
                        } else {
                            handlerTvMessage.setText("收到一条消息：" + msg.obj);
                        }
                        break;
                    default:
                        handlerTvMessage.setText("收到一条未知来源的消息");
                        break;
                }
            }
        };
    }

    @OnClick({R.id.handler_btn_send_message})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.handler_btn_send_message:
                if (NoDoubleClickUtils.isDoubleClick()){
                    // 1.创建一个子线程，在子线程中发送消息
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            Message message = Message.obtain();
                            message.what = 1;
                            message.obj = handlerEdInput.getText().toString();
                            // 2.发送消息
                            mHandler.sendMessage(message);
                        }
                    }).start();
                }
                break;
        }
    }
}
