package com.catherineliu.practice.main_code.about_list_select_all;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.catherineliu.practice.MainActivity;
import com.catherineliu.practice.R;
import com.catherineliu.practice.about_base.BaseActivity;
import com.catherineliu.practice.about_utils.MyLog;
import com.catherineliu.practice.about_utils.NoDoubleClickUtils;
import com.catherineliu.practice.about_utils.StrUtils;
import com.catherineliu.practice.about_utils.ToastUtil;
import com.chad.library.adapter.base.BaseQuickAdapter;

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
 * 备注：单选未完成
 * 作者：ljj
 * 创建时间：2020/4/20
 */
public class ListSelectAllActivity extends BaseActivity {

    @BindView(R.id.include_top_tv_title)
    TextView includeTopTvTitle;
    @BindView(R.id.list_select_all_rv)
    RecyclerView mRecyclerView;
    @BindView(R.id.list_select_all_tv_count)
    TextView mTvCount;

    private ListSelectAllAdapter listSelectAllAdapter = null;
    private List<DataListSelectAll> listSelectAllList = new ArrayList<>();
    private List<String> contentList = new ArrayList<>();

    @Override
    protected int getLayoutView() {
        return R.layout.activity_list_select_all;
    }

    @Override
    protected void initViewUI() {
//        mRecyclerView = getView(R.id.list_select_all_rv);
        includeTopTvTitle.setText("列表全选 & 反选");

        // 初始化RecyclerView
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.addItemDecoration(new DividerItemDecoration(ListSelectAllActivity.this,DividerItemDecoration.VERTICAL));
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void initData() {

        // 初始化数据
        for (int i = listSelectAllList.size(); i <= 16; i++) {
            DataListSelectAll dataListSelectAll = new DataListSelectAll();
            dataListSelectAll.setContent("甜品 " + (i + 1));
            dataListSelectAll.setChecked(false);
            listSelectAllList.add(dataListSelectAll);
        }

        if (listSelectAllList.size() > 0) {
            // 初始化Adapter
            if (listSelectAllAdapter == null) {
                listSelectAllAdapter = new ListSelectAllAdapter(ListSelectAllActivity.this, listSelectAllList);
            }
            mRecyclerView.setAdapter(listSelectAllAdapter);
            listSelectAllAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                    DataListSelectAll item = (DataListSelectAll)adapter.getItem(position);
                    if (item != null) {
                        item.setChecked(!item.isChecked());
                        listSelectAllAdapter.setCheck(item);
                        listSelectAllAdapter.notifyItemData(item);
                    }
                }
            });

        }
    }

    @OnClick({R.id.list_select_all_btn_select_all, R.id.list_select_all_btn_select_none, R.id.list_select_all_btn_sure})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.list_select_all_btn_select_all:  // 全选
                if (NoDoubleClickUtils.isDoubleClickNoToast()){
                    setData(true);
                }
                break;
            case R.id.list_select_all_btn_select_none:  // 全不选
                if (NoDoubleClickUtils.isDoubleClickNoToast()){
                    setData(false);
                }
                break;
            case R.id.list_select_all_btn_sure:  // 确定
                if (NoDoubleClickUtils.isDoubleClickNoToast()){
                    if (listSelectAllAdapter != null) {
                        contentList.clear();
                        for (int i = 0; i < listSelectAllList.size(); i++) {
                            if (listSelectAllList.get(i).isChecked()) {
                                contentList.add(listSelectAllList.get(i).getContent());
                            } else {
                                contentList.remove(listSelectAllList.get(i).getContent());
                            }
                        }
                        List<String> tempNames = listSelectAllAdapter.removeDuplicate(contentList);
                        String strNames = StrUtils.list2String(tempNames, ", ");
                        mTvCount.setText(strNames);
                    }
                }
                break;
        }
    }

    // 设置数据
    private void setData(boolean isAll) {
        for (DataListSelectAll data : listSelectAllList) {
            if (isAll) {
                data.setChecked(true);
                listSelectAllAdapter.setCheck(data);
            } else {
                data.setChecked(false);
            }
        }
        listSelectAllAdapter.notifyData(listSelectAllList);
    }
}
