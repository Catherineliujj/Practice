package com.catherineliu.practice.main_code.about_list_select_all;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.catherineliu.practice.R;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 项目：Practice
 * 文件描述：全选与反选适配器
 * 作者：ljj
 * 创建时间：2020/4/20
 */
public class ListSelectAllAdapter extends BaseQuickAdapter<DataListSelectAll, BaseViewHolder> {

    private Context context;
    private List<DataListSelectAll> list = new ArrayList<>();
    private List<String> contentList = new ArrayList<>();
    private Map<String, DataListSelectAll> checkNow = new HashMap<String, DataListSelectAll>();

    private TextView mTv;
    private CheckBox mCheckBox;
    public ListSelectAllAdapter(Context mContext, List<DataListSelectAll> list) {
        super(R.layout.item_list_select_all, list);
        this.context = mContext;
        this.list = list;
        this.mData = new ArrayList<>();
        this.mData.addAll(list);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        holder.setIsRecyclable(false);
        mTv = holder.getView(R.id.item_tv_content);
        mCheckBox = holder.getView(R.id.item_checkbox);

        DataListSelectAll item = mData.get(position);
        mTv.setText(item.getContent());
        mCheckBox.setChecked(item.isChecked());
    }

    @Override
    protected void convert(final BaseViewHolder helper, final DataListSelectAll item) {}

    // 刷新item
    public void notifyItemData(DataListSelectAll item) {
        if (item != null) {
            new Handler().post(new Runnable() {
                @Override
                public void run() {
                    notifyDataSetChanged();
                }
            });

            if (item.isChecked()) {
                contentList.add(item.getContent());
            } else {
                contentList.remove(item.getContent());
            }

        }
    }

    // 刷新整个列表
    public void notifyData(List<DataListSelectAll> list) {
        if (list != null) {
            this.mData.clear();
            this.mData.addAll(list);
        }
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                notifyDataSetChanged();
            }
        });

        for (int i = 0; i < mData.size(); i++) {
            if (mData.get(i).isChecked()) {
                contentList.add(mData.get(i).getContent());
            } else {
                contentList.remove(mData.get(i).getContent());
            }
        }
    }


    public List<String> removeDuplicate(List<String> list) {
        Set set = new LinkedHashSet<>(list);
        list.clear();
        list.addAll(set);
        return list;
    }

    public void setCheck(DataListSelectAll info) {
        if (checkNow.get(info.getContent()) == null) {
            checkNow.put(info.getContent(), info);
        } else {
            checkNow.remove(info.getContent());
        }
    }
}
