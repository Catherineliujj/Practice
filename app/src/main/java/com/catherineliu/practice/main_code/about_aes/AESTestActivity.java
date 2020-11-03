package com.catherineliu.practice.main_code.about_aes;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.catherineliu.practice.R;
import com.catherineliu.practice.about_base.BaseActivity;
import com.catherineliu.practice.about_utils.AESUtil;
import com.catherineliu.practice.about_utils.NoDoubleClickUtils;
import com.catherineliu.practice.about_utils.StrUtils;
import com.catherineliu.practice.about_utils.ToastUtil;

import butterknife.BindView;
import butterknife.OnClick;

public class AESTestActivity extends BaseActivity {


    @BindView(R.id.include_top_tv_title)
    TextView includeTopTvTitle;
    @BindView(R.id.ed_input_str)
    EditText edInputStr;
    @BindView(R.id.ed_input_pwd)
    EditText edInputPwd;
    @BindView(R.id.tv_result)
    TextView tvResult;

    @Override
    protected int getLayoutView() {
        return R.layout.activity_aestest;
    }

    @Override
    protected void initViewUI() {

    }

    @Override
    protected void initData() {

    }

    @OnClick({R.id.tv_encrypt, R.id.tv_decrypt})
    public void onViewClicked(View view) {
        String str = edInputStr.getText().toString();
        String pwd = edInputPwd.getText().toString();
        switch (view.getId()) {
            case R.id.tv_encrypt:
                if (NoDoubleClickUtils.isDoubleClickNoToast()){
                    if (!StrUtils.isEmpty(str) && !StrUtils.isEmpty(pwd)){
                        String encrypt = AESUtil.encrypt(pwd, str);
                        tvResult.setText(StrUtils.isEmpty(encrypt) ? "加密结果为空" : encrypt);
                    } else {
                        ToastUtil.show("请输入完整的数据");
                    }
                }
                break;
            case R.id.tv_decrypt:
                if (NoDoubleClickUtils.isDoubleClickNoToast()){
                    if (!StrUtils.isEmpty(str) && !StrUtils.isEmpty(pwd)){
                        String decrypt = AESUtil.decrypt(pwd, str);
                        tvResult.setText(StrUtils.isEmpty(decrypt) ? "解密结果为空" : decrypt);
                    } else {
                        ToastUtil.show("请输入完整的数据");
                    }
                }
                break;
        }
    }
}
