
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
    @SerializedName("DietPlanName")
    @Expose
    private String dietPlanName;
    @SerializedName("Img")
    @Expose
    private String img;

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

    public String getDietPlanName() {
        return dietPlanName;
    }

    public void setDietPlanName(String dietPlanName) {
        this.dietPlanName = dietPlanName;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

}
