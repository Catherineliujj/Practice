package com.catherineliu.practice.main_code.about_viewpager_tablayout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.catherineliu.practice.R;

import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

/**
 * 项目：Practice
 * 文件描述：tab的适配器
 * 作者：ljj
 * 创建时间：2020/4/22
 */
public class TabFragmentAdapter extends FragmentPagerAdapter {

    private String[] mTitles;
    private Context mContext;
    private List<Fragment> mFragments;

    public TabFragmentAdapter(List<Fragment> fragments, String[] titles, FragmentManager fm, Context context) {
        super(fm);
        this.mContext = context;
        this.mFragments = fragments;
        this.mTitles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }

    public View getTabView(int position) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_tab, null);
        TextView textView=view.findViewById(R.id.tab_tv);
        textView.setText(mTitles[position]);
        return view;
    }
}









