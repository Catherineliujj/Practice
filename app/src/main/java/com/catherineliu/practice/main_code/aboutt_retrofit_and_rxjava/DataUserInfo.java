package com.catherineliu.practice.main_code.aboutt_retrofit_and_rxjava;

/**
 * 项目：Practice
 * 文件描述：登录后用户信息
 * 作者：ljj
 * 创建时间：2020/7/2
 */
public class DataUserInfo {

    /**
     * code : 200
     * msg : 成功
     * ctn : Login
     * mtn : loginIn
     * record : {"nickName":"大美人","userId":"4dda-565b-f00","mobile":"15260602893","wxSno":"Catherine","userToken":"AFE1A52C-1D19-AC8D-0DA2-BC6928849B73","isFirstLogin":2,"headImg":"/userInfoFiles/57af46d28628e8c384f4886f39a8a801-pic2.jpg_/userInfoFiles/57af46d28628e8c384f4886f39a8a801-pic1.jpg","qrcode":"1_xm6leefun_4dda-565b-f00","personaSignature":"Think twice, code once.","modified":1578017812,"isUpdate":2,"upSnoNum":0}
     * push_type : 1
     * api_key : 20180903
     * timestamp : 1593711827
     * sign : 08638F75D78B65A53F695CE5BD8E2709
     */

    private int code;
    private String msg;
    private String ctn;
    private String mtn;
    private RecordBean record;
    private int push_type;
    private String api_key;
    private int timestamp;
    private String sign;

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

    public String getCtn() {
        return ctn;
    }

    public void setCtn(String ctn) {
        this.ctn = ctn;
    }

    public String getMtn() {
        return mtn;
    }

    public void setMtn(String mtn) {
        this.mtn = mtn;
    }

    public RecordBean getRecord() {
        return record;
    }

    public void setRecord(RecordBean record) {
        this.record = record;
    }

    public int getPush_type() {
        return push_type;
    }

    public void setPush_type(int push_type) {
        this.push_type = push_type;
    }

    public String getApi_key() {
        return api_key;
    }

    public void setApi_key(String api_key) {
        this.api_key = api_key;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public static class RecordBean {
        /**
         * nickName : 大美人
         * userId : 4dda-565b-f00
         * mobile : 15260602893
         * wxSno : Catherine
         * userToken : AFE1A52C-1D19-AC8D-0DA2-BC6928849B73
         * isFirstLogin : 2
         * headImg : /userInfoFiles/57af46d28628e8c384f4886f39a8a801-pic2.jpg_/userInfoFiles/57af46d28628e8c384f4886f39a8a801-pic1.jpg
         * qrcode : 1_xm6leefun_4dda-565b-f00
         * personaSignature : Think twice, code once.
         * modified : 1578017812
         * isUpdate : 2
         * upSnoNum : 0
         */

        private String nickName;
        private String userId;
        private String mobile;
        private String wxSno;
        private String userToken;
        private int isFirstLogin;
        private String headImg;
        private String qrcode;
        private String personaSignature;
        private int modified;
        private int isUpdate;
        private int upSnoNum;

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getWxSno() {
            return wxSno;
        }

        public void setWxSno(String wxSno) {
            this.wxSno = wxSno;
        }

        public String getUserToken() {
            return userToken;
        }

        public void setUserToken(String userToken) {
            this.userToken = userToken;
        }

        public int getIsFirstLogin() {
            return isFirstLogin;
        }

        public void setIsFirstLogin(int isFirstLogin) {
            this.isFirstLogin = isFirstLogin;
        }

        public String getHeadImg() {
            return headImg;
        }

        public void setHeadImg(String headImg) {
            this.headImg = headImg;
        }

        public String getQrcode() {
            return qrcode;
        }

        public void setQrcode(String qrcode) {
            this.qrcode = qrcode;
        }

        public String getPersonaSignature() {
            return personaSignature;
        }

        public void setPersonaSignature(String personaSignature) {
            this.personaSignature = personaSignature;
        }

        public int getModified() {
            return modified;
        }

        public void setModified(int modified) {
            this.modified = modified;
        }

        public int getIsUpdate() {
            return isUpdate;
        }

        public void setIsUpdate(int isUpdate) {
            this.isUpdate = isUpdate;
        }

        public int getUpSnoNum() {
            return upSnoNum;
        }

        public void setUpSnoNum(int upSnoNum) {
            this.upSnoNum = upSnoNum;
        }
    }
}
