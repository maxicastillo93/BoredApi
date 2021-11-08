package com.example.boredapi

import com.google.gson.annotations.SerializedName

data class GetActividad(
    @SerializedName("activity") var actividad : String,
    @SerializedName("type") var tipo : String,
    @SerializedName("participants") var participantes : Double,
    @SerializedName("price") var precio : Double
)