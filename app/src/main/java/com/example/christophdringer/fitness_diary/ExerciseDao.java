package com.example.christophdringer.fitness_diary;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface ExerciseDao {

     @Query("SELECT * FROM exercise")
    List<Exercise> getAll();

     @Query("SELECT * FROM exercise WHERE id == id")
    Exercise findById(int id);
}
