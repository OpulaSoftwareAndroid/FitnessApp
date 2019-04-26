
package com.opula.fitnessapp.POJOClasses.Foodlist;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Dinner {

    @SerializedName("FoodDetailID")
    @Expose
    private String foodDetailID;
    @SerializedName("FoodName")
    @Expose
    private String foodName;
    @SerializedName("FoodCalories")
    @Expose
    private String foodCalories;

    public String getFoodDetailID() {
        return foodDetailID;
    }

    public void setFoodDetailID(String foodDetailID) {
        this.foodDetailID = foodDetailID;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodCalories() {
        return foodCalories;
    }

    public void setFoodCalories(String foodCalories) {
        this.foodCalories = foodCalories;
    }

}
