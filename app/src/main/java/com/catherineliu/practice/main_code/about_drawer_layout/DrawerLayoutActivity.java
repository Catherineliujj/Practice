package com.catherineliu.practice.main_code.about_drawer_layout;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.catherineliu.practice.R;
import com.catherineliu.practice.about_base.BaseActivity;
import com.catherineliu.practice.about_utils.AppManager;
import com.catherineliu.practice.about_utils.NoDoubleClickUtils;
import com.catherineliu.practice.about_utils.StrUtils;
import com.catherineliu.practice.about_utils.ToastUtil;

import androidx.drawerlayout.widget.DrawerLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DrawerLayoutActivity extends BaseActivity {

    @BindView(R.id.include_top_tv_title)
    TextView includeTopTvTitle;
    @BindView(R.id.head_ed_input)
    EditText headEdInput;
    @BindView(R.id.menu_tv_1)
    TextView menuTv1;
    @BindView(R.id.menu_tv_2)
    TextView menuTv2;
    @BindView(R.id.menu_tv_3)
    TextView menuTv3;
    @BindView(R.id.menu_tv_4)
    TextView menuTv4;
    @BindView(R.id.drawer_main)
    DrawerLayout drawerMain;
    @BindView(R.id.tv_content)
    TextView TvContent;
/*     @BindView(R.id.drawer_layout_drawer_layout)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.drawer_layout_navigation_view)
    NavigationView mNavigationView;
    @BindView(R.id.drawer_layout_tv_content)
    TextView drawerLayoutTvContent;
    private MenuItem mMenuItem;*/

    @Override
    protected int getLayoutView() {
        return R.layout.activity_drawer_layout;
    }

    @Override
    protected boolean isTopSwitch() {
        return false;
    }

    @Override
    protected void initViewUI() {
        super.initViewUI();
        includeTopTvTitle.setText(getResources().getString(R.string.main_btn_jump_2_drawer_layout));

//        setNavigationViewItemClickListener();
    }

    @Override
    protected void initData() {
        super.initData();
    }

/*    private void setNavigationViewItemClickListener() {
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (null != mMenuItem) {
                    mMenuItem.setChecked(false);
                }
                switch (item.getItemId()) {
                    case R.id.navigation_item_first:
                        ToastUtil.show("click 第一！");
                        break;
                    case R.id.navigation_item_second:
                        ToastUtil.show("click 第二！！");
                        break;
                    default:
                        ToastUtil.show("click 其它！！");
                        break;

                }
                item.setChecked(true);
                mDrawerLayout.closeDrawer(Gravity.RIGHT);
                mMenuItem = item;
                return false;
            }
        });
    }

    @OnClick({R.id.include_top_iv_right, R.id.drawer_layout_tv_content, R.id.drawer_layout_drawer_layout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.include_top_iv_right:
                if (NoDoubleClickUtils.isDoubleClickNoToast()) {
//                    mDrawerLayout.openDrawer(Gravity.RIGHT);
                }
                break;
            case R.id.drawer_layout_tv_content:
                if (NoDoubleClickUtils.isDoubleClickNoToast()) {
                }
                break;
            case R.id.drawer_layout_drawer_layout:
                if (NoDoubleClickUtils.isDoubleClickNoToast()) {

                }
                break;
        }
    }
*/

    @OnClick({R.id.include_top_iv_right, R.id.head_iv_copy, R.id.bottom_lin_main
            , R.id.menu_lin_version, R.id.menu_lin_version2, R.id.menu_lin_version3, R.id.menu_lin_version4
            , R.id.menu_lin_exit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.include_top_iv_right:
                if (NoDoubleClickUtils.isDoubleClickNoToast()) {
                    drawerMain.openDrawer(Gravity.RIGHT);
                }
                break;
            case R.id.head_iv_copy:
                if (NoDoubleClickUtils.isDoubleClickNoToast()) {
                    String input = headEdInput.getText().toString();
                    StrUtils.copyStrings(DrawerLayoutActivity.this, input);
                    TvContent.setText("已复制：" + input);
                }
                break;
            case R.id.bottom_lin_main:
                if (NoDoubleClickUtils.isDoubleClickNoToast()) {
                    AppManager.getAppManager().finishActivity(DrawerLayoutActivity.this);
                }
                break;
            case R.id.menu_lin_version:
                if (NoDoubleClickUtils.isDoubleClickNoToast()) {
                    TvContent.setText("获取版本信息：" + menuTv1.getText().toString());
                    drawerMain.closeDrawer(Gravity.RIGHT);
                }
                break;
            case R.id.menu_lin_version2:
                if (NoDoubleClickUtils.isDoubleClickNoToast()) {
                    TvContent.setText("获取版本信息：" + menuTv2.getText().toString());
                    drawerMain.closeDrawer(Gravity.RIGHT);
                }
                break;
            case R.id.menu_lin_version3:
                if (NoDoubleClickUtils.isDoubleClickNoToast()) {
                    TvContent.setText("获取版本信息：" + menuTv3.getText().toString());
                    drawerMain.closeDrawer(Gravity.RIGHT);
                }
                break;
            case R.id.menu_lin_version4:
                if (NoDoubleClickUtils.isDoubleClickNoToast()) {
                    TvContent.setText("获取版本信息：" + menuTv4.getText().toString());
                    drawerMain.closeDrawer(Gravity.RIGHT);
                }
                break;
            case R.id.menu_lin_exit:
                if (NoDoubleClickUtils.isDoubleClickNoToast()) {
                    drawerMain.closeDrawer(Gravity.RIGHT);
                }
                break;
        }
    }
}
