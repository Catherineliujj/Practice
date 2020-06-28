package com.catherineliu.practice.main_code.about_ebbinghaus;

import android.app.Dialog;
import android.content.pm.PackageManager;
import android.graphics.pdf.PdfDocument;
import android.os.Environment;
import android.os.Looper;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.catherineliu.practice.R;
import com.catherineliu.practice.about_base.BaseActivity;
import com.catherineliu.practice.about_utils.MyLog;
import com.catherineliu.practice.about_utils.NoDoubleClickUtils;
import com.catherineliu.practice.about_utils.StrUtils;
import com.catherineliu.practice.about_utils.TimeUtil;
import com.catherineliu.practice.about_utils.ToastUtil;
import com.catherineliu.practice.about_utils.about_picker_view.OnTimeSelectChangeListener;
import com.catherineliu.practice.about_utils.about_picker_view.OnTimeSelectListener;
import com.catherineliu.practice.about_utils.about_picker_view.TimePickerBuilder;
import com.catherineliu.practice.about_utils.about_picker_view.TimePickerView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.logging.Handler;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;

public class EbbinghausActivity extends BaseActivity {


    @BindView(R.id.include_top_lin_background)
    LinearLayout includeTopLinBackground;
    @BindView(R.id.include_top_tv_title)
    TextView includeTopTvTitle;
    @BindView(R.id.ebhs_ed_plan_name)
    EditText ebhsEdPlanName;
    @BindView(R.id.ebhs_ed_list_name)
    EditText ebhsEdListName;
    @BindView(R.id.ebhs_ed_list_total_days)
    EditText ebhsEdListTotalDays;
    @BindView(R.id.ebhs_ed_list_order)
    EditText ebhsEdListOrder;
    @BindView(R.id.ebhs_tv_time)
    TextView ebhsTvTime;
    @BindView(R.id.ebhs_tv_time_week)
    TextView ebhsTvTimeWeek;
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
    @BindView(R.id.ebhs_lin_table_pdf)
    LinearLayout ebhsLinMakePdf;

    private TimePickerView pvTime;
    @Override
    protected int getLayoutView() {
        return R.layout.activity_ebbinghaus;
    }

