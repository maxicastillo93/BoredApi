package com.example.boredapi

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {

    //@GET("?type=")

    @GET(".")
    fun getActivityByType(@Query("type") type: String) : Call<GetActividad>
}