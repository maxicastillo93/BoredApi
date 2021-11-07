package com.example.boredapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.boredapi.databinding.ActivityActividadesBinding

class ActivityActividades : AppCompatActivity() {

    private lateinit var binding: ActivityActividadesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityActividadesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listaActividades = listOf<String>("Education", "Recreational", "Social", "Diy", "Charity", "Cooking", "Relaxation", "Music", "Busywork")


        val listActivityModel = listOf<AdapterDataModel>(
             AdapterDataModel("Education","education")
            ,AdapterDataModel("Recreational","recreational")
            ,AdapterDataModel("Social","social")
            ,AdapterDataModel("Diy","diy")
            ,AdapterDataModel("Charity","charity")
            ,AdapterDataModel("Cooking","cooking")
            ,AdapterDataModel("Relaxation","relaxation")
            ,AdapterDataModel("Music","music")
            ,AdapterDataModel("Busywork","busywork"))

        binding.recyclerActividades.layoutManager = LinearLayoutManager(this)
        binding.recyclerActividades.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))
        binding.recyclerActividades.adapter = AdapterActividades(listActivityModel)



    }

}