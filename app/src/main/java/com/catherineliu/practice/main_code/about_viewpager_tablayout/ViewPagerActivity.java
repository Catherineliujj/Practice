package com.catherineliu.practice.main_code.about_viewpager_tablayout;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.catherineliu.practice.R;
import com.catherineliu.practice.about_base.BaseActivity;

/**
 * @author Catherine Liu
 * ViewPager + TabLayout + Fragment的主Activity  同个Activity切换不同的Fragment
 * 08/04/2019
 */
public class ViewPagerActivity extends BaseActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    @Override
    protected int getLayoutView() {
        return R.layout.activity_view_pager;
    }

    @Override
    protected void initViewUI() {
        super.initViewUI();
        tabLayout = getView(R.id.tabs2);
        viewPager = getView(R.id.viewpager);

    }

    @Override
    protected void initBaseView() {
        super.initBaseView();



        //设置界面文件和文字一一对应
        final Fragment[] fragments = {new FirstFragment(), new SecondFragment(), new ThirdFragment(), new ForthFragment()};
        final String[] titles = {"FirstFragment", "SecondFragment", "ThirdFragment", "ForthFragment"};

//        //添加tablayout中的竖线,每一项的中间分隔线
//        LinearLayout linearLayout = (LinearLayout) tabLayout.getChildAt(0);
//        linearLayout.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
//        linearLayout.setDividerDrawable(ContextCompat.getDrawable(this, R.mipmap.fg));

        //每项只进入一次
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments[position];
            }
            @Override
            public int getCount() {
                return fragments.length;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return titles[position];
            }
        });

        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).select();//设置第一个为选中
    }
}
