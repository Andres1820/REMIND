package com.example.remind

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter: RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    val titles = arrayOf("CodeLia", "Suscribete","Youtube","Facebook")
    val detalles = arrayOf("Mamadas", "Ever","Cado","joelnegrito")
    val imagenes = intArrayOf(R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground,R.drawable.logo_remind_preview_rev_1,R.drawable.ic_launcher_foreground)

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var image: ImageView
        var titulo: TextView
        var detalle: TextView
        init {
            image = itemView.findViewById(R.id.imagen)
            titulo = itemView.findViewById(R.id.texto)
            detalle = itemView.findViewById(R.id.detalles)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.ejemplo, viewGroup, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return  titles.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.titulo.text = titles[i]
        viewHolder.detalle.text = detalles[i]
        viewHolder.image.setImageResource(imagenes[i])

    }
}