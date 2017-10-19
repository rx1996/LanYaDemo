package com.kjplusapp.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/10/13.
 */

public class InformationBean {

    /**
     * message : 成功获取签约记录数据
     * status : 1
     * data : [{"id":3,"personId":3,"personName":"牛志伟","personMobile":"13611263262","stafId":1,"stafCode":"69822936","stafName":"张三","stafType":"医院院长","orgId":1,"orgName":"康佳社卫平台","deptId":3,"deptType":"R","deptName":"内科","srvId":1,"srvCode":"17223274","srvName":"康佳社卫服务","srvPrice":0,"reqTime":1507882934,"status":"S","operTime":0,"beginDay":1507824000000,"endDay":1539360000000}]
     * code : 200
     */

    private String message;
    private int status;
    private int code;
    private List<DataBean> data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 3
         * personId : 3
         * personName : 牛志伟
         * personMobile : 13611263262
         * stafId : 1
         * stafCode : 69822936
         * stafName : 张三
         * stafType : 医院院长
         * orgId : 1
         * orgName : 康佳社卫平台
         * deptId : 3
         * deptType : R
         * deptName : 内科
         * srvId : 1
         * srvCode : 17223274
         * srvName : 康佳社卫服务
         * srvPrice : 0.0
         * reqTime : 1507882934
         * status : S
         * operTime : 0
         * beginDay : 1507824000000
         * endDay : 1539360000000
         */

        private int id;
        private int personId;
        private String personName;
        private String personMobile;
        private int stafId;
        private String stafCode;
        private String stafName;
        private String stafType;
        private int orgId;
        private String orgName;
        private int deptId;
        private String deptType;
        private String deptName;
        private int srvId;
        private String srvCode;
        private String srvName;
        private double srvPrice;
        private int reqTime;
        private String status;
        private int operTime;
        private long beginDay;
        private long endDay;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getPersonId() {
            return personId;
        }

        public void setPersonId(int personId) {
            this.personId = personId;
        }

        public String getPersonName() {
            return personName;
        }

        public void setPersonName(String personName) {
            this.personName = personName;
        }

        public String getPersonMobile() {
            return personMobile;
        }

        public void setPersonMobile(String personMobile) {
            this.personMobile = personMobile;
        }

        public int getStafId() {
            return stafId;
        }

        public void setStafId(int stafId) {
            this.stafId = stafId;
        }

        public String getStafCode() {
            return stafCode;
        }

        public void setStafCode(String stafCode) {
            this.stafCode = stafCode;
        }

        public String getStafName() {
            return stafName;
        }

        public void setStafName(String stafName) {
            this.stafName = stafName;
        }

        public String getStafType() {
            return stafType;
        }

        public void setStafType(String stafType) {
            this.stafType = stafType;
        }

        public int getOrgId() {
            return orgId;
        }

        public void setOrgId(int orgId) {
            this.orgId = orgId;
        }

        public String getOrgName() {
            return orgName;
        }

        public void setOrgName(String orgName) {
            this.orgName = orgName;
        }

        public int getDeptId() {
            return deptId;
        }

        public void setDeptId(int deptId) {
            this.deptId = deptId;
        }

        public String getDeptType() {
            return deptType;
        }

        public void setDeptType(String deptType) {
            this.deptType = deptType;
        }

        public String getDeptName() {
            return deptName;
        }

        public void setDeptName(String deptName) {
            this.deptName = deptName;
        }

        public int getSrvId() {
            return srvId;
        }

        public void setSrvId(int srvId) {
            this.srvId = srvId;
        }

        public String getSrvCode() {
            return srvCode;
        }

        public void setSrvCode(String srvCode) {
            this.srvCode = srvCode;
        }

        public String getSrvName() {
            return srvName;
        }

        public void setSrvName(String srvName) {
            this.srvName = srvName;
        }

        public double getSrvPrice() {
            return srvPrice;
        }

        public void setSrvPrice(double srvPrice) {
            this.srvPrice = srvPrice;
        }

        public int getReqTime() {
            return reqTime;
        }

        public void setReqTime(int reqTime) {
            this.reqTime = reqTime;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public int getOperTime() {
            return operTime;
        }

        public void setOperTime(int operTime) {
            this.operTime = operTime;
        }

        public long getBeginDay() {
            return beginDay;
        }

        public void setBeginDay(long beginDay) {
            this.beginDay = beginDay;
        }

        public long getEndDay() {
            return endDay;
        }

        public void setEndDay(long endDay) {
            this.endDay = endDay;
        }
    }
}
