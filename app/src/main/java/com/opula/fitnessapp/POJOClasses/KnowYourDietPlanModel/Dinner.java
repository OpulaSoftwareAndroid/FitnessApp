
package com.opula.fitnessapp.POJOClasses.KnowYourDietPlanModel; ;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Dinner {

    @SerializedName("DinnerName")
    @Expose
    private String dinnerName;
    @SerializedName("DinnerFoodName")
    @Expose
    private String dinnerFoodName;
    @SerializedName("DinnerFoodCalories")
    @Expose
    private String dinnerFoodCalories;

    public String getDinnerName() {
        return dinnerName;
    }

    public void setDinnerName(String dinnerName) {
        this.dinnerName = dinnerName;
    }

    public String getDinnerFoodName() {
        return dinnerFoodName;
    }

    public void setDinnerFoodName(String dinnerFoodName) {
        this.dinnerFoodName = dinnerFoodName;
    }

    public String getDinnerFoodCalories() {
        return dinnerFoodCalories;
    }

    public void setDinnerFoodCalories(String dinnerFoodCalories) {
        this.dinnerFoodCalories = dinnerFoodCalories;
    }

}
