package com.catherineliu.practice;

import android.view.View;
import android.widget.Button;

import com.catherineliu.practice.about_base.BaseActivity;
import com.catherineliu.practice.about_utils.IntentUtils;
import com.catherineliu.practice.about_utils.NoDoubleClickUtils;
import com.catherineliu.practice.main_code.about_password_block.PasswordBlockActivity;
import com.catherineliu.practice.main_code.about_refresh_and_more.RefreshAndMoreActivity;
import com.catherineliu.practice.main_code.about_viewpager_tablayout.ViewPagerActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author Catherine Liu
 * MainActivity
 * 08/04/2019
 */
public class MainActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.main_btn_pwd_lock)
    Button mainBtnPwdLock;
    @BindView(R.id.main_btn_view_pager)
    Button mainBtnViewPager;
    @BindView(R.id.main_btn_refresh_and_more)
    Button mainBtnRefreshAndMore;
    /*private Button mainTv2PwdBlock;
    private Button mainTv2ViewPager;
    private Button mainTv2RefreshAndMore;
    private Button mainTv2ResetTheme;*/

    @Override
    protected int getLayoutView() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViewUI() {
        super.initViewUI();

    }

    @Override
    protected void initBaseView() {
        super.initBaseView();


    }

    @OnClick({R.id.main_btn_pwd_lock, R.id.main_btn_view_pager, R.id.main_btn_refresh_and_more})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.main_btn_pwd_lock:  // 密码框
                if (NoDoubleClickUtils.isDoubleClickNoToast()) {
                    IntentUtils.JumpTo(PasswordBlockActivity.class);
                }
                break;
            case R.id.main_btn_view_pager:  // ViewPager
                if (NoDoubleClickUtils.isDoubleClickNoToast()) {
                    IntentUtils.JumpTo(ViewPagerActivity.class);
                }
                break;
            case R.id.main_btn_refresh_and_more:  // 刷新加载
                if (NoDoubleClickUtils.isDoubleClickNoToast()) {
                    IntentUtils.JumpTo(RefreshAndMoreActivity.class);
                }
                break;
        }
    }


}
