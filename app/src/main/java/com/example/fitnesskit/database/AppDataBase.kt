package com.example.fitnesskit.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.fitnesskit.json.Lesson
import com.example.fitnesskit.json.Trainer

@Database(entities = [Lesson::class,Trainer::class], version = 2, exportSchema = false)
abstract class AppDataBase: RoomDatabase() {

    companion object {
        private var db: AppDataBase? = null
        private const val  DB_NAME = "FitnessData.db"
        private val LOCK = Any()

        fun getInstance(context: Context): AppDataBase {
            synchronized(LOCK) {
                db?.let {return  it}
                val isntance: AppDataBase =
                    Room.databaseBuilder(context, AppDataBase::class.java, DB_NAME).build()
                db = isntance
                return isntance
            }
        }
    }

    abstract fun fitnessLessonsDao(): FitnessLessonsDao

}