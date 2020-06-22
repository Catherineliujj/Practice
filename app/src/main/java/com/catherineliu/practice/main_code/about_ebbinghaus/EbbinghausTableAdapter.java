package com.catherineliu.practice.main_code.about_ebbinghaus;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.catherineliu.practice.R;
import com.catherineliu.practice.main_code.about_list_select_all.DataListSelectAll;
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
public class EbbinghausTableAdapter extends BaseQuickAdapter<DataEbbinghaus, BaseViewHolder> {

    private Context context;
    private List<DataEbbinghaus> list = new ArrayList<>();
    private List<String> contentList = new ArrayList<>();
    private Map<String, DataEbbinghaus> checkNow = new HashMap<String, DataEbbinghaus>();

    private TextView mTv;
    private CheckBox mCheckBox;
    public EbbinghausTableAdapter(Context mContext, List<DataEbbinghaus> list) {
        super(R.layout.item_list_select_all, list);
        this.context = mContext;
        this.list = list;

    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        holder.setIsRecyclable(false);
    }

    @Override
    protected void convert(final BaseViewHolder helper, final DataEbbinghaus item) {}

}
