package com.gerardo.consumeapi


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(val datos:List<Character>):RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){

        val img:ImageView=itemView.findViewById(R.id.img)
        val txtNombre:TextView = itemView.findViewById(R.id.txtNombre)
        val txtEspecie:TextView = itemView.findViewById(R.id.txtEspecie)


        fun Bind(item:Character){
            txtNombre.text=item.name
            txtEspecie.text=item.species
            img.fromURL(item.image)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_row,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.Bind(datos.get(position))
    }

    override fun getItemCount(): Int = datos.size
}