
package com.opula.fitnessapp.POJOClasses.KnowYourDietPlanModel; ;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Breakfast {

    @SerializedName("BreakFastName")
    @Expose
    private String breakFastName;
    @SerializedName("BreakFastFoodName")
    @Expose
    private String breakFastFoodName;
    @SerializedName("BreakFastFoodCalories")
    @Expose
    private String breakFastFoodCalories;

    public String getBreakFastName() {
        return breakFastName;
    }

    public void setBreakFastName(String breakFastName) {
        this.breakFastName = breakFastName;
    }

    public String getBreakFastFoodName() {
        return breakFastFoodName;
    }

    public void setBreakFastFoodName(String breakFastFoodName) {
        this.breakFastFoodName = breakFastFoodName;
    }

    public String getBreakFastFoodCalories() {
        return breakFastFoodCalories;
    }

    public void setBreakFastFoodCalories(String breakFastFoodCalories) {
        this.breakFastFoodCalories = breakFastFoodCalories;
    }

}
