package com.example.boredapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.boredapi.databinding.ActivitySugerenciaBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ActivitySugerencia : AppCompatActivity() {

    private lateinit var binding: ActivitySugerenciaBinding
    private  var apiType : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySugerenciaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Get type from extra
        val bundle = intent.extras

        if (bundle!!.getString("api_type") != null) {
             apiType = bundle!!.getString("api_type").toString()

            makeCall(apiType!!)
        }
        binding.btnTryAnother.setOnClickListener {
            makeCall(apiType)
        }
    }

    private fun getRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://www.boredapi.com/api/activity/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun makeCall(type : String){

        binding.loadingContainer.visibility = View.VISIBLE
        CoroutineScope(Dispatchers.IO).launch {
            val llamada : APIService = getRetrofit().create(APIService::class.java)

            llamada.getActivityByType(type!!).enqueue(object : Callback<GetActividad> {
                override fun onResponse(call: Call<GetActividad>, response: Response<GetActividad>) {
                    Log.i("MainActivity", response.toString())

                    if (!response.isSuccessful){
                        Toast.makeText(this@ActivitySugerencia, "Fallo la llamada", Toast.LENGTH_SHORT).show()
                        return
                    }

                    runOnUiThread {
                        val body = response.body()!!

                        binding.textView6.text = body.actividad
                        binding.textView3.text = body.participantes.toInt().toString()
                        binding.textView5.text = when(body.precio){
                            0.0 -> "Free"
                            in 0.0..0.3 -> "Low"
                            in 0.3..0.6 -> "Medium"
                            else -> "High"
                        }
                    }
                    binding.loadingContainer.visibility = View.GONE
                }
                override fun onFailure(call: Call<GetActividad>, t: Throwable) {
                    Log.i("MainActivity", t.message?: "Null message")
                    binding.loadingContainer.visibility = View.GONE
                }
            })
        }

    }
}