package com.catherineliu.practice.model;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * 项目：DC
 * 文件描述：DC_Assets
 * 作者：ljj
 * 创建时间：2020/9/16
 */
public class DC_Assets extends RealmObject {

    /** 唯一识别;钱包地址+币种名称 */
    @PrimaryKey
    private String totalKey;
    /** 钱包地址 */
    private String address;
    /** 币种合约地址 */
    private String contractAddress;
    /** 币种名称 */
    private String currencyName;
    /** 币种Logo */
    private String currencyLogo;
    /** 币种数量 */
    private Long balanceNum;
    /** 换算CNY价值 */
    private Double valueCNY;
    /** 换算USDT价值 */
    private Double valueUSDT;
    /** 最大手续费 */
    private Long maxFee;
    /** 最小手续费 */
    private Long minFee;
    /** 零钱基础表;Rm_BaseChanges类型 */
    private RealmList<DC_Changes> dcChangesRealmList;
    /** 订单记录基础表;Rm_BaseOrder类型 */
    private RealmList<DC_Orders> dcOrdersRealmList;
    /** 置顶状态;0未置顶  1置顶 */
    private int topStatus;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public Long getBalanceNum() {
        return balanceNum;
    }

    public void setBalanceNum(Long balanceNum) {
        this.balanceNum = balanceNum;
    }

    public Double getValueCNY() {
        return valueCNY;
    }

    public void setValueCNY(Double valueCNY) {
        this.valueCNY = valueCNY;
    }

    public Double getValueUSDT() {
        return valueUSDT;
    }

    public void setValueUSDT(Double valueUSDT) {
        this.valueUSDT = valueUSDT;
    }

    public Long getMaxFee() {
        return maxFee;
    }

    public void setMaxFee(Long maxFee) {
        this.maxFee = maxFee;
    }

    public Long getMinFee() {
        return minFee;
    }

    public void setMinFee(Long minFee) {
        this.minFee = minFee;
    }

    public RealmList<DC_Changes> getDcChangesRealmList() {
        return dcChangesRealmList;
    }

    public void setDcChangesRealmList(RealmList<DC_Changes> dcChangesRealmList) {
        this.dcChangesRealmList = dcChangesRealmList;
    }

    public RealmList<DC_Orders> getDcOrdersRealmList() {
        return dcOrdersRealmList;
    }

    public void setDcOrdersRealmList(RealmList<DC_Orders> dcOrdersRealmList) {
        this.dcOrdersRealmList = dcOrdersRealmList;
    }

    public int getTopStatus() {
        return topStatus;
    }

    public void setTopStatus(int topStatus) {
        this.topStatus = topStatus;
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
