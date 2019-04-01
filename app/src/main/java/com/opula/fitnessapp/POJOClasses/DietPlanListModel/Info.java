
package com.opula.fitnessapp.POJOClasses.DietPlanListModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Info {

    @SerializedName("DietPlanID")
    @Expose
    private String dietPlanID;
    @SerializedName("RegisterID")
    @Expose
    private String registerID;

    public String getDietPlanID() {
        return dietPlanID;
    }

    public void setDietPlanID(String dietPlanID) {
        this.dietPlanID = dietPlanID;
    }

    public String getRegisterID() {
        return registerID;
    }

    public void setRegisterID(String registerID) {
        this.registerID = registerID;
    }

}
