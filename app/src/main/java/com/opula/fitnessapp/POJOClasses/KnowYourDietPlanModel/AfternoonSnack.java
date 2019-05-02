
package com.opula.fitnessapp.POJOClasses.KnowYourDietPlanModel; ;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AfternoonSnack {

    @SerializedName("AfternoonSnackName")
    @Expose
    private String afternoonSnackName;
    @SerializedName("AfternoonSnackFoodName")
    @Expose
    private String afternoonSnackFoodName;
    @SerializedName("AfternoonSnackFoodCalories")
    @Expose
    private String afternoonSnackFoodCalories;

    public String getAfternoonSnackName() {
        return afternoonSnackName;
    }

    public void setAfternoonSnackName(String afternoonSnackName) {
        this.afternoonSnackName = afternoonSnackName;
    }

    public String getAfternoonSnackFoodName() {
        return afternoonSnackFoodName;
    }

    public void setAfternoonSnackFoodName(String afternoonSnackFoodName) {
        this.afternoonSnackFoodName = afternoonSnackFoodName;
    }

    public String getAfternoonSnackFoodCalories() {
        return afternoonSnackFoodCalories;
    }

    public void setAfternoonSnackFoodCalories(String afternoonSnackFoodCalories) {
        this.afternoonSnackFoodCalories = afternoonSnackFoodCalories;
    }

}
