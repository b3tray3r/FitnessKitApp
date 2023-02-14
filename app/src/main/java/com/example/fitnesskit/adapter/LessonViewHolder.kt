package com.example.fitnesskit.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnesskit.R

class LessonViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
    val date: TextView = itemView.findViewById(R.id.item_date)
    val startTime: TextView = itemView.findViewById(R.id.text_time_start)
    val finishTime: TextView = itemView.findViewById(R.id.text_time_finish)
    val lessonName: TextView = itemView.findViewById(R.id.text_lesson_name)
    val trainerName: TextView = itemView.findViewById(R.id.text_trainer_name)
    val lessonLocation: TextView = itemView.findViewById(R.id.text_location)
    val lessonDuration: TextView = itemView.findViewById(R.id.text_duration)
}