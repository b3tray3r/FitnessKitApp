package com.example.fitnesskit.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.map
import com.example.fitnesskit.api.ApiFactory
import com.example.fitnesskit.database.AppDataBase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class LessonViewModel(application: Application): AndroidViewModel(application) {


    private val db = AppDataBase.getInstance(application)

    private val compositeDisposable = CompositeDisposable()

    val lessonList = db.fitnessLessonsDao().getLessonsList()
    val trainerList = db.fitnessLessonsDao().getTrainerList()

    init {
        loadLessons()
    }

    private fun loadLessons() {
        val disposable = ApiFactory.apiService.getLessons()
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .subscribe({
                db.fitnessLessonsDao().insertLessonsList(it.lessons)
                db.fitnessLessonsDao().insertTrainersList(it.trainers)
                Log.d("Test", "Success: $it")
            },{
                Log.d("Test", "Failure: ${it.message}")
            })
        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

}