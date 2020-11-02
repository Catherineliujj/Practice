package com.catherineliu.practice.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * 项目：DC
 * 文件描述：订单记录表
 * 作者：ljj
 * 创建时间：2020/9/16
 */
public class DC_Orders extends RealmObject {

    /** 总id;txId + 对方地址 */
    @PrimaryKey
    private String totalKey;
    /** 交易id */
    private String id;
    /** 交易单号 */
    private String txId;
    /** 钱包地址 */
    private String address;
    /** 付款方地址 */
    private String payAddress;
    /** 收款方地址 */
    private String receiptAddress;
    /** 合约地址 */
    private String contractAddress;
    /** 币种名称 */
    private String currencyName;
    /** 币种Logo */
    private String currencyLogo;
    /** 转账状态;1打包中  2转账失败  3合约失败  4转账成功 */
    private int orderStatus;
    /** 转账类型;1转出 2转入 */
    private int orderType;
    /** 转账时间 */
    private Long transferCreated;
    /** 转账数目 */
    private Long orderValue;
    /** 区块 */
    private String block;
    /** 备注 */
    private String remarkInfo;
    /** 创建时间 */
    private Long created;
    /** 修改时间 */
    private Long modified;
    /** 预留字段 */
    private String others;

    public String getTotalKey() {
        return totalKey;
    }

    public void setTotalKey(String totalKey) {
        this.totalKey = totalKey;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTxId() {
        return txId;
    }

    public void setTxId(String txId) {
        this.txId = txId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPayAddress() {
        return payAddress;
    }

    public void setPayAddress(String payAddress) {
        this.payAddress = payAddress;
    }

    public String getReceiptAddress() {
        return receiptAddress;
    }

    public void setReceiptAddress(String receiptAddress) {
        this.receiptAddress = receiptAddress;
    }

    public String getContractAddress() {
        return contractAddress;
    }

    public void setContractAddress(String contractAddress) {
        this.contractAddress = contractAddress;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getCurrencyLogo() {
        return currencyLogo;
    }

    public void setCurrencyLogo(String currencyLogo) {
        this.currencyLogo = currencyLogo;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getOrderType() {
        return orderType;
    }

    public void setOrderType(int orderType) {
        this.orderType = orderType;
    }

    public Long getTransferCreated() {
        return transferCreated;
    }

    public void setTransferCreated(Long transferCreated) {
        this.transferCreated = transferCreated;
    }

    public Long getOrderValue() {
        return orderValue;
    }

    public void setOrderValue(Long orderValue) {
        this.orderValue = orderValue;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getRemarkInfo() {
        return remarkInfo;
    }

    public void setRemarkInfo(String remarkInfo) {
        this.remarkInfo = remarkInfo;
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
