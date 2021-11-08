package com.example.boredapi

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.Handler
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.boredapi.databinding.ItemActividadBinding
import java.util.logging.Handler as Handler1

class AdapterActividades(private val actividades: List<AdapterDataModel>)
    :RecyclerView.Adapter<ActividadesViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActividadesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ActividadesViewHolder(layoutInflater.inflate(R.layout.item_actividad,parent,false))
    }

    override fun onBindViewHolder(holder: ActividadesViewHolder, position: Int) {
        val activatedEnPosition = actividades[position]
        holder.bind(activatedEnPosition)

        holder.itemView.setOnClickListener {

            var intent = Intent(holder.itemView.context, ActivitySugerencia::class.java)

            intent.putExtra("api_type", activatedEnPosition.typeModel)
            holder.itemView.context.startActivity(intent)
        }

    }

    override fun getItemCount() = actividades.size

}