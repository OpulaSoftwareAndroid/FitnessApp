
package com.opula.fitnessapp.POJOClasses.KnowYourDietPlanModel; ;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MorningSnack {

    @SerializedName("MorningSnackName")
    @Expose
    private String morningSnackName;
    @SerializedName("MorningSnackFoodName")
    @Expose
    private String morningSnackFoodName;
    @SerializedName("MorningSnackFoodCalories")
    @Expose
    private String morningSnackFoodCalories;

    public String getMorningSnackName() {
        return morningSnackName;
    }

    public void setMorningSnackName(String morningSnackName) {
        this.morningSnackName = morningSnackName;
    }

    public String getMorningSnackFoodName() {
        return morningSnackFoodName;
    }

    public void setMorningSnackFoodName(String morningSnackFoodName) {
        this.morningSnackFoodName = morningSnackFoodName;
    }

    public String getMorningSnackFoodCalories() {
        return morningSnackFoodCalories;
    }

    public void setMorningSnackFoodCalories(String morningSnackFoodCalories) {
        this.morningSnackFoodCalories = morningSnackFoodCalories;
    }

}
