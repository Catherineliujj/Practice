package com.catherineliu.practice.main_code.about_mvp;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.catherineliu.practice.R;
import com.catherineliu.practice.about_base.BaseActivity;
import com.catherineliu.practice.about_utils.NoDoubleClickUtils;
import com.catherineliu.practice.about_utils.StrUtils;
import com.catherineliu.practice.main_code.about_mvp.model.ModelBean;
import com.catherineliu.practice.main_code.about_mvp.presenter.Presenter;
import com.catherineliu.practice.main_code.about_mvp.presenter.Presenter2;
import com.catherineliu.practice.main_code.about_mvp.view.IView;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONArray;

import butterknife.BindView;
import butterknife.OnClick;

public class MVPActivity extends BaseActivity implements com.catherineliu.practice.main_code.about_mvp.view.View {

    @BindView(R.id.mvp_ed_input)
    EditText mvpEdInput;
    @BindView(R.id.mvp_tv_show)
    TextView mvpTvShow;
    @BindView(R.id.include_top_tv_title)
    TextView includeTopTvTitle;

    private Presenter mPresenter;
    private Presenter2 presenter2;

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
//        mPresenter = new Presenter(this);
        presenter2 = new Presenter2(this);
    }

    @OnClick({R.id.mvp_btn_search, R.id.mvp_btn_clear})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mvp_btn_search:
                if (NoDoubleClickUtils.isDoubleClick()) {
//                    mPresenter.getInfo(mvpEdInput.getText().toString());
                    if (StrUtils.isNumber(mvpEdInput.getText().toString())) {
                        presenter2.showInfo(Integer.valueOf(mvpEdInput.getText().toString()));
                    } else {
                        presenter2.showInfo(0);
                    }
                }
                break;
            case R.id.mvp_btn_clear:
                if (NoDoubleClickUtils.isDoubleClick()) {
                    mvpEdInput.setText("");
                }
                break;
        }
    }

/*    @Override
    public void showInfo(String info) {
//        Toast.makeText(this, info, Toast.LENGTH_LONG).show();
        mvpTvShow.setText(info);
    }*/

    @Override
    public void showInfo(ModelBean modelBean) {
        if (modelBean == null){
            mvpTvShow.setText("找不到该人员的信息");
        } else {
            String gson = new Gson().toJson(modelBean);
            mvpTvShow.setText(gson);
        }
    }
}
