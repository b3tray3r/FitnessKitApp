package com.example.fitnesskit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnesskit.adapter.Adapter
import com.example.fitnesskit.viewModel.LessonViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: LessonViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = Adapter()
        val recycler = findViewById<RecyclerView>(R.id.rv_list)

        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(this)

        viewModel = ViewModelProvider(this)[LessonViewModel::class.java]

        viewModel.lessonList.observe(this, Observer {
            adapter.submitList(it)
        })
        viewModel.trainerList.observe(this, Observer {
            adapter.trainerList = it
        })


    }
}