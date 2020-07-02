package com.catherineliu.practice;

import android.app.Dialog;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.catherineliu.practice.about_base.BaseActivity;
import com.catherineliu.practice.about_test.myJNI;
import com.catherineliu.practice.about_utils.IntentUtils;
import com.catherineliu.practice.about_utils.NoDoubleClickUtils;
import com.catherineliu.practice.about_utils.TimeUtil;
import com.catherineliu.practice.about_utils.ToastUtil;
import com.catherineliu.practice.main_code.about_time_picker.TimePickerActivity;
import com.catherineliu.practice.main_code.about_time_picker.about_picker_view.OnTimeSelectChangeListener;
import com.catherineliu.practice.main_code.about_time_picker.about_picker_view.OnTimeSelectListener;
import com.catherineliu.practice.main_code.about_time_picker.about_picker_view.TimePickerBuilder;
import com.catherineliu.practice.main_code.about_time_picker.about_picker_view.TimePickerView;
import com.catherineliu.practice.main_code.about_banner.BannerActivity;
import com.catherineliu.practice.main_code.about_drawer_layout.DrawerLayoutActivity;
import com.catherineliu.practice.main_code.about_ebbinghaus.EbbinghausActivity;
import com.catherineliu.practice.main_code.about_list_select_all.ListSelectAllActivity;
import com.catherineliu.practice.main_code.about_password_block.PasswordBlockActivity;
import com.catherineliu.practice.main_code.about_refresh_and_more.RefreshAndMoreActivity;
import com.catherineliu.practice.main_code.about_viewpager_tablayout.ViewPagerActivity;
import com.catherineliu.practice.main_code.about_viewpager_tablayout.ViewPagerSecondActivity;
import com.catherineliu.practice.main_code.aboutt_retrofit_and_rxjava.RetrofitActivity;
import com.catherineliu.practice.main_code.aboutt_retrofit_and_rxjava.RetrofitAndRxJavaActivity;
import com.catherineliu.practice.main_code.aboutt_retrofit_and_rxjava.RxJavaActivity;

import java.util.Calendar;
import java.util.Date;

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
    @BindView(R.id.main_btn_show_jni)
    Button mainBtnShowJni;
    @BindView(R.id.include_top_tv_title)
    TextView includeTopTvTitle;

    @Override
    protected int getLayoutView() {
        return R.layout.activity_main;
    }

    @Override
    protected boolean isUseFullScreenMode() {
        return true;
    }

    @Override
    protected void initViewUI() {
        super.initViewUI();
        includeTopTvTitle.setText("首页");
    }

    @Override
    protected void initData() {
        super.initData();


    }

    @OnClick({R.id.main_btn_pwd_lock, R.id.main_btn_view_pager, R.id.main_btn_refresh_and_more, R.id.main_btn_time_picker_view
            , R.id.main_btn_show_jni, R.id.main_btn_list_select_all, R.id.main_btn_show_banner, R.id.main_btn_view_pager_2
            , R.id.main_btn_retrofit, R.id.main_btn_rxjava, R.id.main_btn_retrofit_and_rxjava
            , R.id.main_btn_ebbinghaus, R.id.main_btn_drawer_layout
    })
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
            case R.id.main_btn_time_picker_view:  // 时间选择器
                if (NoDoubleClickUtils.isDoubleClickNoToast()) {
                    IntentUtils.JumpTo(TimePickerActivity.class);
                }
                break;
            case R.id.main_btn_show_jni:  // 显示Jni
                if (NoDoubleClickUtils.isDoubleClickNoToast()) {
                    Toast.makeText(MainActivity.this, myJNI.sayHello(), Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.main_btn_list_select_all:  // 列表全选与反选
                if (NoDoubleClickUtils.isDoubleClickNoToast()) {
                    IntentUtils.JumpTo(ListSelectAllActivity.class);
                }
                break;
            case R.id.main_btn_show_banner:  // 显示图片轮播
                if (NoDoubleClickUtils.isDoubleClickNoToast()) {
                    IntentUtils.JumpTo(BannerActivity.class);
                }
                break;
            case R.id.main_btn_view_pager_2:  // ViewPager 2
                if (NoDoubleClickUtils.isDoubleClickNoToast()) {
                    IntentUtils.JumpTo(ViewPagerSecondActivity.class);
                }
                break;
            case R.id.main_btn_retrofit:  // Retrofit
                if (NoDoubleClickUtils.isDoubleClickNoToast()) {
                    IntentUtils.JumpTo(RetrofitActivity.class);
                }
                break;
            case R.id.main_btn_rxjava:  // RxJava
                if (NoDoubleClickUtils.isDoubleClickNoToast()) {
                    IntentUtils.JumpTo(RxJavaActivity.class);
                }
                break;
            case R.id.main_btn_retrofit_and_rxjava:  // Retrofit + RxJava
                if (NoDoubleClickUtils.isDoubleClickNoToast()) {
                    IntentUtils.JumpTo(RetrofitAndRxJavaActivity.class);
                }
                break;
            case R.id.main_btn_ebbinghaus:  // 艾宾浩斯遗忘曲线生成
                if (NoDoubleClickUtils.isDoubleClickNoToast()) {
                    IntentUtils.JumpTo(EbbinghausActivity.class);
                }
                break;
            case R.id.main_btn_drawer_layout:  // 侧边栏菜单
                if (NoDoubleClickUtils.isDoubleClickNoToast()) {
                    IntentUtils.JumpTo(DrawerLayoutActivity.class);
                }
                break;
        }
    }

}
