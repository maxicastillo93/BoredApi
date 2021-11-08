package com.example.boredapi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
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

        //val listaActividades = listOf<String>("Education", "Recreational", "Social", "Diy", "Charity", "Cooking", "Relaxation", "Music", "Busywork")


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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_random, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.icon_random ->{
                startActivity(Intent(this, ActivityRandom::class.java))
            }
        }
        return super.onOptionsItemSelected(item)
    }
}