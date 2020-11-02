package com.catherineliu.practice.model;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * 项目：DC
 * 文件描述：主钱包表
 * 作者：ljj
 * 创建时间：2020/9/16
 */
public class DC_Main extends RealmObject {

    /** 钱包地址 */
    @PrimaryKey
    private String address;
    /** 钱包地址 */
    private String walletName;
    /** keyStore */
    private String keyStore;
    /** 助记词列表Json */
    private String wordsJson;
    /** 明文密码 */
    private String plainPwd;
    /** 密码的备注信息 */
    private String promptInfo;
    /** 资产列表;OC_Assets类型 */
    private RealmList<DC_Assets> dcAssetsRealmList;
    /** 拥有的总资产 */
    private Long totalAssets;
    /** 拥有的总资产（CNY） */
    private Double totalAssetsCNY;
    /** 拥有的总资产（USDT） */
    private Double totalAssetsUSDT;
    /** 拥有的总资产单位（币种名称） */
    private String currencyName;
    /** 资产是否可见 */
    private String isShowAssets;
    /** 权益状态;0未开通  1已开通 */
    private String role;
    /** 是否被删除状态;0否  1是 */
    private int deletedStatus;
    /** 是否被选中 */
    private boolean isChecked;
    /** 所属主网 */
    private String mainNet;
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

    public String getWalletName() {
        return walletName;
    }

    public void setWalletName(String walletName) {
        this.walletName = walletName;
    }

    public String getKeyStore() {
        return keyStore;
    }

    public void setKeyStore(String keyStore) {
        this.keyStore = keyStore;
    }

    public String getWordsJson() {
        return wordsJson;
    }

    public void setWordsJson(String wordsJson) {
        this.wordsJson = wordsJson;
    }

    public String getPlainPwd() {
        return plainPwd;
    }

    public void setPlainPwd(String plainPwd) {
        this.plainPwd = plainPwd;
    }

    public String getPromptInfo() {
        return promptInfo;
    }

    public void setPromptInfo(String promptInfo) {
        this.promptInfo = promptInfo;
    }

    public RealmList<DC_Assets> getDcAssetsRealmList() {
        return dcAssetsRealmList;
    }

    public void setDcAssetsRealmList(RealmList<DC_Assets> dcAssetsRealmList) {
        this.dcAssetsRealmList = dcAssetsRealmList;
    }

    public Long getTotalAssets() {
        return totalAssets;
    }

    public void setTotalAssets(Long totalAssets) {
        this.totalAssets = totalAssets;
    }

    public Double getTotalAssetsCNY() {
        return totalAssetsCNY;
    }

    public void setTotalAssetsCNY(Double totalAssetsCNY) {
        this.totalAssetsCNY = totalAssetsCNY;
    }

    public Double getTotalAssetsUSDT() {
        return totalAssetsUSDT;
    }

    public void setTotalAssetsUSDT(Double totalAssetsUSDT) {
        this.totalAssetsUSDT = totalAssetsUSDT;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getIsShowAssets() {
        return isShowAssets;
    }

    public void setIsShowAssets(String isShowAssets) {
        this.isShowAssets = isShowAssets;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getDeletedStatus() {
        return deletedStatus;
    }

    public void setDeletedStatus(int deletedStatus) {
        this.deletedStatus = deletedStatus;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public String getMainNet() {
        return mainNet;
    }

    public void setMainNet(String mainNet) {
        this.mainNet = mainNet;
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
