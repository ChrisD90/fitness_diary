package com.example.christophdringer.fitness_diary;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.media.Image;

import java.util.ArrayList;

@Entity(tableName = "exercise")
public class Exercise {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "muscles")
    private ArrayList<String> musclegroups;

    @ColumnInfo(name = "description")
    private String description;

    @ColumnInfo(name = "image")
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