    @Override
    protected void initViewUI() {
        super.initViewUI();
        includeTopLinBackground.setBackgroundColor(getResources().getColor(R.color.white));
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
        MyLog.i("adapter", "==========================开始");
        if (ebbinghausTableAdapter == null){
            ebbinghausTableAdapter = new EbbinghausTableAdapter(EbbinghausActivity.this, dataEbbinghausList);
            ebbinghausTableAdapter.bindToRecyclerView(mRecyclerView);
        }
        MyLog.i("adapter", "==========================结束");
    }
    public static boolean isBelong2 (List<String> list, int order){
//        List<Integer> list = Arrays.asList(2, 3, 7, 14, 21, 30, 45, 60, 80);
        for (String i : list){
            try {
                if (order == Integer.valueOf(i)){
                    return true;
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
                ToastUtil.show("请输入正确的列表序号");
                return false;
            }
        }
        return false;
    }

    private void initListData() {
        dataEbbinghausList.clear();
        ebbinghausTableAdapter = null;
        DateFormat format = new SimpleDateFormat("yyyy/MM/dd");//日期格式
        selectedDate = null;
        String planDay = ebhsEdPlanDay.getText().toString();
        String planTotal = ebhsEdPlanTotal.getText().toString();
        String listName = ebhsEdListName.getText().toString();  // list名
        String listStrs = ebhsEdListOrder.getText().toString();  // 需要从头复习的天数
        String totalDays = ebhsEdListTotalDays.getText().toString();  // 计划总天数
        String startTime = ebhsTvTime.getText().toString();

        if (StrUtils.isEmpty(planDay) || StrUtils.isEmpty(planTotal) || StrUtils.isEmpty(listName)){
            ToastUtil.show("请将信息填写完整");
            return;
        }
        if ("请点击选择日期".equals(startTime)){
            ToastUtil.show("请选择开始时间");
            return;
        }

        try {
            selectedDate = format.parse(startTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Integer planDayInt = Integer.valueOf(planDay);  // 每天的计划数
        Integer planTotalInt = Integer.valueOf(planTotal) + 1;  // 总的计划数
        Integer totalDaysInt = Integer.valueOf(totalDays);  // 计划总天数

        if ((float)totalDaysInt < ((float)planTotalInt / planDayInt)){
            ToastUtil.show("请输入正确的【计划总天数】");
            return;
        }
        String[] listsStr = listStrs.split("\\s+");
        Arrays.sort(listsStr);
        // 冒泡排序法
        for(int i = 0; i < listsStr.length-1; i++) {
            for (int j = i+1; j < listsStr.length; j++) {
//                if(listsStr[i].compareTo(listsStr[j]) > 0) {
                try {
                    if(Integer.valueOf(listsStr[i]) > Integer.valueOf(listsStr[j])) {
                        String temp = listsStr[i];
                        listsStr[i] = listsStr[j];
                        listsStr[j] = temp;
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    ToastUtil.show("请输入正确的【计划总天数】");
                    return;
                }
            }
        }

        String s = listsStr[listsStr.length - 1];
        if (Integer.valueOf(s) > totalDaysInt){
            ToastUtil.show("请输入正确的【计划总天数】");
            return;
        }

        // List<Integer> integersList = Arrays.asList(2, 3, 7, 14, 21, 30, 45, 60, 80);
        List<String> stringList = Arrays.asList(listsStr);

        int temp = 0;
        double listNum = (float)planTotalInt / planDayInt;
        for (int i = 1; i < totalDaysInt + listNum; i++){
            StringBuilder listStr = new StringBuilder();
            String selectedFormat = TimeUtil.sfSlashMD.format(selectedDate);
            DataEbbinghaus dataEbbinghaus = new DataEbbinghaus();
            dataEbbinghaus.setDay(selectedFormat);

            int dayofWeek = TimeUtil.getDayofWeek(TimeUtil.sfSlashYMD.format(selectedDate));
            dataEbbinghaus.setWeek(dayofWeek);  // 原始的一周从周日开始，+1代表一周从周一开始
            if (((planDayInt * dataEbbinghausList.size()) + 1) < planTotalInt) {  // 前一部分列表数小于总计划数
                if (planDayInt > 1) {
                    if (planDayInt * (dataEbbinghausList.size() + 1) < planTotalInt) {  // 后一部分列表数小于总计划数，否则后部分世界拼接总计划数
                        listStr/*.append("  ")*/.append(listName).append((planDayInt * dataEbbinghausList.size()) + 1).append(" ~ ").append(listName).append(planDayInt * (dataEbbinghausList.size() + 1)).append("\n");
                    } else {
                        listStr/*.append("  ")*/.append(listName).append((planDayInt * dataEbbinghausList.size()) + 1).append(" ~ ").append(listName).append(planTotalInt).append("\n");
                    }
                } else {
                    listStr/*.append("  ")*/.append(listName).append((planDayInt * dataEbbinghausList.size()) + 1).append("\n");
                }
            }

//            if (i != 1) {
                if (isBelong2(stringList, i)){  // 如果当前天数属于计划中的那几天（从List1开始复习）
                    if (planDayInt > 1) {
                        listStr.append("*").append(listName).append(1).append(" ~ ").append(listName).append(planDayInt).append("\n");
                    } else {
                        listStr.append("*").append(listName).append(1).append("\n");
                    }
                }
//                else {
                try {
                    for (String jStr : stringList){
                        int j = Integer.valueOf(jStr);
                        if (((planDayInt * (i - j)) + 1) < planTotalInt) {
                            if (i > j){
                                if (planDayInt > 1) {
                                    if (planDayInt * (i - j + 1) < planTotalInt) {
                                        listStr.append("*").append(listName).append((planDayInt * (i - j)) + 1).append(" ~ ").append(listName).append(planDayInt * (i - j + 1)).append("\n");
                                    } else {
                                        listStr.append("*").append(listName).append((planDayInt * (i - j)) + 1).append(" ~ ").append(listName).append(planTotalInt).append("\n");
                                    }
                                } else {
                                    listStr.append("*").append(listName).append((planDayInt * (i - j)) + 1).append("\n");
                                }
                            } else {
                                break;
                            }
                        }
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    ToastUtil.show("请输入正确的列表序号");
                }
//            }


            dataEbbinghaus.setListStr(listStr.toString());
            dataEbbinghausList.add(dataEbbinghaus);

            Calendar c = Calendar.getInstance();
            c.setTime(selectedDate);
            c.add(Calendar.DAY_OF_MONTH, 1);  // 今天+1天
            selectedDate = c.getTime();
        }
    }

    @OnClick({R.id.ebhs_lin_time, R.id.ebhs_tv_make_table, R.id.ebhs_tv_make_pdf})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ebhs_lin_time:  // 选择日期
                if (NoDoubleClickUtils.isDoubleClickNoToast()) {
                    pvTime.show(view);//弹出时间选择器，传递参数过去，回调的时候则可以绑定此view
                }
                break;
            case R.id.ebhs_tv_make_table:  // 生成表格
                if (NoDoubleClickUtils.isDoubleClickNoToast()) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            Looper.prepare();
                            // 处理数据
                            initListData();
                            EbbinghausActivity.this.runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
//                                    ToastUtil.show("请稍等，正在生成数据");
                                    // 此处更新UI
                                    initAdapter();
                                    String planName = ebhsEdPlanName.getText().toString();
                                    if (!StrUtils.isEmpty(planName)) {
                                        ebhsTvPlanName.setText(planName);
                                    }
                                    if (dataEbbinghausList.size() > 0){
                                        ebhsTvMakePdf.setVisibility(View.VISIBLE);
                                    } else {
                                        ebhsTvMakePdf.setVisibility(View.GONE);
                                    }
                                }
                            });
                            Looper.loop();
                        }
                    }).start();
                }
                break;
            case R.id.ebhs_tv_make_pdf:  // 生成PDF文件
                if (NoDoubleClickUtils.isDoubleClickNoToast()) {
                    String[] PERMISSIONS = {
                            "android.permission.READ_EXTERNAL_STORAGE",
                            "android.permission.WRITE_EXTERNAL_STORAGE"};
                    //检测是否有写的权限
                    int permission = ContextCompat.checkSelfPermission(EbbinghausActivity.this,
                            "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (permission != PackageManager.PERMISSION_GRANTED) {
                        // 没有写的权限，去申请写的权限，会弹出对话框
                        ActivityCompat.requestPermissions(EbbinghausActivity.this, PERMISSIONS, 1);
                    } else {
                        MyLog.i("pdf", "=============开始执行");
                        PdfDocument document = new PdfDocument();//1, 建立PdfDocument
                        PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(
                                ebhsLinMakePdf.getMeasuredWidth(), ebhsLinMakePdf.getMeasuredHeight(), 1).create();//2
                        PdfDocument.Page page = document.startPage(pageInfo);
                        ebhsLinMakePdf.draw(page.getCanvas());//3
                        document.finishPage(page);//4
                        MyLog.i("pdf", "=============判断文件是否存在");

                        try {
                            String path = Environment.getExternalStorageDirectory() + File.separator + ebhsEdPlanName.getText().toString() + ".pdf";
                            File e = new File(path);
                            if (e.exists()) {
                                e.delete();
                            }
                            MyLog.i("pdf", "=============写入: " + path);
                            document.writeTo(new FileOutputStream(e));
                        } catch (IOException e) {
                            e.printStackTrace();
                            ToastUtil.show("error: " + e.toString());
                        }
                        document.close();//5

                        ToastUtil.show("Successful!");
                    }
                }
                break;
        }
    }

    private Date selectedDate;
    private void initTimePicker() {//Dialog 模式下，在底部弹出
        pvTime = new TimePickerBuilder(this, new OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {
                selectedDate = date;
                String currentDateStr = TimeUtil.getCurrentDateStr();  // 当前的日期
                String dateFormat = TimeUtil.sfSlashYMD.format(date);  // 选择的日期
                if (currentDateStr.compareTo(dateFormat) <= 0) {  // 大于等于当前日期
                    int dayofWeek = TimeUtil.getDayofWeek(dateFormat);
                    String dayofWeekStr = TimeUtil.getDayofWeekStr(dayofWeek);
                    ebhsTvTime.setText(dateFormat + "");
                    ebhsTvTimeWeek.setText("      " + dayofWeekStr);
                    ebhsTvTip.setVisibility(View.GONE);
                } else {
                    ebhsTvTip.setVisibility(View.VISIBLE);
                    ebhsTvTime.setText("请点击选择日期");
                    ebhsTvTip.setText("选择的日期早于当前日期，安排不了哦！");
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
