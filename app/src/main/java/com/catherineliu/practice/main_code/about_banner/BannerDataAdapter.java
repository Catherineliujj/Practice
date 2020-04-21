package com.catherineliu.practice.main_code.about_banner;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.catherineliu.practice.R;
import com.youth.banner.adapter.BannerAdapter;
import com.youth.banner.util.BannerUtils;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * 项目：Practice
 * 文件描述：图片轮播器图片适配器
 * 作者：ljj
 * 创建时间：2020/4/21
 */
public class BannerDataAdapter extends BannerAdapter<DataBannerBean, BannerDataAdapter.BannerViewHolder> {
    public BannerDataAdapter(List<DataBannerBean> mDatas) {
        //设置数据，也可以调用banner提供的方法,或者自己在adapter中实现
        super(mDatas);
    }

    //创建ViewHolder，可以用viewType这个字段来区分不同的ViewHolder
    @Override
    public BannerViewHolder onCreateHolder(ViewGroup parent, int viewType) {
        ImageView imageView = new ImageView(parent.getContext());
        //注意，必须设置为match_parent，这个是viewpager2强制要求的
        imageView.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        TextView mFirstText = new TextView(parent.getContext());
        mFirstText.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        mFirstText.setTextColor(parent.getContext().getResources().getColor(R.color.app_theme));
        mFirstText.setTextSize(parent.getContext().getResources().getDimension(R.dimen.sp20));
        TextView mSecondText = new TextView(parent.getContext());
        mSecondText.setTextColor(parent.getContext().getResources().getColor(R.color.wallet_theme));
        mSecondText.setTextSize(parent.getContext().getResources().getDimension(R.dimen.sp16));
        return new BannerViewHolder(BannerUtils.getView(parent, R.layout.item_banner));
    }

    @Override
    public void onBindView(BannerViewHolder holder, DataBannerBean data, int position, int size) {
        holder.imageView.setImageResource(data.getDrawableId());
        holder.firstTextView.setText(data.getFirstText());
        holder.secondTextView.setText(data.getSecondText());
    }

    class BannerViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView firstTextView;
        TextView secondTextView;

        public BannerViewHolder(@NonNull View view) {
            super(view);
            this.imageView = view.findViewById(R.id.item_iv);
            this.firstTextView = view.findViewById(R.id.item_tv_first);
            this.secondTextView = view.findViewById(R.id.item_tv_second);
        }
    }

}
