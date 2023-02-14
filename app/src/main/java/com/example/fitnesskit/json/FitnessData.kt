package com.example.fitnesskit.json

import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



data class FitnessData(

    @PrimaryKey
    @SerializedName("lessons")
    @Expose
    val lessons: List<Lesson>,

    @SerializedName("option")
    @Expose
    val option: Option,

    @SerializedName("tabs")
    @Expose
    val tabs: List<Tab>,

    @SerializedName("trainers")
    @Expose
    val trainers: List<Trainer>
)

