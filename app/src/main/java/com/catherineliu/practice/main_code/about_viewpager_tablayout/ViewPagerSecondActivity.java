package com.catherineliu.practice.main_code.about_viewpager_tablayout;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.catherineliu.practice.R;
import com.catherineliu.practice.about_base.BaseActivity;
import com.catherineliu.practice.main_code.about_banner.DataBannerBean;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

/**
 * 项目：Practice
 * 文件描述：ViewPager + TabLayout + Fragment的主Activity 第二个测试
 * 作者：ljj
 * 创建时间：2020/4/21
 */
public class ViewPagerSecondActivity extends BaseActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    @Override
    protected int getLayoutView() {
        return R.layout.activity_view_pager_second;
    }

    @Override
    protected void initViewUI() {
        tabLayout = getView(R.id.tabs2);
        viewPager = getView(R.id.viewpager);

        DataBannerBean dataBannerBean = new DataBannerBean();
        dataBannerBean.setFirstText("FirstFragment");

        DataBannerBean dataBannerBean2 = new DataBannerBean();
        dataBannerBean2.setFirstText("SecondFragment");
        titlesList.add(dataBannerBean);
        titlesList.add(dataBannerBean2);

        // 初始化fragment的题目
        titles = new String[]{"FirstFragment"
                , "SecondFragment"
        };
        fragmentsList = new ArrayList<>();
        if (fragmentsList.size() == 0){
            fragmentsList.add(new FirstFragment());
            fragmentsList.add(new SecondFragment());
        }

        TabFragmentAdapter mTabFragmentAdapter = new TabFragmentAdapter(fragmentsList, titles, getSupportFragmentManager(), ViewPagerSecondActivity.this);
        viewPager.setOffscreenPageLimit(2);
        viewPager.setAdapter(mTabFragmentAdapter);
        viewPager.setCurrentItem(0);  // 设置当前显示标签页为第一页
        // 将ViewPager和TabLayout绑定
        tabLayout.setupWithViewPager(viewPager);
        // 设置自定义tab
        for (int i = 0; i < tabLayout.getTabCount(); i++){
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            if (tab != null) {
                tab.setCustomView(mTabFragmentAdapter.getTabView(i));
            }
        }
        // 设置第一页为选中状态时的tab文字颜色为红色
        View view = tabLayout.getTabAt(0).getCustomView();
        TextView textView = view.findViewById(R.id.tab_tv);
        textView.setTextColor(getResources().getColor(R.color.wallet_theme));
        LinearLayout mLinMain = view.findViewById(R.id.tab_lin_main);
        mLinMain.setBackground(getResources().getDrawable(R.drawable.shape_rec_white));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                // 选中了tab的逻辑
//                MyLog.i("tab", "======我选中了====");

                View view=tab.getCustomView();
                TextView textView = view.findViewById(R.id.tab_tv);
                textView.setTextColor(getResources().getColor(R.color.wallet_theme));
                LinearLayout mLinMain = view.findViewById(R.id.tab_lin_main);
                mLinMain.setBackground(getResources().getDrawable(R.drawable.shape_rec_white));
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                //未选中tab的逻辑
//                MyLog.i("tab", "======我未被选中====");

                View view=tab.getCustomView();
                TextView textView = view.findViewById(R.id.tab_tv);
                textView.setTextColor(getResources().getColor(R.color.grey333));
                LinearLayout mLinMain = view.findViewById(R.id.tab_lin_main);
                mLinMain.setBackground(getResources().getDrawable(R.drawable.stroke_shape_rec_grey333));
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                //再次选中tab的逻辑
//                MyLog.i("tab", "======我再次被选中====");
            }
        });





/*  todo      BaseTabLayoutAdapter<DataBannerBean> baseTabLayoutAdapter =
                new BaseTabLayoutAdapter<DataBannerBean>(this, titlesList, R.layout.layout_tab) {
                    @Override
                    public void updateStatus(TabLayoutViewHolder holder, DataBannerBean data, boolean isSelect) {
                        holder.<TextView>getView(R.id.tab_tv).setText(data.getFirstText());
                        holder.<TextView>getView(R.id.tab_tv).setTextColor(isSelect ? getResources().getColor(R.color.wallet_theme) : getResources().getColor(R.color.grey666));
                        holder.<LinearLayout>getView(R.id.tab_lin_main).setBackground(isSelect ? getResources().getDrawable(R.drawable.btn_shape_white) : getResources().getDrawable(R.drawable.btn_stroke_grey333));
                    }
                };
        baseTabLayoutAdapter.setOnTabSelectListener(new BaseTabLayoutAdapter.OnTabSelectListener<DataBannerBean>() {
            @Override
            public void onSelect(int pos, DataBannerBean data) {
                // 选中事件
            }
        });
        baseTabLayoutAdapter.attachTabLayout(tabLayout);*/
    }

    @Override
    protected void initData() {
//        initFragment();

    }

    private List<DataBannerBean> titlesList = new ArrayList<>();
    private List<Fragment> fragmentsList;
    private String[] titles;
/*    private void initFragment() {
        // 初始化fragment的题目
        titles = new String[]{"FirstFragment"
                , "SecondFragment"
        };

        // 根据题目的个数创建fragment
        fragmentsList = new ArrayList<>();
        fragmentsList.add(new FirstFragment());
        fragmentsList.add(new SecondFragment());

        // 初始化适配器和viewPager
        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(myPagerAdapter);
//        tabLayout.setupWithViewPager(viewPager);
//        tabLayout.getTabAt(0).select();  // 设置第一个为选中

        // 最多设置2个fragment界面
        viewPager.setOffscreenPageLimit(2);
        // 设置监听
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                // 根据所在位置进行请求相对应界面的数据
     *//*           if (position == 0) {  // 导入私钥界面，右上角可扫描
                    FirstFragment mFirstFragment = (FirstFragment) fragmentsList.get(position);
                } else if (position == 1)  {
                    SecondFragment mSecondFragment = (SecondFragment) fragmentsList.get(position);
                }*//*

            }

            @Override
            public void onPageScrollStateChanged(int state) {}
        });
    }*/

/*    private final class MyPagerAdapter extends FragmentPagerAdapter {
        private MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentsList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentsList.size();
        }

*//*        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }*//*
    }*/
}
