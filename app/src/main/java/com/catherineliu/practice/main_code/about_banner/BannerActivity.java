package com.catherineliu.practice.main_code.about_banner;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.catherineliu.practice.R;
import com.catherineliu.practice.about_base.BaseActivity;
import com.catherineliu.practice.about_utils.AppManager;
import com.catherineliu.practice.about_utils.CusPopupWindow;
import com.catherineliu.practice.about_utils.NoDoubleClickUtils;
import com.catherineliu.practice.about_utils.ToastUtil;
import com.youth.banner.Banner;
import com.youth.banner.indicator.CircleIndicator;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * 项目：Practice
 * 文件描述：图片轮播器界面
 * 作者：ljj
 * 创建时间：2020/4/21
 */
public class BannerActivity extends BaseActivity {

    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.banner_lin_main)
    LinearLayout mLinMain;

    private List<DataBannerBean> drawableIdsList = new ArrayList<>();
    @Override
    protected int getLayoutView() {
        return R.layout.activity_banner;
    }

    @Override
    protected void initViewUI() {
        super.initViewUI();

        DataBannerBean dataBannerBean = new DataBannerBean();
        dataBannerBean.setDrawableId(R.drawable.checked);
        dataBannerBean.setFirstText("这是第一个界面");
        dataBannerBean.setSecondText("Hello World!");
        drawableIdsList.add(dataBannerBean);
        DataBannerBean dataBannerBean2 = new DataBannerBean();
        dataBannerBean2.setDrawableId(R.drawable.unchecked);
        dataBannerBean2.setFirstText("这是第二个界面");
        dataBannerBean2.setSecondText("Hello World + +!");
        drawableIdsList.add(dataBannerBean2);

        banner.setAdapter(new BannerDataAdapter(drawableIdsList))
                .setIndicator(new CircleIndicator(this))
                .setIndicatorSelectedColor(getResources().getColor(R.color.app_theme))
                .setIndicatorNormalColor(getResources().getColor(R.color.greye5))
                .start();

    }

    @OnClick({R.id.banner_tv_create, R.id.banner_tv_import})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.banner_tv_create:  // 创建
                if (NoDoubleClickUtils.isDoubleClickNoToast()){
//                    ToastUtil.show("创建");
                    showCusPopupWindow();
//                    AppManager.getAppManager().finishActivity(BannerActivity.this);
                }
                break;
            case R.id.banner_tv_import:  // 导入
                if (NoDoubleClickUtils.isDoubleClickNoToast()){
                    ToastUtil.show("导入");
                    AppManager.getAppManager().finishActivity(BannerActivity.this);
                }
                break;
        }
    }

    private CusPopupWindow cusPopupWindow = null;
    private void showCusPopupWindow() {
        View mView = LayoutInflater.from(this).inflate(R.layout.layout_cus_popupwindow, null);
        if (cusPopupWindow == null) {
            cusPopupWindow = new CusPopupWindow.PopupWindowBuilder(BannerActivity.this)
                    .setView(mView)
                    .setFocusable(true)
                    .setOutsideTouchable(true)
                    .size(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
                    .setAnimationStyle(0) // 添加自定义显示和消失动画
                    .create();
            if(Build.VERSION.SDK_INT < Build.VERSION_CODES.N){ // 如果版本号小于7.0
                cusPopupWindow.showAsDropDown(mLinMain, 0, -mLinMain.getHeight());
            } else {
                cusPopupWindow.showAsDropDown(mLinMain, 0, 0);
            }
            mView.findViewById(R.id.pop_btn_sure).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (cusPopupWindow != null){
                        cusPopupWindow.dismiss();
                        ToastUtil.show("确定");
                    }
                }
            });
            mView.findViewById(R.id.pop_btn_cancel).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (cusPopupWindow != null)
                        cusPopupWindow.dismiss();
                }
            });
            mView.findViewById(R.id.pop_rl_main).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (cusPopupWindow != null)
                        cusPopupWindow.dismiss();
                }
            });
        } else {
            if(Build.VERSION.SDK_INT < Build.VERSION_CODES.N){ // 如果版本号小于7.0
                cusPopupWindow.showAsDropDown(mLinMain, 0, -mLinMain.getHeight());
            } else {
                cusPopupWindow.showAsDropDown(mLinMain, 0, 0);
            }
        }
    }
}
