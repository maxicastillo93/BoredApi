package com.example.boredapi

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.boredapi.databinding.ItemActividadBinding

class ActividadesViewHolder(view : View): RecyclerView.ViewHolder(view) {

    private val binding : ItemActividadBinding = ItemActividadBinding.bind(view)

    fun bind(actividadEnPosicion: AdapterDataModel) {
        binding.tvItemActividad.text = actividadEnPosicion.title
    }
}