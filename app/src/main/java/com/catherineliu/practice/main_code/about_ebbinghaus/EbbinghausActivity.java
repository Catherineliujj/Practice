package com.catherineliu.practice.main_code.about_ebbinghaus;

import android.app.Dialog;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.catherineliu.practice.R;
import com.catherineliu.practice.about_base.BaseActivity;
import com.catherineliu.practice.about_utils.NoDoubleClickUtils;
import com.catherineliu.practice.about_utils.StrUtils;
import com.catherineliu.practice.about_utils.TimeUtil;
import com.catherineliu.practice.about_utils.ToastUtil;
import com.catherineliu.practice.about_utils.about_picker_view.OnTimeSelectChangeListener;
import com.catherineliu.practice.about_utils.about_picker_view.OnTimeSelectListener;
import com.catherineliu.practice.about_utils.about_picker_view.TimePickerBuilder;
import com.catherineliu.practice.about_utils.about_picker_view.TimePickerView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EbbinghausActivity extends BaseActivity {


    @BindView(R.id.include_top_tv_title)
    TextView includeTopTvTitle;
    @BindView(R.id.ebhs_ed_plan_name)
    EditText ebhsEdPlanName;
    @BindView(R.id.ebhs_ed_table_name)
    EditText ebhsEdTableName;
    @BindView(R.id.ebhs_tv_time)
    TextView ebhsTvTime;
    @BindView(R.id.ebhs_ed_plan_day)
    EditText ebhsEdPlanDay;
    @BindView(R.id.ebhs_ed_plan_total)
    EditText ebhsEdPlanTotal;
    @BindView(R.id.ebhs_tv_plan_name)
    TextView ebhsTvPlanName;
    @BindView(R.id.ebhs_rv)
    RecyclerView mRecyclerView;
    @BindView(R.id.ebhs_tv_tip)
    TextView ebhsTvTip;
    @BindView(R.id.ebhs_tv_make_table)
    TextView ebhsTvMakeTable;
    @BindView(R.id.ebhs_tv_make_pdf)
    TextView ebhsTvMakePdf;

    private TimePickerView pvTime;

    @Override
    protected int getLayoutView() {
        return R.layout.activity_ebbinghaus;
    }

    @Override
    protected void initViewUI() {
        super.initViewUI();
        includeTopTvTitle.setText("艾宾浩斯遗忘曲线生成");

        // 初始化RecyclerView
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setNestedScrollingEnabled(false);
        mRecyclerView.setLayoutManager(new GridLayoutManager(EbbinghausActivity.this, 7));

        initTimePicker();
    }

    private EbbinghausTableAdapter ebbinghausTableAdapter;
    @Override
    protected void initData() {
        super.initData();
    }


    private List<DataEbbinghaus> dataEbbinghausList = new ArrayList<>();
    private void initAdapter() {
        if (ebbinghausTableAdapter == null){
            ebbinghausTableAdapter = new EbbinghausTableAdapter(EbbinghausActivity.this, dataEbbinghausList);
            ebbinghausTableAdapter.bindToRecyclerView(mRecyclerView);
        }
    }

    @OnClick({R.id.ebhs_tv_time, R.id.ebhs_tv_make_table, R.id.ebhs_tv_make_pdf})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ebhs_tv_time:  // 选择日期
                if (NoDoubleClickUtils.isDoubleClickNoToast()) {
                    pvTime.show(view);//弹出时间选择器，传递参数过去，回调的时候则可以绑定此view
                }
                break;
            case R.id.ebhs_tv_make_table:  // 生成表格
                if (NoDoubleClickUtils.isDoubleClickNoToast()) {
                    String planName = ebhsEdPlanName.getText().toString();
                    if (!StrUtils.isEmpty(planName)) {
                        ebhsTvPlanName.setText(planName);
                    }
                    initAdapter();
                }
                break;
            case R.id.ebhs_tv_make_pdf:  // 生成PDF文件
                if (NoDoubleClickUtils.isDoubleClickNoToast()) {
                    PdfDocument document = new PdfDocument();//1, 建立PdfDocument
                    PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(
                            mRecyclerView.getMeasuredWidth(), mRecyclerView.getMeasuredHeight(), 1).create();//2
                    PdfDocument.Page page = document.startPage(pageInfo);
                    mRecyclerView.draw(page.getCanvas());//3
                    document.finishPage(page);//4
                    document.close();//5
                }
                break;
        }
    }

    private void initTimePicker() {//Dialog 模式下，在底部弹出
        pvTime = new TimePickerBuilder(this, new OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {
                long currentTimeMillis = System.currentTimeMillis();
                long time = date.getTime();
                if (time > currentTimeMillis) {
                    ebhsTvTime.setText(TimeUtil.getDay(date));
                    ebhsTvTip.setVisibility(View.GONE);
                } else {
                    ebhsTvTip.setVisibility(View.VISIBLE);
                    ebhsTvTime.setText("请点击选择日期");
                    ebhsTvTip.setText("选择的日期早于当前日期，安排不了！");
                }

            }
        })
                .setTimeSelectChangeListener(new OnTimeSelectChangeListener() {
                    @Override
                    public void onTimeSelectChanged(Date date) {
                        Log.i("pvTime", "onTimeSelectChanged");
                    }
                })
                .setType(new boolean[]{true, true, true, false, false, false})
                .isDialog(true) //默认设置false ，内部实现将DecorView 作为它的父控件。
                .addOnCancelClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.i("pvTime", "onCancelClickListener");
                    }
                })
                .setItemVisibleCount(5) //若设置偶数，实际值会加1（比如设置6，则最大可见条目为7）
                .setLineSpacingMultiplier(2.0f)
                .isAlphaGradient(true)
                .build();

        Dialog mDialog = pvTime.getDialog();
        if (mDialog != null) {

            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    Gravity.BOTTOM);

            params.leftMargin = 0;
            params.rightMargin = 0;
            pvTime.getDialogContainerLayout().setLayoutParams(params);

            Window dialogWindow = mDialog.getWindow();
            if (dialogWindow != null) {
//                dialogWindow.setWindowAnimations(R.style.picker_view_slide_anim);//修改动画样式
                dialogWindow.setGravity(Gravity.BOTTOM);//改成Bottom,底部显示
                dialogWindow.setDimAmount(0.3f);
            }
        }
    }

}
