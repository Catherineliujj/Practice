package com.catherineliu.practice.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * 项目：DC
 * 文件描述：联系人地址本表
 * 作者：ljj
 * 创建时间：2020/9/16
 */
public class DC_AddressBook extends RealmObject {
    
    /** 联系人钱包地址 */
    @PrimaryKey
    private String address;
    /** 备注信息 */
    private String remark;
    /** 创建时间 */
    private Long created;
    /** 修改时间 */
    private Long modified;
    /** 预留字段 */
    private String others;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
