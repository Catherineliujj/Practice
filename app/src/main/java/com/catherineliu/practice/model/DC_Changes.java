package com.catherineliu.practice.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * 项目：DC
 * 文件描述：零钱表
 * 作者：ljj
 * 创建时间：2020/9/16
 */
public class DC_Changes extends RealmObject {

    /** 唯一识别;txId+n */
    @PrimaryKey
    private String totalKey ;
    /** 钱包地址 */
    private String address ;
    /** 钱包所在utxh的txid */
    private String txId ;
    /** 所在交易输出次序 */
    private int n ;
    /** 金额，单位为汤圆 */
    private Long value ;
    /** 交易锁定脚本 */
    private String reqSigs ;
    /** 开始锁定的区块高度 */
    private Long createdBlock ;
    /** 解锁区块高度 */
    private Long lockTime ;
    /** 交易类型;1交易、质押、找零  4开通权益 */
    private String actionType ;
    /** 零钱使用状态;0待打包  1可以使用 */
    private int status ;
    /** 生成时间 */
    private Long created ;
    /** 修改时间 */
    private Long modified ;
    /** 预留字段 */
    private String others ;

    public String getTotalKey() {
        return totalKey;
    }

    public void setTotalKey(String totalKey) {
        this.totalKey = totalKey;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTxId() {
        return txId;
    }

    public void setTxId(String txId) {
        this.txId = txId;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public String getReqSigs() {
        return reqSigs;
    }

    public void setReqSigs(String reqSigs) {
        this.reqSigs = reqSigs;
    }

    public Long getCreatedBlock() {
        return createdBlock;
    }

    public void setCreatedBlock(Long createdBlock) {
        this.createdBlock = createdBlock;
    }

    public Long getLockTime() {
        return lockTime;
    }

    public void setLockTime(Long lockTime) {
        this.lockTime = lockTime;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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
