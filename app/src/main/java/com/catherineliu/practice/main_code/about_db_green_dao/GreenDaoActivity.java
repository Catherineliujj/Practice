package com.catherineliu.practice.main_code.about_db_green_dao;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.catherineliu.practice.R;
import com.catherineliu.practice.about_base.BaseActivity;
import com.catherineliu.practice.about_utils.NoDoubleClickUtils;
import com.catherineliu.practice.about_utils.StrUtils;
import com.catherineliu.practice.main_code.about_db_green_dao.model.PersonInfoDao;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import pl.com.salsoft.sqlitestudioremote.internal.SQLiteStudioDbService;

/**
 * 项目：Practice
 * 文件描述：GreenDao数据库
 * 作者：ljj
 * 创建时间：2020/11/2
 */
public class GreenDaoActivity extends BaseActivity {

    @BindView(R.id.include_top_tv_title)
    TextView includeTopTvTitle;
    @BindView(R.id.green_dao_ed_input)
    EditText greenDaoEdInput;
    @BindView(R.id.green_dao_tv_content)
    TextView greenDaoTvContent;
    @BindView(R.id.green_dao_ed_type)
    EditText greenDaoEdType;

    private DbController mDbController;
    private PersonInfoDao personInfoDao, personInfoDao2, personInfoDao3, personInfoDao4, personInfoDao5, personInfoDao6;

    @Override
    protected int getLayoutView() {
        return R.layout.activity_green_dao;
    }

    @Override
    protected void initViewUI() {
        includeTopTvTitle.setText(getString(R.string.main_btn_jump_2_green_dao));
        mDbController = DbController.getInstance(this);
//        new SQLiteStudioDbService(this);
    }

    @Override
    protected void initData() {
        personInfoDao = new PersonInfoDao(null, "001", "张叁", "男", 20);
        personInfoDao2 = new PersonInfoDao(null, "002", "李斯", "女", 22);
        personInfoDao3 = new PersonInfoDao(null, "003", "王武", "男", 24);
        personInfoDao4 = new PersonInfoDao(null, "004", "叶柳", "女", 26);
        personInfoDao5 = new PersonInfoDao(null, "005", "邓柒", "男", 26);
        personInfoDao6 = new PersonInfoDao(null, "006", "庞巴", "男", 23);
    }

    @OnClick({R.id.green_dao_tv_add, R.id.green_dao_tv_update, R.id.green_dao_tv_search, R.id.green_dao_tv_search_all
            , R.id.green_dao_tv_delete, R.id.green_dao_tv_delete_all
    })
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.green_dao_tv_add:  // 添加六条数据
                if (NoDoubleClickUtils.isDoubleClick()) {
                    String perNo = greenDaoEdType.getText().toString().trim();
                    String input = greenDaoEdInput.getText().toString().trim();
                    if (StrUtils.isEmpty(perNo) || StrUtils.isEmpty(input)) {
                        greenDaoTvContent.setText("输入为空，无法查询\n");
//                        showDataList("输入为空，无法查询\n", new ArrayList<>());
                        return;
                    }
                    String[] split = input.split("\\s+");
                    if (split.length != 3) {
                        greenDaoTvContent.setText("输入有误，无法添加\n");
//                        showDataList("输入有误，无法查询\n", new ArrayList<>());
                        return;
                    }
                    int age = 0;
                    try {
                        age = Integer.parseInt(split[2]);
                    } catch (NumberFormatException e) {
                        greenDaoTvContent.setText("输入有误，无法添加\n");
                        e.printStackTrace();
                        return;
                    }

                    PersonInfoDao personInfoDao = new PersonInfoDao(null, perNo, split[0], split[1], age);
                    mDbController.insertOrReplace(personInfoDao);
                    showDataList("", mDbController.searchAll());
                }
                break;
            case R.id.green_dao_tv_update:  // 更新符合条件的数据
                if (NoDoubleClickUtils.isDoubleClick()) {
                    String perNo = greenDaoEdType.getText().toString().trim();
                    String input = greenDaoEdInput.getText().toString().trim();
                    if (StrUtils.isEmpty(perNo) || StrUtils.isEmpty(input)) {
                        greenDaoTvContent.setText("输入为空，无法查询\n");
//                        showDataList("输入为空，无法查询\n", new ArrayList<>());
                        return;
                    }
                    String[] split = input.split("\\s+");
                    if (split.length != 3) {
                        greenDaoTvContent.setText("输入有误，无法查询\n");
//                        showDataList("输入有误，无法查询\n", new ArrayList<>());
                        return;
                    }
                    int age = 0;
                    try {
                        age = Integer.parseInt(split[2]);
                    } catch (NumberFormatException e) {
                        greenDaoTvContent.setText("输入有误，无法查询\n");
                        e.printStackTrace();
                        return;
                    }

                    PersonInfoDao personInfoDao = new PersonInfoDao(null, perNo, split[0], split[1], age);
                    mDbController.update(personInfoDao);
                    showDataList("", mDbController.searchAll());
                }
                break;
            case R.id.green_dao_tv_search:  // 搜索符合条件的数据
                if (NoDoubleClickUtils.isDoubleClick()) {
                    String type = greenDaoEdType.getText().toString().trim();
                    String input = greenDaoEdInput.getText().toString().trim();
                    if (StrUtils.isEmpty(input) || StrUtils.isEmpty(input)) {
                        greenDaoTvContent.setText("输入为空，无法查询\n");
//                        showDataList("", null);
                        return;
                    }
                    List<PersonInfoDao> personInfoDaos = mDbController.searchByWhere(Integer.parseInt(type), input);
                    showDataList("", personInfoDaos);
                }
                break;
            case R.id.green_dao_tv_search_all:  // 搜索全部
                if (NoDoubleClickUtils.isDoubleClick()) {
                    showDataList("", mDbController.searchAll());
                }
                break;
            case R.id.green_dao_tv_delete:  // 删除符合条件的数据
                if (NoDoubleClickUtils.isDoubleClick()) {
                    String type = greenDaoEdType.getText().toString().trim();
                    String input = greenDaoEdInput.getText().toString().trim();
                    if (StrUtils.isEmpty(input)) {
                        greenDaoTvContent.setText("输入为空，无法查询\n");
//                        showDataList("输入为空，无法查询\n", new ArrayList<>());
                        return;
                    }
                    mDbController.deleteByWhere(Integer.parseInt(type), input);
                    showDataList("", mDbController.searchAll());
                }
                break;
            case R.id.green_dao_tv_delete_all:  // 删除全部
                if (NoDoubleClickUtils.isDoubleClick()) {
                    mDbController.deleteAll();
                    showDataList("", mDbController.searchAll());
                }
                break;
        }
    }

    private void showDataList(String s, List<PersonInfoDao> personInfoDaos) {
        StringBuilder stringBuilder = new StringBuilder();
        if (personInfoDaos != null && personInfoDaos.size() > 0) {
            for (PersonInfoDao personInfoDao : personInfoDaos) {
                stringBuilder.append("Id: ").append(personInfoDao.getId()).append("\n")
                        .append("PerNo: ").append(personInfoDao.getPerNo()).append("\n")
                        .append("Name: ").append(personInfoDao.getName()).append("\n")
                        .append("Sex: ").append(personInfoDao.getSex()).append("\n")
                        .append("Age: ").append(personInfoDao.getAge()).append("\n").append("\n");
            }
            greenDaoTvContent.setText(s + stringBuilder.toString().trim());
        } else {
            greenDaoTvContent.setText("暂无数据");
        }
    }

}
