package com.example.fitnesskit.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.fitnesskit.json.FitnessData
import com.example.fitnesskit.json.Lesson
import com.example.fitnesskit.json.Option
import com.example.fitnesskit.json.Tab
import com.example.fitnesskit.json.Trainer

@Dao
interface FitnessLessonsDao {

    @Query("SELECT * FROM full_lessons_list ORDER BY date")
    fun getLessonsList(): LiveData<List<Lesson>>

    @Query("SELECT * FROM full_trainers_list")
    fun getTrainerList(): LiveData<List<Trainer>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertLessonsList(lessonsList: List<Lesson>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTrainersList(trainerList: List<Trainer>)

}