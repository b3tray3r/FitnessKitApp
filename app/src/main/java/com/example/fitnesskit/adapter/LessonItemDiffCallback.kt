package com.example.fitnesskit.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.fitnesskit.json.Lesson


class LessonItemDiffCallback: DiffUtil.ItemCallback<Lesson>() {
    override fun areItemsTheSame(oldItem: Lesson, newItem: Lesson): Boolean {
        return oldItem.date == newItem.date
    }

    override fun areContentsTheSame(oldItem: Lesson, newItem: Lesson): Boolean {
        return oldItem == newItem
    }
}