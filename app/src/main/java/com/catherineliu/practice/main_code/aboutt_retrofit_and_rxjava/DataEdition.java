package com.catherineliu.practice.main_code.aboutt_retrofit_and_rxjava;

/**
 * 项目：Practice
 * 文件描述：
 * 作者：ljj
 * 创建时间：2020/12/28
 */
public class DataEdition {

    /**
     * code : 200
     * msg : ok
     * record : {"edition":{"id":6,"name":"安卓","num":"10","type":"android","url":"https://xm6leefun.oss-cn-shanghai.aliyuncs.com/xm6leefun/file/zwdu20191120.apk","isForce":1,"remark":"版本已更新","appType":2,"createTime":"1574244376","createTimeStr":"2019-11-20 18:06:16","updateTime":"0","updateTimeStr":"1970-01-01 08:00:00","isDel":1}}
     */

    private int code;
    private String msg;
    private RecordBean record;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public RecordBean getRecord() {
        return record;
    }

    public void setRecord(RecordBean record) {
        this.record = record;
    }

    public static class RecordBean {
        /**
         * edition : {"id":6,"name":"安卓","num":"10","type":"android","url":"https://xm6leefun.oss-cn-shanghai.aliyuncs.com/xm6leefun/file/zwdu20191120.apk","isForce":1,"remark":"版本已更新","appType":2,"createTime":"1574244376","createTimeStr":"2019-11-20 18:06:16","updateTime":"0","updateTimeStr":"1970-01-01 08:00:00","isDel":1}
         */

        private EditionBean edition;

        public EditionBean getEdition() {
            return edition;
        }

        public void setEdition(EditionBean edition) {
            this.edition = edition;
        }

        public static class EditionBean {
            /**
             * id : 6
             * name : 安卓
             * num : 10
             * type : android
             * url : https://xm6leefun.oss-cn-shanghai.aliyuncs.com/xm6leefun/file/zwdu20191120.apk
             * isForce : 1
             * remark : 版本已更新
             * appType : 2
             * createTime : 1574244376
             * createTimeStr : 2019-11-20 18:06:16
             * updateTime : 0
             * updateTimeStr : 1970-01-01 08:00:00
             * isDel : 1
             */

            private int id;
            private String name;
            private String num;
            private String type;
            private String url;
            private int isForce;
            private String remark;
            private int appType;
            private String createTime;
            private String createTimeStr;
            private String updateTime;
            private String updateTimeStr;
            private int isDel;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getNum() {
                return num;
            }

            public void setNum(String num) {
                this.num = num;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public int getIsForce() {
                return isForce;
            }

            public void setIsForce(int isForce) {
                this.isForce = isForce;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public int getAppType() {
                return appType;
            }

            public void setAppType(int appType) {
                this.appType = appType;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getCreateTimeStr() {
                return createTimeStr;
            }

            public void setCreateTimeStr(String createTimeStr) {
                this.createTimeStr = createTimeStr;
            }

            public String getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(String updateTime) {
                this.updateTime = updateTime;
            }

            public String getUpdateTimeStr() {
                return updateTimeStr;
            }

            public void setUpdateTimeStr(String updateTimeStr) {
                this.updateTimeStr = updateTimeStr;
            }

            public int getIsDel() {
                return isDel;
            }

            public void setIsDel(int isDel) {
                this.isDel = isDel;
            }
        }
    }
}
