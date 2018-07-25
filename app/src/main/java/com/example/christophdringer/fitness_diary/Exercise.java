package com.example.christophdringer.fitness_diary;

import android.media.Image;

import java.util.ArrayList;

public class Exercise {

    private String name;
    private ArrayList<String> musclegroups;
    private String description;
    private Image image;

    public Exercise(String name) {
        this.name = name;
    }

    public void changeName(String name) {
        this.name = name;
    }

    public void setMusclegroups(ArrayList<String> musclegroups) {
        this.musclegroups = musclegroups;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
