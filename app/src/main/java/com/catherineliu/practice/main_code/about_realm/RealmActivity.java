package com.catherineliu.practice.main_code.about_realm;

import android.view.View;
import android.widget.TextView;

import com.catherineliu.practice.R;
import com.catherineliu.practice.about_base.BaseActivity;
import com.catherineliu.practice.about_base.BaseRealmConfig;
import com.catherineliu.practice.about_utils.MyLog;
import com.catherineliu.practice.about_utils.NoDoubleClickUtils;
import com.catherineliu.practice.about_utils.ToastUtil;
import com.catherineliu.practice.about_utils.about_realm.BaseRealmTransaction;
import com.catherineliu.practice.model.DC_Main;

import butterknife.BindView;
import butterknife.OnClick;
import io.realm.RealmResults;

public class RealmActivity extends BaseActivity {

    @BindView(R.id.include_top_tv_title)
    TextView includeTopTvTitle;
    @BindView(R.id.realm_tv_content)
    TextView realmTvContent;

    private StringBuilder content = new StringBuilder();
    @Override
    protected int getLayoutView() {
        return R.layout.activity_realm;
    }

    @Override
    protected void initViewUI() {
        includeTopTvTitle.setText("Realm实战");
    }

    @Override
    protected void initData() {
    }

    private void saveDb() {
        new BaseRealmTransaction(BaseRealmConfig.getRealm()) {
            @Override
            public void beginDb() {
                RealmResults<DC_Main> all = realm.where(DC_Main.class).findAll();
                if (all == null){
                    DC_Main first = realm.createObject(DC_Main.class, "地址1");
                    first.setWalletName("钱包1");
                } else {
                    DC_Main first = realm.where(DC_Main.class).equalTo("address", "地址" + (all.size() + 1)).findFirst();
                    if(first == null){
                        first = realm.createObject(DC_Main.class, "地址" + (all.size() + 1));
                    }
                    first.setWalletName("钱包" + all.size());
                }
                if (all != null) {
                    ToastUtil.show("保存成功，共有" + all.size() + "条信息");
                } else {
                    ToastUtil.show("保存失败，没有信息");
                }
                showInfo();
            }
        };
    }

    @OnClick({R.id.realm_tv_save, R.id.realm_tv_show, R.id.realm_tv_delete, R.id.realm_tv_delete_all})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.realm_tv_save:
                MyLog.e("realm", "保存信息");
                saveDb();
                break;
            case R.id.realm_tv_delete_all:
                MyLog.e("realm", "删除全部信息");
                new BaseRealmTransaction(BaseRealmConfig.getRealm()) {
                    @Override
                    public void beginDb() {
                        RealmResults<DC_Main> mains = BaseRealmConfig.getRealm().where(DC_Main.class).findAll();
                        if (mains != null) {
                            mains.deleteAllFromRealm();
                        }
                        ToastUtil.show("删除全部信息成功");
                    }
                };
            case R.id.realm_tv_show:
                MyLog.e("realm", "显示信息");
                showInfo();
                break;
            case R.id.realm_tv_delete:
                MyLog.e("realm", "删除一条信息");
                new BaseRealmTransaction(BaseRealmConfig.getRealm()) {
                    @Override
                    public void beginDb() {
                        DC_Main dcMain = BaseRealmConfig.getRealm().where(DC_Main.class).findFirst();
                        if (dcMain != null) {
                            dcMain.deleteFromRealm();
                        }
                        ToastUtil.show("删除一条信息成功");
                        showInfo();
                    }
                };
                break;
        }
    }

    private void showInfo() {
        RealmResults<DC_Main> mains = BaseRealmConfig.getRealm().where(DC_Main.class).findAll();
        if (mains.size() != 0) {
            for (DC_Main dc_main : mains) {
                content.delete(0, content.length());
                content.append(mains.toString()).append("\n").append("\n").append("\n");
            }
            realmTvContent.setText(content);
        } else {
            realmTvContent.setText("暂无信息");
        }
    }
}