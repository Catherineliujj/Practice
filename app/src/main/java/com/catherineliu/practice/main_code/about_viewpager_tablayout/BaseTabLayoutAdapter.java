package com.catherineliu.practice.main_code.about_viewpager_tablayout;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.catherineliu.practice.R;
import com.catherineliu.practice.main_code.about_banner.DataBannerBean;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Describe : TabLayout适配器,快速实现TabLayout自定义View数据加载
 * @author chendong
 */
public abstract class BaseTabLayoutAdapter<T>{

    private Context mContext;
    // 自定义布局layout文件
    private int mResId;
    // 数据源
    private List<T> mDatas;
    // 全部的控件，用来切换时改变显示
    private List<TabLayoutViewHolder> mTabLayoutViewHolders;
    // tabLayout
    private TabLayout mTabLayout;
    // 简化的tab点击事件
    private OnTabSelectListener<T> mOnTabSelectListener;

    /**
     * Tab选中的接口
     *
     * @param <T>
     */
    public interface OnTabSelectListener<T> {
        void onSelect(int pos, T data);
    }

    protected BaseTabLayoutAdapter(Context context, List<T> datas, int resId) {
        mDatas = datas;
        mContext = context;
        mResId = resId;
        mTabLayoutViewHolders = new ArrayList<>();
    }

    public void attachTabLayout(TabLayout tabLayout) {
        attachTabLayout(tabLayout, 0);
    }
    private TextView mTv;
    private LinearLayout mLinMain;
    private void attachTabLayout(TabLayout tabLayout, int posSelect) {
        mTabLayout = tabLayout;
        // 设置导航条高度=0
        tabLayout.setSelectedTabIndicatorHeight(0);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                updateStatus(mTabLayoutViewHolders.get(position), mDatas.get(position), true);
                if (mOnTabSelectListener != null) {
                    mOnTabSelectListener.onSelect(position, mDatas.get(position));
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                updateStatus(mTabLayoutViewHolders.get(tab.getPosition()), mDatas.get(tab.getPosition()), false);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                updateStatus(mTabLayoutViewHolders.get(tab.getPosition()), mDatas.get(tab.getPosition()), true);
            }
        });
        //  初始化view,默认初始化为全部不选中
        View childView;
        TabLayoutViewHolder holder;
        TabLayout.Tab tab;
        for (int i = 0; i < mDatas.size(); i++) {
            childView = LayoutInflater.from(mContext).inflate(R.layout.layout_tab, tabLayout, false);
            holder = new TabLayoutViewHolder(childView);
            mTabLayoutViewHolders.add(holder);
            DataBannerBean dataBannerBean = (DataBannerBean) mDatas.get(i);
            mTv = childView.findViewById(R.id.tab_tv);
            mTv.setText(dataBannerBean.getFirstText());
            mLinMain = childView.findViewById(R.id.tab_lin_main);
            mLinMain.setBackground(mContext.getResources().getDrawable(R.drawable.btn_stroke_grey333));
            updateStatus(mTabLayoutViewHolders.get(i), this.mDatas.get(i), false);
            tab = tabLayout.newTab().setCustomView(childView);
            tabLayout.addTab(tab);
        }

        // 选中初始化选中的那个
        TabLayout.Tab tabAt = tabLayout.getTabAt(posSelect);
        if (tabAt != null){
            tabAt.select();
/*            mLinMain.setBackground(mContext.getResources().getDrawable(R.drawable.btn_shape_white));
            mTv.setTextColor(mContext.getResources().getColor(R.color.wallet_theme));*/
        }
    }

    /**
     * 抽象方法，更新控件状态显示
     * @param holder view holder
     * @param data 数据
     * @param isSelect 是否选中
     */
    public abstract void updateStatus(TabLayoutViewHolder holder, T data, boolean isSelect);

    public void setOnTabSelectListener(OnTabSelectListener<T> onTabSelectListener) {
        mOnTabSelectListener = onTabSelectListener;
    }

    /**
     * 公共holder，用来存储和快速获取控件
     */
    public static class TabLayoutViewHolder {
        private View parentView;
        private SparseArray<View> mCacheViews;

        public View getParentView() {
            return parentView;
        }

        TabLayoutViewHolder(View parentView) {
            this.parentView = parentView;
            mCacheViews = new SparseArray<>();
        }

        public <V extends View> V getView(int resId) {
            V v = (V) mCacheViews.get(resId);
            if (v == null) {
                v = (V) parentView.findViewById(resId);
                if (v != null) {
                    mCacheViews.put(resId, v);
                }
            }
            return v;
        }
    }
}