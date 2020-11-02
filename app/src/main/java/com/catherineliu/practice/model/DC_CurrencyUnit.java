package com.catherineliu.practice.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * 项目：DC
 * 文件描述：货币单位表
 * 作者：ljj
 * 创建时间：2020/9/16
 */
public class DC_CurrencyUnit extends RealmObject {

    /** 货币单位 */
    @PrimaryKey
    private String currencyName ;
    /** 选中状态 */
    private boolean isChecked ;
    /** 创建时间 */
    private Long created ;
    /** 修改时间 */
    private Long modified ;
    /** 预留字段 */
    private String others ;

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public Long getModified() {
        return modified;
    }

    public void setModified(Long modified) {
        this.modified = modified;
    }

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
    }
}
