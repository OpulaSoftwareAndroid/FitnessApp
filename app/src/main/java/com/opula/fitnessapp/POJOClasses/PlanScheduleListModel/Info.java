
package com.opula.fitnessapp.POJOClasses.PlanScheduleListModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Info {

    @SerializedName("PlanScheduleID")
    @Expose
    private String planScheduleID;
    @SerializedName("Period")
    @Expose
    private String period;

    public String getPlanScheduleID() {
        return planScheduleID;
    }

    public void setPlanScheduleID(String planScheduleID) {
        this.planScheduleID = planScheduleID;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

}
