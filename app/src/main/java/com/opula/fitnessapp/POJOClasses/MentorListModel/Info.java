package com.opula.fitnessapp.POJOClasses.MentorListModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Info {

    @SerializedName("MentorID")
    @Expose
    private String mentorID;
    @SerializedName("Name")
    @Expose
    private String name;

    public String getMentorID() {
        return mentorID;
    }

    public void setMentorID(String mentorID) {
        this.mentorID = mentorID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}