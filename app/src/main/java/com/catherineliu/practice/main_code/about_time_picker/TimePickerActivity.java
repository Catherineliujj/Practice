package com.catherineliu.practice.main_code.about_time_picker;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.catherineliu.practice.R;
import com.catherineliu.practice.about_base.BaseActivity;
import com.catherineliu.practice.about_utils.NoDoubleClickUtils;
import com.catherineliu.practice.about_utils.TimeUtil;
import com.catherineliu.practice.main_code.about_time_picker.about_picker_view.OnTimeSelectChangeListener;
import com.catherineliu.practice.main_code.about_time_picker.about_picker_view.OnTimeSelectListener;
import com.catherineliu.practice.main_code.about_time_picker.about_picker_view.TimePickerBuilder;
import com.catherineliu.practice.main_code.about_time_picker.about_picker_view.TimePickerView;

import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TimePickerActivity extends BaseActivity {

    @BindView(R.id.include_top_tv_title)
    TextView includeTopTvTitle;
    @BindView(R.id.time_picker_tv_content)
    TextView timePickerTvContent;
    @BindView(R.id.time_picker_tv_show)
    TextView timePickerTvShow;

    private TimePickerView pvTime;

    @Override
    protected int getLayoutView() {
        return R.layout.activity_time_picker;
    }

    @Override
    protected void initViewUI() {
        super.initViewUI();
        includeTopTvTitle.setText(getResources().getString(R.string.main_btn_jump_2_time_picker_view));

        // 时间选择器
        initTimePicker();
    }

    /**
     * 时间选择器
     */
    private void initTimePicker() { // Dialog 模式下，在底部弹出
        Date startDate = new Date();
        startDate.setTime(TimeUtil.dateToStamp("2010-01-01", "yyyy-MM-dd"));
        Date endDate = new Date();
        endDate.setTime(TimeUtil.dateToStamp("2030-12-31", "yyyy-MM-dd"));

        Calendar startTime = Calendar.getInstance();
        startTime.setTime(startDate);
        Calendar endTime = Calendar.getInstance();
        endTime.setTime(endDate);
        Calendar time = Calendar.getInstance();
        time.setTime(TimeUtil.getCurrentTime());

        pvTime = new TimePickerBuilder(this, new OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {
                String currentDateStr = TimeUtil.getCurrentDateYMDStr();  // 当前的日期
                String dateFormat = TimeUtil.sfSlashYMD.format(date);  // 选择的日期
                int dayofWeek = TimeUtil.getDayofWeek(dateFormat);
                String dayofWeekStr = TimeUtil.getWeekDayStr(dayofWeek);  // 星期
                timePickerTvContent.setText("选择的时间是：" + dateFormat + "  " + dayofWeekStr);

            }
        })
                .setTimeSelectChangeListener(new OnTimeSelectChangeListener() {
                    @Override
                    public void onTimeSelectChanged(Date date) {
                        Log.i("pvTime", "onTimeSelectChanged");
                    }
                })
                .setType(new boolean[]{true, true, true, false, false, false})  // 年月日时分秒
                .isDialog(true) //默认设置false ，内部实现将DecorView 作为它的父控件。
                .addOnCancelClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        timePickerTvContent.setText("未选择任何时间");
                        Log.i("pvTime", "onCancelClickListener");
                    }
                })
                .setItemVisibleCount(5) //若设置偶数，实际值会加1（比如设置6，则最大可见条目为7）
                .setLineSpacingMultiplier(2.0f)
                .isAlphaGradient(true)
                .setTitleBgColor(0xff44b7f9)  // 设置标题背景颜色，采用0x+2位透明度+6位rgb色值
                .setTitleColor(0xffffffff)
                .setTitleText("Time Picker")
                .setSubmitColor(0xffffffff)
                .setSubmitText("Sure")
                .setCancelColor(0xffffffff)
                .setCancelText("Cancel")
                .setRangDate(startTime, endTime)  // 设置开始和结束时间
                .setDate(time)  // 设置默认选中时间
//                .isCyclic(true)  // 是否进行滚轮循环
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

    @OnClick({R.id.time_picker_tv_content, R.id.time_picker_tv_show})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.time_picker_tv_content:
                if (NoDoubleClickUtils.isDoubleClickNoToast()){

                }
                break;
            case R.id.time_picker_tv_show:
                if (NoDoubleClickUtils.isDoubleClickNoToast()){
                    pvTime.show(timePickerTvShow);//弹出时间选择器，传递参数过去，回调的时候则可以绑定此view
                }
                break;
        }
    }
}
