package com.catherineliu.practice.main_code.about_mvp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.catherineliu.practice.R;
import com.catherineliu.practice.about_base.BaseActivity;
import com.catherineliu.practice.about_utils.NoDoubleClickUtils;
import com.catherineliu.practice.main_code.about_mvp.presenter.Presenter;
import com.catherineliu.practice.main_code.about_mvp.view.IView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MVPActivity extends BaseActivity implements IView {

    @BindView(R.id.mvp_ed_input)
    EditText mvpEdInput;
    @BindView(R.id.mvp_tv_show)
    TextView mvpTvShow;
    @BindView(R.id.include_top_tv_title)
    TextView includeTopTvTitle;

    private Presenter mPresenter;

    @Override
    protected int getLayoutView() {
        return R.layout.activity_mvp;
    }

    @Override
    protected void initViewUI() {
        super.initViewUI();
        includeTopTvTitle.setText(getResources().getString(R.string.mvp_title));

    }

    @Override
    protected void initData() {
        super.initData();
        mPresenter = new Presenter(this);
    }

    @OnClick({R.id.mvp_btn_search, R.id.mvp_btn_clear})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mvp_btn_search:
                if (NoDoubleClickUtils.isDoubleClick()) {
                    mPresenter.getInfo(mvpEdInput.getText().toString());
                }
                break;
            case R.id.mvp_btn_clear:
                if (NoDoubleClickUtils.isDoubleClick()) {
                    mvpEdInput.setText("");
                }
                break;
        }
    }

    @Override
    public void showInfo(String info) {
//        Toast.makeText(this, info, Toast.LENGTH_LONG).show();
        mvpTvShow.setText(info);
    }

}
