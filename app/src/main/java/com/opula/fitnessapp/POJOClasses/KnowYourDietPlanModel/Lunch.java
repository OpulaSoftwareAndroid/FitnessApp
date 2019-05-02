
package com.opula.fitnessapp.POJOClasses.KnowYourDietPlanModel; ;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Lunch {

    @SerializedName("LaunchName")
    @Expose
    private String launchName;
    @SerializedName("LaunchFoodName")
    @Expose
    private String launchFoodName;
    @SerializedName("LaunchFoodCalories")
    @Expose
    private String launchFoodCalories;

    public String getLaunchName() {
        return launchName;
    }

    public void setLaunchName(String launchName) {
        this.launchName = launchName;
    }

    public String getLaunchFoodName() {
        return launchFoodName;
    }

    public void setLaunchFoodName(String launchFoodName) {
        this.launchFoodName = launchFoodName;
    }

    public String getLaunchFoodCalories() {
        return launchFoodCalories;
    }

    public void setLaunchFoodCalories(String launchFoodCalories) {
        this.launchFoodCalories = launchFoodCalories;
    }

}
