package com.catherineliu.practice.main_code.about_identity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.catherineliu.practice.R;
import com.catherineliu.practice.about_base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 项目：Practice
 * 文件描述：验证身份证是否正确
 * 作者：ljj
 * 创建时间：2020/11/24
 */
public class IdentityActivity extends BaseActivity {

    @BindView(R.id.include_top_tv_title)
    TextView includeTopTvTitle;
    @BindView(R.id.ed_input)
    EditText edInput;
    @BindView(R.id.tv_show_result)
    TextView tvShowResult;

    @Override
    protected int getLayoutView() {
        return R.layout.activity_identity;
    }

    @Override
    protected void initViewUI() {
        includeTopTvTitle.setText(getString(R.string.main_btn_jump_2_identity));
    }

    @Override
    protected void initData() {

    }

    @OnClick(R.id.btn_check)
    public void onViewClicked() {
        String id = edInput.getText().toString().trim();
        tvShowResult.setText((IdentityUtils.isRealIDCard(id) && IdentityUtils.isRealIDCardSec(id)) ? "是正确的身份证信息" : "校验不通过");
    }

}
