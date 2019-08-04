package com.catherineliu.practice;

import android.view.View;
import android.widget.Button;

import com.catherineliu.practice.about_base.BaseActivity;
import com.catherineliu.practice.about_utils.NoDoubleClickUtils;
import com.catherineliu.practice.main_code.about_password_block.PasswordBlockActivity;
import com.catherineliu.practice.about_utils.IntentUtils;
import com.catherineliu.practice.main_code.about_viewpager_tablayout.ViewPagerActivity;

/**
 * @author Catherine Liu
 * MainActivity
 * 08/04/2019
 */
public class MainActivity extends BaseActivity implements View.OnClickListener {

    Button mainTv2PwdBlock;
    Button mainTv2ViewPager;
    @Override
    protected int getLayoutView() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViewUI() {
        super.initViewUI();
        mainTv2PwdBlock = getView(R.id.main_btn_pwd_lock);
        mainTv2ViewPager = getView(R.id.main_btn_view_pager);

        addOnClickListeners(R.id.main_btn_pwd_lock
                , R.id.main_btn_view_pager
        );
    }

    @Override
    protected void initBaseView() {
        super.initBaseView();


    }


    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()){
            case R.id.main_btn_pwd_lock:
                if (NoDoubleClickUtils.isDoubleClick()){
                    IntentUtils.JumpTo(PasswordBlockActivity.class);
                }

                break;
            case R.id.main_btn_view_pager:
                if (NoDoubleClickUtils.isDoubleClick()){
                    IntentUtils.JumpTo(ViewPagerActivity.class);
                }

                break;
        }
    }
}
