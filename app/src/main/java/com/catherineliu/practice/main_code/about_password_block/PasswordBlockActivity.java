package com.catherineliu.practice.main_code.about_password_block;

import android.widget.Toast;

import com.catherineliu.practice.R;
import com.catherineliu.practice.about_base.BaseActivity;

public class PasswordBlockActivity extends BaseActivity {

    PasswordView pwdView;
    @Override
    protected int getLayoutView() {
        return R.layout.activity_password_block;
    }

    @Override
    protected void initViewUI() {
        super.initViewUI();
        //初始化控件
        pwdView = getView(R.id.pwd_view);

    }

    @Override
    protected void initBaseView() {
        super.initBaseView();

        // 添加回调接口
        pwdView.setOnFinishInput(new OnPasswordInputFinish() {
            @Override
            public void inputFinish() {
                // 输入完成后我们简单显示一下输入的密码
                // 也就是说——>实现你的交易逻辑什么的在这里写
                Toast.makeText(PasswordBlockActivity.this, pwdView.getStrPassword(),
                        Toast.LENGTH_SHORT).show();
            }
            //取消支付
            @Override
            public void outfo() {
                //关闭支付页面
                finish();
            }
            //忘记密码回调事件
            @Override
            public void forgetPwd() {
                Toast.makeText(PasswordBlockActivity.this, "忘记密码", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
