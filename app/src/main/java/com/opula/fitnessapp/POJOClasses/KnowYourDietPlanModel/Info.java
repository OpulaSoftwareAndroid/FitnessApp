
package com.opula.fitnessapp.POJOClasses.KnowYourDietPlanModel;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Info {

    @SerializedName("Breakfast")
    @Expose
    private List<Breakfast> breakfast = null;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("MorningSnack")
    @Expose
    private List<MorningSnack> morningSnack = null;
    @SerializedName("Lunch")
    @Expose
    private List<Lunch> lunch = null;
    @SerializedName("AfternoonSnack")
    @Expose
    private List<AfternoonSnack> afternoonSnack = null;
    @SerializedName("Dinner")
    @Expose
    private List<Dinner> dinner = null;

    public List<Breakfast> getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(List<Breakfast> breakfast) {
        this.breakfast = breakfast;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MorningSnack> getMorningSnack() {
        return morningSnack;
    }

    public void setMorningSnack(List<MorningSnack> morningSnack) {
        this.morningSnack = morningSnack;
    }

    public List<Lunch> getLunch() {
        return lunch;
    }

    public void setLunch(List<Lunch> lunch) {
        this.lunch = lunch;
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
