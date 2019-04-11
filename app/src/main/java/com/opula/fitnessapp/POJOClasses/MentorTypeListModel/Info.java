package com.opula.fitnessapp.POJOClasses.MentorTypeListModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Info extends com.opula.fitnessapp.POJOClasses.PlanScheduleListModel.Info {

    @SerializedName("MentorTypeID")
    @Expose
    private String mentorTypeID;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("DOB")
    @Expose
    private String dOB;
    @SerializedName("Price")
    @Expose
    private String price;
    @SerializedName("Image")
    @Expose
    private String image;
    @SerializedName("Message")
    @Expose
    private String message;



    public String getMentorTypeID() {
        return mentorTypeID;
    }

    public void setMentorTypeID(String mentorTypeID) {
        this.mentorTypeID = mentorTypeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDOB() {
        return dOB;
    }

    public void setDOB(String dOB) {
        this.dOB = dOB;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}