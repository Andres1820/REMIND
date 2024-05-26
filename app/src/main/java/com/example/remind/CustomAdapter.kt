package com.example.remind

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter: RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    val titles = arrayOf("Tarea 1", "Tarea 2","Tarea 3","Tarea 4")
    val fechas = arrayOf("27/05/2024", "30/05/2024","04/06/2024","06/06/2024")
    val detalles = arrayOf(
        "Agendar reunión de Seguimiento",
        "Apoyar en el proceso de terminación del contrato 106-2024",
        "Hacer seguimiento a los compromisos",
        "Asistir a las Mesas de Riesgos")
    val imagenes = intArrayOf(R.drawable.logo_remind_preview_rev_1, R.drawable.logo_remind_preview_rev_1,R.drawable.logo_remind_preview_rev_1,R.drawable.logo_remind_preview_rev_1)

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var image: ImageView
        var titulo: TextView
        var fecha: TextView
        var detalle: TextView
        init {
            image = itemView.findViewById(R.id.imagen)
            titulo = itemView.findViewById(R.id.titulo)
            fecha = itemView.findViewById(R.id.fecha)
            detalle = itemView.findViewById(R.id.detalles)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.tareas_proyecto, viewGroup, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return  titles.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.titulo.text = titles[i]
        viewHolder.fecha.text = fechas[i]
        viewHolder.detalle.text = detalles[i]
        viewHolder.image.setImageResource(imagenes[i])
    }
}