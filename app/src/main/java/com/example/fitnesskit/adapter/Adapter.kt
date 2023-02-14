package com.example.fitnesskit.adapter

import android.graphics.Color
import android.graphics.PorterDuff
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.fitnesskit.R
import com.example.fitnesskit.json.Lesson
import com.example.fitnesskit.json.Trainer
import java.lang.RuntimeException
import java.sql.Date
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale
import kotlin.math.absoluteValue

class Adapter : ListAdapter<Lesson, LessonViewHolder>(LessonItemDiffCallback()) {


    var trainerList: List<Trainer> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LessonViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_lesson, parent, false)
        return LessonViewHolder(view)
    }


    override fun onBindViewHolder(holder: LessonViewHolder, position: Int) {
        val lesson = getItem(position)
        val trainer = trainerList
        if (getDate(lesson.date) != getItem(position).date) {
            holder.date.text = getDate(lesson.date)
        } else {
            holder.date.visibility = View.GONE
        }
        holder.startTime.text = lesson.startTime
        holder.finishTime.text = lesson.endTime
        holder.lessonName.text = lesson.tab
        holder.trainerName.text = trainer.find { it.id == lesson.coach_id }?.name
        holder.lessonLocation.text = lesson.place.substringBefore("Олимпия")
        holder.lessonDuration.text = getDuration(lesson.startTime, lesson.endTime)
    }


    private fun getDuration(startTime: String, endTime: String): String {
        var result: String = ""
        val hours = endTime.substringBefore(":").toInt() - startTime.substringBefore(":").toInt()
        val minutes = endTime.substringAfter(":").toInt() - startTime.substringAfter(":").toInt()
        if (minutes == 0) {
            result = "${hours.absoluteValue}:00 ч"
        } else {
            result = "${hours.absoluteValue}:${minutes.absoluteValue} ч"
        }
        return result
    }


    private fun getDate(date: String): String {
        val textDate = LocalDate.parse(date)
        val formatter = DateTimeFormatter.ofPattern("EEEE dd MMMM")
        return textDate.format(formatter)
    }


}