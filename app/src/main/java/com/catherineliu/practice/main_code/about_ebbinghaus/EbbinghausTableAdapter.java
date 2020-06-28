package com.catherineliu.practice.main_code.about_ebbinghaus;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.catherineliu.practice.R;
import com.catherineliu.practice.about_utils.MyLog;
import com.catherineliu.practice.about_utils.StrUtils;
import com.catherineliu.practice.main_code.about_list_select_all.DataListSelectAll;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.Calendar;
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

    public EbbinghausTableAdapter(Context mContext, List<DataEbbinghaus> list) {
        super(R.layout.item_ebbinghaus_day, list);
        this.context = mContext;
        this.list = list;

    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        holder.setIsRecyclable(false);
        TextView mTvTime = holder.getView(R.id.item_tv_time);
        TextView mTvList = holder.getView(R.id.item_tv_list);

        if (position == 0) {
            DataEbbinghaus dataEbbinghaus0 = list.get(0);
            MyLog.i("dataEbbinghaus", dataEbbinghaus0.getListStr() + "=====" + dataEbbinghaus0.getWeek());
            int week = dataEbbinghaus0.getWeek();
            for (int i = 0; i < week - 1; i++) {
                DataEbbinghaus dataEbbinghaus = new DataEbbinghaus();
                dataEbbinghaus.setListStr("");
                dataEbbinghaus.setDay("");
                list.add(0, dataEbbinghaus);
            }
            DataEbbinghaus dataEbbinghaus = list.get(week - 1);
            if (dataEbbinghaus != null){
                mTvTime.setText(dataEbbinghaus.getDay() + "");
                mTvList.setText(dataEbbinghaus.getListStr() + "");
            }
            return;
        }

        DataEbbinghaus dataEbbinghaus = list.get(position);
        if (dataEbbinghaus != null/* && !StrUtils.isEmpty(dataEbbinghaus.getDay())*/){
            mTvTime.setText(dataEbbinghaus.getDay() + "");
            mTvList.setText(dataEbbinghaus.getListStr() + "");
        }

    }

    @Override
    protected void convert(final BaseViewHolder helper, final DataEbbinghaus item) {}

}
