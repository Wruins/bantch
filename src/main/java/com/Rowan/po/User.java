package com.Rowan.po;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String staffId;
    private String staffPassword;
    private String staffName;
    private Integer staffSex;
    private Integer staffAge;
    private String staffAddress;
    private String staffIphone;
    private String staffAvator;


    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", staffId='" + staffId + '\'' +
                ", staffPassword='" + staffPassword + '\'' +
                ", staffName='" + staffName + '\'' +
                ", staffSex=" + staffSex +
                ", staffAge=" + staffAge +
                ", staffAddress='" + staffAddress + '\'' +
                ", staffIphone='" + staffIphone + '\'' +
                ", staffAvator='" + staffAvator + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getStaffPassword() {
        return staffPassword;
    }

    public void setStaffPassword(String staffPassword) {
        this.staffPassword = staffPassword;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public Integer getStaffSex() {
        return staffSex;
    }

    public void setStaffSex(Integer staffSex) {
        this.staffSex = staffSex;
    }

    public Integer getStaffAge() {
        return staffAge;
    }

    public void setStaffAge(Integer staffAge) {
        this.staffAge = staffAge;
    }

    public String getStaffAddress() {
        return staffAddress;
    }

    public void setStaffAddress(String staffAddress) {
        this.staffAddress = staffAddress;
    }

    public String getStaffIphone() {
        return staffIphone;
    }

    public void setStaffIphone(String staffIphone) {
        this.staffIphone = staffIphone;
    }

    public String getStaffAvator() {
        return staffAvator;
    }

    public void setStaffAvator(String staffAvator) {
        this.staffAvator = staffAvator;
    }
}
