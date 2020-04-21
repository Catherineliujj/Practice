package com.catherineliu.practice.main_code.about_list_select_all;

import android.view.View;
import android.widget.TextView;

import com.catherineliu.practice.R;
import com.catherineliu.practice.about_base.BaseActivity;
import com.catherineliu.practice.about_utils.NoDoubleClickUtils;
import com.catherineliu.practice.about_utils.StrUtils;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * 项目：Practice
 * 文件描述：列表全选与全不选
 * 作者：ljj
 * 创建时间：2020/4/20
 */
public class TestListSelectAllActivity extends BaseActivity {

    @BindView(R.id.include_top_tv_title)
    TextView includeTopTvTitle;
    @BindView(R.id.list_select_all_rv)
    RecyclerView mRecyclerView;
    //    private RecyclerView mRecyclerView;
    @BindView(R.id.list_select_all_tv_count)
    TextView mTvCount;

    private TestListSelectAllAdapter listSelectAllAdapter = null;
    private List<DataListSelectAll> listSelectAllList = new ArrayList<>();
    private List<String> contentList = new ArrayList<>();

    @Override
    protected int getLayoutView() {
        return R.layout.activity_list_select_all;
    }

    @Override
    protected void initViewUI() {
        super.initViewUI();
//        mRecyclerView = getView(R.id.list_select_all_rv);
    }

    @Override
    protected void initData() {
        super.initData();
        // 初始化RecyclerView
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.addItemDecoration(new DividerItemDecoration(TestListSelectAllActivity.this,DividerItemDecoration.VERTICAL));

        // 初始化数据
        for (int i = listSelectAllList.size(); i <= 16; i++) {
            DataListSelectAll dataListSelectAll = new DataListSelectAll();
            dataListSelectAll.setContent("地点 " + (i + 1));
            dataListSelectAll.setChecked(false);
            listSelectAllList.add(dataListSelectAll);
        }

        if (listSelectAllList.size() > 0) {
            // 初始化Adapter
            listSelectAllAdapter = new TestListSelectAllAdapter(TestListSelectAllActivity.this, listSelectAllList);
            mRecyclerView.setAdapter(listSelectAllAdapter);

        }
    }

    @OnClick({R.id.list_select_all_btn_select_all, R.id.list_select_all_btn_select_none, R.id.list_select_all_btn_sure})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.list_select_all_btn_select_all:  // 全选
                if (NoDoubleClickUtils.isDoubleClickNoToast()){
                }
                break;
            case R.id.list_select_all_btn_select_none:  // 全不选
                if (NoDoubleClickUtils.isDoubleClickNoToast()){
                }
                break;
            case R.id.list_select_all_btn_sure:  // 确定
                if (NoDoubleClickUtils.isDoubleClickNoToast()){
                }
                break;
        }
    }
}
