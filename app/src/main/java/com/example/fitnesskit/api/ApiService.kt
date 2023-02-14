package com.example.fitnesskit.api

import com.example.fitnesskit.json.FitnessData
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("?club_id=2")
    fun getLessons(): Single<FitnessData>

}