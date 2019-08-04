package com.catherineliu.practice;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.catherineliu.practice.about_base.BaseActivity;
import com.catherineliu.practice.about_password_block.PasswordBlockActivity;
import com.catherineliu.practice.about_utils.IntentUtils;

/**
 * @author Catherine Liu
 */
public class MainActivity extends BaseActivity {

    Button mainTv2PwdBlock;

    @Override
    protected int getLayoutView() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViewUI() {
        super.initViewUI();
        mainTv2PwdBlock = getView(R.id.main_btn_pwd_lock);

        mainTv2PwdBlock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentUtils.JumpTo(PasswordBlockActivity.class);
            }
        });
    }

    @Override
    protected void initBaseView() {
        super.initBaseView();


    }

}
