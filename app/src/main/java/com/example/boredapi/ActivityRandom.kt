package com.example.boredapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.boredapi.databinding.ActivityRandomBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ActivityRandom : AppCompatActivity() {

    private lateinit var binding : ActivityRandomBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRandomBinding.inflate(layoutInflater)
        setContentView(binding.root)

        makeCall()

        binding.bntTryAgainRandom.setOnClickListener {
            makeCall()
        }
    }

    private fun getRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://www.boredapi.com/api/activity/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun makeCall(){

        binding.loadingContainterRandom.visibility = View.VISIBLE
        val llamada : APIService = getRetrofit().create(APIService::class.java)

        llamada.getActivityRandom().enqueue(object : Callback<GetActividad> {
            override fun onResponse(call: Call<GetActividad>, response: Response<GetActividad>) {
                Log.i("MainActivity", response.toString())

                val body = response.body()!!

                binding.tvTitle1Random.text = body.actividad
                binding.textView9.text = body.participantes.toInt().toString()
                binding.tvCostRandom.text = when(body.precio){
                    0.0 -> "Free"
                    in 0.0..0.3 -> "Low"
                    in 0.4..0.6 -> "Medium"
                    else -> "High"
                }
                binding.textView12.text = body.tipo

                binding.loadingContainterRandom.visibility = View.GONE

            }
            override fun onFailure(call: Call<GetActividad>, t: Throwable) {
                Log.i("MainActivity", t.message?: "Null message")
               binding.loadingContainterRandom.visibility = View.GONE

            }
        })

    }
}