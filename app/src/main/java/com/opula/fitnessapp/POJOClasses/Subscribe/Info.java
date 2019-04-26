
package com.opula.fitnessapp.POJOClasses.Subscribe; ;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Info {

    @SerializedName("SubscribeID")
    @Expose
    private String subscribeID;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("PlanType")
    @Expose
    private String planType;
    @SerializedName("MembershipType")
    @Expose
    private String membershipType;
    @SerializedName("Price")
    @Expose
    private String price;
    @SerializedName("PlanTypeName")
    @Expose
    private String planTypeName;
    @SerializedName("MembershipTypeName")
    @Expose
    private String membershipTypeName;

    public String getSubscribeID() {
        return subscribeID;
    }

    public void setSubscribeID(String subscribeID) {
        this.subscribeID = subscribeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlanType() {
        return planType;
    }

    public void setPlanType(String planType) {
        this.planType = planType;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPlanTypeName() {
        return planTypeName;
    }

    public void setPlanTypeName(String planTypeName) {
        this.planTypeName = planTypeName;
    }

    public String getMembershipTypeName() {
        return membershipTypeName;
    }

    public void setMembershipTypeName(String membershipTypeName) {
        this.membershipTypeName = membershipTypeName;
    }

}
