package model;

import java.util.*;

public class User {
    private String name;
    private String emailId;
    private String userId;
    private String mobileNumber;
    private static Map<String,Map<String,Double>> balances =  new HashMap<>();


    public User(String name, String emailId, String mobileNumber,String userId) {
        this.name = name;
        this.emailId = emailId;
        this.mobileNumber = mobileNumber;
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }


    public static Map<String,Map<String,Double>> getBalances() {
        return balances;
    }
}
