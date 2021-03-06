package com.catherineliu.practice;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.catherineliu.practice.about_base.BaseActivity;
import com.catherineliu.practice.about_test.myJNI;
import com.catherineliu.practice.about_utils.IntentUtils;
import com.catherineliu.practice.about_utils.NoDoubleClickUtils;
import com.catherineliu.practice.main_code.about_banner.BannerActivity;
import com.catherineliu.practice.main_code.about_db_green_dao.GreenDaoActivity;
import com.catherineliu.practice.main_code.about_download_file.DownloadFileActivity;
import com.catherineliu.practice.main_code.about_drawer_layout.DrawerLayoutActivity;
import com.catherineliu.practice.main_code.about_ebbinghaus.EbbinghausActivity;
import com.catherineliu.practice.main_code.about_handler.HandlerActivity;
import com.catherineliu.practice.main_code.about_identity.IdentityActivity;
import com.catherineliu.practice.main_code.about_list_select_all.ListSelectAllActivity;
import com.catherineliu.practice.main_code.about_mvp.MVPActivity;
import com.catherineliu.practice.main_code.about_okhttp.OkHttpActivity;
import com.catherineliu.practice.main_code.about_password_block.PasswordBlockActivity;
import com.catherineliu.practice.main_code.about_realm.RealmActivity;
import com.catherineliu.practice.main_code.about_refresh_and_more.RefreshAndMoreActivity;
import com.catherineliu.practice.main_code.about_third_part_share.ThirdPartShareActivity;
import com.catherineliu.practice.main_code.about_time_picker.TimePickerActivity;
import com.catherineliu.practice.main_code.about_viewpager_tablayout.ViewPagerActivity;
import com.catherineliu.practice.main_code.about_viewpager_tablayout.ViewPagerSecondActivity;
import com.catherineliu.practice.main_code.aboutt_retrofit_and_rxjava.RetrofitActivity;
import com.catherineliu.practice.main_code.aboutt_retrofit_and_rxjava.RetrofitAndRxJavaActivity;
import com.catherineliu.practice.main_code.aboutt_retrofit_and_rxjava.RxJavaActivity;

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
        includeTopTvTitle.setText("Welcome to Catherine's Practice Kingdom");
    }

    @Override
    protected void initData() {
    }

    @OnClick({R.id.main_btn_pwd_lock, R.id.main_btn_view_pager, R.id.main_btn_refresh_and_more, R.id.main_btn_time_picker_view
            , R.id.main_btn_show_jni, R.id.main_btn_list_select_all, R.id.main_btn_show_banner, R.id.main_btn_view_pager_2
            , R.id.main_btn_retrofit, R.id.main_btn_rxjava, R.id.main_btn_retrofit_and_rxjava
            , R.id.main_btn_ebbinghaus, R.id.main_btn_drawer_layout, R.id.main_btn_download, R.id.main_btn_mvp
            , R.id.main_btn_handler, R.id.main_btn_realm, R.id.main_btn_green_dao, R.id.main_btn_third_part_share
            , R.id.main_btn_identity, R.id.main_btn_jump_2_okhttp
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
            case R.id.main_btn_download:  // 下载文件
                if (NoDoubleClickUtils.isDoubleClickNoToast()) {
                    IntentUtils.JumpTo(DownloadFileActivity.class);
                }
                break;
            case R.id.main_btn_mvp:  // MVP实战
                if (NoDoubleClickUtils.isDoubleClickNoToast()) {
                    IntentUtils.JumpTo(MVPActivity.class);
                }
                break;
            case R.id.main_btn_handler:  // Handler实战
                if (NoDoubleClickUtils.isDoubleClickNoToast()) {
                    IntentUtils.JumpTo(HandlerActivity.class);
                }
                break;
            case R.id.main_btn_realm:  // realm实战
                if (NoDoubleClickUtils.isDoubleClickNoToast()) {
                    IntentUtils.JumpTo(RealmActivity.class);
                }
                break;
            case R.id.main_btn_green_dao:  // greenDao实战
                if (NoDoubleClickUtils.isDoubleClickNoToast()) {
                    IntentUtils.JumpTo(GreenDaoActivity.class);
                }
                break;
            case R.id.main_btn_third_part_share:  // greenDao实战
                if (NoDoubleClickUtils.isDoubleClickNoToast()) {
                    IntentUtils.JumpTo(ThirdPartShareActivity.class);
                }
                break;
            case R.id.main_btn_identity:  // 身份证验证
                if (NoDoubleClickUtils.isDoubleClickNoToast()) {
                    IntentUtils.JumpTo(IdentityActivity.class);
                }
                break;
            case R.id.main_btn_jump_2_okhttp:  // OkHttp
                if (NoDoubleClickUtils.isDoubleClickNoToast()) {
                    IntentUtils.JumpTo(OkHttpActivity.class);
                }
                break;
        }
    }

}
