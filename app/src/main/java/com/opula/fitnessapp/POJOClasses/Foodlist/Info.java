
package com.opula.fitnessapp.POJOClasses.Foodlist;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Info {

    @SerializedName("FoodID")
    @Expose
    private String foodID;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Breakfast")
    @Expose
    private List<Breakfast> breakfast = null;
    @SerializedName("Morning Snack")
    @Expose
    private List<MorningSnack> morningSnack = null;
    @SerializedName("Launch")
    @Expose
    private List<Launch> launch = null;
    @SerializedName("Afternoon Snack")
    @Expose
    private List<AfternoonSnack> afternoonSnack = null;
    @SerializedName("Dinner")
    @Expose
    private List<Dinner> dinner = null;

    public String getFoodID() {
        return foodID;
    }

    public void setFoodID(String foodID) {
        this.foodID = foodID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Breakfast> getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(List<Breakfast> breakfast) {
        this.breakfast = breakfast;
    }

    public List<MorningSnack> getMorningSnack() {
        return morningSnack;
    }

    public void setMorningSnack(List<MorningSnack> morningSnack) {
        this.morningSnack = morningSnack;
    }

    public List<Launch> getLaunch() {
        return launch;
    }

    public void setLaunch(List<Launch> launch) {
        this.launch = launch;
    }

    public List<AfternoonSnack> getAfternoonSnack() {
        return afternoonSnack;
    }

    public void setAfternoonSnack(List<AfternoonSnack> afternoonSnack) {
        this.afternoonSnack = afternoonSnack;
    }

    public List<Dinner> getDinner() {
        return dinner;
    }

    public void setDinner(List<Dinner> dinner) {
        this.dinner = dinner;
    }

}
