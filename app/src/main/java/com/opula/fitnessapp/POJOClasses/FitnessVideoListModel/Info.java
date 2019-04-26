
package com.opula.fitnessapp.POJOClasses.FitnessVideoListModel; ;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Info {

    @SerializedName("ExercisePlanID")
    @Expose
    private String exercisePlanID;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Video")
    @Expose
    private String video;
    @SerializedName("ThumbnailImage")
    @Expose
    private String thumbnailImage;

    public String getExercisePlanID() {
        return exercisePlanID;
    }

    public void setExercisePlanID(String exercisePlanID) {
        this.exercisePlanID = exercisePlanID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getThumbnailImage() {
        return thumbnailImage;
    }

    public void setThumbnailImage(String thumbnailImage) {
        this.thumbnailImage = thumbnailImage;
    }

}
