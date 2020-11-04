package com.catherineliu.practice.main_code.about_third_part_share;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.catherineliu.practice.R;
import com.catherineliu.practice.about_base.BaseActivity;
import com.catherineliu.practice.about_utils.NoDoubleClickUtils;
import com.catherineliu.practice.about_utils.ToastUtil;
import com.tencent.connect.share.QQShare;
import com.tencent.connect.share.QzoneShare;
import com.tencent.mm.opensdk.constants.Build;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.OnClick;

import static com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req.WXSceneSession;
import static com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req.WXSceneTimeline;

/**
 * 项目：Practice
 * 文件描述：三方分享
 * 作者：ljj
 * 创建时间：2020/11/4
 */
public class ThirdPartShareActivity extends BaseActivity {

    @BindView(R.id.include_top_tv_title)
    TextView includeTopTvTitle;

    private Tencent mTencent;  // 新建Tencent实例用于调用分享方法
    private static final String WX_APP_ID = "wx88888888";
    private static final String QQ_APP_ID = "tencent88888888";
    // IWXAPI 是第三方app和微信通信的openApi接口
    private IWXAPI api;

    @Override
    protected int getLayoutView() {
        return R.layout.activity_third_part_share;
    }

    @Override
    protected void initViewUI() {
        includeTopTvTitle.setText(getString(R.string.main_btn_jump_2_third_part_share));
    }

    @Override
    protected void initData() {
        // 创建QQ实例
        createQQInstance();
        // 向微信终端注册你的 id
        regToWx();

    }

    private void createQQInstance() {
        // Tencent类是SDK的主要实现类，开发者可通过Tencent类访问腾讯开放的OpenAPI。
        // 其中APP_ID是分配给第三方应用的appid，类型为String。
        // 其中Authorities为 Manifest文件中注册FileProvider时设置的authorities属性值
        mTencent = Tencent.createInstance(QQ_APP_ID, this.getApplicationContext());
    }

    private void regToWx() {
        // 通过WXAPIFactory工厂，获取IWXAPI的实例
        api = WXAPIFactory.createWXAPI(this, WX_APP_ID, true);

        // 将应用的appId注册到微信
        api.registerApp(WX_APP_ID);

        //建议动态监听微信启动广播进行注册到微信
        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                // 将该app注册到微信
                api.registerApp(WX_APP_ID);
            }
        }, new IntentFilter(ConstantsAPI.ACTION_REFRESH_WXAPP));

    }

    @OnClick({R.id.imgbtn_qq, R.id.imgbtn_qq_zone, R.id.imgbtn_wechat, R.id.imgbtn_discover})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imgbtn_qq:  // https://wiki.connect.qq.com/%E5%88%86%E4%BA%AB%E6%B6%88%E6%81%AF%E5%88%B0qq%EF%BC%88%E6%97%A0%E9%9C%80qq%E7%99%BB%E5%BD%95%EF%BC%89
                if (NoDoubleClickUtils.isDoubleClick()) {
                    ToastUtil.show("QQ分享");
                    Bundle params = new Bundle();
                    params.putInt(QQShare.SHARE_TO_QQ_KEY_TYPE, QQShare.SHARE_TO_QQ_TYPE_DEFAULT);// 设置分享类型为纯图片分享
                    params.putString(QQShare.SHARE_TO_QQ_TITLE, "腾讯网");
                    params.putString(QQShare.SHARE_TO_QQ_SUMMARY, "来腾讯网看新闻");
                    params.putString(QQShare.SHARE_TO_QQ_TARGET_URL, "https://www.qq.com/");
                    mTencent.shareToQQ(ThirdPartShareActivity.this, params, mIUiListener);
                }
                break;
            case R.id.imgbtn_qq_zone:  // https://wiki.connect.qq.com/%E5%88%86%E4%BA%AB%E5%88%B0qq%E7%A9%BA%E9%97%B4%EF%BC%88%E6%97%A0%E9%9C%80qq%E7%99%BB%E5%BD%95%EF%BC%89
                if (NoDoubleClickUtils.isDoubleClick()) {
                    ToastUtil.show("QQ空间分享");
                    Bundle params = new Bundle();
                    params.putInt(QzoneShare.SHARE_TO_QZONE_KEY_TYPE, QzoneShare.SHARE_TO_QZONE_TYPE_NO_TYPE);
                    params.putString(QzoneShare.SHARE_TO_QQ_TITLE, "百度");//必填
                    params.putString(QzoneShare.SHARE_TO_QQ_SUMMARY, "百度一下，你就知道");//选填
                    params.putString(QzoneShare.SHARE_TO_QQ_TARGET_URL, "http://www.baidu.com/");//必填
                    mTencent.shareToQzone(ThirdPartShareActivity.this, params, mIUiListener);
                }
                break;
            case R.id.imgbtn_wechat:
                if (NoDoubleClickUtils.isDoubleClick()) {
                    ToastUtil.show("微信分享");
                    shareToWeChatOrDiscover(WXSceneSession);
                }
                break;
            case R.id.imgbtn_discover:
                if (NoDoubleClickUtils.isDoubleClick()) {
                    if (api.getWXAppSupportAPI() >= Build.TIMELINE_SUPPORTED_SDK_INT) {  // 判断微信是否支持分享到朋友圈功能
                        ToastUtil.show("朋友圈分享");
                        shareToWeChatOrDiscover(WXSceneTimeline);
                    }
                }
                break;
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Tencent.onActivityResultData(requestCode, resultCode, data, mIUiListener);
//        Tencent.handleResultData(data, mIUiListener);
//        super.onActivityResult(requestCode, resultCode, data);
    }

    private void shareToWeChatOrDiscover(int scene) {
        //初始化一个 WXTextObject 对象，填写分享的文本内容
        WXTextObject textObj = new WXTextObject();
        textObj.text = "来自DC的分享，这是一款数字资产管理的APP。";

        //用 WXTextObject 对象初始化一个 WXMediaMessage 对象
        WXMediaMessage msg = new WXMediaMessage();
        msg.mediaObject = textObj;
        msg.description = "来自DC的分享，这是一款数字资产管理的APP。";

        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = String.valueOf(System.currentTimeMillis());  //transaction字段用与唯一标示一个请求
        req.message = msg;
        // 如果 scene 填 WXSceneSession，那么消息会发送至微信的会话内
        req.scene = WXSceneSession;  // 0：分享到好友  1：分享到朋友圈

        //调用api接口，发送数据到微信
        api.sendReq(req);
    }

    // 调用SDK已经封装好的接口时，例如：登录、快速支付登录、应用分享、应用邀请等接口，需传入该回调的实例。
    private IUiListener mIUiListener = new IUiListener() {

        @Override
        public void onComplete(Object o) {

        }

        @Override
        public void onError(UiError uiError) {

        }

        @Override
        public void onCancel() {

        }
    };

}