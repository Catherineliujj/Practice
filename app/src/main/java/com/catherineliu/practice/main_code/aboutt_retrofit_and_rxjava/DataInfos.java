package com.catherineliu.practice.main_code.aboutt_retrofit_and_rxjava;

import java.util.List;

/**
 * 项目：Practice
 * 文件描述：Retrofit 2.0 和 RxJava 使用model
 * 作者：ljj
 * 创建时间：2020/6/18
 */
public class DataInfos {

    /**
     * code : 200
     * record : {"info":{"pledgeStatus":1,"invitationStatus":2,"isRole":2,"totalAssets":"499998000000000","endTime":"2021-03-29 17:44:46","startTime":"2020-03-29 17:44:46","currencyName":"ONLY","userUuid":"78795119-49b8-3521-09f0-88f9e61526bd"},"list":[{"id":1,"currencyName":"ONLY","currencyLogo":"www.google.com","balanceNum":"499998000000000","currencyUnit":"0CNY","contractAddress":"0000000000000000000000000000000000000000","valueCNY":"","valueUSDT":""}]}
     */

    private int code;
    private RecordBean record;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public RecordBean getRecord() {
        return record;
    }

    public void setRecord(RecordBean record) {
        this.record = record;
    }

    public static class RecordBean {
        /**
         * info : {"pledgeStatus":1,"invitationStatus":2,"isRole":2,"totalAssets":"499998000000000","endTime":"2021-03-29 17:44:46","startTime":"2020-03-29 17:44:46","currencyName":"ONLY","userUuid":"78795119-49b8-3521-09f0-88f9e61526bd"}
         * list : [{"id":1,"currencyName":"ONLY","currencyLogo":"www.google.com","balanceNum":"499998000000000","currencyUnit":"0CNY","contractAddress":"0000000000000000000000000000000000000000","valueCNY":"","valueUSDT":""}]
         */

        private InfoBean info;
        private List<ListBean> list;

        public InfoBean getInfo() {
            return info;
        }

        public void setInfo(InfoBean info) {
            this.info = info;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class InfoBean {
            /**
             * pledgeStatus : 1
             * invitationStatus : 2
             * isRole : 2
             * totalAssets : 499998000000000
             * endTime : 2021-03-29 17:44:46
             * startTime : 2020-03-29 17:44:46
             * currencyName : ONLY
             * userUuid : 78795119-49b8-3521-09f0-88f9e61526bd
             */

            private int pledgeStatus;
            private int invitationStatus;
            private int isRole;
            private String totalAssets;
            private String endTime;
            private String startTime;
            private String currencyName;
            private String userUuid;

            public int getPledgeStatus() {
                return pledgeStatus;
            }

            public void setPledgeStatus(int pledgeStatus) {
                this.pledgeStatus = pledgeStatus;
            }

            public int getInvitationStatus() {
                return invitationStatus;
            }

            public void setInvitationStatus(int invitationStatus) {
                this.invitationStatus = invitationStatus;
            }

            public int getIsRole() {
                return isRole;
            }

            public void setIsRole(int isRole) {
                this.isRole = isRole;
            }

            public String getTotalAssets() {
                return totalAssets;
            }

            public void setTotalAssets(String totalAssets) {
                this.totalAssets = totalAssets;
            }

            public String getEndTime() {
                return endTime;
            }

            public void setEndTime(String endTime) {
                this.endTime = endTime;
            }

            public String getStartTime() {
                return startTime;
            }

            public void setStartTime(String startTime) {
                this.startTime = startTime;
            }

            public String getCurrencyName() {
                return currencyName;
            }

            public void setCurrencyName(String currencyName) {
                this.currencyName = currencyName;
            }

            public String getUserUuid() {
                return userUuid;
            }

            public void setUserUuid(String userUuid) {
                this.userUuid = userUuid;
            }
        }

        public static class ListBean {
            /**
             * id : 1
             * currencyName : ONLY
             * currencyLogo : www.google.com
             * balanceNum : 499998000000000
             * currencyUnit : 0CNY
             * contractAddress : 0000000000000000000000000000000000000000
             * valueCNY :
             * valueUSDT :
             */

            private int id;
            private String currencyName;
            private String currencyLogo;
            private String balanceNum;
            private String currencyUnit;
            private String contractAddress;
            private String valueCNY;
            private String valueUSDT;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
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

            public String getBalanceNum() {
                return balanceNum;
            }

            public void setBalanceNum(String balanceNum) {
                this.balanceNum = balanceNum;
            }

            public String getCurrencyUnit() {
                return currencyUnit;
            }

            public void setCurrencyUnit(String currencyUnit) {
                this.currencyUnit = currencyUnit;
            }

            public String getContractAddress() {
                return contractAddress;
            }

            public void setContractAddress(String contractAddress) {
                this.contractAddress = contractAddress;
            }

            public String getValueCNY() {
                return valueCNY;
            }

            public void setValueCNY(String valueCNY) {
                this.valueCNY = valueCNY;
            }

            public String getValueUSDT() {
                return valueUSDT;
            }

            public void setValueUSDT(String valueUSDT) {
                this.valueUSDT = valueUSDT;
            }
        }
    }
}
